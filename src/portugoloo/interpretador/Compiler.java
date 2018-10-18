/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portugoloo.interpretador;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.List;
import javabeans.Arquivo;

/**
 *
 * @author root
 */
public class Compiler {

	private Arquivo arquivoMain;
	private List<Arquivo> arquivos;

	private String path;

	public Compiler(List<Arquivo> arquivos, String path) {
		this.arquivos = arquivos;
		this.path = path + "output/";
	}


	public void Compile() throws Exception{
		
		for (final Arquivo arq : arquivos) {
			if (arq.isMain()) {
				arquivoMain = arq;
			}
			Writer(arq);
		}

		runProcess("javac -classpath " + this.path + " " + this.path  + arquivoMain.getNomeArq() + ".java");
		
		runProcess("java -classpath " + this.path + " " + arquivoMain.getNomeArq());
	}


	private void printLines(String name, InputStream ins) throws Exception {
		String line = null;
		BufferedReader in = new BufferedReader(
			new InputStreamReader(ins));
		while ((line = in.readLine()) != null) {
			System.out.println(name + " " + line);
		}
	}

	private void runProcess(String command) throws Exception {
		Process pro = Runtime.getRuntime().exec(command);

		printLines(arquivoMain.getNomeArq()+" stdout:", pro.getInputStream());
		printLines(arquivoMain.getNomeArq()+" stderr:", pro.getErrorStream());
		pro.waitFor();
		System.out.println(arquivoMain.getNomeArq()+" exitValue() " + pro.exitValue());
	}
	

	private void Writer (Arquivo arq) {
		new File(this.path).delete();
		try {
			new File(path).mkdirs();
			PrintWriter w = new PrintWriter(this.path + arq.getNomeArq() + ".java", "UTF-8");
			for (final String linha : arq.getConteudoArq()) 
				w.print(linha +"\n");
			
			w.close();
		}catch (IOException e) {
			System.out.println("Erro ao criar o arquivo: " + e.getMessage());
		}
		
	}
	
}
