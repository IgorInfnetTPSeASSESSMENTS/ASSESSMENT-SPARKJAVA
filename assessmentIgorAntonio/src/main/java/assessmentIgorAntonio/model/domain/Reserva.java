package assessmentIgorAntonio.model.domain;

import java.util.Objects;

import assessmentIgorAntonio.model.service.HotelService;

public class Reserva {

	private Integer idDoHotelReservado;
	private Acomodacao acomodacao;
    private Quarto quarto;
    private String dataInicio;
    private String dataFim;
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	try {
    	return "\nHotel: " + "ID do hotel: " + HotelService.obterHotelPeloId(idDoHotelReservado).getId() +
    			"\nNúmero de estrelas: " + HotelService.obterHotelPeloId(idDoHotelReservado).getEstrelas() + 
    			"\nPossui piscina: " + HotelService.obterHotelPeloId(idDoHotelReservado).isPossuiPiscina() +
    			"\nPossui cafe da manha: " + HotelService.obterHotelPeloId(idDoHotelReservado).isPossuiCafeDaManha() +
    			"\nAcomodacao selecionada: " + "Andar número: " + acomodacao.getId() + 
    			"\nQuarto: " + quarto + "\nData Início: " + dataInicio + " - Data Final: " + dataFim;
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return "Esse hotel não existe!";
    }
    
    public Reserva(Integer hotel, Acomodacao acomodacao, Quarto quarto, String dataInicio, String dataFim) {
    	this.idDoHotelReservado = hotel;
    	this.acomodacao = acomodacao;
    	this.quarto = quarto;
    	this.dataInicio = dataInicio;
    	this.dataFim = dataFim;
    }
  
	public Acomodacao getAcomodacao() {
		return acomodacao;
	}
	public void setAcomodacao(Acomodacao acomodacao) {
		this.acomodacao = acomodacao;
	}
	public Quarto getQuarto() {
		return quarto;
	}
	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public Integer getHotelReservado() {
		return idDoHotelReservado;
	}

	public void setHotelReservado(Integer hotelReservado) {
		this.idDoHotelReservado = hotelReservado;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return Objects.equals(quarto, reserva.quarto) &&
                Objects.equals(dataInicio, reserva.dataInicio) &&
                Objects.equals(dataFim, reserva.dataFim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quarto, dataInicio, dataFim);
    }
	
}
