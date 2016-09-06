package br.erickweil.simplelang;

import java.io.File;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.Arrays;

import org.antlr.v4.Tool;
import org.antlr.v4.gui.TreeTextProvider;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.Tree;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import br.erickweil.simplelang.core.ConvertHierarquia;
import br.erickweil.simplelang.core.GenerateJson;
import br.erickweil.simplelang.core.ListHelper;
import br.erickweil.simplelang.core.ListHelper.Hierarquia;
import br.erickweil.simplelang.core.MySecondListener;
import br.erickweil.simplelang.core.MySimpleListener;
import br.erickweil.simplelang.generated.SimpleLexer;
import br.erickweil.simplelang.generated.SimpleParser;
import br.erickweil.simplelang.utils.LoadFile;

public class Main {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		StringBuilder Allfiles = new StringBuilder();
		System.out.println(Arrays.toString(new File("javacode").list()));
		String[] files = LoadFile.Readtxt("javacode/",new File("javacode").list());
		for(String s : files) Allfiles.append(s);
		String result_json = print(
				Allfiles.toString(),
				LoadFile.Readtxt("project/project.json")
			);
		
		String zipPath = "generated.sb2";
		String[] zipPaths = new String[]{"project.json","0.png","0.wav","1.svg","1.wav","2.svg","3.png"};
		byte[][] zipContents = new byte[][]{
				result_json.getBytes(Charset.forName("UTF-8")),
				LoadFile.readSmallBinaryFile("project/0.png"),
				LoadFile.readSmallBinaryFile("project/0.wav"),
				LoadFile.readSmallBinaryFile("project/1.svg"),
				LoadFile.readSmallBinaryFile("project/1.wav"),
				LoadFile.readSmallBinaryFile("project/2.svg"),
				LoadFile.readSmallBinaryFile("project/3.png")
		};
		LoadFile.WriteZip(zipPath,zipPaths,zipContents);
		
	}
	
	@SuppressWarnings("unchecked")
	private static String print(String drinkSentence,String scratchJson) throws ParseException {
	    // Get our lexer
	    SimpleLexer lexer = new SimpleLexer(new ANTLRInputStream(drinkSentence));
	 
	    // Get a list of matched tokens
	    CommonTokenStream tokens = new CommonTokenStream(lexer);
	 
	    // Pass the tokens to the parser
	    SimpleParser parser = new SimpleParser(tokens);
	 
	    // Specify our entry point
	    ParseTree context = parser.compilationUnit();
	 
	    // Walk it and attach our listener
	    
	    ParseTreeWalker walker = new ParseTreeWalker();
	    JSONObject jsonobj = (JSONObject) JSONValue.parse(scratchJson);
		JSONArray scripts = new JSONArray();
	    
		MySecondListener listener = new MySecondListener(parser);
	    walker.walk(listener, context);
	    
	    Hierarquia hierarquia_java8 = listener.arvore;
	    
	    JSONArray hierarquia_scratchjson = ConvertHierarquia.convert(hierarquia_java8);
	    
	    //new GenerateJson(listener.arvore).Parse(scripts);
	    
	    System.out.println(hierarquia_scratchjson.toJSONString());
	    
	    //System.out.println(listener.arvore.toIdentString());
	    
	    
	    
	   // System.out.println(scripts.toJSONString());
	    jsonobj.put("children", hierarquia_scratchjson);
	   // JSONArray children = (JSONArray)jsonobj.get("children");
	   //JSONObject ator1 = (JSONObject) children.get(0);
	   // ator1.put("scripts", ((JSONObject)hierarquia_scratchjson.get(0)).get("scripts"));
	    
	    //listener.enterBlock((BlockContext)context);
	    
	    TreeViewer viewer = new TreeViewer(Arrays.asList(lexer.getRuleNames()),context);
        viewer.setTreeTextProvider(new TreeTextProvider()
        {
            TreeTextProvider defaultProvider = new TreeViewer.DefaultTreeTextProvider(Arrays.asList(parser.getRuleNames()));

            @Override
            public String getText(Tree node)
            {
                return defaultProvider.getText(node);
            }
        });
	    viewer.open();
	    
	    return jsonobj.toJSONString();
	}

}
