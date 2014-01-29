package calculadora.modelo;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Félix Marín Ramírez | felixmurcia@gmail.com
 */
public class ModeloCientificaTest {

    private ModeloCientifica instance;
    private boolean operando1Bol;
    private boolean operando2Bol;
    private double operando1Dou;
    private double operando2Dou;
    private boolean expResultBol;
    private boolean resultBol;
    private double expResultDou;
    private double resultDou;

    public ModeloCientificaTest() {
    }

    @Before
    public void setUp() {
        instance = new ModeloCientifica();
    }

    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of and method, of class ModeloCientifica.
     */
    @Test
    public void testAnd() {
        operando1Bol = false;
        operando2Bol = false;
        expResultBol = false;
        resultBol = instance.and(operando1Bol, operando2Bol);
        assertEquals(expResultBol, resultBol);
        assertFalse(resultBol);
        //--//
        operando1Bol = true;
        operando2Bol = false;
        expResultBol = false;
        resultBol = instance.and(operando1Bol, operando2Bol);
        assertEquals(expResultBol, resultBol);
        assertFalse(resultBol);
        //--//
        operando1Bol = false;
        operando2Bol = true;
        expResultBol = false;
        resultBol = instance.and(operando1Bol, operando2Bol);
        assertEquals(expResultBol, resultBol);
        assertFalse(resultBol);
        //--//
        operando1Bol = true;
        operando2Bol = true;
        expResultBol = true;
        resultBol = instance.and(operando1Bol, operando2Bol);
        assertEquals(expResultBol, resultBol);
        assertTrue(resultBol);
    }

    /**
     * Test of or method, of class ModeloCientifica.
     */
    @Test
    public void testOr() {
        operando1Bol = false;
        operando2Bol = false;
        expResultBol = false;
        resultBol = instance.or(operando1Bol, operando2Bol);
        assertEquals(expResultBol, resultBol);
        assertFalse(resultBol);

        //--//
        operando1Bol = true;
        operando2Bol = false;
        expResultBol = true;
        resultBol = instance.or(operando1Bol, operando2Bol);
        assertEquals(expResultBol, resultBol);
        assertTrue(resultBol);
        //--//
        operando1Bol = false;
        operando2Bol = true;
        expResultBol = true;
        resultBol = instance.or(operando1Bol, operando2Bol);
        assertEquals(expResultBol, resultBol);
        assertTrue(resultBol);
        //--//
        operando1Bol = true;
        operando2Bol = true;
        expResultBol = true;
        resultBol = instance.or(operando1Bol, operando2Bol);
        assertEquals(expResultBol, resultBol);
        assertTrue(resultBol);
    }

    /**
     * Test of xor method, of class ModeloCientifica.
     */
    @Test
    public void testXor() {
        operando1Bol = false;
        operando2Bol = false;
        expResultBol = false;
        resultBol = instance.xor(operando1Bol, operando2Bol);
        assertEquals(expResultBol, resultBol);
        assertFalse(resultBol);
        //--//
        operando1Bol = true;
        operando2Bol = false;
        expResultBol = true;
        resultBol = instance.xor(operando1Bol, operando2Bol);
        assertEquals(expResultBol, resultBol);
        assertTrue(resultBol);
        //--//
        operando1Bol = false;
        operando2Bol = true;
        expResultBol = true;
        resultBol = instance.xor(operando1Bol, operando2Bol);
        assertEquals(expResultBol, resultBol);
        assertTrue(resultBol);
        //--//
        operando1Bol = false;
        operando2Bol = false;
        expResultBol = false;
        resultBol = instance.xor(operando1Bol, operando2Bol);
        assertEquals(expResultBol, resultBol);
        assertFalse(resultBol);
    }

    /**
     * Test of not method, of class ModeloCientifica.
     */
    @Test
    public void testNot() {
        operando1Bol = false;
        expResultBol = true;
        resultBol = instance.not(operando1Bol);
        assertEquals(expResultBol, resultBol);
        assertTrue(resultBol);
        //--//
        operando1Bol = true;
        expResultBol = false;
        resultBol = instance.not(operando1Bol);
        assertEquals(expResultBol, resultBol);
        assertFalse(resultBol);
    }

