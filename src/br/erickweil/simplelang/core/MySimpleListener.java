package br.erickweil.simplelang.core;

import java.beans.Expression;
import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import br.erickweil.simplelang.generated.SimpleBaseListener;

public class MySimpleListener extends SimpleBaseListener{
/*
	SimpleParser parser;
	JSONObject scratch_json;
	JSONArray scripts;
	Object tobj;
	public static int ident = 0;
	
	public MySimpleListener(SimpleParser parser, JSONObject jsonobj) {
		// TODO Auto-generated constructor stub
		this.parser = parser;
		this.scratch_json = jsonobj;
		scripts = (JSONArray) scratch_json.get("scripts");
		scripts.clear();
	}

/*
	@SuppressWarnings("unchecked")
	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		//if(ctx.getChildCount() > 1)
		String RuleName = parser.getRuleNames()[ctx.getRuleIndex()];
		switch(RuleName)
		{
			case "block":
			{
				JSONArray scripts = (JSONArray) json_stack.peek();
				
				JSONArray block = new JSONArray();
				block.add(0);//x
				block.add(0);//y
				JSONArray temparray = new JSONArray();
				block.add(temparray);
				JSONArray blockname = new JSONArray();
				blockname.add("whenGreenFlag");
				temparray.add(blockname);
				scripts.add(block);
				
				json_stack.push(temparray);
			}
				break;
			case "statement":
			{
				JSONArray block = (JSONArray) json_stack.peek();
				
				JSONArray statement = new JSONArray();
				block.add(statement);
				json_stack.push(statement);
			}
				break;
			case "assignment":
			{
				JSONArray statement = (JSONArray) json_stack.peek();
				statement.add("setVar:to:");
				AssignmentContext myctx = (AssignmentContext) ctx;
				statement.add(myctx.variable().getText());

			}
				break;
			case "expr":
			{
				ExprContext myctx = (ExprContext) ctx;
				
				JSONArray prev_expression = (JSONArray) json_stack.peek();
				JSONArray expression = new JSONArray();

				prev_expression.add(expression);
				json_stack.push(expression);
			}
				break;
			case "variable":
				break;
			case "literal":
				break;
		}
		
		System.out.println( GetIdent(ident)+RuleName);
		ident++;
		//else
		//System.out.print(ctx.getText());
	}


	@SuppressWarnings("unchecked")
	@Override
	public void enterBlock(BlockContext ctx) {
		// TODO Auto-generated method stub
		JSONArray block = new JSONArray();
		block.add(0);//x
		block.add(0);//y
		JSONArray temparray = new JSONArray();
		block.add(temparray);
		JSONArray blockname = new JSONArray();
		blockname.add("whenGreenFlag");
		temparray.add(blockname);
		scripts.add(block);
		
		//System.out.println("Block");
		//for( StatementContext child : ctx.statement())
		//{
			//System.out.println(parser.getRuleNames()[child.getRuleIndex()]);
			tobj = block;
			enterStatement(ctx.statement());
		//}
		//enterVariable(ctx.get);
	}


	@SuppressWarnings("unchecked")
	@Override
	public void enterStatement(StatementContext ctx) {
		// TODO Auto-generated method stub
		if( ctx.assignment() != null)
		{
			JSONArray block = (JSONArray) tobj;
			JSONArray statement = new JSONArray();
			block.add(statement);
			tobj = statement;
			enterAssignment(ctx.assignment());
		}
		if( ctx.if_stat() != null)
			enterIf_stat(ctx.if_stat());
	}


	@Override
	public void enterIf_stat(If_statContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("If_stat");
	}


	@SuppressWarnings("unchecked")
	@Override
	public void enterAssignment(AssignmentContext ctx) {
		// TODO Auto-generated method stub
		JSONArray statement = (JSONArray) tobj;
		statement.add("setVar:to:");
		VariableContext variable = ctx.variable();
		tobj = statement;
		enterVariable(variable);
		
		
		ExprContext expression = ctx.expr();
		tobj = statement;
		enterExpr(expression);

	}


	@Override
	public void enterExpr(ExprContext ctx) {
		// TODO Auto-generated method stub
		JSONArray statement = (JSONArray) tobj;
		for( ParseTree child : ctx.children)
		{
			if(child instanceof ExprContext)
			{
				//System.out.println("Uhuul");
				enterExpr((ExprContext)child);
			}
		}
		System.out.println("expr"+ctx.ADDMINUS()+ctx.MULTIPLICATIVE()+ctx.variable()+ctx.literal());
	}


	@SuppressWarnings("unchecked")
	@Override
	public void enterVariable(VariableContext ctx) {
		// TODO Auto-generated method stub
		JSONArray statement = (JSONArray) tobj;
		statement.add(ctx.getText());
		System.out.print(ctx.getText());
	}


	@Override
	public void enterLiteral(LiteralContext ctx) {
		// TODO Auto-generated method stub
		System.out.print(ctx.getText());
	}


	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		//if(ctx.getChildCount() > 1)
		ident--;
		//System.out.println(GetIdent(ident)+"}");
	}


	@Override
	public void visitTerminal(TerminalNode node) {
		// TODO Auto-generated method stub
		System.out.println(GetIdent(ident)+node.getText());
	}

	public static String GetIdent(int ident)
	{
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<ident;i++)
		{
			builder.append("|   ");
		}
		return builder.toString();
	}
*/
}
