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

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Félix Marín Ramírez | felixmurcia@gmail.com
 */
public class VistaCalcPrimos extends JPanel {

    private JTabbedPane tabbeds;
    private VistaPrimTab1 tab1;
    private VistaPrimTab2 tab2;

    /**
     * Constructor de la clase.
     */
    public VistaCalcPrimos() {
        super(new GridLayout(1, 1));
        tab1 = new VistaPrimTab1(this);
        tab2 = new VistaPrimTab2();
        addPanelsToTab();

        this.crearPanel();
    }

    /**
     *
     * @return Devuelve el JPanel de VistaCalcPrimos.
     */
    public JPanel getJPanel() {
        return this;
    }

    /**
     *
     * @return Devuelve el primer tab del JTabbedPane situado en
     * VistaCalcPrimos.
     */
    public VistaPrimTab1 getTab1() {
        return tab1;
    }

    /**
     *
     * @return Devuelve el segundo tab del JTabbedPane situado en
     * VistaCalcPrimos.
     */
    public VistaPrimTab2 getTab2() {
        return tab2;
    }

    /**
     * Método que añade los JPanels de VistaPrimTab1 y VistaPrimTab2 al
     * JTabbedPane de VistaCalcPrimos.
     */
    private void addPanelsToTab() {
        tabbeds = new JTabbedPane();
        //--//
        tabbeds.addTab("Primos", tab1.getJPanel());
        //--//
        tabbeds.addTab("Progreso", tab2.getJScrollPane());
        //--//
        tabbeds.setVisible(true);
        this.add(tabbeds);
        tabbeds.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }

    private void crearPanel() {
        this.setName("Primos");
        this.setMinimumSize(new Dimension(509, 660));
        this.setVisible(true);
    }
    
    /**
     *
     * @param mensaje Variable de tipo String que se pasa como argumento y que
     * contiene el mensaje que se mostrará en la ventana.
     */
    public void mensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
