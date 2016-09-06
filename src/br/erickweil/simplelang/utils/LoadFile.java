package br.erickweil.simplelang.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class LoadFile {
	public static String[] Readtxt(String dir,String ... path)
	{
		String[] str_return = new String[path.length];
		for(int i=0;i< path.length;i++)
		{
			str_return[i] = Readtxt(dir+path[i]);
		}
		return str_return;
	}
	public static String Readtxt(String path)
	{
		String content=null;

		try {
			//content = new String(Files.readAllBytes(Paths.get(path)));
			File arquivo = new File(path);
			if(arquivo.exists())
			{
				content = new String(Files.readAllBytes(arquivo.toPath()),Charset.forName("UTF-8"));
			}
			else
			{
				return null;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return content+" ";
	}
	public static void Writetxt(String path,String content)
	{

		try {
			//content = new String(Files.readAllBytes(Paths.get(path)));
			Files.write(new File(path).toPath(), content.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static void WriteZip(String zippath,String[] paths,byte[][] contents) {
        
        try {
		    // Create the ZIP file
		    File outFilename = new File(zippath);
		    ZipOutputStream out = new ZipOutputStream(new FileOutputStream(outFilename));

		    // Compress two files
		    for (int i=0; i<paths.length; i++) {
		        // Add ZIP entry to output stream.
		        out.putNextEntry(new ZipEntry(paths[i]));
		        
		        byte[] content = contents[i];
		        out.write(content);

		        // Close the file
		        out.closeEntry();
		    }

		    // Close the ZIP file
		    out.close();
		} catch (IOException e) {
			System.out.println("Problem writing ZIP file: " + e);
		}

	}

	
	public static byte[] readSmallBinaryFile(String aFileName) 
	{
	   Path path = new File(aFileName).toPath();
	   try 
	   {
		   return Files.readAllBytes(path);
	   } 
	   catch (IOException e) 
	   {
		e.printStackTrace();
		return null;
	   }

	}
}
