/*
 * Copyright (C) 2013 Félix Marín Ramírez | felixmurcia@gmail.com
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>. * 
 */

/*
 * DOCUMENTACION: http://documentacion-calculadora.tk
 */
package calculadora.modelo;

/**
 *
 * @author Félix Marín Ramírez | felixmurcia@gmail.com
 * @version 1.0
 */
public class ModeloProgramador {

    /**
     * Método que sirve para pasar un valor de decimal a binario.
     *
     * @param operando Variable de tipo String la cual debe conterner un valor
     * numéroco <strong>decimal</strong>.
     * @return Devuelve una cadena con el valor en <strong>binario</strong>.
     * @throws NumberFormatException En el caso de que hayan caracteres no
     * permitidos se lanzará una excepción.
     * @throws IllegalArgumentException En el caso de que el argumento no sea
     * válido se lanzará una excepción.
     * @see calculadora.controlador.ConversorControl#resultadoDecBin(String
     * operando)
     */
    public String decimalBinario(String operando)
            throws NumberFormatException, IllegalArgumentException {  //1
        int i = Integer.parseInt(operando, 10);
        return Integer.toBinaryString(i);
    }

    /**
     * Método que sirve para pasar un valor de decimal a octal.<hr />
     *
     * @param operando Variable de tipo String la cual debe conterner un valor
     * numéroco <strong>decimal</strong>.
     * @return Devuelve una cadena con el valor en <strong>octal</strong>.
     * @throws NumberFormatException En el caso de que hayan caracteres no
     * permitidos se lanzará una excepción.
     * @throws IllegalArgumentException En el caso de que el argumento no sea
     * válido se lanzará una excepción.
     * @see calculadora.controlador.ConversorControl#resultadoDecOct(String
     * operando)
     */
    public String decimalOctal(String operando)
            throws NumberFormatException, IllegalArgumentException {   //2
        int i = Integer.parseInt(operando, 10);
        return Integer.toOctalString(i);
    }

    /**
     * Método que sirve para pasar un valor de decimal a hexadecimal.<hr />
     *
     * @param operando Variable de tipo String la cual debe conterner un valor
     * numéroco <strong>decimal</strong>.
     * @return Devuelve una cadena con el valor en <strong>hexadecimal</strong>.
     * @throws NumberFormatException En el caso de que hayan caracteres no
     * permitidos se lanzará una excepción.
     * @throws IllegalArgumentException En el caso de que el argumento no sea
     * válido se lanzará una excepción.
     * @see calculadora.controlador.ConversorControl#resultadoDecHex(String
     * operando)
     */
    public String decimalHexadecimal(String operando)
            throws NumberFormatException, IllegalArgumentException { //3
        int i = Integer.parseInt(operando, 10);
        return Integer.toHexString(i);
    }

    /**
     * Método que sirve para pasar un valor de binario a decimal.<hr />
     *
     * @param operando Variable de tipo String la cual debe conterner un valor
     * en <strong>binario</strong>.
     * @return Devuelve una cadena con el valor en <strong>decimal</strong>.
     * @throws NumberFormatException En el caso de que hayan caracteres no
     * permitidos se lanzará una excepción.
     * @throws IllegalArgumentException En el caso de que el argumento no sea
     * válido se lanzará una excepción.
     * @see calculadora.controlador.ConversorControl#resultadoBinDec(String
     * operando)
     */
    public String binarioDecimal(String operando)
            throws NumberFormatException, IllegalArgumentException { //4
        int i = Integer.parseInt(operando, 2);
        return Integer.toString(i);
    }

    /**
     * Método que sirve para pasar un valor de binario a octal.<hr />
     *
     * @param operando Variable de tipo String la cual debe conterner un valor
     * en <strong>binario</strong>.
     * @return Devuelve una cadena con el valor en <strong>octal</strong>.
     * @throws NumberFormatException En el caso de que hayan caracteres no
     * permitidos se lanzará una excepción.
     * @throws IllegalArgumentException En el caso de que el argumento no sea
     * válido se lanzará una excepción.
     * @see calculadora.controlador.ConversorControl#resultadoBinOct(String
     * operando)
     */
    public String binarioOctal(String operando)
            throws NumberFormatException, IllegalArgumentException {   //5
        int i = Integer.parseInt(operando, 2);
        return Integer.toOctalString(i);
    }

    /**
     * Método que sirve para pasar un valor de binario a hexadecimal. <hr />
     *
     * @param operando Variable de tipo String la cual debe conterner un valor
     * en <strong>binario</strong>.
     * @return Devuelve una cadena con el valor en <strong>hexadecimal</strong>.
     * @throws NumberFormatException En el caso de que hayan caracteres no
     * permitidos se lanzará una excepción.
     * @throws IllegalArgumentException En el caso de que el argumento no sea
     * válido se lanzará una excepción.
     * @see calculadora.controlador.ConversorControl#resultadoBinHex(String
     * operando)
     */
    public String binarioHexadecimal(String operando)
            throws NumberFormatException, IllegalArgumentException { //6
        int i = Integer.parseInt(operando, 2);
        return Integer.toHexString(i);
    }

