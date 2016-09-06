package br.erickweil.simplelang.core;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import br.erickweil.simplelang.core.ListHelper.*;
import br.erickweil.simplelang.generated.SimpleParser;
@SuppressWarnings("unchecked")
public class ConvertHierarquia{
	
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
	
	public static Map<String,Tipo> variables_types;
	public static ArrayList<String> method_params;
	public static Map<String,String> jsonmethods_names;
	public static Map<String,Tipo> lists_types;
	static{
		variables_types = new HashMap<>();
		lists_types = new HashMap<>();
		method_params = new ArrayList<String>();
		jsonmethods_names = new HashMap<>();
	}
	static int tempvar;
	static int tempwhilevar;
	static String declaring_array;
	static Hierarquia generated;
	static Hierarquia hierarquia;
	
	public static JSONArray convert(Hierarquia hierarquia_toconvert) throws ParseException
	{
		hierarquia = hierarquia_toconvert;
		ScratchStantardLibrary.getMethods();
		JSONArray generated = new JSONArray();
		
		List<Hierarquia> classes = hierarquia.deepGet("classDeclaration",10);
		//if(classes.size() != 1) throw new ParseException("Expecting one, and only one, class declaration", 1);
		for(int i=0;i<classes.size();i++)
		generated.add(convert_classe(classes.get(i),i+1));
		
		return generated;
	}
	
	public static JSONObject convert_classe(Hierarquia parent,int index)
	{
		List<Hierarquia> metodos = parent.deepGet("methodDeclaration",6);
		String class_name = parent.leafGet(SimpleParser.Identifier);
		JSONObject classe = new JSONObject();
		classe.put("objName",class_name);
		JSONArray scripts = new JSONArray();
		for(Hierarquia metodo : metodos)
		{
			scripts.add(convert_metodo(metodo));
		}
		JSONObject costume = new JSONObject();
		costume.put("costumeName", "fantasia1");
		costume.put("baseLayerID", 1);
		costume.put("baseLayerMD5", "09dc888b0b7df19f70d81588ae73420e.svg");
		costume.put("bitmapResolution", 1);
		costume.put("rotationCenterX", 47);
		costume.put("rotationCenterY", 55);
		JSONArray costumes = new JSONArray();
		costumes.add(costume);
		classe.put("costumes",costumes);
		classe.put("scripts",scripts);
		classe.put("currentCostumeIndex",0);
		classe.put("scratchX",0);
		classe.put("scratchY",0);
		classe.put("scale",1);
		classe.put("direction",90);
		classe.put("rotationStyle","normal");
		classe.put("isDraggable",false);
		classe.put("indexInLibrary",index);
		classe.put("visible",true);
		classe.put("spriteInfo",new JSONObject());
		/*
		    "costumes": [{
					"costumeName": "fantasia1",
					"baseLayerID": 1,
					"baseLayerMD5": "d36f6603ec293d2c2198d3ea05109fe0.png",
					"bitmapResolution": 2,
					"rotationCenterX": 0,
					"rotationCenterY": 0
				}],
			"currentCostumeIndex": 0,
			"scratchX": 0,
			"scratchY": 0,
			"scale": 1,
			"direction": 90,
			"rotationStyle": "normal",
			"isDraggable": false,
			"indexInLibrary": 1,
			"visible": true,
			"spriteInfo": {
			}
		 */
		
		return classe;
	}
	
	public static JSONArray convert_metodo(Hierarquia parent)
	{
		String method_name = parent.leafGet(SimpleParser.Identifier);
		JSONArray metodo = new JSONArray();
		metodo.add(0);
		metodo.add(0);
		JSONArray stats = new JSONArray();
		List<Hierarquia> statements = parent.deepGet("blockStatement",4);
		JSONArray json_parameters = new JSONArray();
		JSONArray json_emptyparameters = new JSONArray();
		//JSONArray parameters_declare = new JSONArray();
		Hierarquia parameterList = parent.deepFGet("formalParameterList", 3);
		method_params.clear();
		if(parameterList != null)
		{
			List<Hierarquia> parameters = parameterList.deepGet("formalParameter", 1);
			for(Hierarquia parameter : parameters)
			{
				String type = parameter.deepFGet("type", 1).toString();
				String name = parameter.deepFGet("variableDeclaratorId",1).toString();
				json_parameters.add(name);
				json_emptyparameters.add("");
				method_name += " "+name+":%s";
				
				//JSONArray tempassign_stat = new JSONArray();
				//tempassign_stat.add("setVar:to:");
				//tempassign_stat.add(name);
				//JSONArray get_par = new JSONArray();
				//get_par.addAll(Arrays.asList("getParam",name,"r"));
				//tempassign_stat.add(get_par);
				variables_types.put(name, Tipo.STRING);
				method_params.add(name);
				//parameters_declare.add(tempassign_stat);
			}
		}
		
		jsonmethods_names.put(parent.leafGet(SimpleParser.Identifier),method_name);
		
		JSONArray definition = new JSONArray();
		definition.add("procDef");
		definition.add(method_name);
		definition.add(json_parameters);
		definition.add(json_emptyparameters);
		definition.add(true);
		stats.add(definition);
		//stats.addAll(parameters_declare);
		for(Hierarquia statement : statements)
		{
			stats.addAll(convert_statement(statement));
		}
		metodo.add(stats);
		return metodo;
	}

