package assessmentIgorAntonio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import assessmentIgorAntonio.model.domain.Cliente;
import assessmentIgorAntonio.model.domain.Reserva;

import java.util.HashSet;
import java.util.Set;

public class ClienteTest {

    private Cliente cliente;
    
    @Before
    public void setUp() {
        cliente = new Cliente();
    }
    
    @Test
    public void testIncluirReserva() {
        Reserva reserva = new Reserva();
        
        cliente.incluirReserva(reserva);
        
        Set<Reserva> reservas = cliente.getReservas();
        assertTrue(reservas.contains(reserva));
    }
    
    @Test
    public void testGetId() {
        cliente.setId(1);
        
        assertEquals(Integer.valueOf(1), cliente.getId());
    }
    
    @Test
    public void testGetReservas() {
        Set<Reserva> reservas = new HashSet<>();
        reservas.add(new Reserva());
        
        cliente.setReservas(reservas);
        
        assertEquals(reservas, cliente.getReservas());
    }
    
    @Test
    public void testSetReservas() {
        Set<Reserva> reservas = new HashSet<>();
        reservas.add(new Reserva());
        
        cliente.setReservas(reservas);
        
        assertEquals(reservas, cliente.getReservas());
    }
    
    @Test
    public void testGetNome() {
        cliente.setNome("João");
        
        assertEquals("João", cliente.getNome());
    }
    
    @Test
    public void testSetNome() {
        cliente.setNome("Maria");
        
        assertEquals("Maria", cliente.getNome());
    }
    
    @Test
    public void testGetEmail() {
        cliente.setEmail("joao@example.com");
        
        assertEquals("joao@example.com", cliente.getEmail());
    }
    
    @Test
    public void testSetEmail() {
        cliente.setEmail("maria@example.com");
        
        assertEquals("maria@example.com", cliente.getEmail());
    }
}
