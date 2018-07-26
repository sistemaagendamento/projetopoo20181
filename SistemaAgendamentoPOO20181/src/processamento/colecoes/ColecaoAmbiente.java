package processamento.colecoes;

import processamento.classes.*;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.io.File;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;

/**
 * @see processamento.classes.Ambiente
 * @see java.util.HashMap
 * Este construtor de (ColecaoAmbiente) � utilizado para criar um HashMap que guarda objetos da classe Ambiente, recebendo nada como parametro.
 * 
 */ 
public class ColecaoAmbiente {
	
	private ArrayList<Ambiente> coleambiente;
	private File ambiente_xml;

	public ColecaoAmbiente() {
		super();
		this.coleambiente = new ArrayList<Ambiente>();
		this.ambiente_xml = new File("Listagem-de-Ambientes.xml");
	}

	
	
	/**
	 * @return String de todos os elementos do ArrayList
	 */
	@Override
	public String toString() {
		return "ColecaoAmbiente [coleambiente=" + coleambiente + "]";
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
	public void adicionarAmbiente(Ambiente ambientetmp) throws Exception {
		
		//Ambiente ambitmp = gerarAmbiente();
		
		Boolean check = false;
		
		for(Ambiente ambtmp : coleambiente) {
			if(ambientetmp.getHorario().equals(ambtmp.getHorario()) && ambientetmp.getNome().equals(ambtmp.getNome())) {
				Exception e = new Exception("Ambiente ja existe!");	
				throw e;
			}	else	{
				
				check = true;
			}
		
		}
	
		if(check) {
			coleambiente.add(ambientetmp);
		}
		
		
	}
	
	
	/**
	 * @see processamento.classes.Ambiente
	 * Este metodo privado (procurarAmbiente), � utilizado para realizar a pesquisa de um objeto da classe Ambiente, 
	 * dentro da cole��o, se encontrado o tal objeto � retornado, sen�o lan�a uma exe��o caso n�o exista
	 *  o objeto dentro da cole��o.
	 * 
	 * @param horariotemporario HorarioAmbiente - O horario o qual se deve informar para que a procura seja realizada.
	 * @param nomeambientetmp String - O nome do ambiente o qual se deve informar para que a procura seja realizada.
	 * @throws Exception
	 * @return Ambiente
	 * 
	 */
	public Ambiente procurarAmbiente(HorarioAmbiente horariotemporario, String nomeambientetmp) throws Exception {
		
		for(Ambiente ambtmp : coleambiente) {
			
			if(ambtmp.getHorario().equals(horariotemporario) && ambtmp.getNome().equals(nomeambientetmp)) {
				return ambtmp;				
			}	else	{
				Exception e = new Exception("Ambiente nao existe!");
				throw e;
			}
		
		}
		return null;
		
	}
	
	/**
	 * @see processamento.classes.Ambiente
	 * Este metodo privado (removerAmbiente), � utilizado para remover um objeto da classe Ambiente
	 *  dentro da cole��o, se encontrado o tal objeto � removido, sen�o lan�a uma exe��o caso n�o exista
	 *  o objeto dentro da cole��o.
	 * 
	 * @param horariotemporario HorarioAmbiente - O horario o qual se deve informar para que a remo��o seja realizada.
	 * @param nomeambientetmp String - O nome do ambiente o qual se deve informar para que a procura seja realizada.
	 * @throws Exception
	 * @return void
	 * 
	 */
	public void removerAmbiente(HorarioAmbiente horariotemporario, String nomeambientetmp) throws Exception {
		
		
		for(Ambiente ambtmp : coleambiente) {
			
			if(ambtmp.getHorario().equals(horariotemporario) && ambtmp.getNome().equals(nomeambientetmp)) {
				coleambiente.remove(ambtmp);				
			}	else	{
				Exception e = new Exception("Ambiente nao existe!");
				throw e;
			}
		
		}		
		
	}
	
	/**
	 * @see processamento.classes.Ambiente
	 * Este metodo publico (verColecaoAmbiente), � utilizado para ver a cole��o Ambiente inteira
	 * 

	 * @return void
	 * 
	 */
	public void verColecaoAmbiente() throws Exception {
		
		
		for(Ambiente ambtmp : coleambiente) {
			System.out.println(ambtmp);
		}		
		
	}
	
	
	
	 /**
		 * @see processamento.classes.Ambiente
		 * Este metodo publico (salvarEmXml), � utilizado para serializar a Colecao, que guarda objetos da classe Ambiente
		 *  e guarda esta serializa��o em um arquivo xml, sen�o lan�a uma exe��o.
		 *  o objeto dentro da cole��o.
		 * 
		 * @throws Exception
		 * @return void
		 * 
		 */
	   public void salvarEmXml() throws Exception {
		   
		   XStream sai_xml =  new XStream(new DomDriver());
	       FileOutputStream salvar_dados;
	       
	       sai_xml.alias("Ambiente", Ambiente.class);
	       sai_xml.alias("Listagem-de-Ambientes",ColecaoAmbiente.class);
	       
	       
	       try {
	           
	    	   salvar_dados = new FileOutputStream(this.ambiente_xml);
	    	   salvar_dados.write(sai_xml.toXML(this.coleambiente).getBytes());
	    	   salvar_dados.flush();
	    	   salvar_dados.close();
	           
	       } catch (Exception erro) {
	    	   erro.printStackTrace();
	       }
	   }
	   
	   /**
	  	 * @see processamento.classes.Laboratorio
	  	 * Este metodo publico (lerDoXml), � utilizado para deserializar a Colecao, que l� objetos da classe Laboratorio,
	  	 *  serializados em um arquivo xml, sen�o lan�a uma exe��o.
	  	 * @throws Exception
	  	 * @return void
	  	 * 
	  	 */
	   public void lerDoXml() throws Exception {
		   XStream recebe_xml =  new XStream(new DomDriver());
	       BufferedInputStream ler_dados;
	       
	       recebe_xml.alias("Ambiente", Ambiente.class);
	       recebe_xml.alias("Listagem de ambientes",ColecaoAmbiente.class);
	       
	       
	       if(ambiente_xml.exists()) {
	    	   try {
	           
	    		   ler_dados = new BufferedInputStream( new FileInputStream(this.ambiente_xml) );
	    	   
	    		   this.coleambiente = (ArrayList<Ambiente>) recebe_xml.fromXML(ler_dados);
	    		   
	    		   ler_dados.close();
	           
	       		} catch (Exception erro) {
	    	   		erro.printStackTrace();
	       		}
	       }
	   }
	
	
}//fim da colecao ambiente
