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
public class ModeloSimple {
    
    
     /**
     * Método que permite sumar dos numeros decimales grandes. <hr />
     *
     * @param operando1 Variable de tipo <strong>double</strong> que será sumada
     * a la variable operando2.
     * @param operando2 Variable de tipo <strong>double</strong> que será sumada
     * a la variable operando1.
     * @return Devuelve un tipo <strong>double</strong> con el resultado de
     * <strong>sumar</strong> operando1 a operando2.
     * @throws NumberFormatException
     * @throws IllegalArgumentException
     * @see calculadora.controlador.ArhitmeticControl#resultadoSumar(double
     * operando1, double operando2)
     */
    public double sumar(double operando1, double operando2)
            throws NumberFormatException, IllegalArgumentException {
        
        double res = (operando1) + (operando2);
        return (operando1) + (operando2);
    }

    /**
     * Método que permite restar dos numeros decimales grandes. <hr />
     *
     * @param operando1 Variable de tipo <strong>double</strong>, la cual, será
     * restada a la variable operando2.
     * @param operando2 Variable de tipo <strong>double</strong>, la cual, será
     * restada a la variable operando1.
     * @return Devuelve un tipo <strong>double</strong> con el resultado de
     * <strong>restar</strong> operando1 a operando2.
     * @throws NumberFormatException
     * @throws IllegalArgumentException
     * @see calculadora.controlador.ArhitmeticControl#resultadoRestar(double
     * operando1, double operando2)
     */
    public double restar(double operando1, double operando2)
            throws NumberFormatException, IllegalArgumentException {
        return (operando1) - (operando2);
    }

    /**
     * Método que permite multiplicar dos numeros decimales grandes. <hr />
     *
     * @param operando1 Variable de tipo <strong>double</strong> que será
     * multiplicada a la variable operando2.
     * @param operando2 Variable de tipo <strong>double</strong> que será
     * multiplicada a la variable operando1.
     * @return Devuelve un tipo <strong>double</strong> con el resultado de
     * <strong>multiplicar</strong> el operando1 con operando2.
     * @throws NumberFormatException En el caso de que hayan caracteres no
     * permitidos se lanzará una excepción.
     * @throws IllegalArgumentException En el caso de que el argumento no sea
     * válido se lanzará una excepción.
     * @see
     * calculadora.controlador.ArhitmeticControl#resultadoMultiplicar(double
     * operando1, double operando2)
     */
    public double multiplicar(double operando1, double operando2)
            throws NumberFormatException, IllegalArgumentException {
        return (operando1) * (operando2);
    }

    /**
     * Método que permite dividir dos numeros decimales grandes. El divisor no
     * puede ser cero. <hr />
     *
     * @param operando1 Variable de tipo <strong>double</strong> que actuará
     * como dividendo.
     * @param operando2 Variable de tipo <strong>double</strong> que actuará
     * como divisor.
     * @return Devuelve un tipo <strong>double</strong> con el resultado de
     * <strong>dividir</strong> el operando1 entre el operando2.
     * @throws NumberFormatException En el caso de que hayan caracteres no
     * permitidos se lanzará una excepción.
     * @throws IllegalArgumentException Excepción que se lanzará cuando el
     * divisor sea cero.
     * @see calculadora.controlador.ArhitmeticControl#resultadoDividir(double
     * operando1, double operando2)
     */
    public double dividir(double operando1, double operando2)
            throws NumberFormatException, 
            IllegalArgumentException {                 
        return (operando1) / (operando2);
    }

    /**
     * Método que permite obtener el módulo dos numeros decimales grandes. Ni el
     * divisor ni el dividendo pueden ser cero.<hr />
     *
     * @param operando1 Variable de tipo <strong>double</strong> que actuará
     * como dividendo.
     * @param operando2 Variable de tipo <strong>double</strong> que actuará
     * como divisor.
     * @return Devuelve el <strong>módulo (resto)</strong> de la división entre
     * los dos números pasados como argumentos.
     * @throws NumberFormatException En el caso de que hayan caracteres no
     * permitidos se lanzará una excepción.
     * @throws IllegalArgumentException En el caso de que el argumento no sea
     * válido se lanzará una excepción.
     * @see calculadora.controlador.ArhitmeticControl#resultadoModulo(double
     * operando1, double operando2)
     */
    public double modulo(double operando1, double operando2)
            throws NumberFormatException, 
            IllegalArgumentException {   
        return (operando1) % (operando2);
    }
}
