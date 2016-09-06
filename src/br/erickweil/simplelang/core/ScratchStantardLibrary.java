package br.erickweil.simplelang.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import br.erickweil.simplelang.core.ListHelper.Tipo;

public class ScratchStantardLibrary {
	
	static Map<String,MethInfo> meths;
	/*public static void main(String[] args)
	{
		getMethods();
		System.out.println(meths.toString());
		//System.out.println(10*10 + 10/10);
	}*/
	
	public static void getMethods()
	{
		Class<ScratchStantardLibrary> thisclass = ScratchStantardLibrary.class;
		Method[] metodos = thisclass.getMethods();
		meths = new HashMap<>();
		for(Method m : metodos)
		{
			if(m.getDeclaringClass().equals(ScratchStantardLibrary.class))
			{
				String methName = m.getName();
				if(!methName.equals("getMethods"))
				{
				if(m.isAnnotationPresent(MethConvert.class))
				{
					Annotation annotation = m.getAnnotation(MethConvert.class);
					MethConvert test = (MethConvert) annotation;
					String return_name = m.getReturnType().getName();
					Tipo tipo = Tipo.getTipo(return_name);
					MethInfo info = new MethInfo(methName, test.name(), test.params(), m.getParameterCount(), tipo);
					meths.put(methName, info);
				}
				else System.err.println("Meth "+methName+" not converted!");
				}
			}
		}
		System.out.println(meths.toString());
	}	
	
	/*
	 *  control meths
	 */
	@MethConvert(name = "stopScripts",params = {"all"})
	public static final double stopAll(){
		throw new RuntimeException("Stoped All!");
	}

	@MethConvert(name = "doWaitUntil",params = {""})
	public static final void waitUntil(boolean arg0){
		throw new RuntimeException("this method only works on scratch, use while(!condition){} as workarround");
	}
	
	@MethConvert(name = "wait:elapsed:from:",params = {""})
	public static final void waitSeconds(double arg0){
		try {
			Thread.sleep((long)(arg0*1000.0));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 *  operators meths
	 */
	
	@MethConvert(name = "randomFrom:to:",params = {"",""})
	public static final double random(double arg0,double arg1){
		double diff = arg0 -arg1;
		return (Math.random()*diff)+arg0;
	}
	@MethConvert(name = "randomFrom:to:",params = {"",""})
	public static final int random(int arg0,int arg1){
		double diff = arg0 -arg1;
		return (int)Math.round((Math.random()*diff)+arg0);
	}
	
	/*
	 *  todas as variantes de computeFunction:of:
	 */
	
	@MethConvert(name = "computeFunction:of:",params = {"abs",""})
	public static final double abs(double arg0){return Math.abs(arg0);}
	@MethConvert(name = "computeFunction:of:",params = {"floor",""})
	public static final double floor(double arg0){return Math.floor(arg0);}
	@MethConvert(name = "computeFunction:of:",params = {"ceiling",""})
	public static final double ceil(double arg0){return Math.ceil(arg0);}
	@MethConvert(name = "computeFunction:of:",params = {"sqrt",""})
	public static final double sqrt(double arg0){return Math.sqrt(arg0);}
	@MethConvert(name = "computeFunction:of:",params = {"sin",""})
	public static final double sin(double arg0){return Math.sin(arg0);}
	@MethConvert(name = "computeFunction:of:",params = {"cos",""})
	public static final double cos(double arg0){return Math.cos(arg0);}
	@MethConvert(name = "computeFunction:of:",params = {"tan",""})
	public static final double tan(double arg0){return Math.tan(arg0);}
	@MethConvert(name = "computeFunction:of:",params = {"asin",""})
	public static final double asin(double arg0){return Math.asin(arg0);}
	@MethConvert(name = "computeFunction:of:",params = {"acos",""})
	public static final double acos(double arg0){return Math.acos(arg0);}
	@MethConvert(name = "computeFunction:of:",params = {"atan",""})
	public static final double atan(double arg0){return Math.atan(arg0);}
	@MethConvert(name = "computeFunction:of:",params = {"ln",""})
	public static final double ln(double arg0){return Math.log(arg0);}
	@MethConvert(name = "computeFunction:of:",params = {"log",""})
	public static final double log(double arg0){return Math.log10(arg0);}
	@MethConvert(name = "computeFunction:of:",params = {"e ^",""})
	public static final double exp(double arg0){return Math.exp(arg0);}
	@MethConvert(name = "computeFunction:of:",params = {"10 ^",""})
	public static final double pow_base10(double arg0){return Math.pow(10.0,arg0);}
}
