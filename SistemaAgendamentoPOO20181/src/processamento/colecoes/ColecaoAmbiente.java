package processamento.colecoes;

import processamento.classes.*;
import java.util.HashMap;

public class ColecaoAmbiente {
	
	private HashMap<HorarioAmbiente,Ambiente> coleambiente;

	public ColecaoAmbiente() {
		super();
		this.coleambiente = new HashMap<HorarioAmbiente,Ambiente>();
	}

	private Ambiente gerarAmbiente() {
		
		Ambiente ambtmp = new Ambiente();
		
		ambtmp.criarAmbiente();
		
		return ambtmp;
	}
	
	public void adicionarAmbiente() throws Exception {
		
		Ambiente ambitmp = gerarAmbiente();
		HorarioAmbiente htmp = ambitmp.getHorario();
		
		if(coleambiente.containsKey(htmp)) {
			Exception e = new Exception();
			System.err.println("Ambiente ja existe!");
			throw e;
		}	else	{
				coleambiente.put(htmp, ambitmp);
		}
		
	}
	
	public Ambiente procurarAmbiente(HorarioAmbiente horariotemporario) throws Exception {
		
		if(coleambiente.containsKey(horariotemporario)) {
			return coleambiente.get(horariotemporario);
		}	else	{
				Exception e = new Exception();
				System.err.println("Ambiente nao existe!");
				throw e;
		}
	}
	
	
	
	
}//fim da colecao ambiente