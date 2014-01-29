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

import calculadora.vista.VistaCalcCientifica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author Félix Marín Ramírez | felixmurcia@gmail.com
 * @version 1.0
 */
public class ControlCientifica extends Control implements ActionListener {

    private VistaCalcCientifica vcCientifica;
    private ArrayList<String> booleanos;
    private boolean resultadoBol;
    private String result;
    private boolean bolButtons;
    //--//
    private ICommand<Boolean> iCommandBol;

    /**
     * Constructor de la clase encargado de crear todos los elementos necesarios
     * para que la clase sea funcional.
     *
     * @param vcCientifica Parámetro de tipo
     * <strong>VistaCalcCientifica</strong>, el cual, se le pasa como argumento
     * al constructor de la clase.
     */
    public ControlCientifica(VistaCalcCientifica vcCientifica) {
        this.vcCientifica = vcCientifica;
        super.acumulador = "";
        super.numeros = new ArrayList();
        this.booleanos = new ArrayList();
        this.bolButtons = true;
    }

    /**
     *
     * @return Devuelve un objeto de tipo IComand al cual se le ha asignado un
     * tipo Boolean.
     */
    public ICommand<Boolean> getiCommandBol() {
        return iCommandBol;
    }

    /**
     * Método utilizdo para crear objetos de tipo IComand concretos (sumar,
     * restar, ...)
     *
     * @param iCommandBol
     */
    public void setiCommandBol(ICommand<Boolean> iCommandBol) {
        this.iCommandBol = iCommandBol;
    }

    /**
     * Método encargado de descomponer la variable 'acumulador' e introducir
     * cada valor en la lista 'numeros', a coninuación, según el simbolo de la
     * operación realizara una operacion <strong>aritmética</strong> u otra.
     */
    @Override
    public void controlOperacion() {
        this.vcCientifica.addTexto("");
        super.descomponerAcumulador();
        if (iCommand != null) {
            this.result = String.valueOf(super.iCommand.doit(super.numeros));
            this.vcCientifica.addTexto(super.nf.format(Double.parseDouble(this.result))
                    + ' ' + '=');
            this.reset();
        }

    }

    /**
     * Método encargado de descomponer la variable 'acumulador' e introducir
     * cada valor en la lista 'numeros', a coninuación, según el simbolo de la
     * operación realizara una operacion <strong>booleana</strong> u otra.
     */
    public void trueTables() {
        try {

            this.selectorDeBoleanos();

            if (this.booleanos.size() > 1 && super.operacion == 'n'
                    || this.iCommandBol == null) {
                this.vcCientifica.addTexto("");
                this.reset();
            }

            this.vcCientifica.addTexto("");
            this.resultadoBol = this.iCommandBol.doit(booleanos);
            this.vcCientifica.addTexto(String.valueOf(
                    converter(this.resultadoBol)) + ' ' + '=');
            this.reset();

        } catch (IndexOutOfBoundsException | NumberFormatException | UnsupportedOperationException ex) {
            this.reset();
            this.vcCientifica.addTexto("");
        }
    }

    /**
     * Resetea todas las variables acumuladoras.
     */
    @Override
    public void reset() {
        super.reset();
        booleanos.clear();
        bolButtons = true;
    }

    /**
     * Método que devuelve un String con la palabra "Verdadero" o "Falso"
     * dependiendo del parámetro booleano que recibe.
     *
     * @param bol Parámetro de tipo boolean.
     * @return Devuelve un String con "Verdadero" o "Falso".
     */
    public String converter(boolean bol) {
        if (bol) {
            return "Verdadero";
        } else {
            return "Falso";
        }
    }

    /**
     * Método utilizado para eliminar el contenido de la pantalla cuando en ésta
     * hay un resultado de otra operación.
     */
    public void limpiarResultadoAnterior() {
        if (this.vcCientifica.getCampoTexto().getText().contains("=")) {
            this.vcCientifica.addTexto("");
            super.reset();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.numberSizeControl()) {
            //DO NOTHIG
        } else {
            JButton btn = (JButton) e.getSource();
            super.acumulador += btn.getText();
            this.vcCientifica.getCampoTexto().setText("");
            this.vcCientifica.getCampoTexto().setText(
                    super.nf.format(Double.parseDouble(this.acumulador)));
        }
    }

    public void setOperando(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if (this.vcCientifica.campoTextoIsEmpty()
                && btn.getText().equals("-")) {
            super.setAcumulador("-");
            this.vcCientifica.addTexto("-");
        } else {
            super.setPrimerOperando(super.getAcumulador());
            super.setAcumulador("");
        }
    }

    public void setBolButtons(boolean b) {
        this.bolButtons = b;
    }

    public boolean isBolButtons() {
        return this.bolButtons;
    }

    private void selectorDeBoleanos() {
        try {
            if (Integer.parseInt(super.primerOperando) != 0) {
                this.booleanos.add("true");
            } else {
                this.booleanos.add("false");
            }


            if (Integer.parseInt(super.segundoOperando) != 0) {
                this.booleanos.add("true");
            } else {
                this.booleanos.add("false");
            }
        } catch (NullPointerException | NumberFormatException ex) {
            //DO NOTHING
        }
    }
}
