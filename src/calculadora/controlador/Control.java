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
package calculadora.controlador;

import calculadora.modelo.ModeloSimple;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 *
 * @author Félix Marín Ramírez | felixmurcia@gmail.com
 * @version 1.0
 */
public abstract class Control {

    /**
     * Instancia de la Clase ModeloSimple.
     */
    protected ModeloSimple modelo;
    /**
     * Instancia de la clase NumberFormat.
     */
    protected NumberFormat nf;
    /**
     * Instancia de la Interfaz ICommand.
     */
    protected ICommand<Double> iCommand;
    /**
     * Variable que contiene el primer operando.
     */
    protected String primerOperando;
    /**
     * Variable que contiene el segundo operando.
     */
    protected String segundoOperando;
    /**
     * Variable que indica si se añaden numeros a la variable primerOperando o
     * segundoOperando.
     */
    protected boolean selector;
    /**
     * Variable de tipo <strong>String</strong> a la cual se van concatenando
     * los valores introducidos.
     */
    protected String acumulador;
    /**
     * Lista donde se almacenarán el primer y el segundo número con los que se
     * realizará la operación.
     */
    protected ArrayList<String> numeros;
    /**
     * Variable de tipo <strong>char</strong> que almacenará el símbolo de la
     * operación.
     */
    protected char operacion;
    /**
     * Variable de tipo <strong>double</strong> en la que se almacena el
     * resultado de la operación.
     */
    protected double resultado;

    /**
     * Variable de tipo <strong>StringTokenizer</strong> utilizada para obtener
     * el primer y el segundo número de la operación.
     */
    //protected StringTokenizer z;
    /**
     * Contructor de la Clase.
     */
    public Control() {
        this.modelo = new ModeloSimple();
        this.nf = NumberFormat.getInstance();
        this.nf.setMinimumFractionDigits(3);
        this.acumulador = "";
    }

    /**
     *
     * @return Devuelve el primer operando.
     */
    public String getPrimerOperando() {
        return primerOperando;
    }

    /**
     *
     * @param primerOperando Establece el valor del primer operando.
     */
    public void setPrimerOperando(String primerOperando) {
        this.primerOperando = primerOperando;
    }

    /**
     *
     * @return Devuelve el segundo operando.
     */
    public String getSegundoOperando() {
        return segundoOperando;
    }

    /**
     *
     * @param SegundoOperando establece el valor del segundo operando.
     */
    public void setSegundoOperando(String SegundoOperando) {
        this.segundoOperando = SegundoOperando;
    }

    /**
     *
     * @return Devuele la variable selector de tipo boolean.
     */
    public boolean isSelector() {
        return selector;
    }

    /**
     *
     * @param selector Parametro para añadir true o false a la variable
     * selector.
     */
    public void setSelector(boolean selector) {
        this.selector = selector;
    }

    /**
     *
     * @return Devueve la variable de tipo <strong>char</strong> 'operacion'.
     */
    public char getOperacion() {
        return operacion;
    }

    /**
     *
     * @param operacion Parametro que indica el tipo de operación a realizar.
     */
    public void setOperacion(char operacion) {
        this.operacion = operacion;
    }

    /**
     *
     * @return Devuleve la variable donde se concatena cada pulsación del
     * teclado de la calculadora.
     */
    public String getAcumulador() {
        return acumulador;
    }

    /**
     * Método utilizado para establecer o añadir un String a la variable
     * 'acumulador'.
     *
     * @param acumulador Párametro utilizado para añadir Strings a la variable
     * acumulador.
     */
    public void setAcumulador(String acumulador) {
        this.acumulador = acumulador;
    }

    /**
     * Método para obtener el objeto iCommand.
     *
     * @return Devuelve la variable de tip ICommand
     */
    public ICommand getICommand() {
        return iCommand;
    }

    /**
     * Método utlizado para establecer un objeto de tipo iCommand.
     *
     * @param iCommand
     */
    public void setICommand(ICommand iCommand) {
        this.iCommand = iCommand;
    }

    /**
     * Resetea todas las variables acumuladoras.
     */
    public void reset() {
        this.acumulador = "";
        this.numeros.clear();
        this.operacion = ' ';
        this.resultado = 0;
        this.selector = true;
    }

    /**
     * Método encargado de relizar la operación aritmética.
     *
     * @return Devuelve el resultado de la operación.
     */
    protected String realizarOperacion() {
        try {
            descomponerAcumulador();
            if (iCommand != null) {
                this.resultado = this.iCommand.doit(this.numeros);
            }
        } catch (IndexOutOfBoundsException | NumberFormatException ex) {
            reset();
        }
        return String.valueOf(this.nf.format(this.resultado));
    }

    /**
     * Método utilizado para descomponer el Sting que contiene la operación a
     * realizar.
     */
    protected void descomponerAcumulador() {
        try {
            this.numeros.add(primerOperando.trim());
            this.numeros.add(segundoOperando.trim());
        } catch (NullPointerException ex) {
            //DO NOTHING
        }
    }
    
    public boolean numberSizeControl() {
        double nsc = 0;
        if(!this.acumulador.equals("")) {
            nsc = Double.parseDouble(this.getAcumulador());
        }
        return nsc >= 99999999999999L;
    }
    abstract void controlOperacion();
}
