package processamento.colecoes;

import processamento.classes.*;
import java.util.HashMap;

/**
 * @see processamento.classes.Ambiente
 * @see java.util.HashMap
 * Este construtor de (ColecaoAmbiente) é utilizado para criar um HashMap que guarda objetos da classe Ambiente, recebendo nada como parametro.
 * 
 */ 
public class ColecaoAmbiente {
	
	private HashMap<HorarioAmbiente,Ambiente> coleambiente;

	public ColecaoAmbiente() {
		super();
		this.coleambiente = new HashMap<HorarioAmbiente,Ambiente>();
	}

	/**
	 * @see processamento.classes.Ambiente
	 * Este metodo privado (gerarAmbiente) é utilizado para criar um objeto da classe Ambiente e retorna o mesmo.
	 * @return Ambiente
	 */
	private Ambiente gerarAmbiente() {
		
		Ambiente ambtmp = new Ambiente();
		
		ambtmp.criarAmbiente();
		
		return ambtmp;
	}
	
	
	/**
	 * @see processamento.classes.Ambiente
	 * Este metodo privado (adicionarAmbiente), é utilizado para adicionar um objeto da classe Ambiente, 
	 * gerado dentro da mesma usando gerarAmbiente, e lança uma exeção caso já exista o objeto dentro da coleção.
	 * 
	 * @throws Exception
	 * @return void
	 * 
	 */
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
	
	
	/**
	 * @see processamento.classes.Ambiente
	 * Este metodo privado (procurarAmbiente), é utilizado para realizar a pesquisa de um objeto da classe Ambiente, 
	 * dentro da coleção, se encontrado o tal objeto é retornado, senão lança uma exeção caso não exista
	 *  o objeto dentro da coleção.
	 * 
	 * @param horariotemporario HorarioAmbiente - O horario o qual se deve informar para que a procura seja realizada.
	 * @throws Exception
	 * @return Ambiente
	 * 
	 */
	public Ambiente procurarAmbiente(HorarioAmbiente horariotemporario) throws Exception {
		
		if(coleambiente.containsKey(horariotemporario)) {
			return coleambiente.get(horariotemporario);
		}	else	{
				Exception e = new Exception();
				System.err.println("Ambiente nao existe!");
				throw e;
		}
	}
	
	/**
	 * @see processamento.classes.Ambiente
	 * Este metodo privado (removerAmbiente), é utilizado para remover um objeto da classe Ambiente
	 *  dentro da coleção, se encontrado o tal objeto é removido, senão lança uma exeção caso não exista
	 *  o objeto dentro da coleção.
	 * 
	 * @param horariotemporario HorarioAmbiente - O horario o qual se deve informar para que a remoção seja realizada.
	 * @throws Exception
	 * @return void
	 * 
	 */
	public void removerAmbiente(HorarioAmbiente horariotemporario) throws Exception {
		
		if(coleambiente.containsKey(horariotemporario)) {
			coleambiente.remove(horariotemporario);
		}	else	{
				Exception e = new Exception("Ambiente nao existe!");
				throw e;
		}
		
	}
	
	
}//fim da colecao ambiente
