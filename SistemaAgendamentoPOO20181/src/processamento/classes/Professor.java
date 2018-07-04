package processamento.classes;

import java.util.Scanner;

public class Professor {
	
	private String nome;
	private String matricula;
	private String cpf;
	private String formacao;
	private SetorLogico ua;
	//nao foi implementado rg e cadeiras
	
	//contrutores
	
	public Professor() {

		super();
	}
	
	//getters and setters
	public String getNome() {
		return nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public String getCpf() {
		return cpf;
	}
	public String getFormacao() {
		return formacao;
	}
	public SetorLogico getUa() {
		return ua;
	}
	private void setNome(String nome) {
		this.nome = nome;
	}
	private void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	private void setCpf(String cpf) {
		this.cpf = cpf;
	}
	private void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	public void setUa(SetorLogico ua) {
		this.ua = ua;
	}
	
	//toString
	@Override
	public String toString() {
		return "Professor [nome=" + nome + ", matricula=" + matricula + ", cpf=" + cpf + ", formacao=" + formacao
				+ ", ua=" + ua + "]";
	}
	
	//hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((formacao == null) ? 0 : formacao.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((ua == null) ? 0 : ua.hashCode());
		return result;
	}
	
	//equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (formacao == null) {
			if (other.formacao != null)
				return false;
		} else if (!formacao.equals(other.formacao))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (ua == null) {
			if (other.ua != null)
				return false;
		} else if (!ua.equals(other.ua))
			return false;
		return true;
	}
	
	
	
	//metodos
	
	
	public void criarProfessor(){
	
		Scanner tclin = new Scanner(System.in);
		
		System.out.print("Digite o nome do professor: ");
		setNome(tclin.nextLine());
				
		System.out.print("Digite a matricula do professor: ");
		setMatricula(tclin.nextLine());
		
		System.out.print("Digite o CPF do professor: ");
		setCpf(tclin.nextLine());
		
		System.out.print("Digite a formacao do professor: ");
		setFormacao(tclin.nextLine());
		
		/*System.out.print("Indique a unidade academica do professor pelo id: ");*/
		
	}
	
	
	

}//fim da classe professor
