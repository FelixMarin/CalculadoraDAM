/*
 * Copyright (C) 2014 Félix Marín Ramírez | felixmurcia@gmail.com
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * DOCUMENTACION: http://documentacion-calculadora.tk
 */
package calculadora.controlador;

import java.util.ArrayList;

/**
 *
 * @param <T> Tipo del que será la interfaz a la hora de instanciarla.
 * @author Félix Marín Ramírez | felixmurcia@gmail.com
 */
public interface ICommand<T> {

    /**
     * Método encargado de enviar los operadores al modelo para que éste realice
     * la operación.
     *
     * @param numeros Array Parámetro de tipo ArrayList que contiene los operadores.
     * @return Devuelve resultado obtenido en la operación aritmética.
     */
    public T doit(ArrayList<String> numeros);
}
