/* 114211201 - Sergio de Sousa Duarte: LAB 04 - Turma 3 */
package logica;

import java.util.HashSet;

public class Jogo {
	
	private String nome, tipoDeJogo;
	private double preco;
	private int maiorPontuacao, qtdVezesJogado, qtdZerado;
	private boolean jahZerou; 
	private HashSet<Jogabilidade> jogabilidades;

	public Jogo(String nome, double preco, HashSet<Jogabilidade> jogabilidades) {
		this.nome = nome;
		this.preco = preco;
		maiorPontuacao = 0;
		qtdVezesJogado = 0;
		jahZerou = false;
		this.jogabilidades = jogabilidades;
	}
	
	public void joga(int pontuacao, boolean zerou){
		if (pontuacao > maiorPontuacao) {
			this.maiorPontuacao = pontuacao;
		}
		if (zerou) {
			this.jahZerou = zerou;
			this.qtdZerado ++;
		}
		this.qtdVezesJogado ++;
	}

	public double getPreco() {
		return this.preco;
	}
	
	public void setTipoDeJogo(String tipo) {
		this.tipoDeJogo = tipo;
	}

	public boolean isJahZerou() {
		return jahZerou;
	}

	public void setJahZerou(boolean jahZerou) {
		this.jahZerou = jahZerou;
	}

	public String getNome() {
		return nome;
	}

	public String getTipoDeJogo() {
		return tipoDeJogo;
	}

	public int getMaiorPontuacao() {
		return maiorPontuacao;
	}

	public int getQtdVezesJogado() {
		return qtdVezesJogado;
	}

	public int getQtdZerado() {
		return qtdZerado;
	}

	public HashSet<Jogabilidade> getJogabilidades() {
		return jogabilidades;
	}
	
	@Override
	public String toString() {
		String saida = "+ " + getNome() + getTipoDeJogo() + ":\n";
		saida += "==> Jogou: " + getQtdVezesJogado() + " vez(es).\n";
		saida += "==> Zerou: " + getQtdZerado() + " vez(es).\n";
		saida += "==> Maior score: " + getMaiorPontuacao() + "\n";
		return saida;
	}
}
