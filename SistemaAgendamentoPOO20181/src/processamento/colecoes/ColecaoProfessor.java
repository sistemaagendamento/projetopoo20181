package processamento.colecoes;

import java.util.HashMap;
import processamento.classes.*;


public class ColecaoProfessor {

	private HashMap<String,Professor> coleprofessor;

	public ColecaoProfessor() {
		super();
		this.coleprofessor = new HashMap<String,Professor>();
	}

	@Override
	public String toString() {
		return "ColecaoProfessor [coleprofessor=" + coleprofessor + "]";
	}
	
	//metodos
	
	private Professor gerarProfessor() {
		
		Professor temporario = new Professor();
		
		temporario.criarProfessor();
		
		return temporario;	
	}
	
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
	
 	public Professor pesquisarProfessor(String matriculaprof) throws Exception{
			
			if(coleprofessor.containsKey(matriculaprof) ) { 
				return coleprofessor.get(matriculaprof);
				}	else{ 
						Exception e = new Exception();
						System.err.println("Professor nao existe!");
						throw e;	
			}
	}
		
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
