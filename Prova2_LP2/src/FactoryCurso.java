
public class FactoryCurso {
	
	
	//strategy com polimorfismo
	public static Curso criaCurso(String curso) throws Exception { 
		if (curso.toLowerCase().equals("japones")) {
			return new cursoJapones();
		} else if (curso.toLowerCase().equals("ingles")) {
			return new cursoIngles();
		} else if (curso.toLowerCase().equals("sueco")) {
			return new cursoSueco();
		} else {
			throw new Exception("HelloWorld não ensina " + curso);
		}
	}
}
