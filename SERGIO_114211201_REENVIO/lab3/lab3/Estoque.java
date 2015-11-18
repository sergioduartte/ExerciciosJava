/* 114211201 - Sergio de Sousa Duarte: LAB 03 - Turma 3 */
package lab3;

import java.util.Scanner;

public class Estoque {
	private Produto[] produtos;
	private double valorEmEstoque;
	private double totalArrecadado;

	public Estoque() {
		this.produtos = new Produto[0];
		this.valorEmEstoque = 0;
		this.totalArrecadado = 0;
	}

	private int verificaProdutoRepetido(Produto p) {
		for (int i = 0; i < this.produtos.length; i++) {
			if (p.equals(produtos[i])) {
				return i;
			}
		}
		return -1;
	}

	private void aumentaArray() {
		Produto[] arrayTemp = new Produto[this.produtos.length + 1];

		for (int i = 0; i < this.produtos.length; i++) {
			arrayTemp[i] = this.produtos[i];
		}
		this.produtos = arrayTemp;
	}

	public Produto criaProduto(Scanner sc) {
		String continua = "sim";

		System.out.print("Digite o nome do produto: ");
		String nome = sc.nextLine();

		System.out.print("Digite o preco unitario do produto: ");
		double preco = sc.nextDouble();
		sc.nextLine();

		System.out.print("Digite o tipo do produto: ");
		String tipo = sc.nextLine();

		System.out.print("Digite a quantidade no estoque: ");
		int quantidade = sc.nextInt();
		sc.nextLine();
		return new Produto(nome, preco, tipo, quantidade);

	}

	public void adicionaProduto(Produto p) {
		int indice = verificaProdutoRepetido(p);
		if (indice != -1) {
			int quantidade = p.getQuantidade();
			produtos[indice].aumentaQuantidade(quantidade);
		} else {
			aumentaArray();
			produtos[produtos.length - 1] = p;
		}
		atualizaValorEstoque();
	}

	public void atualizaValorEstoque() {
		double soma = 0;
		this.valorEmEstoque = 0;
		for (Produto produto : produtos) {
			if (produto != null){
				soma += produto.getPreco() * produto.getQuantidade();
			}
		}
		this.valorEmEstoque = soma;
	}

	public void diminuiQuantidadeProduto(Scanner sc) {
		System.out.print("Digite o nome do produto: ");
		String nome = sc.nextLine();
		if (produtos.length == 0) {
			System.out.println("==>" + nome + " nao cadastrado no sistema.");
		} else if (retornaPorNome(nome) == null) {
			System.out.println("==>" + nome + " nao cadastrado no sistema.");
		} else {
			Produto p = retornaPorNome(nome);
			System.out.println("==>" + nome + "(" + p.getTipo() + "). R$" + p.getPreco() + "\n");
			System.out.print("Digite a quantidade que deseja vender: ");
			int quantidadeVenda = sc.nextInt();
			sc.nextLine();
			if (p.getQuantidade() < quantidadeVenda) {
				System.out.println("Nao eh possivel vender pois nao ha " + p.getNome() + " suficiente.");
			} else {
				p.diminuiQuantidade(quantidadeVenda);
				atualizaTotalArrecadado(p, quantidadeVenda);
				atualizaValorEstoque();
			}
		}
	}

	private void atualizaTotalArrecadado(Produto p, int quantidadeVenda) {
		this.totalArrecadado += quantidadeVenda * p.getPreco();
	}

	public Produto retornaPorNome(String nome) {
		for (Produto produto : produtos) {
			if (produto.getNome().equals(nome)) {
				return produto;
			}
		}
		return null;
	}

	public Produto[] getProdutos() {
		return this.produtos;
	}

	public double getTotalArrecadado() {
		return this.totalArrecadado;
	}

	public double getValorEmEstoque() {
		return this.valorEmEstoque;
	}
}
