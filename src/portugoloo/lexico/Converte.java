/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portugoloo.lexico;

import java.util.ArrayList;
import java.util.List;
import javabeans.Arquivo;
import javabeans.ArquivoIntermediario;

/**
 *
 * @author JONATASWILLIAMSILVES
 */
public class Converte {

    private ArquivoIntermediario arqInt;
    private List<String> cod;
    private List<ArquivoIntermediario> listaInter = new ArrayList<ArquivoIntermediario>();

    public List<ArquivoIntermediario> getListaInter() {
        return listaInter;
    }

    public void setListaInter(List<ArquivoIntermediario> listaInter) {
        this.listaInter = listaInter;
    }

    public void converter(List<Arquivo> arquivos) {
        for (Arquivo arquivo : arquivos) {
            arqInt = new ArquivoIntermediario();
            cod = new ArrayList<String>();
            arqInt.setNomeInt(arquivo.getNomeArq());
            for (String linha : arquivo.getConteudoArq()) {
                String linhaCod = translate(linha);
                cod.add(linhaCod);
            }
            arqInt.setConteudoInt(cod);
            this.listaInter.add(arqInt);
        }
    }

    private static String translate(String input) {

        String output = input;
        
        output = output.replace("metodo publico Principal()", "||203|");
        output = output.replace("classe publica", "||10|");
        output = output.replace("publica", "||0|");
        output = output.replace("publico", "||0|");
        output = output.replace("classe", "||1|");
        output = output.replace("escreva", "||4|");
        output = output.replace("escrevaln", "||5|");
        output = output.replace("texto", "||6|");
        output = output.replace("inteiro", "||7|");
        output = output.replace("real", "||8|");
        output = output.replace("caractere", "||9|");
        output = output.replace("logico", "||10|");
        output = output.replace("verdadeiro", "||11|");
        output = output.replace("falso", "||12|");
        output = output.replace("nulo", "||13|");
        output = output.replace("vazio", "||14|");
        output = output.replace("caso", "||15|");
        output = output.replace("escolha", "||16|");
        output = output.replace("para", "||17|");
        output = output.replace("enquanto", "||18|");
        output = output.replace("faca", "||19|");
        output = output.replace("estatico", "||20|");
        output = output.replace("constante", "||21|");
        output = output.replace("retorne", "||22|");
        output = output.replace("este.", "||23|.");
        output = output.replace("super", "||24|");

        return output;
    }

}
