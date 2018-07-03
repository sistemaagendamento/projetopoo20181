package processamento.classes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;
import processamento.colecoes.*;

public class Ambiente {

	private String nome;
	private HorarioAmbiente horario;
	private Professor solicitador;
	private String localizacao;
	private EquipamentoGenerico equipgen;
	private EquipamentoEletronico equipelet;
	
	//constutor
	public Ambiente() {
		super();
	}

	public Ambiente(String nome, HorarioAmbiente horario, Professor solicitador, String localizacao,
			EquipamentoGenerico equipgen, EquipamentoEletronico equipelet) {
		super();
		this.nome = nome;
		this.horario = horario;
		this.solicitador = solicitador;
		this.localizacao = localizacao;
		this.equipgen = equipgen;
		this.equipelet = equipelet;
	}

	
	public String getNome() {
		return nome;
	}

	public HorarioAmbiente getHorario() {
		return horario;
	}

	public Professor getSolicitador() {
		return solicitador;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public EquipamentoGenerico getEquipgen() {
		return equipgen;
	}

	public EquipamentoEletronico getEquipelet() {
		return equipelet;
	}

	
	private void setNome(String nome) {
		this.nome = nome;
	}

	private void setHorario(HorarioAmbiente horario) {
		this.horario = horario;
	}

	public void setSolicitador(Professor solicitador) {
		this.solicitador = solicitador;
	}

	private void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	private void setEquipgen(EquipamentoGenerico equipgen) {
		this.equipgen = equipgen;
	}

	private void setEquipelet(EquipamentoEletronico equipelet) {
		this.equipelet = equipelet;
	}

	//toString
	@Override
	public String toString() {
		return "Ambiente [nome=" + nome + ", horario=" + horario + ", solicitador=" + solicitador + ", localizacao="
				+ localizacao + ", equipgen=" + equipgen + ", equipelet=" + equipelet + "]";
	}

	
	//hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((equipelet == null) ? 0 : equipelet.hashCode());
		result = prime * result + ((equipgen == null) ? 0 : equipgen.hashCode());
		result = prime * result + ((horario == null) ? 0 : horario.hashCode());
		result = prime * result + ((localizacao == null) ? 0 : localizacao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((solicitador == null) ? 0 : solicitador.hashCode());
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
		Ambiente other = (Ambiente) obj;
		if (equipelet == null) {
			if (other.equipelet != null)
				return false;
		} else if (!equipelet.equals(other.equipelet))
			return false;
		if (equipgen == null) {
			if (other.equipgen != null)
				return false;
		} else if (!equipgen.equals(other.equipgen))
			return false;
		if (horario == null) {
			if (other.horario != null)
				return false;
		} else if (!horario.equals(other.horario))
			return false;
		if (localizacao == null) {
			if (other.localizacao != null)
				return false;
		} else if (!localizacao.equals(other.localizacao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (solicitador == null) {
			if (other.solicitador != null)
				return false;
		} else if (!solicitador.equals(other.solicitador))
			return false;
		return true;
	}
	
	
	//metodos
	
	public void criarAmbiente() {
		
		Scanner tclin = new Scanner(System.in);
		
		EquipamentoGenerico equipgentmp = new EquipamentoGenerico();
		EquipamentoEletronico equipelettmp = new EquipamentoEletronico();
		HorarioAmbiente horariotmp = new HorarioAmbiente();		
				
		System.out.print("Digite o nome do ambiente: ");
		setNome(tclin.nextLine() );
		
		System.out.print("Digite o horario do ambiente: ");
		horariotmp.criarHorarioAmbiente();
		setHorario(horariotmp);
		
		System.out.print("Digite a matricula do professor solicitador do ambiente: ");
		
		
		System.out.print("Digite o lugar do ambiente: ");
		setLocalizacao(tclin.nextLine() );
		
		System.out.print("Digite os componetes genericos do ambiente: ");
		equipgentmp.criarEquipamentoGenerico();
		setEquipgen(equipgentmp);
		
		System.out.print("Digite os componetes eletronicos do ambiente: ");
		equipelettmp.criarEquipamentoEletronico();
		setEquipelet(equipelettmp);
		
	}
		
	
	
}//fim da classe Aplicativo
