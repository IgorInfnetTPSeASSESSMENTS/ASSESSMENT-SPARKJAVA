package assessmentIgorAntonio.model.domain;

public class Quarto {
	
	private int idDoQuarto;
	private boolean disponivel;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ID do quarto: " + idDoQuarto;
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
	
	
}
