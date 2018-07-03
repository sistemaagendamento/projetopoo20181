package processamento.colecoes;

import java.util.HashMap;

import processamento.classes.*;

public class ColecaoLaboratorio {
	
	private HashMap<HorarioAmbiente,Laboratorio> colelaboratorio;

	public ColecaoLaboratorio() {
		super();
		this.colelaboratorio = new HashMap<HorarioAmbiente,Laboratorio>();
	}

	@Override
	public String toString() {
		return "ColecaoLaboratorio [colelaboratorio=" + colelaboratorio + "]";
	}

	private Laboratorio gerarLaboratorio() {
		
		Laboratorio labtmp = new Laboratorio();
		
		labtmp.criarAmbiente();
		labtmp.criarLaboratorio();
		
		return labtmp;
	}
	

	public void adicionarLaboratorio() throws Exception {
		Laboratorio laboratoriotmp = gerarLaboratorio();
		HorarioAmbiente htmp = laboratoriotmp.getHorario();
		
		if(colelaboratorio.containsKey(htmp)) {
			Exception e = new Exception();
			System.err.println("Ambiente ja existe!");
			throw e;
		}	else	{
				colelaboratorio.put(htmp, laboratoriotmp);
		}
		
		
	}
	
	public Laboratorio procurarlaboratorio(HorarioAmbiente horariotemporario) throws Exception {
		
		if(colelaboratorio.containsKey(horariotemporario)) {
			return colelaboratorio.get(horariotemporario);
		}	else	{
				Exception e = new Exception();
				System.err.println("Ambiente nao existe!");
				throw e;
		}
	}

}
