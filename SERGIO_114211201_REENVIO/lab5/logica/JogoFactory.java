/* 114211201 - Sergio de Sousa Duarte: LAB 05 - Turma 2 */
package logica;

import java.util.HashSet;

public class JogoFactory {

	private static final String RPG = "rpg";
	private static final String LUTA = "luta";
	private static final String PLATAFORMA = "plataforma";

	public static Jogo criaJogo(String nome, double preco, String tipoDeJogo, HashSet<Jogabilidade> jogabilidades) {
		if (tipoDeJogo.toLowerCase().equals(RPG)) {
			return new JogoRPG(nome, preco, jogabilidades);
		} else if (tipoDeJogo.toLowerCase().equals(LUTA)) {
			return new JogoLuta(nome, preco, jogabilidades);
		} else if (tipoDeJogo.toLowerCase().equals(PLATAFORMA)) {
			return new JogoPlataforma(nome, preco, jogabilidades);
		}
		return null;
	}
	
	

}
