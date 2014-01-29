package calculadora.modelo;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Félix Marín Ramírez | felixmurcia@gmail.com
 */
public class ModeloSimpleTest {

    private ModeloSimple instance;
    private double operando1;
    private double operando2;
    private double expResult;
    private double result;

    public ModeloSimpleTest() {
    }

    @Before
    public void setUp() {
        instance = new ModeloSimple();
    }

    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of sumar method, of class ModeloSimple.
     */
    @Test
    public void testSumar() {
        operando1 = 0.0;
        operando2 = 0.0;
        expResult = 0.0;
        result = instance.sumar(operando1, operando2);
        assertEquals(expResult, result, 0.0);
        //--//
        operando1 = 0.0;
        operando2 = 1.0;
        expResult = 1.0;
        result = instance.sumar(operando1, operando2);
        assertEquals(expResult, result, 1.0);
        //--//
        operando1 = 1.0;
        operando2 = 0.0;
        expResult = 1.0;
        result = instance.sumar(operando1, operando2);
        assertEquals(expResult, result, 1.0);
        //--//
        operando1 = -1.0;
        operando2 = 0.0;
        expResult = -1.0;
        result = instance.sumar(operando1, operando2);
        assertEquals(expResult, result, -1.0);
        //--//
        operando1 = 0.0;
        operando2 = -1.0;
        expResult = -1.0;
        result = instance.sumar(operando1, operando2);
        assertEquals(expResult, result, -1.0);
        //--//
        operando1 = -1.0;
        operando2 = -1.0;
        expResult = -2.0;
        result = instance.sumar(operando1, operando2);
        assertEquals(expResult, result, -2.0);
        //--//
        operando1 = 1.0;
        operando2 = 1.0;
        expResult = 2.0;
        result = instance.sumar(operando1, operando2);
        assertEquals(expResult, result, 2.0);
    }

