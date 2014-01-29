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
package calculadora.controlador.icommandCientifica;

import calculadora.controlador.ICommand;
import calculadora.modelo.ModeloCientifica;
import java.util.ArrayList;

/**
 *
 * @author Félix Marín Ramírez | felixmurcia@gmail.com
 */
public class ComandoAnd implements ICommand<Boolean> {
    
    private ModeloCientifica mCientifica;

    /**
     * Constructor de la clase.
     */
    public ComandoAnd() {
        mCientifica = new ModeloCientifica();
    }

    @Override
    public Boolean doit(ArrayList<String> booleanos) throws NumberFormatException {
        return mCientifica.and(
                Boolean.parseBoolean(booleanos.get(0).toString().trim()),
                Boolean.parseBoolean(booleanos.get(1).toString().trim()));        
    }    
}
