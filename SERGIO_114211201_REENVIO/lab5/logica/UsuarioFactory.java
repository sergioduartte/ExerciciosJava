/* 114211201 - Sergio de Sousa Duarte: LAB 05 - Turma 2 */
package logica;

public class UsuarioFactory {

	public static Usuario criaUsuario(String nome, String nickname) {
		return new UsuarioNoob(nome, nickname);
	}
}
