/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author potato
 */
public class ArquivoIntermediario {
	private String nomeInt;
	private List<Integer> conteudoInt = new ArrayList<Integer>();

	public String getNomeInt() {
		return nomeInt;
	}

	public void setNomeInt(String nomeInt) {
		this.nomeInt = nomeInt;
	}

	public List<Integer> getConteudoInt() {
		return conteudoInt;
	}

	public void setConteudoInt(List<Integer> conteudoInt) {
		this.conteudoInt = conteudoInt;
	}
	
	
}
