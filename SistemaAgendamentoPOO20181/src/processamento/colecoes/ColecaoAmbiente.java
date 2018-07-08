package processamento.colecoes;

import processamento.classes.*;
import java.util.HashMap;

/**
 * @see processamento.classes.Ambiente
 * @see java.util.HashMap
 * Este construtor de (ColecaoAmbiente) � utilizado para criar um HashMap que guarda objetos da classe Ambiente, recebendo nada como parametro.
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
	 * Este metodo privado (gerarAmbiente) � utilizado para criar um objeto da classe Ambiente e retorna o mesmo.
	 * @return Ambiente
	 */
	private Ambiente gerarAmbiente() {
		
		Ambiente ambtmp = new Ambiente();
		
		ambtmp.criarAmbiente();
		
		return ambtmp;
	}
	
	
	/**
	 * @see processamento.classes.Ambiente
	 * Este metodo privado (adicionarAmbiente), � utilizado para adicionar um objeto da classe Ambiente, 
	 * gerado dentro da mesma usando gerarAmbiente, e lan�a uma exe��o caso j� exista o objeto dentro da cole��o.
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
	 * Este metodo privado (procurarAmbiente), � utilizado para realizar a pesquisa de um objeto da classe Ambiente, 
	 * dentro da cole��o, se encontrado o tal objeto � retornado, sen�o lan�a uma exe��o caso n�o exista
	 *  o objeto dentro da cole��o.
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
	 * Este metodo privado (removerAmbiente), � utilizado para remover um objeto da classe Ambiente
	 *  dentro da cole��o, se encontrado o tal objeto � removido, sen�o lan�a uma exe��o caso n�o exista
	 *  o objeto dentro da cole��o.
	 * 
	 * @param horariotemporario HorarioAmbiente - O horario o qual se deve informar para que a remo��o seja realizada.
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
