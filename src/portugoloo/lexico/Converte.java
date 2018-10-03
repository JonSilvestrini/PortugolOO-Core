/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portugoloo.lexico;

import java.util.ArrayList;
import java.util.List;
import javabeans.Arquivo;
import javabeans.Token;
import javabeans.TokensGenBasico;

/**
 *
 * @author JONATASWILLIAMSILVES
 */
public class Converte{

    private Arquivo arqInt;
    private List<String> cod;
    private List<Arquivo> listaInter = new ArrayList<>();
    private List<Token> tokens;

    public Converte(List<Token> tokens) {
        this.tokens = tokens;
    }

    public List<Arquivo> getListaInter() {
        return listaInter;
    }

    public void setListaInter(List<Arquivo> listaInter) {
        this.listaInter = listaInter;
    }

    public void converter(List<Arquivo> arquivos) {
        for (Arquivo arquivo : arquivos) {
            arqInt = new Arquivo();
            cod = new ArrayList<>();
            arqInt.setNomeArq(arquivo.getNomeArq());
            for (String linha : arquivo.getConteudoArq()) {
                String linhaCod = translate(linha);
                if (linhaCod.contains("||203|")){
                    arqInt.setMain(true);
		}
                cod.add(linhaCod);
            }
            arqInt.setConteudoArq(cod);
            this.listaInter.add(arqInt);
        }
    }

    private String translate(String input) {

        String output = input;

        for (Token token : tokens) {
            output = output.replace(token.getLoop(), token.getToken());
        }

        return output;
    }

}
