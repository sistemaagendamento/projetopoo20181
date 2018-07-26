package processamento.colecoes;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocket {
	
	private ServerSocket servidor;
	private Socket cl;
	private ObjectInputStream entrada;
	private ObjectOutputStream saida;
	private int porta;
	private int num_conexoes;
 
	/**
	 * 
	 * @param porta int - Define uma porta para ser usada
	 * @param num_conexoes - Define um numero m�ximo de conex�es(n�o implementado)
	 */
    public ServidorSocket(int porta, int num_conexoes) {
		super();
		this.porta = porta;
		this.num_conexoes = num_conexoes;
		
	}

    
    /** 
     * Este m�todo faz a inicializa��o do servidor 
     * @param porta Integer - Porta para ser usada no ServerSocket
     * @throws Exception
     */
    public void abrirServerSocket() throws Exception{
    	//servidor = new ServerSocket(this.porta,this.num_conexoes);
    	servidor = new ServerSocket(this.porta);
    }

    
    /**
     * Este m�todo faz com que o servidor aguarde a conex�o
     * @return Socket
     * @throws Exception
     */
    public Socket aguardaConexao() throws Exception{
    	
    	this.cl = servidor.accept();
    	return cl;
    }
    
    /**
     * Este m�todo faz o controle de entrada e saida do socket
     * @return void
     * @throws Exception
     */
    public void gerenciadorSocket(Socket sockt) throws Exception {
    	
    	
    	this.saida = new ObjectOutputStream(cl.getOutputStream());
    	
    	this.entrada = new ObjectInputStream(cl.getInputStream());
    	
    	
    }
    
    /**
     * Este m�todo faz o fechamento de entrada e saida do ServidorSocket
     * @return void
     * @throws Exception
     */
    public void fecharStreamsInternos() throws IOException {
    	this.saida.close();
    	this.entrada.close();
    }
    
    /**
     * Este m�todo faz o fechamento de entrada e saida externos ao ServidorSocket
     * @return void
     * @throws Exception
     */
    public void fecharStreams(ObjectOutputStream saida, ObjectInputStream entrada) throws IOException {
    	
    	saida.close();
    	entrada.close();
    	
    }
    
    /**
     * Este m�todo faz o fechamento do socket
     * @return void
     * @throws Exception
     */
    public void fecharSocket(Socket sockt) throws Exception {
    	
    	sockt.close();
    	
    }
    
}//fim da classe ServidorSocket
