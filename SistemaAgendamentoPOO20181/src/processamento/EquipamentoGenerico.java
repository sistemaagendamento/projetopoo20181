package processamento;

public class EquipamentoGenerico {

	private Integer mesas;
	private Integer cadeiras;
	private Integer lixeiras;
	private Integer quadros;
	
	//Construtores
	
	public EquipamentoGenerico(Integer mesas, Integer cadeiras, Integer lixeiras, Integer quadros) {
		super();
		this.mesas = mesas;
		this.cadeiras = cadeiras;
		this.lixeiras = lixeiras;
		this.quadros = quadros;
	}

	public EquipamentoGenerico() {
		super();
	}

	//Getters and Setters
	
	public Integer getMesas() {
		return mesas;
	}

	public Integer getCadeiras() {
		return cadeiras;
	}

	public Integer getLixeiras() {
		return lixeiras;
	}

	public Integer getQuadros() {
		return quadros;
	}

	public void setMesas(Integer mesas) {
		this.mesas = mesas;
	}

	public void setCadeiras(Integer cadeiras) {
		this.cadeiras = cadeiras;
	}

	public void setLixeiras(Integer lixeiras) {
		this.lixeiras = lixeiras;
	}

	public void setQuadros(Integer quadros) {
		this.quadros = quadros;
	}

	//toString
	
	@Override
	public String toString() {
		return "EquipamentoGenerico [mesas=" + mesas + ", cadeiras=" + cadeiras + ", lixeiras=" + lixeiras
				+ ", quadros=" + quadros + "]";
	}

	//hashCode
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cadeiras == null) ? 0 : cadeiras.hashCode());
		result = prime * result + ((lixeiras == null) ? 0 : lixeiras.hashCode());
		result = prime * result + ((mesas == null) ? 0 : mesas.hashCode());
		result = prime * result + ((quadros == null) ? 0 : quadros.hashCode());
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
		EquipamentoGenerico other = (EquipamentoGenerico) obj;
		if (cadeiras == null) {
			if (other.cadeiras != null)
				return false;
		} else if (!cadeiras.equals(other.cadeiras))
			return false;
		if (lixeiras == null) {
			if (other.lixeiras != null)
				return false;
		} else if (!lixeiras.equals(other.lixeiras))
			return false;
		if (mesas == null) {
			if (other.mesas != null)
				return false;
		} else if (!mesas.equals(other.mesas))
			return false;
		if (quadros == null) {
			if (other.quadros != null)
				return false;
		} else if (!quadros.equals(other.quadros))
			return false;
		return true;
	}
	
	//Metodos
	
	
	
}
