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
public class ModeloCientifica {
     /**
     * Método utilizado para obtener el <strong>AND</strong> lógico aplicado
     * entre dos valores de tipo booleano.<hr />
     *
     * @param operando1 Variable de tipo <strong>boolean</strong> que será
     * aplicada al valor de la segunda variable para realizar la operación.
     * @param operando2 Variable de tipo <strong>boolean</strong> que será
     * aplicada al valor de la primera variable para realizar la operación.
     * @return Devuelve el resultado de realizar un <strong>AND</strong> lígico
     * entre los argumentos.
     * @throws IllegalArgumentException En el caso de que uno de los valores sea
     * cero lanzará una excepción.
     */
    public boolean and(boolean operando1, boolean operando2)
            throws IllegalArgumentException {
        return operando1 && operando2;
    }

    /**
     * Método utilizado para obtener el <strong>OR</strong> lógico aplicado
     * entre dos valores de tipo booleano.<hr />
     *
     * @param operando1 Variable de tipo <strong>boolean</strong> que será
     * aplicada al valor de la segunda variable para realizar la operación.
     * @param operando2 Variable de tipo <strong>boolean</strong> que será
     * aplicada al valor de la primera variable para realizar la operación.
     * @return Devuelve el resultado de realizar un <strong>OR</strong> lígico
     * entre los argumentos.
     * @throws IllegalArgumentException En el caso de que uno de los valores sea
     * cero lanzará una excepción.
     */
    public boolean or(boolean operando1, boolean operando2)
            throws IllegalArgumentException {
        return operando1 || operando2;
    }

    /**
     * Método utilizado para obtener el <strong>XOR</strong> lógico aplicado
     * entre dos valores de tipo booleano.<hr />
     *
     * @param operando1 Variable de tipo <strong>boolean</strong> que será
     * aplicada al valor de la segunda variable para realizar la operación.
     * @param operando2 Variable de tipo <strong>boolean</strong> que será
     * aplicada al valor de la primera variable para realizar la operación.
     * @return Devuelve el resultado de realizar un <strong>XOR</strong> lígico
     * entre los argumentos.
     * @throws IllegalArgumentException En el caso de que uno de los valores sea
     * cero lanzará una excepción.
     */
    public boolean xor(boolean operando1, boolean operando2)
            throws IllegalArgumentException {
        return (operando1 || operando2) && !(operando1 && operando2);
    }

    /**
     * Método utilizado para obtener el <strong>NOT</strong> lógico aplicado a
     * un valor de tipo booleano.<hr />
     *
     * @param operando Variable de tipo <strong>boolean</strong> de la que
     * obtendremos la negacion.
     * @return Devuelve el resultado de realizar un <strong>XOR</strong> lígico
     * a un valor de tipo booleano.
     */
    public boolean not(boolean operando) {
        return !operando;
    }
    
    /**
     * Método que permite obtener la potencia del primer número elevado al
     * segundo.<hr />
     *
     * @param operando1 Variable de tipo <strong>double</strong> que actuará
     * como base de la potencia.
     * @param operando2 Variable de tipo <strong>double</strong> que actuará
     * como exponente de la potencia.
     * @return Devuelve el resultado de la <strong>potencia</strong> de los dos
     * números pasados como argumentos.
     * @throws NumberFormatException Excepción que se lanzará si el formato de
     * los números no es correcto.
     * @throws IllegalArgumentException En el caso de que uno de los valores sea
     * cero lanzará una excepción.
     */
    public double potencia(double operando1, double operando2)
            throws NumberFormatException, IllegalArgumentException {
        return Math.pow(operando1, operando2);
    }

    /**
     * Método que permite obtener la potencia del primer número elevado a uno
     * entre el segundo número (operando1^(1/operando2)).<hr />
     *
     * @param operando1 Variable de tipo <strong>double</strong> que actuará
     * como base de la potencia.
     * @param operando2 Variable de tipo <strong>double</strong> que actuará
     * como divisor de uno en el exponente de la potencia.
     * @return Devuelve un tipo <strong>double</strong> con el resultado de la
     * <strong>raíz</strong>.
     * @throws NumberFormatException Excepción que se lanzará si el formato de
     * los números no es correcto.
     * @throws IllegalArgumentException En el caso de que uno de los valores sea
     * cero lanzará una excepción.
     * @throws ArithmeticException si el operando 1 es negativo o el operando 2
     * es cero se lanzará una excepción.
     */
    public double raiz(double operando1, double operando2)
            throws NumberFormatException,
            IllegalArgumentException {
        return Math.pow(operando1, 1 / operando2);
    }
    
    /**
     * Método utilizado para calcular el seno de un numero decimal grande.<hr />
     *
     * @param operando Variable de tipo <strong>double</strong> de la cual se
     * obtendrá el <strong>seno</strong>.
     * @return Devuelve el resultado de aplicar el <strong>seno</strong> al
     * valor pasado como argumento.
     * @throws NumberFormatException Excepción que se lanzará si el formato de
     * los números no es correcto.
     * @throws IllegalArgumentException En el caso de que uno de los valores sea
     * cero lanzará una excepción.
     */
    public double seno(double operando)
            throws NumberFormatException, IllegalArgumentException {
        return Math.sin(operando);
    }

    /**
     * Método utilizado para calcular el coseno de un numero decimal grande.<hr
     * />
     *
     * @param operando Variable de tipo <strong>double</strong> de que se
     * obtendrá el <strong>coseno</strong>.
     * @return Devuelve el resultado de aplicar el <strong>coseno</strong> al
     * valor pasado como argumento.
     * @throws NumberFormatException Excepción que se lanzará si el formato de
     * los números no es correcto.
     * @throws IllegalArgumentException En el caso de que uno de los valores sea
     * cero lanzará una excepción.
     */
    public double coseno(double operando)
            throws NumberFormatException, IllegalArgumentException {
        return Math.cos(operando);
    }

    /**
     * Método utilizado para calcular la tangente de un numero decimal
     * grande.<hr />
     *
     * @param operando Variable de tipo <strong>double</strong> de la cual se
     * obtendrá la <strong>tangente</strong>.
     * @return Devuelve el resultado de aplicar la <strong>tangente</strong> al
     * valor pasado como argumento.
     * @throws NumberFormatException Excepción que se lanzará si el formato de
     * los números no es correcto.
     * @throws IllegalArgumentException En el caso de que uno de los valores sea
     * cero lanzará una excepción.
     */
    public double tangente(double operando)
            throws NumberFormatException, IllegalArgumentException {
        return Math.tan(operando);
    }
}
