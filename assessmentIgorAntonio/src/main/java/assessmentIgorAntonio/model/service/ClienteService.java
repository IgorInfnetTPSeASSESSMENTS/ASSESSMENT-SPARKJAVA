package assessmentIgorAntonio.model.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import assessmentIgorAntonio.model.domain.Cliente;
import assessmentIgorAntonio.model.domain.Reserva;

public class ClienteService {

    private static Set<Cliente> clientes = new HashSet<>();

    public static void criarCliente(Cliente cliente) {
        try {
            clientes.add(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean excluirCliente(int id) {
        try {
            Iterator<Cliente> iterator = clientes.iterator();
            while (iterator.hasNext()) {
                Cliente cliente = iterator.next();
                if (cliente.getId() == id) {
                    iterator.remove();
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Cliente obterClientePeloId(int id) {
        try {
            for (Cliente cliente : clientes) {
                if (cliente.getId() == id) {
                    return cliente;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Set<Cliente> obterListaDeClientes() {
        return clientes;
    }
    
    
    public static boolean existeClienteComEmail(String email) {
        for (Cliente cliente : clientes) {
            if (cliente.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
}
