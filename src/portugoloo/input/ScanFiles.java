/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portugoloo.input;

import java.io.File;

/**
 *
 * @author JONATASWILLIAMSILVES
 */

public class ScanFiles {
    private File path;
    
    public void setPath(String $path){
        this.path = new File($path); 
    }
    
    public void Scan(final File $pasta){
        for (final File listaArquivos : this.path.listFiles()){
            if (listaArquivos.isDirectory()){
                Scan(listaArquivos);
            } else {
                System.out.println(listaArquivos.getName());
            }
        }
    }
    
}
