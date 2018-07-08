package processamento.colecoes;

import java.util.HashMap;

import processamento.classes.*;

public class ColecaoLaboratorio {
	
	private HashMap<HorarioAmbiente,Laboratorio> colelaboratorio;

	/**
	 * @see processamento.classes.Laboratorio
	 * @see java.util.HashMap
	 * Este construtor de (ColecaoLaboratorio) é utilizado para criar um HashMap que guarda objetos da classe Laboratorio, recebendo nada como parametro.
	 * 
	 */ 
	public ColecaoLaboratorio() {
		super();
		this.colelaboratorio = new HashMap<HorarioAmbiente,Laboratorio>();
	}

	@Override
	public String toString() {
		return "ColecaoLaboratorio [colelaboratorio=" + colelaboratorio + "]";
	}

	/**
	 * @see processamento.classes.Laboratorio
	 * @see processamento.classes.Ambiente
	 * Este metodo privado (gerarLaboratorio) é utilizado para criar um objeto da classe Laboratorio e retorna o mesmo.
	 * @return Laboratorio
	 */
	private Laboratorio gerarLaboratorio() {
		
		Laboratorio labtmp = new Laboratorio();
		
		labtmp.criarAmbiente();
		labtmp.criarLaboratorio();
		
		return labtmp;
	}
	
	/**
	 * @see processamento.classes.Laboratorio
	 * Este metodo privado (adicionarLaboratorio), é utilizado para adicionar um objeto da classe Laboratorio, 
	 * gerado dentro da mesma usando gerarLaboratorio, e lança uma exeção caso já exista o objeto dentro da coleção.
	 * 
	 * @throws Exception
	 * @return void
	 * 
	 */
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
	
	/**
	 * @see processamento.classes.Laboratorio
	 * Este metodo privado (procurarLaboratorio), é utilizado para realizar a pesquisa de um objeto da classe Laboratorio, 
	 * dentro da coleção, se encontrado o tal objeto é retornado, senão lança uma exeção caso não exista
	 *  o objeto dentro da coleção.
	 * 
	 * @param horariotemporario HorarioAmbiente - O horario o qual se deve informar para que a procura seja realizada.
	 * @throws Exception
	 * @return Laboratorio
	 * 
	 */
	public Laboratorio procurarlaboratorio(HorarioAmbiente horariotemporario) throws Exception {
		
		if(colelaboratorio.containsKey(horariotemporario)) {
			return colelaboratorio.get(horariotemporario);
		}	else	{
				Exception e = new Exception();
				System.err.println("Ambiente nao existe!");
				throw e;
		}
	}
	
	
	/**
	 * @see processamento.classes.Laboratorio
	 * Este metodo privado (removerLaboratorio), é utilizado para remover um objeto da classe Laboratorio
	 *  dentro da coleção, se encontrado o tal objeto é removido, senão lança uma exeção caso não exista
	 *  o objeto dentro da coleção.
	 * 
	 * @param horariotemporario HorarioAmbiente - O horario o qual se deve informar para que a procura seja realizada.
	 * @throws Exception
	 * @return void
	 * 
	 */
	public void removerlaboratorio(HorarioAmbiente horariotemporario) throws Exception {
		
		if(colelaboratorio.containsKey(horariotemporario)) {
			colelaboratorio.remove(horariotemporario);
		}	else	{
				Exception e = new Exception();
				System.err.println("Ambiente nao existe!");
				throw e;
		}
	}

}//fim da classe
