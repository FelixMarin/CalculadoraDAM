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
package calculadora;

import calculadora.vista.Vista;
import javax.swing.SwingUtilities;

/**
 * Clase princpal encargada de ejecutar el programa.
 *
 * @author Félix Marín Ramírez | felixmurcia@gmail.com
 * @version 1.0
 */
public class Principal {

    /**
     * Método encargado de ejecutar la aplicación.
     *
     * @param args No recibe ningún argumento de inicio
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Vista vista = new Vista();
            }
        });
    }
}
