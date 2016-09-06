package br.erickweil.simplelang.core;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import br.erickweil.simplelang.core.ListHelper.*;
import br.erickweil.simplelang.generated.SimpleBaseListener;
import br.erickweil.simplelang.generated.SimpleParser;

public class MySecondListener extends SimpleBaseListener{

	SimpleParser parser;
	public Hierarquia arvore;
	Stack<Hierarquia> atual;

	
	public MySecondListener(SimpleParser parser) {
		// TODO Auto-generated constructor stub
		this.parser = parser;
		arvore = new Hierarquia("base");
		atual = new Stack<>();
		atual.push(arvore);
	}

	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		String RuleName = parser.getRuleNames()[ctx.getRuleIndex()];
		Hierarquia nova;
		nova = new Hierarquia(RuleName); 
		
		atual.peek().add(nova);
		atual.push(nova);
	}

	@Override
	public void visitTerminal(TerminalNode node) {
		// TODO Auto-generated method stub
		String TerminalStr = node.getText();
		Object value = null;
		Tipo tipo = null;
		int type = node.getSymbol().getType(); 
		if(type == SimpleParser.StringLiteral || type == SimpleParser.CharacterLiteral)
		{
			TerminalStr = TerminalStr.substring(1, TerminalStr.length()-1);
			value = TerminalStr;
			tipo = Tipo.STRING;
		}
		else if(type == SimpleParser.IntegerLiteral)
		{
			if(TerminalStr.contains("_"))
				TerminalStr = TerminalStr.replaceAll("_", "");
			char c0 = TerminalStr.charAt(0);
			char c1 = TerminalStr.length() > 1 ? Character.toLowerCase(TerminalStr.charAt(1)) : '?';
			if(c0 == '0')
			{
				TerminalStr = TerminalStr.substring(1);
				if(c1 == 'x')
				{
					TerminalStr = TerminalStr.substring(1);
					value = Integer.parseInt(TerminalStr,16);
				}
				else if(c1 == 'b')
				{
					TerminalStr = TerminalStr.substring(1);
					value = Integer.parseInt(TerminalStr,2);
				}
				else if (Character.isDigit(c1))
				{
					value = Integer.parseInt(TerminalStr,8);
				}
				else if( !(TerminalStr.length() > 1))
				{
					value = 0;
				}
				else
				{
					System.err.println("Int inválido:"+TerminalStr);
				}
			}
			else
			{
				value = Integer.parseInt(TerminalStr);
			}
			tipo = Tipo.INTEGER;
		}
		else if(type == SimpleParser.FloatingPointLiteral)
		{
			if(TerminalStr.endsWith("f"))
			{
				TerminalStr = TerminalStr.substring(0, TerminalStr.length()-1);
				value = Float.parseFloat(TerminalStr);
				tipo = Tipo.FLOAT;
			}
			else
			{
				if(TerminalStr.endsWith("d"))TerminalStr = TerminalStr.substring(0, TerminalStr.length()-1);
				value = Double.parseDouble(TerminalStr);
				tipo = Tipo.DOUBLE;
			}
		}
		else if(type == SimpleParser.BooleanLiteral)
		{
			value = Boolean.parseBoolean(TerminalStr);
			tipo = Tipo.BOOLEAN;
		}
		else if(TerminalStr.equals("null"))
		{
			value = null;
			tipo = Tipo.NULL;
		}
		else
		{
			value = TerminalStr;
		}
		atual.peek().add(new StringNode(value+"",value,type,tipo));
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		atual.pop();
	}
	

}
