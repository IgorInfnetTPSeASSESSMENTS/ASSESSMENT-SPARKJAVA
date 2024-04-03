package assessmentIgorAntonio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import assessmentIgorAntonio.model.domain.Quarto;

import java.util.Objects;

public class QuartoTest {

    private Quarto quarto;
    
    @Before
    public void setUp() {
        quarto = new Quarto(101);
    }
    
    @Test
    public void testIsDisponivel() {
        assertFalse(quarto.isDisponivel());
    }
    
    @Test
    public void testSetDisponivel() {
        quarto.setDisponivel(true);
        
        assertTrue(quarto.isDisponivel());
    }
    
    @Test
    public void testGetIdDoQuarto() {
        assertEquals(101, quarto.getIdDoQuarto());
    }
    
    @Test
    public void testSetIdDoQuarto() {
        quarto.setIdDoQuarto(102);
        
        assertEquals(102, quarto.getIdDoQuarto());
    }
    
    @Test
    public void testEquals() {
        Quarto outroQuarto = new Quarto(101);
        
        assertTrue(quarto.equals(outroQuarto));
    }
    
    @Test
    public void testNotEquals() {
        Quarto outroQuarto = new Quarto(102);
        
        assertFalse(quarto.equals(outroQuarto));
    }
    
    @Test
    public void testHashCode() {
        assertEquals(Objects.hash(101), quarto.hashCode());
    }
}
