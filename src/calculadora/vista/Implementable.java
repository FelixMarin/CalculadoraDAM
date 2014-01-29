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
package calculadora.vista;

import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Félix Marín Ramírez | felixmurcia@gmail.com
 * @version 1.0
 */
public interface Implementable {

    /**
     *
     * @return Devuelve el JPanel de la clase en la que se implementa.
     */
    public JPanel getJPanel();

    /**
     * Método que debe ser definido y en el cual se configura el layout de la
     * clase en la que se implementa.
     */
    public void establecerLayout();

    /**
     * Método que debe ser definido y en el cual se configuran los listeners de
     * los componentes que lo necesiten.
     */
    public void addListeners();

    /**
     * Método utilizado para devolver el campo de texto correspondiente a la
     * pantalla de la calculadora;
     *
     * @return Devuelve un campo de texto.
     */
    public JTextField getCampoTexto();

    /**
     * Método Untilizado para añadir los mnemonicos a los componentes de la
     * calculdaora.
     */
    public void addMnemonics();

    /**
     * Método utlizado para añadir una cadena al campo de texto correspondiente
     * a la pantalla de la calculadora.
     *
     * @param cadena
     */
    public void addTexto(String cadena);

    /**
     * Método encargado de mostrar un error mediante una ventana emergente.
     *
     * @param ex Pátametro de tipo Exception el cual contiene la descripción del
     * error producido.
     */
    public void mensajeError(Exception ex);

    /**
     * Método utilizado para agregar los botones un JPanel.
     */
    public void addButtonsToPanel();

    /**
     * Metodo que sirve para añadir un espacio.
     */
    public void setSeparator();

    /**
     * Método que inserta el operador en el campo de texto y añade dicho
     * operador en la variable operación de la clase ControlProgramador.
     *
     * @param c El símbolo de la operación (+,-,/,*)
     */
    //public void setAcumulador(char c);
}
