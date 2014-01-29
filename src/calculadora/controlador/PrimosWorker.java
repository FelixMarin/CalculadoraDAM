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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

/**
 *
 * @author Félix Marín Ramírez | felixmurcia@gmail.com
 */
public class PrimosWorker extends SwingWorker<Integer, Integer> implements PropertyChangeListener {

    private VistaCalcPrimos vcPrimos;
    private int posicion;
    private int numInt;
    private JProgressBar bar;

    /**
     * Constructor de la clase.
     * @param vcPrimos Parámetro de tipo 
     * @param posicion
     * @param bar
     */
    public PrimosWorker(VistaCalcPrimos vcPrimos, int posicion, JProgressBar bar) {
        this.posicion = posicion;
        this.vcPrimos = vcPrimos;
        this.bar = bar;
    }

    /**
     *
     * @return
     */
    public SwingWorker getWorker() {
        return this;
    }

    /**
     *
     * @param posicion
     */
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    @Override
    public void done() {
        try {
            vcPrimos.getTab1().addTexto(vcPrimos.getTab1().getTxtArea().getText()
                    + "Posición "
                    + posicion
                    + " --> Número "
                    + String.valueOf(get()));

        } catch (InterruptedException | ExecutionException ignore) {
            vcPrimos.getTab1().mensajeError(ignore);
        }
    }

    @Override
    protected Integer doInBackground() throws Exception {

        int i, j;
        final int MAX = 10000;
        boolean[] esPrimo = new boolean[MAX];
        int[] primos = new int[MAX];
        // Se inicializa la tabla
        esPrimo[0] = false;
        for (i = 0; i < MAX; i++) {
            esPrimo[i] = true;
        }
        // Empieza la criba 
        for (i = 2; i <= (MAX / 2); i++) {
            for (j = 2; j <= (MAX / i); j++) {
                esPrimo[i * j - 1] = false;
            }
        }
        // Se cuenta el número de primos encontrados
        for (i = 1; i <= posicion; i++) {
            if (esPrimo[i]) {
                numInt++;
            }
            if (posicion > 100) {
                Thread.sleep(100);
                publish(i / 10);
                setProgress(i / 10);
            } else {
                Thread.sleep(1000);
                publish(i);
                setProgress(i);
            }
        }
        int cont = 0;
        for (i = 1; i < MAX; i++) {
            if (esPrimo[i]) {
                primos[cont++] = i + 1;
            }
        }
        if (posicion == 0) {
            posicion++;
        }

        setProgress(100);
        return primos[posicion - 1];
    }

    @Override
    public void process(List<Integer> values) {
        // Estoy en el hilo de eventos 
        // => puedo modificar la interfaz
        for (int i = 0; i < values.size(); i++) {
            Integer d = values.get(i);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("progress".equals(evt.getPropertyName())) {
            int progress = (Integer) evt.getNewValue();
            this.bar.setValue(progress);
        }
    }
}
