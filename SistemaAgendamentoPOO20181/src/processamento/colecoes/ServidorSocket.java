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
 
	
    public ServidorSocket(int porta, int num_conexoes) {
		super();
		this.porta = porta;
		this.num_conexoes = num_conexoes;
		
	}

    
    
    public void abrirServerSocket() throws Exception{
    	//servidor = new ServerSocket(this.porta,this.num_conexoes);
    	servidor = new ServerSocket(this.porta);
    }

    
    
    public Socket aguardaConexao() throws Exception{
    	
    	this.cl = servidor.accept();
    	return cl;
    }
    
    public void gerenciadorSocket(Socket sockt) throws Exception {
    	
    	
    	this.saida = new ObjectOutputStream(cl.getOutputStream());
    	
    	this.entrada = new ObjectInputStream(cl.getInputStream());
    	
    	
    }
    
    
    public void fecharStreamsInternos() throws IOException {
    	this.saida.close();
    	this.entrada.close();
    }
    
    public void fecharStreams(ObjectOutputStream saida, ObjectInputStream entrada) throws IOException {
    	
    	saida.close();
    	entrada.close();
    	
    }
    
    public void fecharSocket(Socket sockt) throws Exception {
    	
    	sockt.close();
    	
    }
    
}//fim da classe ServidorSocket