	static List<JSONArray> convert_statement(Hierarquia parent) {
		// TODO Auto-generated method stub
		Hierarquia parentstat = (Hierarquia) parent.get(0);
		String statement_type;
		if(parentstat.getText().equals("statement"))
		{
			statement_type = parentstat.get(0).getText();
		}
		else
		{
			statement_type = parentstat.getText();
		}
		List<JSONArray> statements = new ArrayList<>();
		switch(statement_type)
		{
			case "localVariableDeclarationStatement":
			{
				Hierarquia type = parentstat.deepFGet("type",2);
				List<Hierarquia> declarations = parentstat.deepGet("variableDeclarator",4);
				for(Hierarquia declaration : declarations)
				{
					statements.addAll(convert_declaration(declaration));
				}
			}
				break;
			case "block":
			{
				List<Hierarquia> stats = parentstat.deepGet("blockStatement",1);
				for(Hierarquia statement : stats)
				{
					statements.addAll(convert_statement(statement));
				}
			}
				break;
			case "if" :
			{
				Hierarquia if_condition = parentstat.deepFGet("expression",2);
				
				Hierarquia true_stat = (Hierarquia) parentstat.get(2);
				Hierarquia false_stat = parentstat.size() == 5 ? (Hierarquia)parentstat.get(4) : null;
				
				JSONArray if_statement = new JSONArray();
				if(false_stat == null)
					if_statement.add("doIf");
				else
					if_statement.add("doIfElse");
				
				convert_expression(if_condition, statements, if_statement);
				JSONArray stat = new JSONArray();
				stat.addAll(convert_statement(true_stat));
				if_statement.add(stat.size() > 0 ? stat : null);
				if(false_stat != null) 
				{
					stat = new JSONArray();
					stat.addAll(convert_statement(false_stat));
					if_statement.add(stat.size() > 0 ? stat : null);
				}
				
				statements.add(if_statement);
			}
				break;
			case "for" :
			{
				// 0    1       2      3    4
				//'for' '(' forControl ')' statement
				Hierarquia forcontrol = (Hierarquia) parentstat.get(2);
				//   forInit? ';' expression? ';' forUpdate?
				
				
				Hierarquia for_init = forcontrol.deepFGet("forInit",1); //localVariableDeclaration   |   expressionList
				Hierarquia for_condition = forcontrol.deepFGet("expression",1);
				Hierarquia for_inc = forcontrol.deepFGet("forUpdate",1); //expressionList
				List<Hierarquia> for_inc_expressions = for_inc != null ? for_inc.deepGet("expression", 1) : null;
				Hierarquia for_statement = (Hierarquia) parentstat.get(4);
				
				if(for_init != null)
				{
					Hierarquia init = (Hierarquia) for_init.get(0);
					String init_type = init.getText();
					switch(init_type)
					{
						case "localVariableDeclaration": 
						{
							List<Hierarquia> declarations = init.deepGet("variableDeclarator",4);
							for(Hierarquia declaration : declarations)
							{
								statements.addAll(convert_declaration(declaration));
							}
						}
							break;
						case "expressionList": 
						{
							List<Hierarquia> for_init_exprs = init.deepGet("expression", 1);
							for(Hierarquia init_expr : for_init_exprs)
							{
								tempvar = 0;
								convert_expression(init_expr, statements, null);
							}
						}
							break;
					}
				}
				JSONArray while_statement = new JSONArray();
				while_statement.add("doUntil");
				
				JSONArray stat = new JSONArray(); // while(true) == do_until( Not(true) )
				stat.add(translate_op.get("!"));
				tempvar = 0;
				convert_expression(for_condition, statements, stat);
				while_statement.add(stat);
				
				stat = new JSONArray();
				stat.addAll(convert_statement(for_statement));
				if(for_inc_expressions != null)
				{
					for(Hierarquia inc_expr : for_inc_expressions) 
					{
						tempvar = 0;
						convert_expression(inc_expr, stat, null);
					}
				}
				while_statement.add(stat.size() > 0 ? stat : null);
				
				statements.add(while_statement);
			}
				break;
			case "while" :
			{
				Hierarquia while_condition = parentstat.deepFGet("expression",2);
				Hierarquia repeat_statement = (Hierarquia) parentstat.get(2);
				
				JSONArray while_statement = new JSONArray();
				while_statement.add("doUntil");
				
				JSONArray stat = new JSONArray(); // while(true) == do_until( Not(true) )
				stat.add(translate_op.get("!"));
				tempvar = 0;
				convert_expression(while_condition, statements, stat);
				while_statement.add(stat);
				
				stat = new JSONArray();
				stat.addAll(convert_statement(repeat_statement));
				while_statement.add(stat.size() > 0 ? stat : null);
				
				statements.add(while_statement);
			}
				break;
			case "do" :
			{
				//  0     1           2        3          4
				// 'do' statement 'while' parExpression ';'
				Hierarquia while_condition = (Hierarquia) ((Hierarquia)parentstat.get(3)).get(1); // '(' expression ')'
				Hierarquia repeat_statement = (Hierarquia) parentstat.get(1);
				
				String whilecondvar ="untilcond"+(tempwhilevar++); 
				declareGenVariable(whilecondvar,true,Tipo.INTEGER,statements);
				
				JSONArray while_statement = new JSONArray();
				while_statement.add("doUntil");
				
				JSONArray stat = new JSONArray(); // while(true) == do_until( Not(true) )
				stat.add(translate_op.get("=="));
				readGenVariable(whilecondvar,stat);
				stat.add("false");
				tempvar = 0;
				while_statement.add(stat);
				
				stat = new JSONArray();
				stat.addAll(convert_statement(repeat_statement));
				setGenVariable(whilecondvar,while_condition,stat);	
				
				while_statement.add(stat.size() > 0 ? stat : null);
				
				statements.add(while_statement);
			}
				break;
			case "assert": 
			case "try" :
			case "switch" :
			case "synchronized" :
			case "return" :
			case "throw" :
			case "break" :
			case "continue" :
			case "typeDeclaration":
				System.err.println("programming Structure not supported:"+statement_type);
				break;
			case ";":break;
			case "statementExpression":
				Hierarquia statementExpression = (Hierarquia)((Hierarquia)parentstat.get(0)).get(0);
				tempvar = 0;
				convert_expression(statementExpression,statements,null);
				break;
			default:
			    // Identifier ':' statement
				System.err.println("Unknown statement:"+parentstat.toString());
				break;
		}
		return statements;
	}
	
