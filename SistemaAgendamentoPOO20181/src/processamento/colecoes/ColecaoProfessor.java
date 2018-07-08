package processamento.colecoes;

import java.util.HashMap;
import processamento.classes.*;


public class ColecaoProfessor {

	private HashMap<String,Professor> coleprofessor;

	/**
	 * @see processamento.classes.Professor
	 * @see java.util.HashMap
	 * Este construtor de (ColecaoProfessor) � utilizado para criar um HashMap que guarda objetos da classe Professor, recebendo nada como parametro.
	 * 
	 */ 
	public ColecaoProfessor() {
		super();
		this.coleprofessor = new HashMap<String,Professor>();
	}

	@Override
	public String toString() {
		return "ColecaoProfessor [coleprofessor=" + coleprofessor + "]";
	}
	
	//metodos
	
	/**
	 * @see processamento.classes.Professor
	 * Este metodo privado (gerarProfessor) � utilizado para criar um objeto da classe Professor e retorna o mesmo.
	 * @return Professor
	 */
	private Professor gerarProfessor() {
		
		Professor temporario = new Professor();
		
		temporario.criarProfessor();
		
		return temporario;	
	}
	
	/**
	 * @see processamento.classes.Professor
	 * Este metodo privado (adicionarProfessor), � utilizado para adicionar um objeto da classe Professor, 
	 * gerado dentro da mesma usando gerarProfessor, e lan�a uma exe��o caso j� exista o objeto dentro da cole��o.
	 * 
	 * @throws Exception
	 * @return void
	 * 
	 */
 	public void adicionarProfessor() throws Exception{
		Professor prof = gerarProfessor();
		String matprofessor = prof.getMatricula();
		
		
		if(coleprofessor.containsKey(matprofessor) ) { 
			Exception e = new Exception();
			System.err.println("Professor ja existe!");
			throw e;
			}	else{ 
				coleprofessor.put(matprofessor, prof);	
		}
		
 	}
	
 	/**
 	 * @see processamento.classes.Professor
 	 * Este metodo privado (pesquisarProfessor), � utilizado para realizar a pesquisa de um objeto da classe Professor, 
 	 * dentro da cole��o, se encontrado o tal objeto � retornado, sen�o lan�a uma exe��o caso n�o exista
 	 *  o objeto dentro da cole��o.
 	 * 
 	 * @param matriculaprof String - A matricula a qual se deve informar para que a procura seja realizada.
 	 * @throws Exception
 	 * @return Professor
 	 * 
 	 */
 	public Professor pesquisarProfessor(String matriculaprof) throws Exception{
			
			if(coleprofessor.containsKey(matriculaprof) ) { 
				return coleprofessor.get(matriculaprof);
				}	else{ 
						Exception e = new Exception();
						System.err.println("Professor nao existe!");
						throw e;	
			}
	}
	
 	/**
 	 * @see processamento.classes.Professor
 	 * Este metodo privado (removerProfessor), � utilizado para remover um objeto da classe Professor
 	 *  dentro da cole��o, se encontrado o tal objeto � removido, sen�o lan�a uma exe��o caso n�o exista
 	 *  o objeto dentro da cole��o.
 	 * 
 	 * @param matriculaprof String - A matricula a qual se deve informar para que a remo��o seja realizada.
 	 * @throws Exception
 	 * @return void
 	 * 
 	 */
	public void removerProfessor(String matriculaprof) throws Exception{
		
		if(coleprofessor.containsKey(matriculaprof) ) { 
			coleprofessor.remove(matriculaprof);
			}	else{ 
					Exception e = new Exception();
					System.err.println("Professor nao existe!");
					throw e;	
		}
}
	
	
 	
	
}//fim da classe ColecaoProfessor
