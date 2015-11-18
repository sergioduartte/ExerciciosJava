/* 114211201 - Sergio de Sousa Duarte: LAB 05 - Turma 2 */
package logica;

import java.util.HashSet;

public class JogoRPG extends Jogo {

	public JogoRPG(String nome, double preco, HashSet<Jogabilidade> jogabilidades) {
		super(nome, preco, jogabilidades);
		setTipoDeJogo("rpg");
	}

}
