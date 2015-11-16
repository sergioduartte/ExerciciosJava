package lab3;

public class Menu {

	public void imprimeOpcoes() {
		System.out.print(
				"==== Bem vindo(a) ao EconomizaP2 ====\n" + "Digita a opcao desejada:\n" + "1 - Cadastrar um Produto\n"
						+ "2 - Vender um Produto\n" + "3 - Imprimir Balanco\n" + "4 - Sair\n" + "\nOpcao: ");
	}

	public void imprimeBalanco(Estoque estoque) {
		System.out.println("==== Impressao de Balanco ====\n\n" + "Produtos cadastrados:\n");
		int cont = 1;
		if (estoque.getProdutos().length > 0) {
			for (Produto produto : estoque.getProdutos()) {
				System.out.println(cont + ") " + produto.toString());
				cont++;
			}
		}
		System.out.printf("\n\nTotal arrecadado em vendas: R$%.2f.", (estoque.getTotalArrecadado()));
		System.out.printf("\nTotal que pode ser arrecadado: R$%.2f\n\n", (estoque.getValorEmEstoque()));
	}

}
