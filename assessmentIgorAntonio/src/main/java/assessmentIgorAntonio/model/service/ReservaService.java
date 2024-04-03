package assessmentIgorAntonio.model.service;

import assessmentIgorAntonio.model.domain.Cliente;
import assessmentIgorAntonio.model.domain.Reserva;

public class ReservaService {

	
	 public static void realizarReserva(int idDoCliente, Reserva reserva) {
	        try {
	            Cliente cliente = ClienteService.obterClientePeloId(idDoCliente);
	           
	            cliente.incluirReserva(reserva);
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.err.println("Erro ao realizar reserva para o cliente com ID: " + idDoCliente);
	        }
	        
	    }
}
