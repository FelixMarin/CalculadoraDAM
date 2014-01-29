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
package calculadora.vista.primos;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

/**
 *
 * @author Félix Marín Ramírez | felixmurcia@gmail.com
 */
public class VistaPrimTab2 extends JScrollPane {

    private JProgressBar[] arrayBarras;
    private JPanel panel;
    private int contador;

    /**
     * Constructur de la clase.
     */
    public VistaPrimTab2() {
        contador = 0;
        this.arrayBarras = new JProgressBar[100];
        this.panel = new JPanel();
        this.panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.getViewport().add(panel);
        this.setVisible(true);
    }

    /**
     *
     * @return Devuelve el objeto de tipo JScrollPane de la clase VistaPrimTab2.
     */
    public JScrollPane getJScrollPane() {
        return this;
    }

    /**
     *
     * @return Devuelve el objeto de tipo JPane de la clase VistaPrimTab2.
     */
    public JPanel getJPanel() {
        return panel;
    }  

    public JProgressBar newProgressBar() {
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setName("progress" + contador++);
        progressBar.setStringPainted(true);
        progressBar.setBackground(new java.awt.Color(204, 204, 204));
        progressBar.setForeground(new java.awt.Color(51, 51, 255));
        progressBar.setVisible(true);
        panel.add(progressBar);
        this.repaint();
        panel.validate();
        this.validate();
        return progressBar;
    }
}
