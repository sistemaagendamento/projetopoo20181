package processamento;

public class EquipamentoEletronico {

	private Integer computadores;
	private Integer arcondicionado;
	private Integer projetores;
	private Integer sistemadesom;
	
	
	//Construtores
	public EquipamentoEletronico(Integer computadores, Integer arcondicionado, Integer projetores,
			Integer sistemadesom) {
		super();
		this.computadores = computadores;
		this.arcondicionado = arcondicionado;
		this.projetores = projetores;
		this.sistemadesom = sistemadesom;
	}

	public EquipamentoEletronico() {
		super();
	}

	//Getters and Setters
	public Integer getComputadores() {
		return computadores;
	}

	public Integer getArcondicionado() {
		return arcondicionado;
	}

	public Integer getProjetores() {
		return projetores;
	}

	public Integer getSistemadesom() {
		return sistemadesom;
	}

	public void setComputadores(Integer computadores) {
		this.computadores = computadores;
	}

	public void setArcondicionado(Integer arcondicionado) {
		this.arcondicionado = arcondicionado;
	}

	public void setProjetores(Integer projetores) {
		this.projetores = projetores;
	}

	public void setSistemadesom(Integer sistemadesom) {
		this.sistemadesom = sistemadesom;
	}

	//toString
	@Override
	public String toString() {
		return "EquipamentoEletronico [computadores=" + computadores + ", arcondicionado=" + arcondicionado
				+ ", projetores=" + projetores + ", sistemadesom=" + sistemadesom + "]";
	}

	//hash code
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arcondicionado == null) ? 0 : arcondicionado.hashCode());
		result = prime * result + ((computadores == null) ? 0 : computadores.hashCode());
		result = prime * result + ((projetores == null) ? 0 : projetores.hashCode());
		result = prime * result + ((sistemadesom == null) ? 0 : sistemadesom.hashCode());
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
		EquipamentoEletronico other = (EquipamentoEletronico) obj;
		if (arcondicionado == null) {
			if (other.arcondicionado != null)
				return false;
		} else if (!arcondicionado.equals(other.arcondicionado))
			return false;
		if (computadores == null) {
			if (other.computadores != null)
				return false;
		} else if (!computadores.equals(other.computadores))
			return false;
		if (projetores == null) {
			if (other.projetores != null)
				return false;
		} else if (!projetores.equals(other.projetores))
			return false;
		if (sistemadesom == null) {
			if (other.sistemadesom != null)
				return false;
		} else if (!sistemadesom.equals(other.sistemadesom))
			return false;
		return true;
	}
	
	

	
}
