package processamento.classes;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Laboratorio extends Ambiente {

	private String equipamentoespecifico;
	private Integer qtdequipespecifico;
	
	public Laboratorio() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Laboratorio(String nome, HorarioAmbiente horario, Professor solicitador, String localizacao,
			EquipamentoGenerico equipgen, EquipamentoEletronico equipelet, String equipamentoespecifico,
			Integer qtdequipespecifico) {
		super(nome, horario, solicitador, localizacao, equipgen, equipelet);
		this.equipamentoespecifico = equipamentoespecifico;
		this.qtdequipespecifico = qtdequipespecifico;
	}
	
	
	public String getEquipamentoespecifico() {
		return equipamentoespecifico;
	}
	public Integer getQtdequipespecifico() {
		return qtdequipespecifico;
	}
	private void setEquipamentoespecifico(String equipamentoespecifico) {
		this.equipamentoespecifico = equipamentoespecifico;
	}
	private void setQtdequipespecifico(Integer qtdequipespecifico) {
		this.qtdequipespecifico = qtdequipespecifico;
	}
	
	@Override
	public String toString() {
		return "Laboratorio [equipamentoespecifico=" + equipamentoespecifico + ", qtdequipespecifico="
				+ qtdequipespecifico + ", toString()=" + super.toString() + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((equipamentoespecifico == null) ? 0 : equipamentoespecifico.hashCode());
		result = prime * result + ((qtdequipespecifico == null) ? 0 : qtdequipespecifico.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Laboratorio other = (Laboratorio) obj;
		if (equipamentoespecifico == null) {
			if (other.equipamentoespecifico != null)
				return false;
		} else if (!equipamentoespecifico.equals(other.equipamentoespecifico))
			return false;
		if (qtdequipespecifico == null) {
			if (other.qtdequipespecifico != null)
				return false;
		} else if (!qtdequipespecifico.equals(other.qtdequipespecifico))
			return false;
		return true;
	}

	public void criarLaboratorio() {
		
		Scanner tclin = new Scanner(System.in);
		
		System.out.print("Digite o equipamento especifico do ambiente: ");
		setEquipamentoespecifico(tclin.nextLine());
		
		System.out.print("Digite a quantidade deste equipamento especifico do ambiente: ");
		setQtdequipespecifico(lerInteiro(tclin) );
		
	}
	
private int lerInteiro(Scanner tclin) {
		
		while (!tclin.hasNextInt()) {
			System.out.print("");
			tclin.nextInt();
		}
		return tclin.nextInt();
	}
	
}
