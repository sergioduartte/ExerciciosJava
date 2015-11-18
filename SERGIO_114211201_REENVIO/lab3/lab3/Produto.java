/* 114211201 - Sergio de Sousa Duarte: LAB 03 - Turma 3 */
package lab3;

public class Produto {
	
	private String nome, tipo;
	private double preco;
	private int quantidade;
	
	public Produto(String nome, double preco, String tipo, int quantidade) {
		this.nome = nome;
		this.preco = preco;
		this.tipo = tipo;
		this.quantidade = quantidade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void aumentaQuantidade(int quantidade) {
		this.quantidade += quantidade;
	}

	public void diminuiQuantidade(int quantidade) {
		this.quantidade -= quantidade;
	}

	public String getNome() {
		return nome;
	}
	
	@Override
	public String toString() {
		String p = String.format("%.2f", preco);
		return (nome + "(" + tipo + "). R$" + p + ". Restante: " + quantidade);
	}
	
	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof Produto) {
			Produto novoProduto = (Produto) objeto;
			
			if (novoProduto.getNome().equals(this.nome)) {
				return true;
			}
		}
		return false;
	}
}

