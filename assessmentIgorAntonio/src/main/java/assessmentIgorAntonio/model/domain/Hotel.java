package assessmentIgorAntonio.model.domain;

public class Hotel extends Acomodacao {

    private Integer id;
    private int estrelas;
    private boolean possuiPiscina;
    private boolean possuiCafeDaManha;

    @Override
    public String toString() {
        return "Id do hotel: " + id + "Nº de estrelas: " + estrelas + "Possui piscina: " + possuiPiscina
                + "Possui café da manhã: " + possuiCafeDaManha;
    }

    public Hotel(Integer id, int estrelas, boolean possuiPiscina, boolean possuiCafeDaManha) {
        this.id = id;
        this.estrelas = estrelas;
        this.possuiPiscina = possuiPiscina;
        this.possuiCafeDaManha = possuiCafeDaManha;
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
}
