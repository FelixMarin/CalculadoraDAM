
package calculadora.modelo;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Félix Marín Ramírez | felixmurcia@gmail.com
 */
public class ModeloProgramadorTest {
    
    private ModeloProgramador instance;
    private String operando;
    private String expResult;
    private String result;
    
    public ModeloProgramadorTest() {
    }
    
    @Before
    public void setUp() {
        instance = new ModeloProgramador();
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of decimalBinario method, of class ModeloProgramador.
     */
    @Test
    public void testDecimalBinario() {
        operando = "10";
        expResult = "1010";
        result = instance.decimalBinario(operando);
        assertEquals(expResult, result);
    }

    /**
     * Test of decimalOctal method, of class ModeloProgramador.
     */
    @Test
    public void testDecimalOctal() {
        operando = "10";
        expResult = "12";
        result = instance.decimalOctal(operando);
        assertEquals(expResult, result);
    }

    /**
     * Test of decimalHexadecimal method, of class ModeloProgramador.
     */
    @Test
    public void testDecimalHexadecimal() {
        operando = "10";
        expResult = "a";
        result = instance.decimalHexadecimal(operando);
        assertEquals(expResult, result);
    }

    /**
     * Test of binarioDecimal method, of class ModeloProgramador.
     */
    @Test
    public void testBinarioDecimal() {
        operando = "1010";
        expResult = "10";
        result = instance.binarioDecimal(operando);
        assertEquals(expResult, result);
    }

    /**
     * Test of binarioOctal method, of class ModeloProgramador.
     */
    @Test
    public void testBinarioOctal() {
        operando = "1010";
        expResult = "12";
        result = instance.binarioOctal(operando);
        assertEquals(expResult, result);
    }

    /**
     * Test of binarioHexadecimal method, of class ModeloProgramador.
     */
    @Test
    public void testBinarioHexadecimal() {
        operando = "1010";
        expResult = "a";
        result = instance.binarioHexadecimal(operando);
        assertEquals(expResult, result);
    }

    /**
     * Test of hexadecimalBinario method, of class ModeloProgramador.
     */
    @Test
    public void testHexadecimalBinario() {
        operando = "a";
        expResult = "1010";
        result = instance.hexadecimalBinario(operando);
        assertEquals(expResult, result);
    }

    /**
     * Test of hexadecimalOctal method, of class ModeloProgramador.
     */
    @Test
    public void testHexadecimalOctal() {
        operando = "a";
        expResult = "12";
        result = instance.hexadecimalOctal(operando);
        assertEquals(expResult, result);
    }

    /**
     * Test of hexadecimalDecimal method, of class ModeloProgramador.
     */
    @Test
    public void testHexadecimalDecimal() {
        operando = "a";
        expResult = "10";
        result = instance.hexadecimalDecimal(operando);
        assertEquals(expResult, result);
    }

    /**
     * Test of octalBinario method, of class ModeloProgramador.
     */
    @Test
    public void testOctalBinario() {
        operando = "12";
        expResult = "1010";
        result = instance.octalBinario(operando);
        assertEquals(expResult, result);
    }

    /**
     * Test of octalDecimal method, of class ModeloProgramador.
     */
    @Test
    public void testOctalDecimal() {
        operando = "12";
        expResult = "10";
        result = instance.octalDecimal(operando);
        assertEquals(expResult, result);
    }

    /**
     * Test of octalHexadecimal method, of class ModeloProgramador.
     */
    @Test
    public void testOctalHexadecimal() {
        operando = "12";
        expResult = "a";
        result = instance.octalHexadecimal(operando);
        assertEquals(expResult, result);
    }
}
