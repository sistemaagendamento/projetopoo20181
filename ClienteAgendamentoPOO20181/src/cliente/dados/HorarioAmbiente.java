/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.dados;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class HorarioAmbiente {
	
	
 	private String diasemana;
 	private String horainicio;
 	private String horatermino;
	
 	public HorarioAmbiente() {
		super();
	}


 	
 	//metodos
	
 

	/**
	 * Metodo (getDiasemana), é feito para coletar informação do artributo diasemana, e retorna um String com tal informação.
 	 * @return diasemana String
	 */
	public String getDiasemana() {
		return diasemana;
	}



	public String getHorainicio() {
		return horainicio;
	}



	public String getHoratermino() {
		return horatermino;
	}


	private void setDiasemana(String diasemana) {
		this.diasemana = diasemana;
	}



	private void setHorainicio(String horainicio) {
		this.horainicio = horainicio;
	}



	private void setHoratermino(String horatermino) {
		this.horatermino = horatermino;
	}


	

	@Override
	public String toString() {
		return "HorarioAmbiente [diasemana=" + diasemana + ", horainicio=" + horainicio
				+ ", horatermino=" + horatermino + "]";
	}


	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diasemana == null) ? 0 : diasemana.hashCode());
		result = prime * result + ((horainicio == null) ? 0 : horainicio.hashCode());
		result = prime * result + ((horatermino == null) ? 0 : horatermino.hashCode());
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
		return true;
	}


	/**
	 * Metodo (criarHorarioAmbiente), é feito para preencher os dados do objeto da classe HorarioAmbiente, não precisando colocar os dados no construtor da classe
	 * @return void
	 */
	public void criarHorarioAmbiente() {
		
		Scanner tclin = new Scanner(System.in);
		
		
		
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
	private String novoTempo() {
		
		String horatmp;
		Scanner tclin = new Scanner(System.in);	
		
		Integer hora; Integer minuto;
		
		/*System.out.print("Digite a hora do ambiente: ");
		hora = lerInteiro(tclin);
		
		System.out.print("Digite o minuto do ambiente: ");
		minuto = lerInteiro(tclin);
		
		/*System.out.print("Digite o sengundo do ambiente: ");
		segundo = lerInteiro(tclin);*/
		
		//horatmp = LocalTime.parse(hora + ":" + minuto + ":" + segundo);
		String hm = new String(tclin.nextLine());
		
		//System.out.print("Digite a horario do ambiente [hh:mm]: ");
		horatmp = new String(hm);
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
