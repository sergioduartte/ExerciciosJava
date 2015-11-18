/* 114211201 - Sergio de Sousa Duarte: LAB 03 - Turma 3 */
package lab3;

import java.util.Scanner;

public class Sistema {

	private Scanner sc;
	private Menu menu;
	private Estoque estoque;
	private int opcao;

	public Sistema() {
		this.sc = new Scanner(System.in);
		this.menu = new Menu();
		this.estoque = new Estoque();
		this.opcao = 0;
	}

	public void roda() {
		do {
			menu.imprimeOpcoes();
			opcao = sc.nextInt();
			sc.nextLine();

			switch (opcao) {
			case 1:
				cadastraProduto(sc, estoque);
				break;
			case 2:
				vendeProduto(sc, estoque);
				break;
			case 3:
				menu.imprimeBalanco(estoque);
				break;
			case 4:
				System.out.println("\n==== Fim de Execucao ====");
				break;
			default:
				System.out.println("\n==== Opcao Invalida ====\n");
				break;
			}
		} while (opcao != 4);

		sc.close();

	}

	private void vendeProduto(Scanner sc, Estoque estoque) {
		String continua = "sim";
		System.out.println("\n==== Venda de Produtos ====");
		while (continua.toLowerCase().equals("sim")) {
			estoque.diminuiQuantidadeProduto(sc);
			System.out.println("\nDeseja vender outro produto?: ");
			continua = sc.nextLine();
		}

	}

	private void cadastraProduto(Scanner sc, Estoque estoque) {
		String continua = "sim";
		System.out.println("==== Cadastro de Produtos ====");
		while (continua.toLowerCase().equals("sim")) {
			Produto p = estoque.criaProduto(sc);
			estoque.adicionaProduto(p);
			System.out.println("\n" + p.getQuantidade() + " " + p.getNome() + "(s)" + " cadastrado com sucesso."
					+ "\n\nDeseja cadastrar outro produto?: ");

			continua = sc.nextLine();
		}

	}
}