	static List<JSONArray> convert_declaration(Hierarquia parent)
	{
		String varName = parent.deepFGet("variableDeclaratorId",1).leafGet(SimpleParser.Identifier);
		
		Hierarquia initializer = parent.deepFGet("variableInitializer",1);
		List<JSONArray> statements = new ArrayList<>();
		if(initializer != null)
		{
			Hierarquia init_expr = (Hierarquia) initializer.get(0);
			String init_type = init_expr.getText();
			if(init_type.equals("expression"))
			{
				Hierarquia creator = init_expr.deepFGet("creator", 1);
				if(creator != null)
				{
					//  nonWildcardTypeArguments createdName classCreatorRest  |   createdName (arrayCreatorRest | classCreatorRest)
					Hierarquia array_creator = creator.deepFGet("arrayCreatorRest",1);
					if(array_creator != null)
					{
					//    '[' 
					//     (
					//			']' ('[' ']')* arrayInitializer
					//      |
					//          expression ']' ('[' expression ']')* ('[' ']')* 
					//     )

						Hierarquia array_init = array_creator.deepFGet("arrayInitializer", 1);
						if(array_init != null) //']' ('[' ']')* arrayInitializer
						{
							init_expr = array_init;
							init_type = init_expr.getText();
						}
						else // expression ']' ('[' expression ']')* ('[' ']')* 
						{
							System.err.println("you need to declare arrays explicity!");
						}
					}
					else
						System.err.println("you can't create objects!");
				}
			}
			switch(init_type)
			{	
				case "arrayInitializer":
				{		
					JSONArray clear_stat = new JSONArray();
					clear_stat.add("deleteLine:ofList:");
					clear_stat.add("all");
					clear_stat.add(varName);
					statements.add(clear_stat);
					
					Tipo array_tipo = initializeArray(varName,init_expr,statements);
					
					variables_types.put(varName, Tipo.LIST);
					lists_types.put(varName, array_tipo);
				}
					break;
				case "expression":
				{
					JSONArray declaration = new JSONArray();
					declaration.add("setVar:to:");
					declaration.add(varName);	
					tempvar = 0;
					convert_expression(init_expr,statements,declaration);
					statements.add(declaration);
					
					variables_types.put(varName, init_expr.getReturnTipo());
				}
					break;
			}
		}
		
		return statements;
	}
	
