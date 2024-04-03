package assessmentIgorAntonio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import assessmentIgorAntonio.model.domain.Acomodacao;
import assessmentIgorAntonio.model.domain.Quarto;

import java.util.Set;

public class AcomodacaoTest {

    private Acomodacao acomodacao;
    
    @Before
    public void setUp() {
        acomodacao = new Acomodacao(1);
    }
    
    @Test
    public void testAdicionarQuarto() {
        Quarto quarto = new Quarto(101);
        
        acomodacao.adicionarQuarto(quarto);
        
        Set<Quarto> quartos = acomodacao.getQuartos();
        assertTrue(quartos.contains(quarto));
    }
    
    @Test
    public void testRemoverQuarto() {
        Quarto quarto = new Quarto(101);
        acomodacao.adicionarQuarto(quarto);
        
        acomodacao.removerQuartoPeloId(101);
        
        Set<Quarto> quartos = acomodacao.getQuartos();
        assertFalse(quartos.contains(quarto));
    }
    
    @Test
    public void testGetQuartoPeloId() {
        Quarto quarto = new Quarto(101);
        acomodacao.adicionarQuarto(quarto);
        
        Quarto quartoRecuperado = acomodacao.getQuartoPeloId(101);
        
        assertEquals(quarto, quartoRecuperado);
    }
    
    @Test
    public void testGetQuartoPeloId_NaoEncontrado() {
        Quarto quarto = new Quarto(101);
        acomodacao.adicionarQuarto(quarto);
        
        Quarto quartoRecuperado = acomodacao.getQuartoPeloId(102);
        
        assertNull(quartoRecuperado);
    }
    
    @Test
    public void testEquals() {
        Acomodacao outraAcomodacao = new Acomodacao(1);
        
        assertTrue(acomodacao.equals(outraAcomodacao));
    }
    
    @Test
    public void testNotEquals() {
        Acomodacao outraAcomodacao = new Acomodacao(2);
        
        assertFalse(acomodacao.equals(outraAcomodacao));
    }
    
    @Test
    public void testHashCode() {
        Acomodacao outraAcomodacao = new Acomodacao(1);
        
        assertEquals(acomodacao.hashCode(), outraAcomodacao.hashCode());
    }
}
