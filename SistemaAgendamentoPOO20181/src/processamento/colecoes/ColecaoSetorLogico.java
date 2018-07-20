package processamento.colecoes;

import processamento.classes.*;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class ColecaoSetorLogico {

	private HashMap<String,SetorLogico> colesetlogico;
	private File slogico_xml;

	/**
	 * @see processamento.classes.SetorLogico
	 * @see java.util.HashMap
	 * Este construtor de (ColecaoSetorLogico) � utilizado para criar um HashMap que guarda objetos da classe SetorLogico, recebendo nada como parametro.
	 * 
	 */ 
	public ColecaoSetorLogico() {
		super();
		this.colesetlogico = new HashMap<String,SetorLogico>();
		this.slogico_xml = new File("Lista-de-Unidades-Academicas.xml");
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
	
	
	  /**
			 * @see processamento.classes.SetorLogico
			 * Este metodo publico (salvarEmXml), � utilizado para serializar a Colecao, que guarda objetos da classe SetorLogico
			 *  e guarda esta serializa��o em um arquivo xml, sen�o lan�a uma exe��o.
			 *  o objeto dentro da cole��o.
			 * 
			 * @throws Exception
			 * @return void
			 * 
			 */
		   public void salvarEmXml() throws Exception {
			   
			   XStream sai_xml =  new XStream(new StaxDriver());
		       FileOutputStream salvar_dados;
		       
		       sai_xml.alias("Unidade_Academica", SetorLogico.class);
		       sai_xml.alias("Listagem de unidades academicas",ColecaoSetorLogico.class);
		       
		       
		       try {
		           
		    	   salvar_dados = new FileOutputStream(this.slogico_xml);
		    	   salvar_dados.write(sai_xml.toXML(this.colesetlogico).getBytes());
		    	   salvar_dados.close();
		           
		       } catch (Exception erro) {
		    	   erro.printStackTrace();
		       }
		   }
		   
		   /**
		  	 * @see processamento.classes.SetorLogico
		  	 * Este metodo publico (lerDoXml), � utilizado para deserializar a Colecao, que l� objetos da classe SetorLogico,
		  	 *  serializados em um arquivo xml, sen�o lan�a uma exe��o.
		  	 * @throws Exception
		  	 * @return void
		  	 * 
		  	 */
		   public void lerDoXml() throws Exception {
			   XStream recebe_xml =  new XStream(new StaxDriver());
		       BufferedInputStream ler_dados;
		       
		       recebe_xml.alias("Unidade_Academica", SetorLogico.class);
		       recebe_xml.alias("Listagem de unidades academicas",ColecaoSetorLogico.class);
		       
		       
		       if(slogico_xml.exists()) {
		       		try {
		           
		       			ler_dados = new BufferedInputStream( new FileInputStream(this.slogico_xml) );
		    	   
		       			this.colesetlogico = (HashMap<String,SetorLogico>) recebe_xml.fromXML(ler_dados);
		    		    	   
		       			ler_dados.close();
		           
		       		} catch (Exception erro) {
		       			erro.printStackTrace();
		       		}
		   		}
		   }
	
	
	
}//fim da colecao