	static void convert_expression(Hierarquia parent,List<JSONArray> prev_statement,JSONArray append_array)
	{
		if(parent.size() >= 3)
		{
		/*
		 
			expression '.' 'new' nonWildcardTypeArguments? innerCreator
			expression '.' 'super' superSuffix
			expression '[' expression ']'
			expression '(' expressionList? ')'
			'(' type ')' expression
		*/
			boolean matched = true;
			switch(parent.get(1).getText())
			{
				case "(":
				{
					//  0         1        2          2,3
					// expression '(' expressionList? ')'
					// primary 
					
					
					Hierarquia expressionList = (Hierarquia) parent.get(2);
					
					
					String methName = parent.get(0).toString();
					if(ScratchStantardLibrary.meths.containsKey(methName))
					{
						MethInfo meth = ScratchStantardLibrary.meths.get(methName);
						if(meth.returnTipo.equals(Tipo.VOID))
						{
							JSONArray call = new JSONArray();
							call.add(meth.scratchName);
							for(String par : meth.scratchParams) if(!par.equals("")) call.add(par);
							if(expressionList != null)
							{
								List<Hierarquia> meth_call_exprs = expressionList.deepGet("expression", 1);
								for(Hierarquia init_expr : meth_call_exprs)
								{
									convert_expression(init_expr, prev_statement, call);
								}
							}
							prev_statement.add(call);
						}
						else
						{
							JSONArray reporter = new JSONArray();
							reporter.add(meth.scratchName);
							for(String par : meth.scratchParams) if(!par.equals("")) reporter.add(par);
							if(expressionList != null)
							{
								List<Hierarquia> meth_call_exprs = expressionList.deepGet("expression", 1);
								for(Hierarquia init_expr : meth_call_exprs)
								{
									convert_expression(init_expr, prev_statement, reporter);
								}
							}
							append_array.add(reporter);
						}
					}
					else if(jsonmethods_names.containsKey(methName))
					{
						JSONArray call = new JSONArray();
						call.add("call");
						call.add(jsonmethods_names.get(methName));
						if(expressionList != null)
						{
							List<Hierarquia> meth_call_exprs = expressionList.deepGet("expression", 1);
							for(Hierarquia init_expr : meth_call_exprs)
							{
								convert_expression(init_expr, prev_statement, call);
							}
						}
						prev_statement.add(call);
						
						if(append_array != null) // its not a expression statement, needs to return the variable itself
						{
							declareMethTemp(methName,prev_statement,append_array);
						}
					}
					else
					{
						System.err.println("Method "+methName+" do not exist!");
					}
				}
				break;
				case "[":
				{
					//   0         1       2      3
					// expression '[' expression ']'
					//  primary
					// Identifier
					String array_name = parent.deepFGet("primary", 2).get(0).getText();
					Hierarquia index_expr = (Hierarquia) parent.get(2);
					
					JSONArray getline = new JSONArray();
					getline.add("getLine:ofList:");
					convert_expression(index_expr, prev_statement, getline);
					getline.add(array_name);
					
					append_array.add(getline);
				}
				break;
				default:
					matched = false;
				break;
			}
			if(!matched && parent.size() == 3)
			{
			if(parent.get(0) instanceof Hierarquia && parent.get(2) instanceof Hierarquia)
			{
				Hierarquia left = (Hierarquia) parent.get(0);
				String operator = parent.get(1).getText();
				String finalop = translate_op.get(operator);
				Hierarquia right = (Hierarquia) parent.get(2);
				JSONArray expression = new JSONArray();
				switch(operator)
				{
						
					case "+":
						if(left.getReturnTipo() == Tipo.STRING || right.getReturnTipo() == Tipo.STRING)
						{
							finalop = translate_op.get("concatenate");
						}
						else
						{
							finalop = translate_op.get(operator);
						}
						
						expression.add(finalop);
						convert_expression(left, prev_statement,expression);
						convert_expression(right, prev_statement,expression);
					break;
					case "<=":
					case ">=":
					{
						// x<=y é mesma coisa que !(x>y)
						// x>=y   !(x<y)  
						finalop = operator.equals("<=") ? ">" : "<";
						finalop = translate_op.get(finalop);
						
						expression.add(translate_op.get("!"));
						JSONArray equals = new JSONArray();
						equals.add(finalop);
						convert_expression(left, prev_statement,equals);
						convert_expression(right, prev_statement,equals);
						expression.add(equals);
					}
						break;
					case "!=":
					{
						finalop = translate_op.get("!");
						
						expression.add(finalop);
						JSONArray equals = new JSONArray();
						equals.add(translate_op.get("=="));
						convert_expression(left, prev_statement,equals);
						convert_expression(right, prev_statement,equals);
						expression.add(equals);
					}
						break;
					case "&&":
					case "||":
					case "!":
						if(left.getReturnTipo() != Tipo.BOOLEAN || right.getReturnTipo() != Tipo.BOOLEAN)
						{
							System.err.println("Expressão booleana com valores não booleanos! "+left+" "+operator+" "+right);
						}
					case "-":
					case "*":
					case "/":
					case "%":
					case "<":
					case ">":
					case "==":
						expression.add(finalop);
						convert_expression(left, prev_statement,expression);
						convert_expression(right, prev_statement,expression);
						break;
					case "=":
					case "+=":
					case "*=":
					case "/=":
					case "-=":
					case "%=":
					{
						if(operator.length() == 2)
						{
							Hierarquia compost = new Hierarquia("expression");
							compost.add(left);
							compost.add(new StringNode(""+operator.charAt(0)));
							compost.add(right);
							if(!assignArrayOrVariable(left,compost,prev_statement))
								System.err.println("Assignment expression with invalid primary:"+left.get(0).toString());
						}
						else
						{
							if(!assignArrayOrVariable(left,right,prev_statement))
								System.err.println("Assignment expression with invalid primary:"+left.get(0).toString());
						}
						
						if(append_array != null) // its not a expression statement, needs to return the variable itself
						{
							declareTemp(left,prev_statement,append_array);
						}
					}
						break;
					default:
						System.err.println("Operator "+operator+" not supported");
					break;
				}
				if(append_array != null)
				{
					if(expression.size() > 0)
					append_array.add(expression);
				}
				else
				{
					if(expression.size() > 0) System.err.println("expressão inútil:"+expression);
				}
			}
			else
			System.err.println("expression "+parent.toString()+" not supported");
			}
			else if(!matched)
				System.err.println("expression "+parent.toString()+" not supported");
		}
		else if(parent.size() == 2) // unary expression
		{
		    //|   'new' creator
		    //|   expression ('++' | '--')
		    //|   ('+'|'-'|'++'|'--') expression
		    //|   ('~'|'!') expression
			Node left = parent.get(0);
			Node right = parent.get(1);
			if(left instanceof Hierarquia) // expression ('++' | '--')
			{
				Hierarquia expr = (Hierarquia) left;
				String varName = extractVariable(expr);
				if(varName != null)
				{
					if(append_array != null) // its not a expression statement, needs to return the variable itself
					{
						declareTemp(expr,prev_statement,append_array);
					}
					
					// first it returns the variable, then it increments itself
					
					JSONArray inc_stat = new JSONArray();
					inc_stat.add("changeVar:by:");
					inc_stat.add(varName);
					switch(right.getText())
					{
						case "++": inc_stat.add(1);break;
						case "--": inc_stat.add(-1);break;
					}
					prev_statement.add(inc_stat);
				}
				else
				{
					System.err.println("Increment expression with invalid primary:"+expr.get(0).toString());
				}
			}
			else // (new |'~'|'!'|'+'|'-'|'++'|'--') expression
			{
				Hierarquia expr = (Hierarquia) right;
				String operator = left.getText();
				switch(operator)
				{
					case "!":
					{
						JSONArray expression = new JSONArray();
						expression.add(translate_op.get(operator)); // ["not",expr]
						convert_expression(expr, prev_statement, expression);
						append_array.add(expression);
					}
						break;
					case "+":
							convert_expression(expr, prev_statement, append_array);
						break;
					case "-":
					{
						JSONArray expression = new JSONArray();
						expression.add(translate_op.get(operator));
						expression.add(0); // -expr == (0 - expr);
						convert_expression(expr, prev_statement, expression);
						append_array.add(expression);
					}
						break;
					case "++":
					case "--":
					{
						String varName = extractVariable(expr);
						if(varName != null)
						{
							
							JSONArray inc_stat = new JSONArray();
							inc_stat.add("changeVar:by:");
							inc_stat.add(varName);
							switch(operator)
							{
								case "++": inc_stat.add(1);break;
								case "--": inc_stat.add(-1);break;
							}
							prev_statement.add(inc_stat);
							
							// first it increments itself then returns the value
							
							if(append_array != null) // its not a expression statement, needs to return the variable itself
							{
								declareTemp(expr,prev_statement,append_array);
							}
							
							
						}
						else
						{
							System.err.println("Increment expression with invalid primary:"+expr.get(0).toString());
						}
					}
						break;
					case "new":
					{
						System.err.println("you can't create objects!");
					}
						
						break;
					default:
						System.err.println("Operator "+operator+" not supported");
				}
			}
		}
		else if(parent.size() == 1) // primary
		{
			convert_primary((Hierarquia)parent.get(0),prev_statement,append_array);
		}
		else
		{
			System.err.println("expression "+parent.toString()+" not supported");
		}
	}
	