    /**
     * Test of restar method, of class ModeloSimple.
     */
    @Test
    public void testRestar() {
        operando1 = 0.0;
        operando2 = 0.0;
        expResult = 0.0;
        result = instance.restar(operando1, operando2);
        assertEquals(expResult, result, 0.0);
        //--//
        operando1 = 1.0;
        operando2 = 0.0;
        expResult = 1.0;
        result = instance.restar(operando1, operando2);
        assertEquals(expResult, result, 1.0);
        //--//
        operando1 = -1.0;
        operando2 = 0.0;
        expResult = -1.0;
        result = instance.restar(operando1, operando2);
        assertEquals(expResult, result, -1.0);
        //--//
        operando1 = 0.0;
        operando2 = -1.0;
        expResult = 1.0;
        result = instance.restar(operando1, operando2);
        assertEquals(expResult, result, 1.0);
        //--//
        operando1 = 0.0;
        operando2 = 1.0;
        expResult = -1.0;
        result = instance.restar(operando1, operando2);
        assertEquals(expResult, result, -1.0);
        //--//
        operando1 = -1.0;
        operando2 = -1.0;
        expResult = 0.0;
        result = instance.restar(operando1, operando2);
        assertEquals(expResult, result, 0.0);
        //--//
        operando1 = 1.0;
        operando2 = 1.0;
        expResult = 0.0;
        result = instance.restar(operando1, operando2);
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of multiplicar method, of class ModeloSimple.
     */
    @Test
    public void testMultiplicar() {
        operando1 = 0.0;
        operando2 = 0.0;
        expResult = 0.0;
        result = instance.multiplicar(operando1, operando2);
        assertEquals(expResult, result, 0.0);
        //--//
        operando1 = 1.0;
        operando2 = 0.0;
        expResult = 0.0;
        result = instance.multiplicar(operando1, operando2);
        assertEquals(expResult, result, 0.0);
        //--//
        operando1 = 0.0;
        operando2 = 1.0;
        expResult = 0.0;
        result = instance.multiplicar(operando1, operando2);
        assertEquals(expResult, result, 0.0);
        //--//
        operando1 = 1.0;
        operando2 = 1.0;
        expResult = 1.0;
        result = instance.multiplicar(operando1, operando2);
        assertEquals(expResult, result, 1.0);
        //--//
        operando1 = -1.0;
        operando2 = 1.0;
        expResult = -1.0;
        result = instance.multiplicar(operando1, operando2);
        assertEquals(expResult, result, -1.0);
        //--//
        operando1 = 1.0;
        operando2 = -1.0;
        expResult = -1.0;
        result = instance.multiplicar(operando1, operando2);
        assertEquals(expResult, result, -1.0);
        //--//
        operando1 = -1.0;
        operando2 = -1.0;
        expResult = 1.0;
        result = instance.multiplicar(operando1, operando2);
        assertEquals(expResult, result, 1.0);
    }

    /**
     * Test of dividir method, of class ModeloSimple.
     */
    @Test
    public void testDividir() {
        operando1 = 0.0;
        operando2 = 0.0;
        expResult = Double.NaN;
        result = instance.dividir(operando1, operando2);
        assertEquals(expResult, result, Double.NaN);
        //--//
        operando1 = 1.0;
        operando2 = 0.0;
        expResult = Double.POSITIVE_INFINITY;
        result = instance.dividir(operando1, operando2);
        assertEquals(expResult, result, Double.POSITIVE_INFINITY);
        //--//
        operando1 = 0.0;
        operando2 = 1.0;
        expResult = 0;
        result = instance.dividir(operando1, operando2);
        assertEquals(expResult, result, 0);
        //--//
        operando1 = 1.0;
        operando2 = 1.0;
        expResult = 1;
        result = instance.dividir(operando1, operando2);
        assertEquals(expResult, result, 1);
        //--//
        operando1 = 1.0;
        operando2 = -1.0;
        expResult = -1;
        result = instance.dividir(operando1, operando2);
        assertEquals(expResult, result, -1);
        //--//
        operando1 = -1.0;
        operando2 = 1.0;
        expResult = -1;
        result = instance.dividir(operando1, operando2);
        assertEquals(expResult, result, -1);
        //--//
        operando1 = -1.0;
        operando2 = -1.0;
        expResult = 1;
        result = instance.dividir(operando1, operando2);
        assertEquals(expResult, result, 1);
    }

    /**
     * Test of modulo method, of class ModeloSimple.
     */
    @Test
    public void testModulo() {
        operando1 = 0.0;
        operando2 = 0.0;
        expResult = Double.NaN;
        result = instance.modulo(operando1, operando2);
        assertEquals(expResult, result, Double.NaN);
        //--//
        operando1 = 1.0;
        operando2 = 0.0;
        expResult = Double.NaN;
        result = instance.modulo(operando1, operando2);
        assertEquals(expResult, result, Double.NaN);
        //--//
        operando1 = 0.0;
        operando2 = 1.0;
        expResult = 0;
        result = instance.modulo(operando1, operando2);
        assertEquals(expResult, result, 0);
        //--//
        operando1 = 1.0;
        operando2 = 1.0;
        expResult = 0;
        result = instance.modulo(operando1, operando2);
        assertEquals(expResult, result, 0);
        //--//
        operando1 = -1.0;
        operando2 = 0.0;
        expResult = Double.NaN;
        result = instance.modulo(operando1, operando2);
        assertEquals(expResult, result, Double.NaN);
        //--//
        operando1 = 0.0;
        operando2 = -1.0;
        expResult = 0;
        result = instance.modulo(operando1, operando2);
        assertEquals(expResult, result, 0);
        //--//
        operando1 = -1.0;
        operando2 = 1.0;
        expResult = 0.0;
        result = instance.modulo(operando1, operando2);
        assertEquals(expResult, result, 0.0);
        //--//
        operando1 = 1.0;
        operando2 = -1.0;
        expResult = 0.0;
        result = instance.modulo(operando1, operando2);
        assertEquals(expResult, result, 0.0);
        //--//
        operando1 = -1.0;
        operando2 = -1.0;
        expResult = 0.0;
        result = instance.modulo(operando1, operando2);
        assertEquals(expResult, result, 0.0);
    }
}
