package processamento.classes;

import java.util.ArrayList;
import java.util.Scanner;
import processamento.colecoes.*;

public class SetorLogico {

	private String id;
	private String nome;
	private Professor coordenador;
	private ArrayList<Curso> cursos;
	

	public SetorLogico() {
		super();
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Professor getCoordenador() {
		return coordenador;
	}

	public ArrayList<Curso> getCursos() {
		return cursos;
	}

	private void setId(String id) {
		this.id = id;
	}

	private void setNome(String nome) {
		this.nome = nome;
	}

	public void setCoordenador(Professor coordenador) {
		this.coordenador = coordenador;
	}

	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
	}

	@Override
	public String toString() {
		return "SetorLogico [id=" + id + ", nome=" + nome + ", coordenador=" + coordenador + ", cursos=" + cursos + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordenador == null) ? 0 : coordenador.hashCode());
		result = prime * result + ((cursos == null) ? 0 : cursos.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		SetorLogico other = (SetorLogico) obj;
		if (coordenador == null) {
			if (other.coordenador != null)
				return false;
		} else if (!coordenador.equals(other.coordenador))
			return false;
		if (cursos == null) {
			if (other.cursos != null)
				return false;
		} else if (!cursos.equals(other.cursos))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

//metodos
	
	public void criarUnidadeAcademica(){
		cursos = new ArrayList<Curso>();
		
		Scanner tclin = new Scanner(System.in);
		
		System.out.print("Digite o id da Unidade Academica: ");
		setId(tclin.nextLine());
		
		System.out.print("Digite o nome da Unidade Academica: ");
		setNome(tclin.nextLine());
		
		/*System.out.print("Digite a matricula do coordenador da Unidade Academica: ");*/
		
		
	}
	

	
}