    /**
     * Test of potencia method, of class ModeloCientifica.
     */
    @Test
    public void testPotencia() {
        operando1Dou = 0.0;
        operando2Dou = 0.0;
        expResultDou = 1.0;
        resultDou = instance.potencia(operando1Dou, operando2Dou);
        assertEquals(expResultDou, resultDou, 1.0);
        //--//
        operando1Dou = 0.0;
        operando2Dou = 1.0;
        expResultDou = 1.0;
        resultDou = instance.potencia(operando1Dou, operando2Dou);
        assertEquals(expResultDou, resultDou, 1.0);
        //--//
        operando1Dou = 1.0;
        operando2Dou = 0.0;
        expResultDou = 1.0;
        resultDou = instance.potencia(operando1Dou, operando2Dou);
        assertEquals(expResultDou, resultDou, 1.0);
        //--//
        operando1Dou = 1.0;
        operando2Dou = 1.0;
        expResultDou = 1.0;
        resultDou = instance.potencia(operando1Dou, operando2Dou);
        assertEquals(expResultDou, resultDou, 1.0);
        //--//
        operando1Dou = -1.0;
        operando2Dou = -1.0;
        expResultDou = -1.0;
        resultDou = instance.potencia(operando1Dou, operando2Dou);
        assertEquals(expResultDou, resultDou, -1.0);
        //--//
        operando1Dou = -1.0;
        operando2Dou = 1.0;
        expResultDou = -1.0;
        resultDou = instance.potencia(operando1Dou, operando2Dou);
        assertEquals(expResultDou, resultDou, -1.0);
        //--//
        operando1Dou = 1.0;
        operando2Dou = -1.0;
        expResultDou = 1.0;
        resultDou = instance.potencia(operando1Dou, operando2Dou);
        assertEquals(expResultDou, resultDou, 1.0);
    }

    /**
     * Test of raiz method, of class ModeloCientifica.
     */
    @Test
    public void testRaiz() {
        operando1Dou = 0.0;
        operando2Dou = 0.0;
        expResultDou = 0.0;
        resultDou = instance.raiz(operando1Dou, operando2Dou);
        assertEquals(expResultDou, resultDou, 0.0);
        //--//
        operando1Dou = 0.0;
        operando2Dou = 1.0;
        expResultDou = 0.0;
        resultDou = instance.raiz(operando1Dou, operando2Dou);
        assertEquals(expResultDou, resultDou, 0.0);
        //--//
        operando1Dou = 0.0;
        operando2Dou = -1.0;
        expResultDou = Double.POSITIVE_INFINITY;
        resultDou = instance.raiz(operando1Dou, operando2Dou);
        assertEquals(expResultDou, resultDou, 0.0);
        //--//
        operando1Dou = 1.0;
        operando2Dou = 0.0;
        expResultDou = Double.NaN;
        resultDou = instance.raiz(operando1Dou, operando2Dou);
        assertEquals(expResultDou, resultDou, 0.0);
        //--//
        operando1Dou = -1.0;
        operando2Dou = 0.0;
        expResultDou = Double.NaN;
        resultDou = instance.raiz(operando1Dou, operando2Dou);
        assertEquals(expResultDou, resultDou, 0.0);
        //--//
        //--//
        operando1Dou = 2.0;
        operando2Dou = 1.0;
        expResultDou = 2.0;
        resultDou = instance.raiz(operando1Dou, operando2Dou);
        assertEquals(expResultDou, resultDou, 2.0);
        //--//
        operando1Dou = 2.0;
        operando2Dou = -1.0;
        expResultDou = 2.0;
        resultDou = instance.raiz(operando1Dou, operando2Dou);
        assertEquals(expResultDou, resultDou, 2.0);
    }

    /**
     * Test of seno method, of class ModeloCientifica.
     */
    @Test
    public void testSeno() {
        operando1Dou = 0.0;
        expResultDou = 0.0;
        resultDou = instance.seno(operando1Dou);
        assertEquals(expResultDou, resultDou, 0.0);
        //--//
        operando1Dou = 1.0;
        expResultDou = 1.0;
        resultDou = instance.seno(operando1Dou);
        assertEquals(expResultDou, resultDou, 1.0);
        //--//
        operando1Dou = -1.0;
        expResultDou = -0.8414709848078965;
        resultDou = instance.seno(operando1Dou);
        assertEquals(expResultDou, resultDou, -0.8414709848078965);
    }

    /**
     * Test of coseno method, of class ModeloCientifica.
     */
    @Test
    public void testCoseno() {
        operando1Dou = 0.0;
        expResultDou = 1.0;
        resultDou = instance.coseno(operando1Dou);
        assertEquals(expResultDou, resultDou, 0.0);
        //--//
        operando1Dou = 1.0;
        expResultDou = 1.0;
        resultDou = instance.coseno(operando1Dou);
        assertEquals(expResultDou, resultDou, 1.0);
        //--//
        operando1Dou = -1.0;
        expResultDou = 1.0;
        resultDou = instance.coseno(operando1Dou);
        assertEquals(expResultDou, resultDou, 1.0);
    }

    /**
     * Test of tangente method, of class ModeloCientifica.
     */
    @Test
    public void testTangente() {
        operando1Dou = 0.0;
        expResultDou = 0.0;
        resultDou = instance.tangente(operando1Dou);
        assertEquals(expResultDou, resultDou, 0.0);
        //--//
        operando1Dou = 1.0;
        expResultDou = 1.0;
        resultDou = instance.tangente(operando1Dou);
        assertEquals(expResultDou, resultDou, 1.0);
        //--//
        operando1Dou = -1.0;
        expResultDou = -1.5574077246549023;
        resultDou = instance.tangente(operando1Dou);
        assertEquals(expResultDou, resultDou, -1.5574077246549023);


    }
}
