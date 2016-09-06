package br.erickweil.simplelang.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.json.simple.JSONArray;

import br.erickweil.simplelang.core.ListHelper.Hierarquia;
import br.erickweil.simplelang.core.ListHelper.Node;
import br.erickweil.simplelang.core.ListHelper.StringNode;
import br.erickweil.simplelang.core.ListHelper.Tipo;
import br.erickweil.simplelang.generated.SimpleParser;

public class ListHelper {
	public static int ident = 0;
	
	static public enum Tipo {
		INTEGER,
		FLOAT,
		DOUBLE,
		STRING,
		BOOLEAN,
		LIST,
		NULL,
		VOID;
		
		static public Tipo getTipo(String type)
		{
			switch(type)
			{
				case "int": return INTEGER;
				case "float": return FLOAT;
				case "double": return DOUBLE;
				case "java.lang.String": return STRING;
				case "boolean": return BOOLEAN;
				case "void": return VOID;
				case "int[]":
				case "float[]":
				case "double[]":
				case "java.lang.String[]":
				case "boolean[]":
				case "java.lang.Object[]":
					return LIST;
				default:
					System.out.println(type);
					break;
			}
			return VOID;
		}
	}
	
	static public interface Node {
		public String toIdentString();
		public String getText();
		public int getType();
		public Tipo getReturnTipo();
		public Object getValue();
	}

	static public class Hierarquia implements Node{
		String Text;
		List<Node> children;
		
		public Hierarquia(String Text) {
			this.Text = Text;
			this.children = new ArrayList<>();
		}

		public Hierarquia(String Text, Node ... nodes) {
			this.Text = Text;
			this.children = new ArrayList<>();
			for(Node node : nodes) add(node);
		}
		
		@Override
		public String toIdentString() {
			// TODO Auto-generated method stub
			StringBuilder sb = new StringBuilder();
			sb.append(GetIdent()+Text+":\n"+GetIdent()+"[\n");
			ident++;
			for(Node node : children) {
				sb.append(node.toIdentString());
			}
			ident--;
			sb.append(GetIdent()+"]\n");
			
			return sb.toString();
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			StringBuilder sb = new StringBuilder();

			for(Node node : children) {
				sb.append(node.toString());
			}
			
			return sb.toString();
		}

		public boolean add(Node arg0) {
			return children.add(arg0);
		}

		public void clear() {
			children.clear();
		}

		public Node get(int arg0) {
			return children.get(arg0);
		}
		
		public String leafGet(int leafType)
		{
			for(Node node : children) {
				if(node.getType() == leafType) return node.getText();
			}
			return null;
		}
		
		public Hierarquia deepFGet(String SearchText,int maxdeep)
		{
			return deepFGet(SearchText,maxdeep,0);
		}
		
		private Hierarquia deepFGet(String SearchText,int maxdeep,int actualdeep)
		{

				if(Text.equals(SearchText))
				{
					return this;
				}
				else
				{
					if(actualdeep < maxdeep)
					{
						for(Node node : children) {
							if(node instanceof Hierarquia)
							{
								Hierarquia result = ((Hierarquia) node).deepFGet(SearchText,maxdeep,actualdeep+1);
								if(result != null) return result;
							}
						}
					}
				}
			
			return null;
		}
		
		public List<Hierarquia> deepGet(String SearchText,int maxdeep)
		{
			return deepGet(SearchText,maxdeep,0);
		}
		
		private List<Hierarquia> deepGet(String SearchText,int maxdeep,int actualdeep)
		{
			List<Hierarquia> return_list = new ArrayList<>();
			if(Text.equals(SearchText))
			{
				return_list.add(this);
			}
			else
			{
				for(Node node : children) {
					if(node instanceof Hierarquia)
					return_list.addAll(((Hierarquia) node).deepGet(SearchText,maxdeep,actualdeep+1));
				}
			}
			return return_list;
		}
		
		public void addAll(List<Node> Node)
		{
			for(Node n : Node) add(n);
		}

		public int size() {
			return children.size();
		}

