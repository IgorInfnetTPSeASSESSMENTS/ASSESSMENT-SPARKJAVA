package assessmentIgorAntonio.model.domain;

import java.util.HashSet;
import java.util.Set;

public class Cliente {
	
	private String nome;
	private String email;
	private Integer id;
	private Set<Reserva> reservas;
	
	
	public Cliente() {
		this.reservas = new HashSet<>();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\nNome do cliente: " + nome + "\nEmail: " + email  + "\nID: " + id + "\nReservas: " + this.getReservas();
	}
	
	public void incluirReserva(Reserva reserva) {
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
