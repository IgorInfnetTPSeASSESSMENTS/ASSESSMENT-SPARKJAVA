package assessmentIgorAntonio.controller;

import java.util.Set;

import com.google.gson.Gson;

import assessmentIgorAntonio.model.domain.Cliente;
import assessmentIgorAntonio.model.domain.Reserva;
import assessmentIgorAntonio.model.service.ClienteService;
import assessmentIgorAntonio.model.service.HotelService;
import spark.Route;

public class ClienteController {

    private static Gson gsonDoCliente = new Gson();

    public static Route obterClientes = (req, res) -> {
        try {
            Set<Cliente> clientes = ClienteService.obterListaDeClientes();
            return clientes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    };

    public static Route criarCliente = (req, res) -> {
        try {
            Cliente novoCliente = gsonDoCliente.fromJson(req.body(), Cliente.class);
            ClienteService.criarCliente(novoCliente);
            return "Cliente criado com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    };

    public static Route excluirClientePeloId = (req, res) -> {
        try {
            Integer index = Integer.valueOf(req.params("id"));
            Cliente clienteDeletado = ClienteService.obterClientePeloId(index);
            ClienteService.excluirCliente(index);
            return "Cliente deletado com sucesso: " + clienteDeletado;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    };

    public static Route obterClientePeloId = (req, res) -> {
        try {
            Integer index = Integer.valueOf(req.params("id"));
            Cliente clienteRecuperado = ClienteService.obterClientePeloId(index);
            return "Cliente recuperado com sucesso: " + clienteRecuperado;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    };
    
    public static Route realizarReserva = (req, res) -> {
    	try {
    		Integer index = Integer.valueOf(req.params("id"));
            Reserva novaReserva = gsonDoCliente.fromJson(req.body(), Reserva.class);
            
            if(HotelService.obterHotelPeloId(novaReserva.getHotelReservado()) != null) {
            	ClienteService.realizarReserva(index, novaReserva);
            } else {
            	return "Esse hotel não existe!";
            }
            
            return "Reserva realizada com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    };
}