		public Tipo getReturnTipo() {
				switch (this.getText()) {
				case "expression":
					switch (this.size()) {
					case 1:
						return this.get(0).getReturnTipo();
					case 2: {
						Node left = this.get(0);
						Node right = this.get(1);

						if (left instanceof Hierarquia) // expr ++ --
						{
							return left.getReturnTipo();
						} else if (right instanceof Hierarquia) {
							return right.getReturnTipo();
						} else {
							System.err.println("Expr inválida!" + this);
							return Tipo.VOID;
						}
					}
					case 3: {
						Node left = this.get(0);
						Node middle = this.get(1);
						Node right = this.get(2);
						if (middle instanceof StringNode) 
						{
							Tipo a = left.getReturnTipo();
							Tipo b = right.getReturnTipo();
							String operator = middle.getText();
							switch(operator)
							{
								case "&&":
								case "||":
								case "==":
								case "!=":
								case "<":
								case ">":
								case "<=":
								case ">=":
									
									return Tipo.BOOLEAN;
								default:
								if (a == Tipo.STRING || b == Tipo.STRING)
									return Tipo.STRING;
								if (a == Tipo.DOUBLE || b == Tipo.DOUBLE)
									return Tipo.DOUBLE;
								if (a == Tipo.FLOAT || b == Tipo.FLOAT)
									return Tipo.FLOAT;
								if (a == Tipo.INTEGER || b == Tipo.INTEGER)
									return Tipo.INTEGER;
								System.err.println("Tipos Estranhos a:" + a + " b:" + b);
							}
							return Tipo.VOID;
						} else 
						{
							System.err.println("Expr inválida!" + this);
							return Tipo.VOID;
						}
					}
					case 4:
					{
						/*
						expression '.' 'new' nonWildcardTypeArguments? innerCreator
						expression '.' 'super' superSuffix
						expression '[' expression ']'
						expression '(' expressionList? ')'
						'(' type ')' expression
					*/
						switch(get(1).getText())
						{
							case "(":
							{
								String meth_Name = get(0).toString();
								if(ConvertHierarquia.variables_types.containsKey(meth_Name+"_return"))
									return ConvertHierarquia.lists_types.get(meth_Name);
								else
									return Tipo.VOID;
							}
							case "[":
							{
								String array_Name = get(0).toString();
								if( ConvertHierarquia.lists_types.containsKey(array_Name))
									return ConvertHierarquia.lists_types.get(array_Name);
									else
									{
										System.err.println("Array Var "+get(0)+" not declared");
										return Tipo.VOID;
									}
							}
							default:
								System.err.println("Expr inválida!" + this);
							return Tipo.VOID;
						}
					}
					default:
						System.err.println("Expr inválida!" + this);
						return Tipo.VOID;
					}
				case "arrayInitializer":
					return Tipo.LIST;
				case "literal":
					return this.get(0).getReturnTipo();
				case "primary":
				{
					switch(this.size())
					{
						case 1: // literal, Identifier
						{
							Node child = get(0);
							if(child.getType() == SimpleParser.Identifier)
							{
								if( ConvertHierarquia.variables_types.containsKey(child.getText()))
								return ConvertHierarquia.variables_types.get(child.getText());
								else
								{
									System.err.println("Var "+child.getText()+" not declared");
									return Tipo.VOID;
								}
							}
							else
							return child.getReturnTipo();
						}
						case 3: // '(' expression ')' |   type '.' 'class'   |   'void' '.' 'class'
						return this.get(1).getReturnTipo();
					}
				}
				default:
					return Tipo.VOID;
				}
		}

		@Override
		public String getText() {
			// TODO Auto-generated method stub
			return Text;
		}

		@Override
		public int getType() {
			// TODO Auto-generated method stub
			return 1;
		}
		
		@Override
		public Object getValue() {
			// TODO Auto-generated method stub
			return get(0).getValue();
		}
	}

	
	static public class StringNode implements Node {

		String Text;
		Object value;
		int type;
		Tipo return_tipo;
		public StringNode(String Text)
		{
			this.Text = Text;
			this.type = -1;
		}
		public StringNode(String Text,Object value,int tipo,Tipo return_tipo)
		{
			this.Text = Text;
			this.type = tipo;
			this.value = value;
			this.return_tipo = return_tipo;
		}

		@Override
		public String toIdentString() {
			return  GetIdent()+Text+"\n";
		} 
		
		@Override
		public String toString() {
			return Text;
		}
		
		@Override
		public Tipo getReturnTipo() {
			// TODO Auto-generated method stub
			return return_tipo;
		}

		@Override
		public String getText() {
			// TODO Auto-generated method stub
			return Text;
		}

		public Object getValue() {
			// TODO Auto-generated method stub
			return value;
		}
		
		@Override
		public int getType() {
			// TODO Auto-generated method stub
			return type;
		} 
		
	}
	
	public static String GetIdent()
	{
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<ident;i++)
		{
			builder.append("    ");
		}
		return builder.toString();
	}
}
