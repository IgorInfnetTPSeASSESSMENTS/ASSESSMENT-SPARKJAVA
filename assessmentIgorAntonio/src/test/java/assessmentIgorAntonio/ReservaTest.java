package assessmentIgorAntonio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import assessmentIgorAntonio.model.domain.Acomodacao;
import assessmentIgorAntonio.model.domain.Quarto;
import assessmentIgorAntonio.model.domain.Reserva;


public class ReservaTest {

    private Reserva reserva;
 

    @Before
    public void setUp() {
        Acomodacao acomodacao = new Acomodacao(101);
        Quarto quarto = new Quarto(1);
        reserva = new Reserva(1, acomodacao, quarto, "2024-04-01", "2024-04-03");


    }

    @Test
    public void testGetAcomodacao() {
        Acomodacao acomodacao = reserva.getAcomodacao();
        assertNotNull(acomodacao);
        assertEquals(Integer.valueOf(101), acomodacao.getId());
    }

    @Test
    public void testSetAcomodacao() {
        Acomodacao acomodacao = new Acomodacao(102);
        reserva.setAcomodacao(acomodacao);
        assertEquals(acomodacao, reserva.getAcomodacao());
    }

    @Test
    public void testGetQuarto() {
        Quarto quarto = reserva.getQuarto();
        assertNotNull(quarto);
        assertEquals(1, quarto.getIdDoQuarto());
    }

    @Test
    public void testSetQuarto() {
        Quarto quarto = new Quarto(2);
        reserva.setQuarto(quarto);
        assertEquals(quarto, reserva.getQuarto());
    }

    @Test
    public void testGetDataInicio() {
        assertEquals("2024-04-01", reserva.getDataInicio());
    }

    @Test
    public void testSetDataInicio() {
        reserva.setDataInicio("2024-04-02");
        assertEquals("2024-04-02", reserva.getDataInicio());
    }

    @Test
    public void testGetDataFim() {
        assertEquals("2024-04-03", reserva.getDataFim());
    }

    @Test
    public void testSetDataFim() {
        reserva.setDataFim("2024-04-04");
        assertEquals("2024-04-04", reserva.getDataFim());
    }

    @Test
    public void testGetHotelReservado() {
        assertEquals(Integer.valueOf(1), reserva.getHotelReservado());
    }

    @Test
    public void testSetHotelReservado() {
        reserva.setHotelReservado(2);
        assertEquals(Integer.valueOf(2), reserva.getHotelReservado());
    }
}
