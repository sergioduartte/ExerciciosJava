/* 114211201 - Sergio de Sousa Duarte: LAB 04 - Turma 3 */
package logica;

import java.util.ArrayList;
import java.util.HashSet;

public class Loja {
	
	private ArrayList<Usuario> listaDeUsuarios;
	private double totalVendas;
	
	public static void main(String[] args) {
		iniciaLoja();
		
	}

	private static void iniciaLoja() {
		System.out.println("iniciando loja...");
	}
	
	public Usuario criaUsuario(String nome, String nickname){
		return UsuarioFactory.criaUsuario(nome, nickname);
	}
	
	public Jogo criaJogo(String nome, double preco, String tipoDeJogo, HashSet<Jogabilidade> jogabilidades) {
		return JogoFactory.criaJogo(nome, preco, tipoDeJogo, jogabilidades);
	}
	
	public void addDinheiroParaUsuario(Usuario usuario, double valor) {
		usuario.addDinheiro(valor);
	}
	
	public void imprimeLoja() {
		for (Usuario usuario : listaDeUsuarios) {
			System.out.println(usuario.toString());
		}
	System.out.printf("Total arrecadado com vendas de jogos: R$%.2f.", totalVendas) ;
	}
}
