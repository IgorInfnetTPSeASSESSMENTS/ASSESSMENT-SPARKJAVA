package assessmentIgorAntonio.model.domain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Acomodacao {

	private Integer andarDaAcomodacao;
	private Set<Quarto> quartos;
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Andar número " + andarDaAcomodacao + "\n Quartos nesse andar: " + quartos;
	}
	
	public Acomodacao() {
		
	}
	
	public Acomodacao(Integer andarDaAcomodacao) {
		this.andarDaAcomodacao = andarDaAcomodacao;
		this.quartos = new HashSet<>();
	}
	
	public void adicionarQuarto(Quarto quarto) {
		quartos.add(quarto);
	}

	public Quarto getQuartoPeloId(int idDoQuarto) {
	    for (Quarto quarto : quartos) {
	        if (quarto.getIdDoQuarto() == idDoQuarto) {
	            return quarto; 
	        }
	    }
	    return null; 
	}
	
	public void removerQuartoPeloId(int idDoQuarto) {
        Iterator<Quarto> iterator = quartos.iterator();
        while (iterator.hasNext()) {
            Quarto quarto = iterator.next();
            if (quarto.getIdDoQuarto() == idDoQuarto) {
                iterator.remove();  
                return; 
            }
        }
    }
	
	public Integer getId() {
		return andarDaAcomodacao;
	}

	public void setId(Integer id) {
		this.andarDaAcomodacao = id;
	}

	public Set<Quarto> getQuartos() {
		return quartos;
	}

	public void setQuartos(Set<Quarto> quartos) {
		this.quartos = quartos;
	}
	
	
}