	static void convert_primary(Hierarquia parent,List<JSONArray> prev_statement,JSONArray append_array)
	{
		if(parent.size() == 3) // '(' expression ')' |   type '.' 'class'   |   'void' '.' 'class'
		{
			if(parent.get(1).getText().equals("expression"))
			convert_expression((Hierarquia)parent.get(1), prev_statement, append_array);
			else
			System.err.println("Primary "+parent.toString()+" not supported");
		}
		else if(parent.size() == 1)
		{
			Node primary = parent.get(0);
			if(primary instanceof Hierarquia)
			{
				switch(primary.getText())
				{
					case "literal":
							append_array.add(primary.getValue());
						break;
					case "this":
					case "super":
					default:
						System.err.println("Primary "+primary.toString()+" not supported");
						break;
				}
			}
			else // 				case "Identifier":
			{
				String varName = primary.getText();
				if(method_params.contains(varName))
				{
					JSONArray tempread = new JSONArray();
					tempread.add("getParam");
					tempread.add(primary.getValue());
					tempread.add("r");
					append_array.add(tempread);
				}
				else
				{
					JSONArray tempread = new JSONArray();
					tempread.add("readVariable");
					tempread.add(primary.getValue());
					append_array.add(tempread);
				}
			}
		}
		else
		{
			System.err.println("Primary "+parent.toString()+" not supported");
		}
	}
	
