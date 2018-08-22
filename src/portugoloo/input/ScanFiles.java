/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portugoloo.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
        private StringBuilder nomeArq, conteudoArq;
        private FileReader arq;
        private String lerArq;

	public void setPath(String $path) {
		this.path = new File($path);
	}

	public void Scan() throws IOException {
		for (final File listaArquivos : this.path.listFiles()) {
			if (listaArquivos.getName().endsWith("classe")){
				this.nomeArq = listaArquivos.getName();
                            try {
                                this.arq = new FileReader(listaArquivos.getPath());
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(ScanFiles.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            this.lerArq = new BufferedReader(this.arq);
                            String conteudoLinha = this.lerArq.readLine();
                            while (conteudoLinha != null){
                                this.conteudoArq += conteudoLinha;
                                this.lerArq.readLine();
                            }
                            
			}
		}
	}
}