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

import calculadora.vista.primos.VistaCalcPrimos;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

/**
 *
 * @author Félix Marín Ramírez | felixmurcia@gmail.com
 */
public class ControlPrimos {

    private VistaCalcPrimos vcPrimos;
    private PrimosWorker pWorker;
    private SwingWorker sWorker;
    private int contador;
    private ArrayList<JProgressBar> listaBarras;

    /**
     * Constructor de la clase.
     *
     * @param vcPrimos Recibe como parametro un objeto tipo VistaCalcPrimos.
     */
    public ControlPrimos(VistaCalcPrimos vcPrimos) {
        this.vcPrimos = vcPrimos;
        this.contador = 0;
        this.listaBarras = new ArrayList<>();
    }

    /**
     *
     * @return Devuelve el número de Barras de progreso creadas.
     */
    public int getContador() {
        return contador;
    }

    /**
     * Método encargado de realizar operaciones pesadas en un hilo aparte de
     * tipo walker.
     *
     * @param evt Parámetro que corresponde a un evento.
     * @param posicion
     */
    public void jButton1ActionPerformed(ActionEvent evt, int posicion) {

        if (!listaBarras.isEmpty()) {
            pWorker = new PrimosWorker(vcPrimos, posicion, listaBarras.get(listaBarras.size() - 1));
            sWorker = pWorker.getWorker();
            sWorker.addPropertyChangeListener(pWorker);
            sWorker.execute();
            contador++;
        }
    }

    /**
     * Método encargado de añadir una nueva barra de progreso ya configurada por
     * el método newProgressBar situado en la clase VistaPrimTab2.
     */
    public void createProgressBar() {
        listaBarras.add(vcPrimos.getTab2().newProgressBar());
    }
}
