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
                
            case "metodo":
                this.token = 2;
                break;
                
            case "Principal()":
                this.token = 3;
                break;
                
            case "escreva":
                this.token = 4;
                break;
               
            case "escrevaln":
                this.token = 5;
                break;
                
            case "texto":
                this.token = 6;
                break;
                
            case "inteiro":
                this.token = 7;
                break;
            
            case "real":
                this.token = 8;
                break;
                
            case "caractere":
                this.token = 9;
                break;
                
            case "logico":
                this.token = 10;
                break;
                
            case "verdadeiro":
                this.token = 11;
                break;
                
            case "falso":
                this.token = 12;
                break;
                
            case "nulo":
                this.token = 13;
                break;
                
            case "vazio":
                this.token = 14;
                break;
                
            default:
                break;
        }
        
        return this.token;
    }
    
}
