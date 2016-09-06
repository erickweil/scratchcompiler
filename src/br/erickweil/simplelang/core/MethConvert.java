package br.erickweil.simplelang.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.erickweil.simplelang.core.ListHelper.Tipo;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) //can use in method only.
public @interface MethConvert {

	//should ignore this test?
	public String name() default "no_name";
	public String[] params() default {""};

}

final class MethInfo{
	final String name;
	final String scratchName;
	final String[] scratchParams;
	final int n_params;
	final Tipo returnTipo;
	public MethInfo(String name, String scratchName, String[] scratchParams, int n_params,Tipo returnTipo) {
		super();
		this.name = name;
		this.scratchName = scratchName;
		this.scratchParams = scratchParams;
		this.n_params = n_params;
		this.returnTipo = returnTipo;
	}
	
	public String toString()
	{
		return "\""+scratchName+"\" returns "+returnTipo;
	}

}