    /**
     * Método que sirve para pasar un valor de hexadecimal a binario. <hr />
     *
     * @param operando Variable de tipo String la cual debe conterner un valor
     * en <strong>hexadecimal</strong>.
     * @return Devuelve una cadena con el valor en <strong>binario</strong>.
     * @throws NumberFormatException En el caso de que hayan caracteres no
     * permitidos se lanzará una excepción.
     * @throws IllegalArgumentException En el caso de que el argumento no sea
     * válido se lanzará una excepción.
     * @see calculadora.controlador.ConversorControl#resultadoHexBin(String
     * operando)
     */
    public String hexadecimalBinario(String operando)
            throws NumberFormatException, IllegalArgumentException { //7
        int i = Integer.parseInt(operando, 16);
        return Integer.toBinaryString(i);
    }

    /**
     * Método que sirve para pasar un valor de hexadecimal a octal.<hr />
     *
     * @param operando Variable de tipo String la cual debe conterner un valor
     * en <strong>hexadecimal</strong>.
     * @return Devuelve una cadena con el valor en <strong>octal</strong>.
     * @throws NumberFormatException En el caso de que hayan caracteres no
     * permitidos se lanzará una excepción.
     * @throws IllegalArgumentException En el caso de que el argumento no sea
     * válido se lanzará una excepción.
     * @see calculadora.controlador.ConversorControl#resultadoHexOct(String
     * operando)
     */
    public String hexadecimalOctal(String operando)
            throws NumberFormatException, IllegalArgumentException {   //8
        int i = Integer.parseInt(operando, 16);
        return Integer.toOctalString(i);
    }

    /**
     * Método que sirve para pasar un valor de hexadecimal a decimal.<hr />
     *
     * @param operando Variable de tipo String la cual debe conterner un valor
     * en <strong>hexadecimal</strong>.
     * @return Devuelve una cadena con el valor en <strong>decimal</strong>.
     * @throws NumberFormatException En el caso de que hayan caracteres no
     * permitidos se lanzará una excepción.
     * @throws IllegalArgumentException En el caso de que el argumento no sea
     * válido se lanzará una excepción.
     * @see calculadora.controlador.ConversorControl#resultadoHexDec(String
     * operando)
     */
    public String hexadecimalDecimal(String operando)
            throws NumberFormatException, IllegalArgumentException { //9
        int i = Integer.parseInt(operando, 16);
        return Integer.toString(i);
    }

    /**
     * Método que sirve para pasar un valor de octal a binario.<hr />
     *
     * @param operando Variable de tipo String la cual debe conterner un valor
     * en <strong>octal</strong>.
     * @return Devuelve una cadena con el valor en <strong>binario</strong>.
     * @throws NumberFormatException En el caso de que hayan caracteres no
     * permitidos se lanzará una excepción.
     * @throws IllegalArgumentException En el caso de que el argumento no sea
     * válido se lanzará una excepción.
     * @see calculadora.controlador.ConversorControl#resultadoOctBin(String
     * operando)
     */
    public String octalBinario(String operando)
            throws NumberFormatException, IllegalArgumentException {   //10
        int i = Integer.parseInt(operando, 8);
        return Integer.toBinaryString(i);
    }

    /**
     * Método que sirve para pasar un valor de octal a decimal.<hr />
     *
     * @param operando Variable de tipo String la cual debe conterner un valor
     * en <strong>octal</strong>.
     * @return Devuelve una cadena con el valor en <strong>decimal</strong>.
     * @throws NumberFormatException En el caso de que hayan caracteres no
     * permitidos se lanzará una excepción.
     * @throws IllegalArgumentException En el caso de que el argumento no sea
     * válido se lanzará una excepción.
     * @see calculadora.controlador.ConversorControl#resultadoOctDec(String
     * operando)
     */
    public String octalDecimal(String operando)
            throws NumberFormatException, IllegalArgumentException {   //11
        int i = Integer.parseInt(operando, 8);
        return Integer.toString(i);
    }

    /**
     * Método que sirve para pasar un valor de octal a hexadecimal.<hr />
     *
     * @param operando Variable de tipo String la cual debe conterner un valor
     * en <strong>octal</strong>.
     * @return Devuelve una cadena con el valor en <strong>hexadecimal</strong>.
     * @throws NumberFormatException En el caso de que hayan caracteres no
     * permitidos se lanzará una excepción.
     * @throws IllegalArgumentException En el caso de que el argumento no sea
     * válido se lanzará una excepción.
     * @see calculadora.controlador.ConversorControl#resultadoOctDec(String
     * operando)
     */
    public String octalHexadecimal(String operando)
            throws NumberFormatException, IllegalArgumentException {   //12
        int i = Integer.parseInt(operando, 8);
        return Integer.toHexString(i);
    }
}
