package assessmentIgorAntonio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import assessmentIgorAntonio.model.domain.Acomodacao;
import assessmentIgorAntonio.model.domain.Hotel;

import java.util.HashSet;
import java.util.Set;

public class HotelTest {

    private Hotel hotel;
    
    @Before
    public void setUp() {
        hotel = new Hotel(1, 5, true, true, new HashSet<>());
    }
    
    @Test
    public void testAdicionarAcomodacao() {
        Acomodacao acomodacao = new Acomodacao(101);
        
        hotel.adicionarAcomodacao(acomodacao);
        
        Set<Acomodacao> acomodacoes = hotel.getAcomodacoes();
        assertTrue(acomodacoes.contains(acomodacao));
    }
    
    @Test
    public void testExcluirAcomodacaoPeloId() {
        Acomodacao acomodacao = new Acomodacao(101);
        hotel.adicionarAcomodacao(acomodacao);
        
        hotel.excluirAcomodacaoPeloId(101);
        
        Set<Acomodacao> acomodacoes = hotel.getAcomodacoes();
        assertFalse(acomodacoes.contains(acomodacao));
    }
    
    @Test
    public void testObterAcomodacaoPeloId() {
        Acomodacao acomodacao = new Acomodacao(101);
        hotel.adicionarAcomodacao(acomodacao);
        
        Acomodacao acomodacaoObtida = hotel.obterAcomodacaoPeloId(101);
        
        assertEquals(acomodacao, acomodacaoObtida);
    }
    
    @Test
    public void testGetEstrelas() {
        assertEquals(5, hotel.getEstrelas());
    }
    
    @Test
    public void testSetEstrelas() {
        hotel.setEstrelas(4);
        
        assertEquals(4, hotel.getEstrelas());
    }
    
    @Test
    public void testIsPossuiPiscina() {
        assertTrue(hotel.isPossuiPiscina());
    }
    
    @Test
    public void testSetPossuiPiscina() {
        hotel.setPossuiPiscina(false);
        
        assertFalse(hotel.isPossuiPiscina());
    }
    
    @Test
    public void testIsPossuiCafeDaManha() {
        assertTrue(hotel.isPossuiCafeDaManha());
    }
    
    @Test
    public void testSetPossuiCafeDaManha() {
        hotel.setPossuiCafeDaManha(false);
        
        assertFalse(hotel.isPossuiCafeDaManha());
    }
    
    @Test
    public void testGetId() {
        assertEquals(Integer.valueOf(1), hotel.getId());
    }
    
    @Test
    public void testSetId() {
        hotel.setId(2);
        
        assertEquals(Integer.valueOf(2), hotel.getId());
    }
    
    @Test
    public void testGetAcomodacoes() {
        Set<Acomodacao> acomodacoes = new HashSet<>();
        acomodacoes.add(new Acomodacao(101));
        
        hotel.setAcomodacoes(acomodacoes);
        
        assertEquals(acomodacoes, hotel.getAcomodacoes());
    }
    
    @Test
    public void testSetAcomodacoes() {
        Set<Acomodacao> acomodacoes = new HashSet<>();
        acomodacoes.add(new Acomodacao(101));
        
        hotel.setAcomodacoes(acomodacoes);
        
        assertEquals(acomodacoes, hotel.getAcomodacoes());
    }
}

