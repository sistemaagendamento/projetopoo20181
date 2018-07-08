package processamento.classes;

import java.util.Scanner;

public class Ambiente {

	private String nome;
	private HorarioAmbiente horario;
	private Professor solicitador;
	private String localizacao;
	private EquipamentoGenerico equipgen;
	private EquipamentoEletronico equipelet;
	
	//constutor
	/**
	 * Este construtor vazio da classe Ambiente é utilizado para criar um objeto da classe Ambiente, recebendo nada como parametro.
	 */
	public Ambiente() {
		super();
	}

	/**
	 * Este construtor não vazio da classe Ambiente é utilizado para criar um objeto da classe Ambiente, recebendo dados como parametro.
	 * 
	 * @param nome String - Informa o nome do Ambiente.
	 * @param horario HorarioAmbiente - Objeto que informa a hora de alocação daquele Ambiente.
	 * @param solicitador Professor - Objeto que informa o professor que solicitou tal Ambiente.
	 * @param localizacao String - Informa o lugar físico do Ambiente
	 * @param equipgen EquipamentoGenerico -  Objeto que informa as quantidades de cada equipamento genérico padrão
	 * @param equipelet EquipamentoEletronico - Objeto que informa as quantidades de cada equipamento eletrônico padrão
	 * 
	 */
	
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

	/**
	 * Metodo (getnome), é feito para coletar informação do artributo nome, e retorna uma String com tal informação.
 	 * @return nome String - Nome do ambiente
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo (getHorario), é feito para coletar informação do artributo horario, e retorna um HorarioAmbiente com tal informação.
 	 * @return horario HorarioAmbiente - Horario alocado para aquele ambiente
	 */
	public HorarioAmbiente getHorario() {
		return horario;
	}

	/**
	 * Metodo (getSolicitador), é feito para coletar informação do artributo solicitador, e retorna um Professor com tal informação.
 	 * @return solicitador Professor - Professor que alocou o tal ambiente
	 */
	public Professor getSolicitador() {
		return solicitador;
	}

	/**
	 * Metodo (getLocalizacao), é feito para coletar informação do artributo localizacao, e retorna um String com tal informação.
 	 * @return localizacao String - Lugar fisico do ambiente
	 */
	public String getLocalizacao() {
		return localizacao;
	}

	/**
	 * Metodo (getEquipgen), é feito para coletar informação do artributo equipgen, e retorna um EquipamentoGenerico com tal informação.
 	 * @return equipgen EquipamentoGenerico - Quantidades de objetos genericos a um ambiente
	 */
	public EquipamentoGenerico getEquipgen() {
		return equipgen;
	}

	/**
	 * Metodo (getEquipelet), é feito para coletar informação do artributo equipelet, e retorna um EquipamentoEletronico com tal informação.
 	 * @return equipelet EquipamentoEletronico - Quantidades de objetos eletronicos a um ambiente
	 */
	public EquipamentoEletronico getEquipelet() {
		return equipelet;
	}

	/**
	 * Metodo (setNome), é feito para adicionar informação ao artributo nome, do tipo String e retorna void.
 	 * @param nome String - Nome do Ambiente a ser inserido 
	 * @return void
	 */
	private void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Metodo (setHorario), é feito para adicionar informação ao artributo horario, do tipo HorarioAmbiente e retorna void.
 	 * @param horario HorarioAmbiente - Horario alocado do Ambiente a ser inserido 
	 * @return void
	 */
	private void setHorario(HorarioAmbiente horario) {
		this.horario = horario;
	}

	/**
	 * Metodo (setSolicitador), é feito para adicionar informação ao artributo solicitador, do tipo Professor e retorna void.
 	 * @param solicitador Professor - Indica o professor que solicitou o ambiente
	 * @return void
	 */
	public void setSolicitador(Professor solicitador) {
		this.solicitador = solicitador;
	}

	/**
	 * Metodo (setLocalizacao), é feito para adicionar informação ao artributo localizacao, do tipo String e retorna void.
 	 * @param localizacao String - Lugar fisico do Ambiente a ser inserido 
	 * @return void
	 */
	private void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	/**
	 * Metodo (setEquipgen), é feito para adicionar informação ao artributo equipgen, do tipo EquipamentoGenerico e retorna void.
 	 * @param equipgen EquipamentoGenerico - Define as quantidades de equipamentos genericos do Ambiente
	 * @return void
	 */
	private void setEquipgen(EquipamentoGenerico equipgen) {
		this.equipgen = equipgen;
	}

	/**
	 * Metodo (setEquipelet), é feito para adicionar informação ao artributo equipelet, do tipo EquipamentoEletronico e retorna void.
 	 * @param equipgen EquipamentoEletronico - Define as quantidades de equipamentos eletronicos do Ambiente
	 * @return void
	 */
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
	
	/**
	 * Metodo (criarAmbiente), é feito para preencher os dados do objeto da classe Ambiente, não precisando colocar os dados no construtor da classe
	 * @return void
	 */
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
		
				
		System.out.print("Digite o lugar do ambiente: ");
		setLocalizacao(tclin.nextLine() );
		
		System.out.print("Digite os componetes genericos do ambiente: ");
		equipgentmp.criarEquipamentoGenerico();
		setEquipgen(equipgentmp);
		
		System.out.print("Digite os componetes eletronicos do ambiente: ");
		equipelettmp.criarEquipamentoEletronico();
		setEquipelet(equipelettmp);
		
		/*System.out.print("Digite a matricula do professor solicitador do ambiente: ");*/
		
	}
		
	
	
}//fim da classe Aplicativo