	static Tipo initializeArray(String array_Name,Hierarquia array_init, List<JSONArray> prev_statement)
	{
		// '{' (variableInitializer (',' variableInitializer)* (',')? )? '}'
		List<Hierarquia> variable_inits = array_init.deepGet("variableInitializer",1);
		Tipo tipo = null;
		for(Hierarquia var_init : variable_inits)
		{
			Hierarquia var_init_expr = var_init.deepFGet("expression", 1);
			if(var_init_expr!= null) //  arrayInitializer   |   expression
			{
				JSONArray append_list = new JSONArray();
				append_list.add("append:toList:");
				convert_expression(var_init_expr, prev_statement, append_list);
				append_list.add(array_Name);
				prev_statement.add(append_list);
				
				if(tipo == null) tipo = var_init_expr.getReturnTipo();
			}
			else 
			{
				System.err.println("you can't declare arrays of multiple dimensions:\n"+var_init.toString());
			}
		}
		return tipo;
	}
	
	static String extractVariable(Hierarquia Expression)
	{
		if(Expression.get(0).getText().equals("primary"))
		{
			Hierarquia primary = (Hierarquia) Expression.get(0);
			if(primary.get(0).getType() == SimpleParser.Identifier)
			{
				
				String varName = primary.get(0).getText();
				if(!variables_types.containsKey(primary.get(0).getText()))
				System.err.println("Var "+primary+" not declared");
				return varName;
			}
		}
		return null;
	}
	
