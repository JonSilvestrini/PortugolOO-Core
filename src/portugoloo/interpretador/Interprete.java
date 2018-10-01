/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portugoloo.interpretador;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import javabeans.Arquivo;
import javabeans.Token;

/**
 *
 * @author root
 */
public class Interprete {

    private Arquivo arqJava;
    private List<String> codigoFinal;
    private List<Arquivo> listaJava = new ArrayList<Arquivo>();
    private List<Token> tokens;

    public Interprete(List<Token> tokens) {
        this.tokens = tokens;
    }
    
    

    public List<Arquivo> getListaJava() {
        return listaJava;
    }

    public void setListaJava(List<Arquivo> listaJava) {
        this.listaJava = listaJava;
    }

    /* "gerarCodigo" está retornando uma string temporariamente para testes,
	 * futuramente ela irá gerar um arquivo java
     */
    public void interpretar(List<Arquivo> arquivos) {
        for (Arquivo arquivo : arquivos) {
            arqJava = new Arquivo();
            codigoFinal = new ArrayList<String>();
            arqJava.setNomeArq(arquivo.getNomeArq());
            for (String linha : arquivo.getConteudoArq()) {
                String javaCod = translate(linha);
                codigoFinal.add(javaCod);
            }
            arqJava.setConteudoArq(codigoFinal);
            listaJava.add(arqJava);
        }
    }

    private String translate(String input) {

        String output = input;

        for (Token token : tokens){
            output = output.replace(token.getToken(), token.getJava());
        }
        
        return output;
    }
}
