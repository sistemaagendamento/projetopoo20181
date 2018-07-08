package processamento.colecoes;

import processamento.classes.*;
import java.util.HashMap;


public class ColecaoCurso {

	private HashMap<String,Curso> colecurso;

	/**
	 * @see processamento.classes.Curso
	 * @see java.util.HashMap
	 * Este construtor de (ColecaoCurso) � utilizado para criar um HashMap que guarda objetos da classe Curso, recebendo nada como parametro.
	 * 
	 */ 
	public ColecaoCurso() {
		super();
		this.colecurso = new HashMap<String, Curso>();
	}

	/**
	 * @return String de todos os elementos do HashMap
	 * */
	@Override
	public String toString() {
		return "ColecaoCurso [colecurso=" + colecurso + "]";
	}
	
	
	/**
	 * @see processamento.classes.Curso
	 * Este metodo privado (gerarCurso) � utilizado para criar um objeto da classe Curso e retorna o mesmo.
	 * @return Curso
	 */
	private Curso gerarCurso() {
		
		Curso temporario = new Curso();
		
		temporario.criarCurso();
		
		return temporario;
	}
	
	

	/**
	 * @see processamento.classes.Curso
	 * Este metodo privado (adicionarCurso), � utilizado para adicionar um objeto da classe Curso, 
	 * gerado dentro da mesma usando gerarCurso, e lan�a uma exe��o caso j� exista o objeto dentro da cole��o.
	 * 
	 * @throws Exception
	 * @return void
	 * 
	 */
	public void adicionarCurso() throws Exception {
		
		Curso cursotmp = gerarCurso();
		String chave = cursotmp.getCodigo();
		
		if(colecurso.containsKey(chave) ) {
			Exception e = new Exception();
			System.err.println("Curso ja existe!");
			throw e;
		}	else {
			colecurso.put(chave, cursotmp);
		}
		
	}

	/**
	 * @see processamento.classes.Curso
	 * Este metodo privado (pesquisarCurso), � utilizado para realizar a pesquisa de um objeto da classe Curso, 
	 * dentro da cole��o, se encontrado o tal objeto � retornado, sen�o lan�a uma exe��o caso n�o exista
	 *  o objeto dentro da cole��o.
	 * 
	 * @param codigotmp String - O codigo do curso o qual se deve informar para que a procura seja realizada.
	 * @throws Exception
	 * @return Curso
	 * 
	 */
	public Curso pesquisarCurso(String codigotmp) throws Exception{
		
		if(colecurso.containsKey(codigotmp)) {
			return colecurso.get(codigotmp);
		}	else {
				Exception e = new Exception();
				System.err.println("Curso nao existe!");
				throw e;
		}
	}
	
	/**
	 * @see processamento.classes.Curso
	 * Este metodo privado (removerCurso), � utilizado para remover um objeto da classe Curso
	 *  dentro da cole��o, se encontrado o tal objeto � removido, sen�o lan�a uma exe��o caso n�o exista
	 *  o objeto dentro da cole��o.
	 * 
	 * @param codigotmp String - O codigo do curso o qual se deve informar para que a remo��o seja realizada.
	 * @throws Exception
	 * @return void
	 * 
	 */
	public void removerCurso(String codigotmp) throws Exception{
		
		if(colecurso.containsKey(codigotmp)) {
			colecurso.remove(codigotmp);
		}	else {
				Exception e = new Exception();
				System.err.println("Curso nao existe!");
				throw e;
		}
	}
	
	
	
}//fim da colecao curso