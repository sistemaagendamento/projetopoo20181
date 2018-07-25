package processamento.classes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class HorarioAmbiente {
	
	private Integer numsemana;
 	private String diasemana;
 	private LocalTime horainicio;
 	private LocalTime horatermino;
	
 	public HorarioAmbiente() {
		super();
	}


 	
 	//metodos
	
 	/**
	 * Metodo (getNumsemana), é feito para coletar informação do artributo numsemana, e retorna um Integer com tal informação.
 	 * @return numsemana Integer
	 */
	public Integer getNumsemana() {
		return numsemana;
	}


	/**
	 * Metodo (getDiasemana), é feito para coletar informação do artributo diasemana, e retorna um String com tal informação.
 	 * @return diasemana String
	 */
	public String getDiasemana() {
		return diasemana;
	}



	public LocalTime getHorainicio() {
		return horainicio;
	}



	public LocalTime getHoratermino() {
		return horatermino;
	}

	


	private void setNumsemana(Integer numsemana) {
		this.numsemana = numsemana;
	}



	private void setDiasemana(String diasemana) {
		this.diasemana = diasemana;
	}



	private void setHorainicio(LocalTime horainicio) {
		this.horainicio = horainicio;
	}



	private void setHoratermino(LocalTime horatermino) {
		this.horatermino = horatermino;
	}


	

	@Override
	public String toString() {
		return "HorarioAmbiente [numsemana=" + numsemana + ", diasemana=" + diasemana + ", horainicio=" + horainicio
				+ ", horatermino=" + horatermino + "]";
	}


	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diasemana == null) ? 0 : diasemana.hashCode());
		result = prime * result + ((horainicio == null) ? 0 : horainicio.hashCode());
		result = prime * result + ((horatermino == null) ? 0 : horatermino.hashCode());
		result = prime * result + ((numsemana == null) ? 0 : numsemana.hashCode());
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
		HorarioAmbiente other = (HorarioAmbiente) obj;
		if (diasemana == null) {
			if (other.diasemana != null)
				return false;
		} else if (!diasemana.equals(other.diasemana))
			return false;
		if (horainicio == null) {
			if (other.horainicio != null)
				return false;
		} else if (!horainicio.equals(other.horainicio))
			return false;
		if (horatermino == null) {
			if (other.horatermino != null)
				return false;
		} else if (!horatermino.equals(other.horatermino))
			return false;
		if (numsemana == null) {
			if (other.numsemana != null)
				return false;
		} else if (!numsemana.equals(other.numsemana))
			return false;
		return true;
	}


	/**
	 * Metodo (criarHorarioAmbiente), é feito para preencher os dados do objeto da classe HorarioAmbiente, não precisando colocar os dados no construtor da classe
	 * @return void
	 */
	public void criarHorarioAmbiente() {
		
		Scanner tclin = new Scanner(System.in);
		
		System.out.println("Digite o numero da semana que o ambiente sera alocado");
		setNumsemana(lerInteiro(tclin) );
		
		System.out.println("Digite o dia da semana que o ambiente sera alocado");
		setDiasemana(tclin.nextLine());
		
		System.out.println("Digite a hora inicial que o ambiente sera alocado");
		setHorainicio(novoTempo() );
		
		System.out.println("Digite a hora final do ambiente alocado");
		setHoratermino(novoTempo() );
		
	}
	
	
	/**
	 * Metodo (novoTempo), é feito para preencher atributos do tipo LocalTime da classe HorarioAmbiente, não precisando colocar os dados no construtor da classe
	 * @return void
	 */
	private LocalTime novoTempo() {
		
		LocalTime horatmp;
		Scanner tclin = new Scanner(System.in);	
		
		Integer hora; Integer minuto; 
		
		System.out.print("Digite a hora do ambiente: ");
		hora = lerInteiro(tclin);
		
		System.out.print("Digite o minuto do ambiente: ");
		minuto = lerInteiro(tclin);
		
		horatmp = LocalTime.parse(hora + ":" + minuto + ":00");
		
		return horatmp;
	}
	
	
	/**
	 * Metodo privado (lerInteiro), é feito para garantir a leitura de um inteiro e retorna um Integer com tal informação.
 	 * @return inteiro Integer
	 */
	private int lerInteiro(Scanner tclin) {
		
		while (!tclin.hasNextInt()) {
			System.out.print("");
			tclin.nextInt();
		}
		return tclin.nextInt();
	}
	
		
		
 	
}//fim da classe HorarioAmbiente