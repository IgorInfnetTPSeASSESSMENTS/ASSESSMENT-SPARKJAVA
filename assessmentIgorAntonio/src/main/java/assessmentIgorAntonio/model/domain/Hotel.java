package assessmentIgorAntonio.model.domain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Hotel extends Acomodacao {

    private Integer id;
    private int estrelas;
    private boolean possuiPiscina;
    private boolean possuiCafeDaManha;
    private Set<Acomodacao> acomodacoes;

    @Override
    public String toString() {
        return "\nID do hotel: " + id + "\nNúmero de estrelas: " + estrelas + "\nPossui piscina: " + possuiPiscina
                + "\nPossui cafe da manha: " + possuiCafeDaManha + "\nAcomodações: " + 
acomodacoes + "\nQuartos: " + this.getQuartos();
    }
    
    public Hotel(Integer id, int estrelas, boolean possuiPiscina, boolean possuiCafeDaManha, HashSet<Acomodacao> acomodacoes) {
        this.id = id;
        this.estrelas = estrelas;
        this.possuiPiscina = possuiPiscina;
        this.possuiCafeDaManha = possuiCafeDaManha;
        this.acomodacoes = acomodacoes;
    }
    
    public void adicionarAcomodacao(Acomodacao acomodacao) {
    	acomodacoes.add(acomodacao);
    }
    
    public void excluirAcomodacaoPeloId(int idDaAcomodacao) {
        Iterator<Acomodacao> iterator = acomodacoes.iterator();
        while (iterator.hasNext()) {
            Acomodacao acomodacao = iterator.next();
            if (acomodacao.getId().equals(idDaAcomodacao)) {
                iterator.remove();
                return;
            }
        }
    }
    
    public Acomodacao obterAcomodacaoPeloId(int idDaAcomodacao) {
        for (Acomodacao acomodacao : acomodacoes) {
            if (acomodacao.getId().equals(idDaAcomodacao)) {
                return acomodacao;
            }
        }
        return null;
    }


    public int getEstrelas() {
        return estrelas;
    }

    public void setEstrelas(int estrelas) {
        this.estrelas = estrelas;
    }

    public boolean isPossuiPiscina() {
        return possuiPiscina;
    }

    public void setPossuiPiscina(boolean possuiPiscina) {
        this.possuiPiscina = possuiPiscina;
    }

    public boolean isPossuiCafeDaManha() {
        return possuiCafeDaManha;
    }

    public void setPossuiCafeDaManha(boolean possuiCafeDaManha) {
        this.possuiCafeDaManha = possuiCafeDaManha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public Set<Acomodacao> getAcomodacoes() {
		return acomodacoes;
	}

	public void setAcomodacoes(Set<Acomodacao> acomodacoes) {
		this.acomodacoes = acomodacoes;
	}
   
    
}
