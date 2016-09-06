package br.erickweil.simplelang.core;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;

import br.erickweil.simplelang.core.ListHelper.Hierarquia;
import br.erickweil.simplelang.core.ListHelper.Node;
import br.erickweil.simplelang.core.ListHelper.StringNode;
//import br.erickweil.simplelang.core.ListHelper.Tipo;

public class GenerateJson {
	/*
	public static final Map<String,String> translate_op; 
	static
	{
		translate_op = new HashMap<>();
		translate_op.put("!","not");
		translate_op.put("*","*");
		translate_op.put("/","/");
		translate_op.put("+","+");
		translate_op.put("concatenate", "concatenate:with:");
		translate_op.put("-","-");
		translate_op.put("%","%");
		translate_op.put("<","<");
		translate_op.put(">",">");
		translate_op.put("==","=");
		translate_op.put("||","|");
		translate_op.put("&&","&");
	}
	public Hierarquia hierarquia;
	public int dowhile_count;
	public GenerateJson(Hierarquia hierarquia)
	{
		this.hierarquia = hierarquia;
	}
	
	public void Parse(JSONArray scripts)
	{
		Parse(hierarquia,scripts);
	}
	
	@SuppressWarnings("unchecked")
	private void Parse(Node node,JSONArray jsonobj)
	{
		if(node instanceof Hierarquia)
		{
			Hierarquia hier = (Hierarquia) node;
			/*
			StringBuilder sb = new StringBuilder();
			boolean first = true;
			for(Node n : hier.children)
			{
				if(n instanceof Hierarquia)
				{
					if(!first)sb.append(",");
					sb.append(((Hierarquia)n).Text);
				}
				else if(n instanceof StringNode)
				{
					if(!first)sb.append(",");
					sb.append(n.toString());
				}
				first = false;
			}
			System.out.println(hier.Text+":"+sb.toString());
			//*
			switch(hier.Text)
			{
				case "base":
				{
					Parse(hier.get(0),jsonobj);
				}
				break;
				case "file":
				{
					for( Node n : hier.children)
					{
						if(n instanceof Hierarquia)
						{
							Parse(n,jsonobj);
						}
					}
				}
				break;
				case "block":
				{
					JSONArray block = new JSONArray();
					block.add(0);//x
					block.add(0);//y
					JSONArray temparray = new JSONArray();
					block.add(temparray);
					JSONArray blockname = new JSONArray();
					blockname.add(hier.get(0).toString());
					temparray.add(blockname);
					
					Parse(hier.get(1),temparray);
					
					jsonobj.add(block);
				}
					break;
				case "statement":
				{
					if(hier.size() <= 2) // 2 pq pode ser assignment ';' ou unarystat ';', mas tbm '{' <nenhum statement> '}'
					{
						if(hier.get(0) instanceof Hierarquia) // se nao e '{' '}'
						{
							Hierarquia child = (Hierarquia)hier.get(0);
							if(child.Text.equals("assignment"))
							{
								Node assign_expr = child.get(2);
								if(assign_expr instanceof Hierarquia && ((Hierarquia) assign_expr).Text.equals("arraycreation"))
								{
									Parse(hier.get(0),jsonobj); // são muitos statements;
									break; 
								}
							}
							if(child.Text.equals("for_stat"))
							{
								Parse(hier.get(0),jsonobj); // são muitos statements;
								break;
							}
							JSONArray statement = new JSONArray();
							jsonobj.add(statement);
							Parse(hier.get(0),statement);
						}
					}
					else
					{
						for( Node n : hier.children)
						{
							if(n instanceof Hierarquia)
							{
								if(((Hierarquia)n).Text.equals("statement"))
								Parse(n,jsonobj);
							}
						}
					}
				}
					break;
				case "for_stat":
				{
					int for_offset = 0;
					Node init_statement = hier.get(2);
					if(init_statement instanceof StringNode && init_statement.toString().equals(";"))
						for_offset++;
					Node condition_expr = hier.get(4-for_offset);
					if(condition_expr instanceof StringNode && condition_expr.toString().equals(";"))
						for_offset++;
					Node increment_expr = hier.get(6-for_offset);
					Node repeat_statement = hier.get(hier.size()-1);
					
					if(init_statement instanceof Hierarquia)
					{
						JSONArray init_stat = new JSONArray();
						Parse(init_statement,init_stat);
						jsonobj.add(init_stat);
					}
					
					JSONArray for_stat = new JSONArray();
					if(condition_expr instanceof Hierarquia)
					{
						for_stat.add("doUntil");
						JSONArray stat = new JSONArray(); // while(true) == do_until( Not(true) )
						stat.add(translate_op.get("!"));
						Parse(condition_expr, stat);
						for_stat.add(stat);
					}
					else // for(.; ;.) == forever
					{
						for_stat.add("doForever");
					}
					JSONArray stat = new JSONArray();
					Parse(repeat_statement, stat);
					if(increment_expr instanceof Hierarquia)
					{
						JSONArray inc_stat = new JSONArray();
						Parse(increment_expr, inc_stat);
						stat.add(inc_stat);
					}
					for_stat.add(stat);
					jsonobj.add(for_stat);
				}
					break;
				case "while_stat":
				{
					Node expr = hier.get(1);
					Node repeat_statement = hier.get(2);
					
					jsonobj.add("doUntil");
					JSONArray stat = new JSONArray(); // while(true) == do_until( Not(true) )
					stat.add(translate_op.get("!"));
					Parse(expr, stat);
					jsonobj.add(stat);
					stat = new JSONArray();
					Parse(repeat_statement, stat);
					jsonobj.add(stat);
				}
					break;
				case "if_stat":
				{
					Node expr = hier.get(1);
					Node true_statement = hier.get(2);
					Node false_statement = hier.size() == 5 ? hier.get(4) : null;
					
					if(false_statement == null)
						jsonobj.add("doIf");
					else
						jsonobj.add("doIfElse");
					
					Parse(expr, jsonobj);
					JSONArray stat = new JSONArray();
					Parse(true_statement, stat);
					jsonobj.add(stat);
					if(false_statement != null) 
					{
						stat = new JSONArray();
						Parse(false_statement, stat);
						jsonobj.add(stat);
					}
				}
					break;
				case "assignment":
				{
					
					Node tempvar = hier.get(0);
					String varname = tempvar.toString();
					
					String op = hier.get(1).toString();
					Node tempexpr = hier.get(2);
					switch(op)
					{
						case "=":
							if(tempexpr instanceof Hierarquia && ((Hierarquia) tempexpr).Text.equals("arraycreation"))
							{
								Hierarquia array_hier = (Hierarquia) tempexpr;
								JSONArray clear_stat = new JSONArray();
								clear_stat.add("deleteLine:ofList:");
								clear_stat.add("all");
								clear_stat.add(varname);
								jsonobj.add(clear_stat);
								if(!ListHelper.variables_types.containsKey(varname))
								{
									ListHelper.variables_types.put(varname, Tipo.LIST);
								}
								for(Node child : array_hier.children)
								{
									if(child instanceof Hierarquia)
									{
										Hierarquia expr = (Hierarquia) child;
										if(expr.Text.equals("expr"))
										{
											JSONArray append_stat = new JSONArray();
											append_stat.add("append:toList:");
											Parse(expr, append_stat);
											append_stat.add(varname);
											jsonobj.add(append_stat);
										}
									}
								}
							}
							else if(tempvar instanceof Hierarquia && ((Hierarquia)tempvar).Text.equals("arrayaccess"))
							{
								Hierarquia array = (Hierarquia)tempvar;
								varname = array.get(0).toString();
								Node indexexpr = array.get(2);
								//varname = tempvar;
								jsonobj.add("setLine:ofList:to:");
								Parse(indexexpr,jsonobj);
								jsonobj.add(varname);
								Parse(tempexpr,jsonobj);
							}
							else
							{
								jsonobj.add("setVar:to:");
								jsonobj.add(varname);
								Parse(tempexpr,jsonobj);
								if(!ListHelper.variables_types.containsKey(varname))
								{
									// determinar tipo da variavel
									Tipo vartipo = tempexpr.getReturnTipo();
									ListHelper.variables_types.put(varname, vartipo);
								}
							}
						break;
						case "+=":
						case "*=":
						case "-=":
						case "/=":
						case "%=":
						case "!=":
						{
							jsonobj.add("setVar:to:");
							jsonobj.add(varname);
							JSONArray expression = new JSONArray();
							GetBinaryExpr(""+op.charAt(0),tempvar,tempexpr,expression);
							//String realop =  GetBinaryOp(""+op.charAt(0),tempvar.getReturnTipo(),tempexpr.getReturnTipo());
							//expression.add(realop);
							//Parse(tempvar,expression);
							//Parse(tempexpr,expression);
							jsonobj.add(expression);
						}
						break;
						default:
							System.err.println("Operador "+op+" Não Suportado");
					}
					
				}
					break;
				case "unarystat":
				{
					jsonobj.add("changeVar:by:");
					Node left = hier.get(0);
					Node right = hier.get(1);
					
					Node tempvar = null;
					String op = "";
					if(left instanceof Hierarquia) // var ++ --
					{
						tempvar = left;
						op = right.toString();
					}
					else if(right instanceof Hierarquia)// ++ -- var
					{
						tempvar = right;
						op = left.toString();
					}
					
					jsonobj.add(tempvar.toString());
					switch(op)
					{
						case "++":
						{
							jsonobj.add("1");
						}
							break;
						case "--":
						{
							jsonobj.add("-1");
						}
							break;
						default:
							System.err.println("Operador "+op+" Não Suportado");
					}
				}
					break;
				case "expr":
				{
					if(hier.size() == 1)
					{
						Parse(hier.get(0),jsonobj);
					}
					else if(hier.size() == 2) // unary operation
					{
						Node left = hier.get(0);
						Node right = hier.get(1);
						
						if(left instanceof Hierarquia) // expr ++ --
						{
							System.err.println("Operador "+right.toString()+" Não Suportado");
						}
						else if(right instanceof Hierarquia) // ! + - expr
						{
							String op = left.toString();
							switch(op)
							{
								case "!":
								{
										JSONArray expression = new JSONArray();
										expression.add(translate_op.get(op)); // ["not",expr]
										Parse(right, expression);
										jsonobj.add(expression);
								}
									break;
								case "+":
										Parse(right,jsonobj); // +expr == expr;
									break;
								case "-":
								{
										JSONArray expression = new JSONArray();
										expression.add(translate_op.get(op));
										expression.add(0); // -expr == (0 - expr);
										Parse(right, expression);
										jsonobj.add(expression);
								}
									break;
								default:
									System.err.println("Operador "+op+" Não Suportado");
							}
						}
					}
					else if(hier.size() == 3)
					{
						Node left = hier.get(0);
						Node middle = hier.get(1);
						Node right = hier.get(2);
						if(middle instanceof Hierarquia && ((Hierarquia)middle).Text.equals("expr"))
						{
							// '(' expr ')'
							Parse(middle,jsonobj);
						}
						else if(middle instanceof StringNode)
						{
							JSONArray expression = new JSONArray();
							GetBinaryExpr(middle.toString(),left,right,expression);
							//expression.add(op);
							//Parse(left, expression);
							//Parse(right, expression);
							jsonobj.add(expression);
						}
					}
				}
					break;
				case "arrayaccess":
				{
					String varname = hier.get(0).toString();
					Node index = hier.get(2);
					JSONArray getlist = new JSONArray();
					getlist.add("getLine:ofList:");
					Parse(index,getlist);
					getlist.add(varname);
					jsonobj.add(getlist);
				}
					break;
				case "variable":
				{
					String varname = hier.get(0).toString();
					if(hier.getReturnTipo() == Tipo.BOOLEAN)
					{
						JSONArray getvar = new JSONArray();
						getvar.add("readVariable");
						getvar.add(varname);
						
						JSONArray bool_compare = new JSONArray();
						bool_compare.add("=");
						bool_compare.add(getvar);
						bool_compare.add("true");
						
						jsonobj.add(bool_compare);
					}
					else
					{
						JSONArray getvar = new JSONArray();
						getvar.add("readVariable");
						getvar.add(varname);
						jsonobj.add(getvar);
					}
				}
					break;
				case "literal":
					if(hier.getReturnTipo() == Tipo.BOOLEAN)
					{
						JSONArray bool_compare = new JSONArray();
						bool_compare.add("=");
						bool_compare.add(hier.get(0).toString());
						bool_compare.add("true");
						
						jsonobj.add(bool_compare);
					}
					else
					jsonobj.add(hier.get(0).toString());
					break;
				default: 
					System.err.println(" estrutura não suportada:"+hier.Text);
					break;
			}
			
		}
		else if(node instanceof StringNode)
		{
			System.err.println("é um stringnode:"+node);
		}
		else
		{
			System.err.println("Desconhecido:"+node);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void GetBinaryExpr(String op,Node left,Node right,JSONArray expression)
	{
		String finalop;
		switch(op)
		{
		case "+":
			if(left.getReturnTipo() == Tipo.STRING || right.getReturnTipo() == Tipo.STRING)
			{
				finalop = translate_op.get("concatenate");
			}
			else
			{
				finalop = translate_op.get(op);
			}
			
			expression.add(finalop);
			Parse(left, expression);
			Parse(right, expression);
		break;
		case "<=":
		case ">=":
		{
			// x<=y é mesma coisa que !(x>y)
			// x>=y   !(x<y)  
			finalop = op.equals("<=") ? ">" : "<";
			finalop = translate_op.get(finalop);
			
			expression.add(translate_op.get("!"));
			JSONArray equals = new JSONArray();
			equals.add(finalop);
			Parse(left, equals);
			Parse(right, equals);
			expression.add(equals);
		}
			break;
		case "!=":
		{
			finalop = translate_op.get("!");
			
			expression.add(finalop);
			JSONArray equals = new JSONArray();
			equals.add(translate_op.get("=="));
			Parse(left, equals);
			Parse(right, equals);
			expression.add(equals);
		}
			break;
		case "&&":
		case "||":
		case "!":
			if(left.getReturnTipo() != Tipo.BOOLEAN || right.getReturnTipo() != Tipo.BOOLEAN)
			{
				System.err.println("Expressão booleana com valores não booleanos! "+left+" "+op+" "+right);
			}
		default:
			finalop = translate_op.get(op);
			
			expression.add(finalop);
			Parse(left, expression);
			Parse(right, expression);
			break;
		}
	
		System.out.println(left.getReturnTipo()+" "+op+" "+right.getReturnTipo()+" -> "+finalop);

		
	}
	
	public String GetUnaryOp(String op,Tipo a)
	{
		return translate_op.get(op);
	}
	*/
}
