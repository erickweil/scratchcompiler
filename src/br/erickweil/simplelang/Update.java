package br.erickweil.simplelang;

import java.io.File;

import org.antlr.v4.Tool;

public class Update {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tool.main(new String[]{new File("src/br/erickweil/simplelang/generated/Simple.g4").getAbsolutePath()});
	}

}
