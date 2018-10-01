/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portugoloo.interpretador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author root
 */
public class Compiler {
	private final String extencaoArquivoTmp = ".java";
	private final String nomeArquivoTmp = "JavaCode";








	public void Compile(String codigoFonte){
		Writer(codigoFonte);	
		try {
			runProcess("javac " + nomeArquivoTmp + extencaoArquivoTmp);
			runProcess("java " + nomeArquivoTmp);
		}catch (Exception e ) {

		}
	}


	private static void printLines(String name, InputStream ins) throws Exception {
		String line = null;
		BufferedReader in = new BufferedReader(
			new InputStreamReader(ins));
		while ((line = in.readLine()) != null) {
			System.out.println(name + " " + line);
		}
	}

	private static void runProcess(String command) throws Exception {
		Process pro = Runtime.getRuntime().exec(command);

		printLines("stdout:", pro.getInputStream());
		printLines("stderr:", pro.getErrorStream());
		pro.waitFor();
		System.out.println(command + " exitValue() " + pro.exitValue());
	}
	

	private void Writer (String text) {
		 try {
			PrintWriter w = new PrintWriter(nomeArquivoTmp, "UTF-8");
			w.print(text);
			w.close();
		 }catch (IOException e) {
			 System.out.println("Erro ao criar o arquivo: " + e.getMessage()); 
		 }
		
	}
	
}
