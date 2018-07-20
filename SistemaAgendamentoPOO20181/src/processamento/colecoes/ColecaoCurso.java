package processamento.colecoes;

import processamento.classes.*;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.io.File;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;


public class ColecaoCurso {

	private HashMap<String,Curso> colecurso;
	private File curso_xml;

	/**
	 * @see processamento.classes.Curso
	 * @see java.util.HashMap
	 * Este construtor de (ColecaoCurso) � utilizado para criar um HashMap que guarda objetos da classe Curso, recebendo nada como parametro.
	 * 
	 */ 
	public ColecaoCurso() {
		super();
		this.colecurso = new HashMap<String, Curso>();
		this.curso_xml = new File("Listagem-de-Cursos");
	}

	/**
	 * @return String de todos os elementos do HashMap
	 * */
	@Override
	public String toString() {
		return "ColecaoCurso [colecurso=" + colecurso + "]";
	}
	
	
	/**
	 * @see processamento.classes.Curso
	 * Este metodo privado (gerarCurso) � utilizado para criar um objeto da classe Curso e retorna o mesmo.
	 * @return Curso
	 */
	private Curso gerarCurso() {
		
		Curso temporario = new Curso();
		
		temporario.criarCurso();
		
		return temporario;
	}
	
	

	/**
	 * @see processamento.classes.Curso
	 * Este metodo privado (adicionarCurso), � utilizado para adicionar um objeto da classe Curso, 
	 * gerado dentro da mesma usando gerarCurso, e lan�a uma exe��o caso j� exista o objeto dentro da cole��o.
	 * 
	 * @throws Exception
	 * @return void
	 * 
	 */
	public void adicionarCurso() throws Exception {
		
		Curso cursotmp = gerarCurso();
		String chave = cursotmp.getCodigo();
		
		if(colecurso.containsKey(chave) ) {
			Exception e = new Exception("Curso ja existe!");
			throw e;
		}	else {
			colecurso.put(chave, cursotmp);
		}
		
	}

	/**
	 * @see processamento.classes.Curso
	 * Este metodo privado (pesquisarCurso), � utilizado para realizar a pesquisa de um objeto da classe Curso, 
	 * dentro da cole��o, se encontrado o tal objeto � retornado, sen�o lan�a uma exe��o caso n�o exista
	 *  o objeto dentro da cole��o.
	 * 
	 * @param codigotmp String - O codigo do curso o qual se deve informar para que a procura seja realizada.
	 * @throws Exception
	 * @return Curso
	 * 
	 */
	public Curso pesquisarCurso(String codigotmp) throws Exception{
		
		if(colecurso.containsKey(codigotmp)) {
			return colecurso.get(codigotmp);
		}	else {
				Exception e = new Exception("Curso nao existe!");
				throw e;
		}
	}
	
	/**
	 * @see processamento.classes.Curso
	 * Este metodo privado (removerCurso), � utilizado para remover um objeto da classe Curso
	 *  dentro da cole��o, se encontrado o tal objeto � removido, sen�o lan�a uma exe��o caso n�o exista
	 *  o objeto dentro da cole��o.
	 * 
	 * @param codigotmp String - O codigo do curso o qual se deve informar para que a remo��o seja realizada.
	 * @throws Exception
	 * @return void
	 * 
	 */
	public void removerCurso(String codigotmp) throws Exception{
		
		if(colecurso.containsKey(codigotmp)) {
			colecurso.remove(codigotmp);
		}	else {
				Exception e = new Exception("Curso nao existe!");
				throw e;
		}
	}
	
	
	 /**
		 * @see processamento.classes.Curso
		 * Este metodo publico (salvarEmXml), � utilizado para serializar a Colecao, que guarda objetos da classe Curso
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
	       
	       sai_xml.alias("Curso", Curso.class);
	       sai_xml.alias("Listagem de cursos",ColecaoCurso.class);
	       
	       
	       try {
	           
	    	   salvar_dados = new FileOutputStream(this.curso_xml);
	    	   salvar_dados.write(sai_xml.toXML(this.colecurso).getBytes());
	    	   salvar_dados.close();
	           
	       } catch (Exception erro) {
	    	   erro.printStackTrace();
	       }
	   }
	   
	   /**
	  	 * @see processamento.classes.Curso
	  	 * Este metodo publico (lerDoXml), � utilizado para deserializar a Colecao, que l� objetos da classe Curso,
	  	 *  serializados em um arquivo xml, sen�o lan�a uma exe��o.
	  	 * @throws Exception
	  	 * @return void
	  	 * 
	  	 */
	   public void lerDoXml() throws Exception {
		   XStream recebe_xml =  new XStream(new StaxDriver());
	       BufferedInputStream ler_dados;
	       
	       recebe_xml.alias("Curso", Curso.class);
	       recebe_xml.alias("Listagem de cursos",ColecaoCurso.class);
	       
	       
	       if(curso_xml.exists()) {
	    	   try {
	           
	    	   ler_dados = new BufferedInputStream( new FileInputStream(this.curso_xml) );
	    	   //ler_dados.write(saixml.toXML(colec_pc).getBytes());
	    	   this.colecurso = (HashMap<String, Curso>) recebe_xml.fromXML(ler_dados);
	    		    	   
	    	   ler_dados.close();
	           
	       		} catch (Exception erro) {
	       			erro.printStackTrace();
	       		}
	       }
	   }
	
}//fim da colecao curso