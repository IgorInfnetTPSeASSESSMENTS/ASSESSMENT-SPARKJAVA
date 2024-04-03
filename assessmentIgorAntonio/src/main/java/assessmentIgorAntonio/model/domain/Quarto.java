package assessmentIgorAntonio.model.domain;

import java.util.Objects;

public class Quarto {
	
	private int idDoQuarto;
	private boolean disponivel;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\nID do quarto: " + idDoQuarto + "\nDiponibilidade: " + disponivel;
	}
	
	public boolean isDisponivel() {
		return disponivel;
	}
	
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public int getIdDoQuarto() {
		return idDoQuarto;
	}

	public void setIdDoQuarto(int idDoQuarto) {
		this.idDoQuarto = idDoQuarto;
	}
	
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    Quarto quarto = (Quarto) o;
	    return idDoQuarto == quarto.idDoQuarto;
	}

	@Override
	public int hashCode() {
	    return Objects.hash(idDoQuarto);
	}

	
}
