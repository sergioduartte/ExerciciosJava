/* 114211201 - Sergio de Sousa Duarte: LAB 05 - Turma 2 */
package logica;

public class UsuarioNoob extends Usuario {
	
	private final double DESCONTO = 0.10;
	
	public UsuarioNoob(String nome, String nickname) {
		super(nome, nickname);
	}
	
	public double getDesconto() {
		return this.getDesconto();
	}
	

	public void compra(Jogo jogo) throws Exception {
		if (jogo.getPreco() < getDinheiroDisp()) {
			diminDinheiroDisp(jogo.getPreco() * DESCONTO) ;
			getListaDeJogosComprados().add(jogo);
		} else { 
			throw new Exception("saldo insuficiente para compra do jogo");
		}
	}
	
	private void diminDinheiroDisp(double d) {
		//TODO 
	}

	@Override
	public String toString() {
		String saida = "";
		double totalDosJogos = 0.0;
		saida += getNickname() + "\n";
		saida += getNome() + "Jogador Noob\n";
		saida += "Lista de Jogos:\n";
		for (Jogo jogo : getListaDeJogosComprados()) {
			saida += jogo.toString();
			totalDosJogos += jogo.getPreco();
		}
		saida += "Total de preco dos jogos: R$" + totalDosJogos + "\n";
		return saida;
	}
}
