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
package calculadora.controlador.icommandSimple;

import calculadora.controlador.ICommand;
import calculadora.modelo.ModeloSimple;
import java.util.ArrayList;

/**
 *
 * @author Félix Marín Ramírez | felixmurcia@gmail.com
 */
public class ComandoRestar implements ICommand <Double>{

    private ModeloSimple mSimple;

    public ComandoRestar() {
        mSimple = new ModeloSimple();
    }

    @Override
    public Double doit(ArrayList<String> numeros) throws NumberFormatException {
        return this.mSimple.restar(
                Double.parseDouble(numeros.get(0).toString().trim()),
                Double.parseDouble(numeros.get(1).toString().trim()));
    }
}
