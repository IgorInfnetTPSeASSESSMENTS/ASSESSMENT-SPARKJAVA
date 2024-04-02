package assessmentIgorAntonio.model.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Cliente {
	
	private Integer id;
	private Set<Reserva> reservas;
	
	
	public Cliente() {
		this.reservas = new HashSet<>();
	}
	
	public void fazerReserva(Acomodacao acomodacao, Quarto quarto, LocalDate dataInicio, LocalDate dataFim) {
        Reserva reserva = new Reserva(acomodacao, quarto, dataInicio, dataFim);
        reservas.add(reserva);
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(Set<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	
}
