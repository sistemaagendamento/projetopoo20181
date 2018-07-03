package processamento.colecoes;

import processamento.classes.*;
import java.util.HashMap;

public class ColecaoSetorLogico {

	private HashMap<String,SetorLogico> colesetlogico;


	public ColecaoSetorLogico() {
		super();
		this.colesetlogico = new HashMap<String,SetorLogico>();
	}


	@Override
	public String toString() {
		return "ColecaoSetorLogico [colesetlogico=" + colesetlogico + "]";
	}

	private SetorLogico gerarSetorLogico() {
		
		SetorLogico temporario = new SetorLogico();
		
		temporario.criarUnidadeAcademica();
		
		return temporario;
	}
	
	public void adicionarSetorLogico() throws Exception {
		
		SetorLogico uatmp = gerarSetorLogico();
		String chave = uatmp.getId();
		
		if(colesetlogico.containsKey(chave)) {
			Exception e = new Exception();
			System.err.println("Setor Logico ja existente!");
			throw e;
		}	else{
				colesetlogico.put(chave, uatmp);
		}
		
	}
	
	
	public SetorLogico pesquisarSetorLogico(String idtmp) throws Exception {
		
		if(colesetlogico.containsKey(idtmp)){
			return colesetlogico.get(idtmp);
		}	else	{
				Exception e = new Exception();
				System.err.println("Setor Logico nao existente!");
				throw e;
		}
		
		
	}
	
}//fim da colecao