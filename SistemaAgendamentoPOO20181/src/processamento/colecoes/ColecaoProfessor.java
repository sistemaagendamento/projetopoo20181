package processamento.colecoes;


import java.util.ArrayList;
import java.util.HashMap;
import processamento.classes.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;


public class ColecaoProfessor {

	private HashMap<String,Professor> coleprofessor;
	private File professor_xml;
	/**
	 * @see processamento.classes.Professor
	 * @see java.util.HashMap
	 * Este construtor de (ColecaoProfessor) é utilizado para criar um HashMap que guarda objetos da classe Professor, recebendo nada como parametro.
	 * 
	 */ 
	public ColecaoProfessor() {
		super();
		this.coleprofessor = new HashMap<String,Professor>();
		this.professor_xml = new File("Lista-de-professores.xml");
	}

	@Override
	public String toString() {
		return "ColecaoProfessor [coleprofessor=" + coleprofessor + "]";
	}
	
	//metodos
	
	/**
	 * @see processamento.classes.Professor
	 * Este metodo privado (gerarProfessor) é utilizado para criar um objeto da classe Professor e retorna o mesmo.
	 * @return Professor
	 */
	private Professor gerarProfessor() {
		
		Professor temporario = new Professor();
		
		temporario.criarProfessor();
		
		return temporario;	
	}
	
	/**
	 * @see processamento.classes.Professor
	 * Este metodo privado (adicionarProfessor), é utilizado para adicionar um objeto da classe Professor, 
	 * gerado dentro da mesma usando gerarProfessor, e lança uma exeção caso já exista o objeto dentro da coleção.
	 * 
	 * @throws Exception
	 * @return void
	 * 
	 */
 	public void adicionarProfessor() throws Exception{
		Professor prof = gerarProfessor();
		String matprofessor = prof.getMatricula();
		
		
		if(coleprofessor.containsKey(matprofessor) ) { 
			Exception e = new Exception("Professor ja existe!");
			throw e;
			}	else{ 
				coleprofessor.put(matprofessor, prof);	
		}
		
 	}
	
 	/**
 	 * @see processamento.classes.Professor
 	 * Este metodo privado (pesquisarProfessor), é utilizado para realizar a pesquisa de um objeto da classe Professor, 
 	 * dentro da coleção, se encontrado o tal objeto é retornado, senão lança uma exeção caso não exista
 	 *  o objeto dentro da coleção.
 	 * 
 	 * @param matriculaprof String - A matricula a qual se deve informar para que a procura seja realizada.
 	 * @throws Exception
 	 * @return Professor
 	 * 
 	 */
 	public Professor pesquisarProfessor(String matriculaprof) throws Exception{
			
			if(coleprofessor.containsKey(matriculaprof) ) { 
				return coleprofessor.get(matriculaprof);
				}	else{ 
						Exception e = new Exception("Professor nao existe!");
						throw e;	
			}
	}
	
 	/**
 	 * @see processamento.classes.Professor
 	 * Este metodo privado (removerProfessor), é utilizado para remover um objeto da classe Professor
 	 *  dentro da coleção, se encontrado o tal objeto é removido, senão lança uma exeção caso não exista
 	 *  o objeto dentro da coleção.
 	 * 
 	 * @param matriculaprof String - A matricula a qual se deve informar para que a remoção seja realizada.
 	 * @throws Exception
 	 * @return void
 	 * 
 	 */
	public void removerProfessor(String matriculaprof) throws Exception{
		
		if(coleprofessor.containsKey(matriculaprof) ) { 
			coleprofessor.remove(matriculaprof);
			}	else{ 
					Exception e = new Exception("Professor nao existe!");
					throw e;	
		}
	}
	
	   /**
		 * @see processamento.classes.Professor
		 * Este metodo publico (salvarEmXml), é utilizado para serializar a Colecao, que guarda objetos da classe Professor
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
	       
	       sai_xml.alias("Professor", Professor.class);
	       sai_xml.alias("Listagem de professores",ColecaoProfessor.class);
	       
	       
	       try {
	           
	    	   salvar_dados = new FileOutputStream(this.professor_xml);
	    	   salvar_dados.write(sai_xml.toXML(coleprofessor).getBytes());
	    	   salvar_dados.close();
	           
	       } catch (Exception erro) {
	    	   erro.printStackTrace();
	       }
	   }
	   
	   /**
	  	 * @see processamento.classes.Professor
	  	 * Este metodo publico (lerDoXml), é utilizado para deserializar a Colecao, que lê objetos da classe Professor,
	  	 *  serializados em um arquivo xml, senão lança uma exeção.
	  	 * @throws Exception
	  	 * @return void
	  	 * 
	  	 */
	   public void lerDoXml() throws Exception {
		   XStream recebe_xml =  new XStream(new StaxDriver());
	       BufferedInputStream ler_dados;
	       
	       recebe_xml.alias("Professor", Professor.class);
	       recebe_xml.alias("Listagem de professores",ColecaoProfessor.class);
	       
	       
	       if(professor_xml.exists()) {
	       		try {
	           
	       			ler_dados = new BufferedInputStream( new FileInputStream(this.professor_xml) );
	    	   
	       			this.coleprofessor = (HashMap<String,Professor>) recebe_xml.fromXML(ler_dados);
	    		    	   
	       			ler_dados.close();
	           
	       		} catch (Exception erro) {
	       			erro.printStackTrace();
	       		}
	       }	
	   }
 	
	
}//fim da classe ColecaoProfessor
