/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portugoloo.lexico;

/**
 *
 * @author JONATASWILLIAMSILVES
 */
public class DicionarioPortugol {
    
    private String palavra;
    private int token;
    
    public void setPalavra(String $palavra){
        this.palavra = $palavra;
    }
    
    
    public int consultaPalavra(){
        switch(this.palavra){
            case "publica":
                this.token = 0;
                break;
            
            case "publico":
                this.token = 0;
                break;
            
            case "classe":
                this.token = 1;
                break;
        }
        
        return this.token;
    }
    
}
