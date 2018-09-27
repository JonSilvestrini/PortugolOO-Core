/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portugoloo.input;

import javabeans.Arquivo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JONATASWILLIAMSILVES
 */
public class ScanFiles {

	private File path;
	private List<Arquivo> arquivos = new ArrayList<Arquivo>();
	private Arquivo arquivo = new Arquivo();
	private List<String> conteudoArq;
	private FileReader arq;
	private BufferedReader lerArq;
	private String nomeArq;

	public void setPath(String $path) {
		this.path = new File($path);
		Arquivo arquivo;
	}

	public List getListaArquivos() {
		return arquivos;
	}

	//Esse método escaneia por arquivos .classes e cria duas variáveis com o nome do arquivo e o conteudo concatenado
	public void ScanClasses() throws IOException {
		for (final File listaArquivos : this.path.listFiles()) {  //for each que lê conteúdo da pasta
			if (listaArquivos.getName().endsWith(".classe")) { //condicional que verifica se o arquivo é ".classe"
				this.nomeArq = listaArquivos.getName();   //Pega o nome do arquivo
				this.arq = new FileReader(listaArquivos.getPath()); //Prepara o arquivo para leitura
				this.lerArq = new BufferedReader(this.arq); //Prepara o buffer de memória para leitura
				String conteudoLinha = this.lerArq.readLine(); //Lê a primeira linha
				conteudoArq = new ArrayList<String>();
				while (conteudoLinha != null) { //Lê enquanto linha não for null
					conteudoLinha = conteudoLinha.replaceAll("\t", " "); //substitui todos os tabs por espaços			       
					conteudoArq.add(conteudoLinha);
					conteudoLinha = this.lerArq.readLine();  //Lê próxima linha
				}  //Se a linha for null indica final do arquivo
				this.arq.close();   //Fecha arquivo lido
				this.nomeArq = this.nomeArq.substring(0, (this.nomeArq.length() - 7)); //Corta extensão do nome do arquivo
				// this.conteudoArq = Arrays.asList(conteudoArqTmp.toString().split(";"));
				// for (int i=0;i < conteudoArq.size();i++){  //Dividindo em ';' em vez de linhas
				//     this.conteudoArq = Arrays.asList(conteudoArq.get(i).split("\\{\""));
				// }
				this.arquivo = new Arquivo();
				this.arquivo.setNomeArq(this.nomeArq);   //Envia nome do arquivo para classe modelo
				this.arquivo.setConteudoArq(this.conteudoArq);   //Envia conteúdo do arquivo para classe modelo
				this.arquivos.add(this.arquivo);   //Adiciona classe modelo em uma lista

			}
		}
	}
}
