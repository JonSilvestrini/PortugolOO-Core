/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

import java.util.List;

/**
 *
 * @author JONATASWILLIAMSILVES
 */
public class Arquivo {

	private String nomeArq;
	private List<String> conteudoArq;
	private boolean Main;

	public Arquivo() {
	}

	public String getNomeArq() {
		return nomeArq;
	}

	public void setNomeArq(String nomeArq) {
		this.nomeArq = nomeArq;
	}

	public List<String> getConteudoArq() {
		return conteudoArq;
	}

	public void setConteudoArq(List<String> conteudoArq) {
		this.conteudoArq = conteudoArq;
	}

	public boolean isMain() {
		return Main;
	}

	public void setMain(boolean isMain) {
		this.Main = isMain;
	}

}
