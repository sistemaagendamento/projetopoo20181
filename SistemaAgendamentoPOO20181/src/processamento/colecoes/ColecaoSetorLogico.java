package processamento.colecoes;

import processamento.classes.*;
import java.util.HashMap;

public class ColecaoSetorLogico {

	private HashMap<String,SetorLogico> colesetlogico;

	/**
	 * @see processamento.classes.SetorLogico
	 * @see java.util.HashMap
	 * Este construtor de (ColecaoSetorLogico) � utilizado para criar um HashMap que guarda objetos da classe SetorLogico, recebendo nada como parametro.
	 * 
	 */ 
	public ColecaoSetorLogico() {
		super();
		this.colesetlogico = new HashMap<String,SetorLogico>();
	}


	@Override
	public String toString() {
		return "ColecaoSetorLogico [colesetlogico=" + colesetlogico + "]";
	}

	/**
	 * @see processamento.classes.SetorLogico
	 * Este metodo privado (gerarSetorLogico) � utilizado para criar um objeto da classe SetorLogico e retorna o mesmo.
	 * @return SetorLogico
	 */
	private SetorLogico gerarSetorLogico() {
		
		SetorLogico temporario = new SetorLogico();
		
		temporario.criarUnidadeAcademica();
		
		return temporario;
	}
	
	/**
	 * @see processamento.classes.SetorLogico
	 * Este metodo privado (adicionarSetorLogico), � utilizado para adicionar um objeto da classe SetorLogico, 
	 * gerado dentro da mesma usando gerarSetorLogico, e lan�a uma exe��o caso j� exista o objeto dentro da cole��o.
	 * 
	 * @throws Exception
	 * @return void
	 * 
	 */
	public void adicionarSetorLogico() throws Exception {
		
		SetorLogico uatmp = gerarSetorLogico();
		String chave = uatmp.getId();
		
		if(colesetlogico.containsKey(chave)) {
			Exception e = new Exception("Setor Logico ja existente!");
			throw e;
		}	else{
				colesetlogico.put(chave, uatmp);
		}
		
	}
	
	
	/**
	 * @see processamento.classes.SetorLogico
	 * Este metodo privado (pesquisarSetorLogico), � utilizado para realizar a pesquisa de um objeto da classe SetorLogico, 
	 * dentro da cole��o, se encontrado o tal objeto � retornado, sen�o lan�a uma exe��o caso n�o exista
	 *  o objeto dentro da cole��o.
	 * 
	 * @param idtmp String - O codigo indentificador da UnidadeAcademica(Setor Logico) o qual se deve informar para que a procura seja realizada.
	 * @throws Exception
	 * @return SetorLogico
	 * 
	 */
	public SetorLogico pesquisarSetorLogico(String idtmp) throws Exception {
		
		if(colesetlogico.containsKey(idtmp)){
			return colesetlogico.get(idtmp);
		}	else	{
				Exception e = new Exception("Setor Logico ja existente!");
				throw e;
		}
	}
	
	/**
	 * @see processamento.classes.SetorLogico
	 * Este metodo privado (removerSetorLogico), � utilizado para remover um objeto da classe SetorLogico
	 *  dentro da cole��o, se encontrado o tal objeto � removido, sen�o lan�a uma exe��o caso n�o exista
	 *  o objeto dentro da cole��o.
	 * 
	 * @param idtmp String -  O codigo indentificador da UnidadeAcademica(Setor Logico) o qual se deve informar para que a remo��o seja realizada.
	 * @throws Exception
	 * @return void
	 * 
	 */
	public void removerSetorLogico(String idtmp) throws Exception {
		
		if(colesetlogico.containsKey(idtmp)){
			colesetlogico.remove(idtmp);
		}	else	{
				Exception e = new Exception("Setor Logico ja existente!");
				throw e;
		}
	}
	
	
	
}//fim da colecao