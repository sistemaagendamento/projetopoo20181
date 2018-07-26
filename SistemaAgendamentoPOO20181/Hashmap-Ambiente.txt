package processamento.colecoes;

import processamento.classes.*;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.io.File;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

/**
 * @see processamento.classes.Ambiente
 * @see java.util.HashMap
 * Este construtor de (ColecaoAmbiente) é utilizado para criar um HashMap que guarda objetos da classe Ambiente, recebendo nada como parametro.
 * 
 */ 
public class ColecaoAmbiente {
	
	private HashMap<HorarioAmbiente,Ambiente> coleambiente;
	private File ambiente_xml;

	public ColecaoAmbiente() {
		super();
		this.coleambiente = new HashMap<HorarioAmbiente,Ambiente>();
		this.ambiente_xml = new File("Listagem-de-ambientes.xml");
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
	public void adicionarAmbiente(Ambiente ambitmp) throws Exception {
		
		//Ambiente ambitmp = gerarAmbiente();
		
		HorarioAmbiente htmp = ambitmp.getHorario();
		
		if(coleambiente.containsKey(htmp)) {
			Exception e = new Exception("Ambiente ja existe!");
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
				Exception e = new Exception("Ambiente nao existe!");
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
	
	
	 /**
		 * @see processamento.classes.Ambiente
		 * Este metodo publico (salvarEmXml), é utilizado para serializar a Colecao, que guarda objetos da classe Ambiente
		 *  e guarda esta serialização em um arquivo xml, senão lança uma exeção.
		 *  o objeto dentro da coleção.
		 * 
		 * @throws Exception
		 * @return void
		 * 
		 */
	   public void salvarEmXml() throws Exception {
		   
		   XStream sai_xml =  new XStream(new StaxDriver());
	       FileOutputStream salvar_dados;
	       
	       sai_xml.alias("Ambiente", Ambiente.class);
	       sai_xml.alias("Listagem de ambientes",ColecaoAmbiente.class);
	       
	       
	       try {
	           
	    	   salvar_dados = new FileOutputStream(this.ambiente_xml);
	    	   salvar_dados.write(sai_xml.toXML(this.coleambiente).getBytes());
	    	   salvar_dados.close();
	           
	       } catch (Exception erro) {
	    	   erro.printStackTrace();
	       }
	   }
	   
	   /**
	  	 * @see processamento.classes.Laboratorio
	  	 * Este metodo publico (lerDoXml), é utilizado para deserializar a Colecao, que lê objetos da classe Laboratorio,
	  	 *  serializados em um arquivo xml, senão lança uma exeção.
	  	 * @throws Exception
	  	 * @return void
	  	 * 
	  	 */
	   public void lerDoXml() throws Exception {
		   XStream recebe_xml =  new XStream(new StaxDriver());
	       BufferedInputStream ler_dados;
	       
	       recebe_xml.alias("Ambiente", Ambiente.class);
	       recebe_xml.alias("Listagem de ambientes",ColecaoAmbiente.class);
	       
	       
	       if(ambiente_xml.exists()) {
	    	   try {
	           
	    		   ler_dados = new BufferedInputStream( new FileInputStream(this.ambiente_xml) );
	    	   
	    		   this.coleambiente = (HashMap<HorarioAmbiente, Ambiente>) recebe_xml.fromXML(ler_dados);
	    		   ler_dados.close();
	           
	       		} catch (Exception erro) {
	    	   		erro.printStackTrace();
	       		}
	       }
	   }
	
	
}//fim da colecao ambiente
