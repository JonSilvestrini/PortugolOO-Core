/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portugoloo.interpretador;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
public class Compilador {

	private Arquivo arquivoMain;
	private List<Arquivo> arquivos;

	private String path;

	private final PropertyChangeSupport support = new PropertyChangeSupport(this);
	
	private String OutputText;

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		support.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		support.removePropertyChangeListener(listener);
	}

	public String getOutputText() {
		return OutputText;
	}

	private void setOutputText(String text) {
		String oldValue = this.OutputText;
		this.OutputText = text;
		support.firePropertyChange("OutputText", oldValue, text);
	}
	

	public Compilador(List<Arquivo> arquivos, String path) {
		this.arquivos = arquivos;
		this.path = path + "/output/";
	}

	public Compilador() {

	}

	public List<Arquivo> getArquivos() {
		return arquivos;
	}

	public void setArquivos(List<Arquivo> arquivos) {
		this.arquivos = arquivos;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path + "/output/";
	}


	public boolean Compile() throws Exception{
		
		for (final Arquivo arq : arquivos) {
			if (arq.isMain()) {
				arquivoMain = arq;
			}
			Writer(arq);
		}

		if (runProcess("javac -classpath " + this.path + " " + this.path  + arquivoMain.getNomeArq() + ".java") !=0)
			return false;


		
		if (runProcess("java -classpath " + this.path + " " + arquivoMain.getNomeArq()) != 0 )
			return false;

		return true;
	}

	public boolean CleanCompile() throws Exception {
		File index = new File(this.path);
		for (final File file : index.listFiles()){
			file.delete();
		}
		return this.Compile();
	}


	private void printLines(String name, InputStream ins) throws Exception {
		String line = null;
		BufferedReader in = new BufferedReader(
			new InputStreamReader(ins));
		while ((line = in.readLine()) != null) {
			System.out.println(name + " " + line);
			setOutputText(line);
		}
	}

	private int runProcess(String command) throws Exception {
		Process pro = Runtime.getRuntime().exec(command);

		printLines(arquivoMain.getNomeArq()+" stdout:", pro.getInputStream());
		printLines(arquivoMain.getNomeArq()+" stderr:", pro.getErrorStream());
		pro.waitFor();
		System.out.println(arquivoMain.getNomeArq()+" exitValue() " + pro.exitValue());
		return pro.exitValue();
	}
	

	private void Writer (Arquivo arq) {
		
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
