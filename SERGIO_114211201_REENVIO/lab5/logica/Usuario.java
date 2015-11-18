/* 114211201 - Sergio de Sousa Duarte: LAB 04 - Turma 3 */
package logica;

import java.util.ArrayList;

public class Usuario {
	
	private String nome, nickname;
	private ArrayList<Jogo> listaDeJogosComprados;
	private double dinheiroDisp;
	
	public Usuario(String nome, String nickname) {
		this.nome = nome;
		this.nickname = nickname;
	}
	
	public void addDinheiro(double valor) {
		this.dinheiroDisp += valor;
	}

	public String getNome() {
		return this.nome;
	}

	public String getNickname() {
		return this.nickname;
	}

	public ArrayList<Jogo> getListaDeJogosComprados() {
		return listaDeJogosComprados;
	}
	
	public double getDinheiroDisp(){
		return this.dinheiroDisp;
	}
}
