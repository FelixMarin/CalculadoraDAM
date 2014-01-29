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

import calculadora.modelo.ModeloProgramador;
import calculadora.vista.VistaCalcProgramador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JRadioButton;

/**
 *
 * @author Félix Marín Ramírez | felixmurcia@gmail.com
 * @version 1.0
 */
public class ControlProgramador extends Control implements ActionListener {

    private VistaCalcProgramador vcProgramador;
    private ModeloProgramador mProgramador;
    private String resultadoTransformado;
    //--
    private boolean bolHex;
    private boolean bolDec;
    private boolean bolOct;
    private boolean bolBin;
    //--
    private String radioActual;
    private String radioPulsado;
    //--
    private ArrayList<String> numerosConvertidos;

    /**
     * Constructor de la clase encargado de crear todos los elementos necesarios
     * para que la clase sea funcional.
     *
     * @param vcProgramador Parámetro de tipo
     * <strong>VistaCalcProgramador</strong>, el cual, se le pasa como argumento
     * al constructor de la clase.
     */
    public ControlProgramador(VistaCalcProgramador vcProgramador) {
        this.vcProgramador = vcProgramador;
        this.mProgramador = new ModeloProgramador();
        super.acumulador = "";
        super.numeros = new ArrayList();
        this.numerosConvertidos = new ArrayList<>();
        this.radioActual = "HEX";
        bolHex = true;
        bolDec = false;
        bolOct = false;
        bolBin = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton && !super.numberSizeControl()) {            
            JButton btn = (JButton) e.getSource();
            super.setAcumulador(super.getAcumulador() + btn.getText());
            vcProgramador.getCampoTexto().setText("");
            vcProgramador.getCampoTexto().setText(super.getAcumulador());
        } else if (e.getSource() instanceof JRadioButton) {
            JRadioButton radioButton = (JRadioButton) e.getSource();
            if (radioButton.isSelected() && !super.getAcumulador().contains("-")) {
                comprobarIgual();
                radioPulsado = radioButton.getText();
                changer();
            } else {
                vcProgramador.addTexto("");
                super.reset();
            }
        }
    }

    /**
     * Método encargado de comparar la varible nombre con el nombre de los tipos
     * enumerados y en el caso de que sean iguales se llamará al método del
     * enumerado.
     */
    public void changer() {
        String nombre = this.radioActual + this.radioPulsado.toUpperCase();
        try {
            for (EnumCambio cambio : EnumCambio.values()) {
                if (cambio.name().equalsIgnoreCase(nombre)) {
                    cambio.resultadoCambio(this.vcProgramador, this, this.mProgramador);
                }
            }
        } catch (NumberFormatException ex) {
            this.vcProgramador.addTexto("");
            this.reset();
        }
        this.radioActual = this.radioPulsado.toUpperCase();
    }

    /**
     * Resetea todas las variables acumuladoras.
     */
    @Override
    public void reset() {
        super.reset();
        this.resultadoTransformado = "";
        this.numerosConvertidos.clear();
    }

    /**
     * Método encargado de descomponer la variable 'acumulador' e introducir
     * cada valor en la lista 'numeros', a coninuación, según el simbolo de la
     * operación realizara una operacion <strong>aritmética</strong> o de
     * <strong>cambio de base</strong>.
     */
    @Override
    public void controlOperacion() {
        try {            
            super.numeros.add(super.primerOperando);
            super.numeros.add(super.segundoOperando);

            if (bolDec) {
                super.resultado = super.iCommand.doit(numeros);
            } else if (bolHex) {
                for (String numero : numeros) {
                    numerosConvertidos.add(
                            this.mProgramador.hexadecimalDecimal(numero));
                }
                super.resultado = super.iCommand.doit(numerosConvertidos);
                this.resultadoTransformado = this.mProgramador.decimalHexadecimal(
                        String.valueOf((int) super.resultado));

            } else if (bolOct) {
                for (String numero : numeros) {
                    numerosConvertidos.add(
                            this.mProgramador.octalDecimal(numero));
                }
                super.resultado = super.iCommand.doit(numerosConvertidos);
                this.resultadoTransformado = this.mProgramador.decimalOctal(
                        String.valueOf((int) super.resultado));
            } else if (bolBin) {
                for (String numero : numeros) {
                    numerosConvertidos.add(
                            this.mProgramador.binarioDecimal(numero));
                }
                super.resultado = super.iCommand.doit(numerosConvertidos);
                this.resultadoTransformado = this.mProgramador.decimalBinario(
                        String.valueOf((int) super.resultado));
            }

            if (numerosConvertidos.isEmpty()) {
                this.vcProgramador.addTexto(String.valueOf((int) super.resultado) + ' ' + '=');
                super.setAcumulador(String.valueOf((int) super.resultado));
            } else {
                numeros.clear();
                this.vcProgramador.addTexto(resultadoTransformado.toUpperCase() + ' ' + '=');
                super.setAcumulador(resultadoTransformado.toUpperCase());
            }
            this.reset();
        } catch (IndexOutOfBoundsException | NumberFormatException ex) {
            this.reset();
            this.vcProgramador.mensajeError(ex);
        }
    }

    /**
     * Método en cargado de activar todos los botones de la calculadora.
     */
    public void activarBotones() {
        for (int i = 0; i < this.vcProgramador.getBotones().length; i++) {
            if (i == 3) {
                continue;
            } else {
                this.vcProgramador.getBotones()[i].setEnabled(true);
            }
        }
    }

    /**
     * Método encargado de establecer la base del número actual.
     *
     * @param bolHex Parámetro que dice si el número actual es hexadecimal o no.
     * @param bolDec Parámetro que dice si el número actual es decimal o no.
     * @param bolOct Parámetro que dice si el número actual es octal o no.
     * @param bolBin Parámetro que dice si el número actual es binario o no.
     */
    public void setOptionBase(boolean bolHex, boolean bolDec,
            boolean bolOct, boolean bolBin) {
        this.bolHex = bolHex;
        this.bolDec = bolDec;
        this.bolOct = bolOct;
        this.bolBin = bolBin;
    }

    /**
     * Método encargado de activar los botones 0 y 1 (teclado binario).
     */
    public void botonesBin() {
        this.activarBotones();
        for (int i = 1; i < 19; i++) {
            if (i == 3 || i == 7 || i == 11 || i == 12) {
                continue;
            } else {
                vcProgramador.getBotones()[i].setEnabled(false);
            }
        }
    }

    /**
     * Método encargado de activar los botones del 0 al 7 (teclado octal).
     */
    public void botonesOct() {
        this.activarBotones();
        for (int i = 9; i < 19; i++) {
            if (i == 11 || i == 12) {
                continue;
            } else {
                vcProgramador.getBotones()[i].setEnabled(false);
            }
        }
    }

    /**
     * Método encargado de activar los botones del 0 al 9 (teclado decimal).
     */
    public void botonesDec() {
        this.activarBotones();
        for (int i = 13; i < 19; i++) {
            vcProgramador.getBotones()[i].setEnabled(false);
        }
    }

    /**
     * Método que comprueba si en la pantalla hay un signo igual y lo retira de
     * la misma para realizar el cambio de base.
     */
    private void comprobarIgual() {
        if (vcProgramador.getCampoTexto().getText().contains("=")) {
            StringBuilder sb = new StringBuilder(vcProgramador.getCampoTexto().getText());
            super.setAcumulador(sb.substring(0, sb.length() - 2));
        }
    }
    
    public void setOperando(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if (this.vcProgramador.campoTextoIsEmpty()
                && btn.getText().equals("-")) {
            super.setAcumulador("-");
            this.vcProgramador.addTexto("-");
        } else {
            super.setPrimerOperando(super.getAcumulador());
            super.setAcumulador("");
        }
    }
}
