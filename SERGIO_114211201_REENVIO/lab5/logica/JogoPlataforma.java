/* 114211201 - Sergio de Sousa Duarte: LAB 04 - Turma 3 */
package logica;

import java.util.HashSet;

public class JogoPlataforma extends Jogo{

	public JogoPlataforma(String nome, double preco, HashSet<Jogabilidade> jogabilidades) {
		super(nome, preco, jogabilidades);
		setTipoDeJogo("plataforma");
	}

}
