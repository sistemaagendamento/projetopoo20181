package processamento.colecoes;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.io.File;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import processamento.classes.*;

public class ColecaoLaboratorio {
	
	private HashMap<HorarioAmbiente,Laboratorio> colelaboratorio;
	private File laboratorio_xml;

	/**
	 * @see processamento.classes.Laboratorio
	 * @see java.util.HashMap
	 * Este construtor de (ColecaoLaboratorio) � utilizado para criar um HashMap que guarda objetos da classe Laboratorio, recebendo nada como parametro.
	 * 
	 */ 
	public ColecaoLaboratorio() {
		super();
		this.colelaboratorio = new HashMap<HorarioAmbiente,Laboratorio>();
		this.laboratorio_xml = new File("Lista-de-Laboratorios.xml");
	}

	@Override
	public String toString() {
		return "ColecaoLaboratorio [colelaboratorio=" + colelaboratorio + "]";
	}

	/**
	 * @see processamento.classes.Laboratorio
	 * @see processamento.classes.Ambiente
	 * Este metodo privado (gerarLaboratorio) � utilizado para criar um objeto da classe Laboratorio e retorna o mesmo.
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
	 * Este metodo privado (adicionarLaboratorio), � utilizado para adicionar um objeto da classe Laboratorio, 
	 * gerado dentro da mesma usando gerarLaboratorio, e lan�a uma exe��o caso j� exista o objeto dentro da cole��o.
	 * 
	 * @throws Exception
	 * @return void
	 * 
	 */
	public void adicionarLaboratorio() throws Exception {
		Laboratorio laboratoriotmp = gerarLaboratorio();
		HorarioAmbiente htmp = laboratoriotmp.getHorario();
		
		if(colelaboratorio.containsKey(htmp)) {
			Exception e = new Exception("Ambiente ja existe!");
			throw e;
		}	else	{
				colelaboratorio.put(htmp, laboratoriotmp);
		}
		
		
	}
	
	/**
	 * @see processamento.classes.Laboratorio
	 * Este metodo privado (procurarLaboratorio), � utilizado para realizar a pesquisa de um objeto da classe Laboratorio, 
	 * dentro da cole��o, se encontrado o tal objeto � retornado, sen�o lan�a uma exe��o caso n�o exista
	 *  o objeto dentro da cole��o.
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
				Exception e = new Exception("Ambiente nao existe!");
				throw e;
		}
	}
	
	
	/**
	 * @see processamento.classes.Laboratorio
	 * Este metodo privado (removerLaboratorio), � utilizado para remover um objeto da classe Laboratorio
	 *  dentro da cole��o, se encontrado o tal objeto � removido, sen�o lan�a uma exe��o caso n�o exista
	 *  o objeto dentro da cole��o.
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
				Exception e = new Exception("Ambiente nao existe!");
				throw e;
		}
	}

	
	 /**
	 * @see processamento.classes.Laboratorio
	 * Este metodo publico (salvarEmXml), � utilizado para serializar a Colecao, que guarda objetos da classe Laboratorio
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
       
       sai_xml.alias("Laboratorio", Laboratorio.class);
       sai_xml.alias("Listagem de laboatorios",ColecaoLaboratorio.class);
       
       
       try {
           
    	   salvar_dados = new FileOutputStream(this.laboratorio_xml);
    	   salvar_dados.write(sai_xml.toXML(this.colelaboratorio).getBytes());
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
	   XStream recebe_xml =  new XStream(new StaxDriver());
       BufferedInputStream ler_dados;
       
       recebe_xml.alias("Laboratorio", Laboratorio.class);
       recebe_xml.alias("Listagem de laboatorios",ColecaoLaboratorio.class);
       
       
       if(laboratorio_xml.exists()) {
    	   try {

    		   ler_dados = new BufferedInputStream( new FileInputStream(this.laboratorio_xml) );
    	   
    		   this.colelaboratorio = (HashMap<HorarioAmbiente, Laboratorio>) recebe_xml.fromXML(ler_dados);
    		    	   
    		   ler_dados.close();
           
    	   } catch (Exception erro) {
    		   erro.printStackTrace();
    	   }
       }
   }
	
}//fim da classe
