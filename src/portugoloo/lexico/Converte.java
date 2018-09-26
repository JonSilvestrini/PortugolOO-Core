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
	private DicionarioPortugol dicpol;
	private List<Integer> cod;
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
			cod = new ArrayList<Integer>();
			arqInt.setNomeInt(arquivo.getNomeArq());
			for (String linha : arquivo.getConteudoArq()) {
				System.out.println(linha);
				dicpol.setPalavra(linha);
				cod.add(dicpol.consultaPalavra());
			}
			arqInt.setConteudoInt(cod);
			this.listaInter.add(arqInt);
		}
	}
}
