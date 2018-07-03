package processamento.classes;

import java.util.Scanner;
import processamento.colecoes.*;

public class Curso {

	private String codigo;
	private String nome;
	private Professor coordenador;
	private String horario;
	
	
	//Construtores

	public Curso() {
		super();
	}

	//getters and setters

	public String getCodigo() {
		return codigo;
	}


	public String getNome() {
		return nome;
	}


	public Professor getCoordenador() {
		return coordenador;
	}


	public String getHorario() {
		return horario;
	}


	private void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	private void setNome(String nome) {
		this.nome = nome;
	}


	public void setCoordenador(Professor coordenador) {
		this.coordenador = coordenador;
	}


	private void setHorario(String horario) {
		this.horario = horario;
	}



	@Override
	public String toString() {
		return "Curso [codigo=" + codigo + ", nome=" + nome + ", coordenador=" + coordenador + ", horario=" + horario
				+ "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((coordenador == null) ? 0 : coordenador.hashCode());
		result = prime * result + ((horario == null) ? 0 : horario.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (coordenador == null) {
			if (other.coordenador != null)
				return false;
		} else if (!coordenador.equals(other.coordenador))
			return false;
		if (horario == null) {
			if (other.horario != null)
				return false;
		} else if (!horario.equals(other.horario))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
	public void criarCurso() {
		
		Scanner tclin = new Scanner(System.in);
		
		System.out.print("Digite o codigo do curso:");
		setCodigo(tclin.nextLine() );
		
		System.out.print("Digite o nome do curso:");
		setNome(tclin.nextLine() );
		
		System.out.print("Digite a matricula do coordenador do curso:");
		
		
		System.out.print("Digite o horario do curso:");
		setHorario(tclin.nextLine() );
		
	}
	
	
}// fim da classe Curso
