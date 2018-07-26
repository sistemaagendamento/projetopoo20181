/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.dados;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClienteSocket {
	
	private Socket cliente;
	private ObjectInputStream entrada_cliente;
	private ObjectOutputStream saida_cliente;
	private Integer porta;
	private String host;
	
	
	public ClienteSocket(int porta,String host) {
        this.porta = porta;
        this.host = host;
    }
	
	public void abrirSocket() throws Exception {
        this.cliente = new Socket(this.host,this.porta);
    }
	
	
	public void gerenciadorSocket() throws Exception {
    	
    	
    	this.saida_cliente = new ObjectOutputStream(cliente.getOutputStream());
    	
    	this.entrada_cliente = new ObjectInputStream(cliente.getInputStream());
    	
    	String mesagem_cliente = new String("Ola servidor, no ip: " + host);
    	System.out.println(mesagem_cliente);
    	saida_cliente.writeUTF("Ola servidor, no ip: " + host);
    	
    	
    	String resposta_server;
        
    	System.out.println();
    	
	}
	
	 public void fecharStreamsInternos() throws IOException {
	    	this.saida_cliente.close();
	    	this.entrada_cliente.close();
	    }
	    

	 public void fecharSocketInterno() throws IOException {
	    	
	    	this.cliente.close();
	    	
	 }
	
}//fim da classe ClienteSocket
