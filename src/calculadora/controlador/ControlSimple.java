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

import calculadora.vista.VistaCalcSimple;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author Félix Marín Ramírez | felixmurcia@gmail.com
 * @version 1.0
 */
public class ControlSimple extends Control implements ActionListener {

    private VistaCalcSimple vcSimple;
    private String result;

    /**
     * Constructor de la clase encargado de crear todos los elementos necesarios
     * para que la clase sea funcional.
     *
     * @param vcSimple Parámetro de tipo <strong>VistaCalcSimple</strong>, el
     * cual, se le pasa como argumento al constructor de la clase.
     */
    public ControlSimple(VistaCalcSimple vcSimple) {
        this.vcSimple = vcSimple;
        super.acumulador = "";
        super.numeros = new ArrayList();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.numberSizeControl()) {
            //DO NOTHIG
        } else {
            JButton btn = (JButton) e.getSource();
            super.acumulador += btn.getText();
            vcSimple.getCampoTexto().setText("");
            vcSimple.getCampoTexto().setText(super.nf.format(Double.parseDouble(super.acumulador)));
        }
    }

    /**
     * Método encargado de descomponer la variable 'acumulador' e introducir
     * cada valor en la lista 'numeros', a coninuación, según el simbolo de la
     * operación realizara una operacion <strong>aritmética</strong> básicas.
     */
    @Override
    public void controlOperacion() {
        result = realizarOperacion();
        if (super.numeros.size() > 2) {
            vcSimple.getCampoTexto().setText("");
        } else {
            this.vcSimple.addTexto(result + ' ' + '=');
        }
        super.reset();
    }

    public void setOperando(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if (vcSimple.campoTextoIsEmpty()
                && btn.getText().equals("-")) {
            this.setAcumulador("-");
            vcSimple.addTexto("-");
        } else {
            this.setPrimerOperando(this.getAcumulador());
            this.setAcumulador("");
        }
    }
}
