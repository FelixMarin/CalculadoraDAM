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

import calculadora.controlador.ControlPrimos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

/**
 *
 * @author Félix Marín Ramírez | felixmurcia@gmail.com
 */
public final class VistaPrimTab1 extends JPanel {

    private ControlPrimos cPrimos;
    //--//
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    private JScrollPane scroll;
    //--//
    private JSpinner spPrimos;
    private JTextArea txtArea;
    private JLabel lbInsertar;
    private ImageIcon icon;
    private JSeparator separador;
    private JButton btnStart;

    /**
     * Contructor de la clase.
     *
     * @param vcPrimos Parametro de tipo VistaCalcPrimos.
     */
    public VistaPrimTab1(VistaCalcPrimos vcPrimos) {
        cPrimos = new ControlPrimos(vcPrimos);
        this.establecerLayout();
        this.configComps();
        this.addMnemonics();
        this.addListeners();
        this.crearPanel();
    }

    /**
     *
     * @return Devuelve el JPanel de VistaPrimTab1.
     */
    public JPanel getJPanel() {
        return this;
    }

    /**
     *
     * @return Devuelve el área de texto.
     */
    public JTextArea getTxtArea() {
        return txtArea;
    }

    /**
     *
     * @param txtArea Establece el área de texto
     */
    public void setTxtArea(JTextArea txtArea) {
        this.txtArea = txtArea;
    }

    /**
     *
     * @return Devuelve el spinner.
     */
    public JSpinner getSpPrimos() {
        return spPrimos;
    }

    /**
     *
     * @param spPrimos Establece un nuevo objeto de tipo JSpinner.
     */
    public void setSpPrimos(JSpinner spPrimos) {
        this.spPrimos = spPrimos;
    }

    /**
     * Método encargado de establecer las dimesiones del JPanel y de hacerlo
     * visible.
     */
    public void crearPanel() {
        this.setName("Numeros Primos");
        this.setMinimumSize(new Dimension(509, 660));
        this.setVisible(true);
    }

    /**
     * Método encargado de establecer y configurar el layout del JPanel.
     */
    private void establecerLayout() {
        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbl.setConstraints(this, gbc);
        this.setLayout(gbl);
    }

    /**
     * Método que stablece parámetros al objeto de tipo GridBagConstraints, los
     * cuales, sirven para indicar la posición del un elemento en la aplicación.
     *
     * @param x Parámetro que representa la posición X del elemento.
     * @param y Parámetro que representa la posición Y del elemento.
     * @param ancho Parámetro que representa el ancho del elemento.
     */
    private void setConstraints(int x, int y, int ancho) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridheight = 1;
        gbc.gridwidth = ancho;
        gbc.ipadx = 20;
        gbc.ipady = 20;
    }

    /**
     * Método encargado de crear y configurar los objetos instanciados.
     */
    private void configComps() {
        this.setConstraints(0, 0, 1);
        lbInsertar = new JLabel("  Seleccione un número -->");
        lbInsertar.setFont(new Font("sans", Font.BOLD, 17));
        this.add(lbInsertar, gbc);
        //--//
        this.setConstraints(1, 0, 2);
        spPrimos = new JSpinner();
        spPrimos.setFont(new Font("sans", Font.BOLD, 17));
        this.add(spPrimos, gbc);
        //--//
        this.setConstraints(0, 2, 3);
        txtArea = new JTextArea();
        txtArea.setBackground(Color.BLACK);
        txtArea.setForeground(Color.WHITE);
        txtArea.setFont(new Font("sans", Font.BOLD, 16));
        txtArea.setEditable(false);
        this.scroll = new JScrollPane(txtArea);
        this.scroll.setVerticalScrollBar(new JScrollBar(JScrollBar.VERTICAL, 1, 10, 0, 100));
        gbc.ipady = 350;
        this.add(scroll, gbc);
        //--//
        this.addButtonsToPanel();
    }

    /**
     *
     */
    private void addListeners() {
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = (int) spPrimos.getValue();
                if (num <= 0) {
                    mensajeError("El valor mínimo es 1");
                } else if (num > 1009) {
                    mensajeError("Límite sobrepasado. Valor máximo: 1009");
                } else {
                    cPrimos.createProgressBar();

                    cPrimos.jButton1ActionPerformed(e, num);
                }
            }
        });
    }

    /**
     * Método Untilizado para añadir los mnemonicos a los componentes de la
     * calculdaora.
     */
    private void addMnemonics() {
        btnStart.setMnemonic(KeyEvent.VK_S);
    }

    /**
     * Método a través del cual se puede añadir un texto al campo de texto.
     *
     * @param cadena Texto que será mostrado en el campo de texto.
     */
    public void addTexto(String cadena) {
        txtArea.setText(cadena + "\n");
    }

    /**
     * Método que lanza un mensaje de error en un JOptionPane
     *
     * @param ex Argumento de tipo Exception del cual obtenemos el mensaje de
     * error de una excepción.
     */
    public void mensajeError(Exception ex) {
        JOptionPane.showMessageDialog(null,
                "La operación introducida no es válida\n "
                + ex.getMessage(), "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    /**
     *
     * @param mensaje Variable de tipo String que se pasa como argumento y que
     * contiene el mensaje que se mostrará en la ventana.
     */
    public static void mensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null,
                mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Método que crea, cofigura y añade el botón a la aplicación.
     */
    private void addButtonsToPanel() {
        this.setConstraints(2, 3, 1);
        btnStart = new JButton("Start");
        this.add(btnStart, gbc);
    }
}
