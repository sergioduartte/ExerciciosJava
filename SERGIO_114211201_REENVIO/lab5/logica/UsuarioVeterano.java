/* 114211201 - Sergio de Sousa Duarte: LAB 05 - Turma 2 */
package logica;

public class UsuarioVeterano extends Usuario{
	
	private final double DESCONTO = 0.20;
	private int x2p;
	
	public UsuarioVeterano(String nome, String nickname) {
		super(nome, nickname);
		
	}
	
	public double getDesconto() {
		return this.getDesconto();
	}
	
	@Override
	public String toString() {
		String saida = "";
		double totalDosJogos = 0.0;
		saida += getNickname() + "\n";
		saida += getNome() + "Jogador Veterano\n";
		saida += "Lista de Jogos:\n";
		for (Jogo jogo : getListaDeJogosComprados()) {
			saida += jogo.toString();
			totalDosJogos += jogo.getPreco();
		}
		saida += "Total de preco dos jogos: R$" + totalDosJogos + "\n";
		return saida;
	}

}