	static boolean assignArrayOrVariable(Hierarquia expression_Var,Hierarquia exression_Assign,List<JSONArray> prev_statement)
	{
		//      0       1      2        3
		//0            expression
		//1   expression '[' expression ']'
		//2   primary        expression
		//3   Identifier     expression
		// |
		//0   expression
		//1   primary 
		//2   Identifier
		if(expression_Var.get(0).getText().equals("primary"))
		{
			Hierarquia primary = (Hierarquia) expression_Var.get(0);
			if(primary.get(0).getType() == SimpleParser.Identifier)
			{
				String varName = primary.get(0).getText();
				if(!variables_types.containsKey(primary.get(0).getText()))
				System.err.println("Var "+primary+" not declared");
				
				JSONArray var_assign = new JSONArray();
				var_assign.add("setVar:to:");
				var_assign.add(varName);
				convert_expression(exression_Assign, prev_statement, var_assign);
				prev_statement.add(var_assign);
				return true;
			}
			else
				return false;
		}
		else
		{
			Hierarquia primary = expression_Var.deepFGet("primary", 2);
			Hierarquia expression = (Hierarquia) expression_Var.get(2);
			if(primary != null && expression != null)
			{
				if(primary.get(0).getType() == SimpleParser.Identifier)
				{
					
					String varName = primary.get(0).getText();
					if(!variables_types.containsKey(primary.get(0).getText()))
					System.err.println("Var "+primary+" not declared");
					
					JSONArray array_assign = new JSONArray();
					array_assign.add("setLine:ofList:to:");
					convert_expression(expression, prev_statement, array_assign);
					array_assign.add(varName);
					convert_expression(exression_Assign, prev_statement, array_assign);
					prev_statement.add(array_assign);
					return true;
				}
				else
				return false;
			}
			else
			return false;
		}
		
	}
	
	static void declareTemp(Hierarquia left,List<JSONArray> prev_statement,JSONArray append_array)
	{
		// put this result in a tempvar
		String tvar = "t_"+tempvar;
		tempvar++;
		JSONArray tempassign_stat = new JSONArray();
		tempassign_stat.add("setVar:to:");
		tempassign_stat.add(tvar);
		convert_primary((Hierarquia)left.get(0), prev_statement, tempassign_stat);
		prev_statement.add(tempassign_stat);
		JSONArray tempread = new JSONArray();
		tempread.add("readVariable");
		tempread.add(tvar);
		append_array.add(tempread);
	}
	
	static void declareMethTemp(String methName,List<JSONArray> prev_statement,JSONArray append_array)
	{
		// put this result in a tempvar
		String tvar = "t_"+tempvar;
		tempvar++;
		JSONArray tempassign_stat = new JSONArray();
		tempassign_stat.add("setVar:to:");
		tempassign_stat.add(tvar);
		String varName = methName+"_return";
		convert_primary(new Hierarquia("primary",new StringNode(varName,varName,SimpleParser.Identifier,Tipo.STRING)), prev_statement, tempassign_stat);
		prev_statement.add(tempassign_stat);
		JSONArray tempread = new JSONArray();
		tempread.add("readVariable");
		tempread.add(tvar);
		append_array.add(tempread);
	}
	
	static void declareGenVariable(String varName,Object varValue,Tipo tipo,List<JSONArray> prev_statement)
	{
		JSONArray tempassign_stat = new JSONArray();
		tempassign_stat.add("setVar:to:");
		tempassign_stat.add(varName);
		tempassign_stat.add(varValue);
		prev_statement.add(tempassign_stat);
		variables_types.put(varName, tipo);
	}
	static void readGenVariable(String varName,JSONArray append_array)
	{
		JSONArray tempread = new JSONArray();
		tempread.add("readVariable");
		tempread.add(varName);
		append_array.add(tempread);
	}
	static void setGenVariable(String varName,Hierarquia expr,List<JSONArray> prev_statement)
	{
		JSONArray tempassign_stat = new JSONArray();
		tempassign_stat.add("setVar:to:");
		tempassign_stat.add(varName);
		convert_expression(expr, prev_statement, tempassign_stat);
		prev_statement.add(tempassign_stat);
	}
}
