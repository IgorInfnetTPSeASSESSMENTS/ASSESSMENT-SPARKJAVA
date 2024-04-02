package assessmentIgorAntonio.model.domain;

import java.time.LocalDate;

public class Reserva {

	private Integer id;
	private Acomodacao acomodacao;
    private Quarto quarto;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    
    public Reserva(Acomodacao acomodacao, Quarto quarto, LocalDate dataInicio, LocalDate dataFim) {
        this.acomodacao = acomodacao;
        this.quarto = quarto;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}
    
    
    
}
