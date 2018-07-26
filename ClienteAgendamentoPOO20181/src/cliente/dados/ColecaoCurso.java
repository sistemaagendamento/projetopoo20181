package cliente.dados;


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
	 * Este construtor de (ColecaoCurso) é utilizado para criar um HashMap que guarda objetos da classe Curso, recebendo nada como parametro.
	 * 
	 */ 
	public ColecaoCurso() {
		super();
		this.colecurso = new HashMap<String, Curso>();
		this.curso_xml = new File("Listagem-de-Cursos.xml");
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
	 * Este metodo privado (gerarCurso) é utilizado para criar um objeto da classe Curso e retorna o mesmo.
	 * @return Curso
	 */
	private Curso gerarCurso() {
		
		Curso temporario = new Curso();
		
		temporario.criarCurso();
		
		return temporario;
	}
	
	

	/**
	 * @see processamento.classes.Curso
	 * Este metodo privado (adicionarCurso), é utilizado para adicionar um objeto da classe Curso, 
	 * gerado dentro da mesma usando gerarCurso, e lança uma exeção caso já exista o objeto dentro da coleção.
	 * 
	 * @throws Exception
	 * @return void
	 * 
	 */
	public void adicionarCurso(Curso cursotmp) throws Exception {
		
		//Curso cursotmp = gerarCurso();
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
	 * Este metodo privado (pesquisarCurso), é utilizado para realizar a pesquisa de um objeto da classe Curso, 
	 * dentro da coleção, se encontrado o tal objeto é retornado, senão lança uma exeção caso não exista
	 *  o objeto dentro da coleção.
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
	 * Este metodo privado (removerCurso), é utilizado para remover um objeto da classe Curso
	 *  dentro da coleção, se encontrado o tal objeto é removido, senão lança uma exeção caso não exista
	 *  o objeto dentro da coleção.
	 * 
	 * @param codigotmp String - O codigo do curso o qual se deve informar para que a remoção seja realizada.
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
		 * Este metodo publico (salvarEmXml), é utilizado para serializar a Colecao, que guarda objetos da classe Curso
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
	  	 * Este metodo publico (lerDoXml), é utilizado para deserializar a Colecao, que lê objetos da classe Curso,
	  	 *  serializados em um arquivo xml, senão lança uma exeção.
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