package processamento.colecoes;

import processamento.classes.*;
import java.util.HashMap;


public class ColecaoCurso {

	private HashMap<String,Curso> colecurso;

	public ColecaoCurso() {
		super();
		this.colecurso = new HashMap<String, Curso>();
	}

	@Override
	public String toString() {
		return "ColecaoCurso [colecurso=" + colecurso + "]";
	}
	
	private Curso gerarCurso() {
		
		Curso temporario = new Curso();
		
		temporario.criarCurso();
		
		return temporario;
	}
	
	
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

	public Curso pesquisarCurso(String codigotmp) throws Exception{
		
		if(colecurso.containsKey(codigotmp)) {
			return colecurso.get(codigotmp);
		}	else {
				Exception e = new Exception();
				System.err.println("Curso nao existe!");
				throw e;
		}
		
		
	}
}//fim do 