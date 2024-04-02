package assessmentIgorAntonio.model.domain;

import java.util.HashSet;
import java.util.Set;

public class Acomodacao {

	private Integer idDaAcomodacao;
	private Set<Quarto> quartos;
	
	public Acomodacao() {
		this.quartos = new HashSet<>();
	}
	
	public void adicionarQuarto(Quarto quarto) {
		quartos.add(quarto);
	}

	public Integer getId() {
		return idDaAcomodacao;
	}

	public void setId(Integer id) {
		this.idDaAcomodacao = id;
	}

	public Set<Quarto> getQuartos() {
		return quartos;
	}

	public void setQuartos(Set<Quarto> quartos) {
		this.quartos = quartos;
	}
	
	
}
