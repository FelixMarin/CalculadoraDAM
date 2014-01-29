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

import calculadora.controlador.ControlProgramador;
import calculadora.controlador.icommandSimple.ComandoMultiplicar;
import calculadora.controlador.icommandSimple.ComandoRestar;
import calculadora.controlador.icommandSimple.ComandoSumar;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

/**
 *
 * @author Félix Marín Ramírez | felixmurcia@gmail.com
 * @version 1.0
 */
public final class VistaCalcProgramador extends JPanel implements Implementable {

    private ControlProgramador cProgramador;
    private VistaCalcSimple vcSimple;
    private GridBagLayout layout;
    private GridBagConstraints constraints;
    private JSeparator separador;
    private JFormattedTextField campoTexto;
    private final JButton[] BOTONES;
    private ButtonGroup radioGrupo;
    private JRadioButton rdHex;
    private JRadioButton rdDec;
    private JRadioButton rdOct;
    private JRadioButton rdBin;
    //--//

    /**
     * Constructor de la clase encargado de crear todos los elementos necesarios
     * para que la clase sea funcional.
     *
     * @param vista Párametro a través del cual se le pasa al constructor una
     * instacia de la clase Vista.
     */
    public VistaCalcProgramador(Vista vista) {
        this.cProgramador = new ControlProgramador(this);
        this.vcSimple = new VistaCalcSimple(vista);
        this.establecerLayout();
        this.campoTexto = vista.crearPantalla(constraints, this);
        this.BOTONES = arrayBotones();
        this.setRadioGroup();
        this.addRadiosToPanel();
        this.setSeparator();
        this.addButtonsToPanel();
        this.addMnemonics();
        this.defaultKey();
        this.addListeners();
        this.BOTONES[20].requestFocusInWindow();
    }

    /**
     *
     * @return Devuelve una instancia del JPanel que representa esta clase.
     */
    @Override
    public JPanel getJPanel() {
        return this;
    }

    /**
     * Método con el que obtendremos el area de texto para poder módificar el
     * contenido.
     *
     * @return Devuelve un objeto JTextArea.
     */
    @Override
    public JFormattedTextField getCampoTexto() {
        return this.campoTexto;
    }

    /**
     *
     * @return Devuelve el array de botones.
     */
    public JButton[] getBotones() {
        return this.BOTONES;
    }

    /**
     * Método que devueve la instancia a la clase controlador
     * ControlProgramador.
     *
     * @return Devueve la instancia a la clase controlador ControlProgramador.
     */
    public ControlProgramador getControlProgramador() {
        return this.cProgramador;
    }

    /**
     *
     * @return Devuelve el radio button de la opción hexadecimal.
     */
    public JRadioButton getRdHex() {
        return this.rdHex;
    }

    /**
     *
     * @return Devuelve el radio button de la opción decimal.
     */
    public JRadioButton getRdDec() {
        return this.rdDec;
    }

    /**
     *
     * @return Devuelve el radio button de la opción octal.
     */
    public JRadioButton getRdOct() {
        return this.rdOct;
    }

    /**
     *
     * @return Devuelve el radio button de la opción binaria.
     */
    public JRadioButton getRdBin() {
        return this.rdBin;
    }

    /**
     * Método sobreescrito, en el cual, se configura el layout del JPanel.
     */
    @Override
    public void establecerLayout() {
        this.layout = new GridBagLayout();
        this.constraints = new GridBagConstraints();
        this.constraints.insets = new Insets(3, 3, 3, 3);
        this.constraints.fill = GridBagConstraints.BOTH;
        this.constraints.weightx = 1.0;
        this.constraints.weighty = 1.0;
        this.layout.setConstraints(this, constraints);
        this.setLayout(layout);
    }

    /**
     * Método encargado de crear y configurar los radio buttons para,
     * posteriormente, añadirlos al radio group.
     */
    public void setRadioGroup() {
        this.rdHex = new JRadioButton("Hex");
        this.rdDec = new JRadioButton("Dec");
        this.rdOct = new JRadioButton("Oct");
        this.rdBin = new JRadioButton("Bin");
        //--//       
        this.rdHex.add(new JSeparator(SwingConstants.HORIZONTAL));
        this.rdHex.setSelected(true);
        this.rdDec.add(new JSeparator(SwingConstants.HORIZONTAL));
        this.rdOct.add(new JSeparator(SwingConstants.HORIZONTAL));
        this.rdBin.add(new JSeparator(SwingConstants.HORIZONTAL));
        //--//
        this.radioGrupo = new ButtonGroup();
        this.radioGrupo.add(rdHex);
        this.radioGrupo.add(rdDec);
        this.radioGrupo.add(rdOct);
        this.radioGrupo.add(rdBin);
    }

    /**
     * Método que añade los radio buttons al JPanel a través del método privado
     * addRadio.
     */
    public void addRadiosToPanel() {
        this.addRadio(rdHex, constraints, 0, 3);
        this.addRadio(rdDec, constraints, 1, 3);
        this.addRadio(rdOct, constraints, 2, 3);
        this.addRadio(rdBin, constraints, 3, 3);

    }

    private void addRadio(JRadioButton radio, GridBagConstraints gbc,
            int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.ipadx = 20;
        gbc.ipady = 40;
        radio.setFont(new Font("sanserif", Font.BOLD, 15));
        radio.addActionListener(this.cProgramador);
        this.add(radio, gbc);
    }

    /**
     * Método que configura los botones de la calculadora a través del método
     * addButton.
     */
    @Override
    public void addButtonsToPanel() {
        this.addButton(BOTONES[0], 0, 5, cProgramador, 1); // botón 1
        this.addButton(BOTONES[1], 1, 5, cProgramador, 1); //botón 2
        this.addButton(BOTONES[2], 2, 5, cProgramador, 1); //botón 3
        this.addButton(BOTONES[3], 3, 5, null, 1); // Clear
        this.addButton(BOTONES[4], 0, 6, cProgramador, 1); //botón 4
        this.addButton(BOTONES[5], 1, 6, cProgramador, 1); //botón 5
        this.addButton(BOTONES[6], 2, 6, cProgramador, 1); //botón 6   
        this.addButton(BOTONES[7], 3, 6, null, 1); // multiplicación
        this.addButton(BOTONES[8], 0, 7, cProgramador, 1); //botón 7
        this.addButton(BOTONES[9], 1, 7, cProgramador, 1); //botón 8
        this.addButton(BOTONES[10], 2, 7, cProgramador, 1); // botón 9
        this.addButton(BOTONES[11], 3, 7, null, 1); // resta
        this.addButton(BOTONES[12], 0, 8, cProgramador, 1); // botón 0
        this.addButton(BOTONES[13], 1, 8, cProgramador, 1); // botón A
        this.addButton(BOTONES[14], 2, 8, cProgramador, 1); // botón B
        this.addButton(BOTONES[15], 0, 9, cProgramador, 1); // botón C
        this.addButton(BOTONES[16], 1, 9, cProgramador, 1); // botón D
        this.addButton(BOTONES[17], 2, 9, cProgramador, 1); // botón E
        this.addButton(BOTONES[18], 3, 9, cProgramador, 1); // botón F
        this.addButton(BOTONES[19], 3, 8, null, 1); // suma
        this.addButton(BOTONES[20], 0, 10, null, 4); // igual
    }

    /**
     *
     * @return Devuelve un array con todos los botones.
     */
    public JButton[] arrayBotones() {
        JButton[] bot = {
            this.vcSimple.getBotones()[0],//[0]
            this.vcSimple.getBotones()[1],//[1]
            this.vcSimple.getBotones()[2],//[2]
            new JButton("Cl"),//[3]
            this.vcSimple.getBotones()[4],//[4]
            this.vcSimple.getBotones()[5],//[5]
            this.vcSimple.getBotones()[6],//[6]
            this.vcSimple.getBotones()[7],//[7]
            this.vcSimple.getBotones()[8],//[8]
            this.vcSimple.getBotones()[9],//[9]
            this.vcSimple.getBotones()[10],//[10]
            this.vcSimple.getBotones()[11],//[11]
            this.vcSimple.getBotones()[12],//[12]
            new JButton("A"),//[13]
            new JButton("B"),//[14]
            new JButton("C"),//[15]
            new JButton("D"),//[16]
            new JButton("E"),//[17]
            new JButton("F"),//[18]
            this.vcSimple.getBotones()[15],//[19]
            this.vcSimple.getBotones()[16]};//[20]

        return bot;
    }

    /**
     * Método que crea un separador y lo añade al JPanel.
     */
    @Override
    public void setSeparator() {
        this.separador = new JSeparator();
        this.constraints.gridx = 0;
        this.constraints.gridy = 4;
        this.constraints.gridheight = 1;
        this.constraints.gridwidth = 4;
        this.constraints.ipadx = 20;
        this.constraints.ipady = 15;
        this.add(separador, constraints);

    }

    /**
     * Método que prepara e inserta los botones numéricos en la posición
     * indicada en las coordenadas x e y.
     *
     * @param boton Parámetro de tipo JButton que cotiene el botón que será
     * insertado en el contenedor.
     * @param constraints Parámetro con el que indicaremos la posición final del
     * botón.
     * @param x Posición con respecto al eje x en la que se insertará el botón.
     * @param y Posición con respecto al eje y en la que se insertará el botón.
     * @param al Argumento que contiene la clase listener para el componente.
     * @param ancho Ancho que tendrá el componente.
     */
    private void addButton(JButton boton,
            int x, int y, ActionListener al, int ancho) {
        this.constraints.gridx = x;
        this.constraints.gridy = y;
        this.constraints.gridheight = 1;
        this.constraints.gridwidth = ancho;
        this.constraints.ipadx = 20;
        this.constraints.ipady = 20;
        boton.setFont(new Font("sanserif", Font.BOLD, 25));
        boton.addActionListener(al);
        this.add(boton, constraints);
    }

    /**
     * Método en el cual se configuran los listeners de los componentes que lo
     * necesiten.
     */
    @Override
    public void addListeners() {
        // CLEAR
        this.BOTONES[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campoTexto.setText("");
                cProgramador.reset();
            }
        });
        // FIN CLEAR        

        // MULTIPLICACION       
        this.BOTONES[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cProgramador.setOperando(e);
                cProgramador.setICommand(new ComandoMultiplicar());
            }
        });
        // FIN MULTIPLICACION

        // RESTA
        this.BOTONES[11].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //setAcumulador('-');
                cProgramador.setOperando(e);
                cProgramador.setICommand(new ComandoRestar());
            }
        });
        //FIN RESTA

        // SUMA
        this.BOTONES[19].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cProgramador.setOperando(e);
                cProgramador.setICommand(new ComandoSumar());
            }
        });
        //FIN SUMA       

        //IGUAL
        this.BOTONES[20].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cProgramador.setSegundoOperando(cProgramador.getAcumulador());
                cProgramador.setAcumulador("");
                addTexto("");
                if (cProgramador.getICommand() != null) {
                    cProgramador.controlOperacion();
                }
            }
        });
    }

    /**
     * Método Untilizado para añadir los mnemonicos a los componentes de la
     * calculdaora.
     */
    @Override
    public void addMnemonics() {
        this.BOTONES[3].setMnemonic(KeyEvent.VK_L);
        this.BOTONES[13].setMnemonic(KeyEvent.VK_A);
        this.BOTONES[14].setMnemonic(KeyEvent.VK_B);
        this.BOTONES[15].setMnemonic(KeyEvent.VK_C);
        this.BOTONES[16].setMnemonic(KeyEvent.VK_D);
        this.BOTONES[17].setMnemonic(KeyEvent.VK_E);
        this.BOTONES[18].setMnemonic(KeyEvent.VK_F);
        this.rdHex.setMnemonic(KeyEvent.VK_H);
        this.rdDec.setMnemonic(KeyEvent.VK_M);
        this.rdOct.setMnemonic(KeyEvent.VK_O);
        this.rdBin.setMnemonic(KeyEvent.VK_N);
    }

    private void defaultKey() {
        InputMap im = BOTONES[20].getInputMap();
        im.put(KeyStroke.getKeyStroke("ENTER"), "pressed");
        im.put(KeyStroke.getKeyStroke("released ENTER"), "released");
    }

    /**
     * Método a través del cual se puede añadir un texto al campo de texto que
     * representa la pantalla de la calculadora.
     *
     * @param cadena Texto que será mostrado en el campo de texto.
     */
    @Override
    public void addTexto(String cadena) {
        this.campoTexto.setText(cadena);
    }

    /**
     * Método que lanza un mensaje de error en un JOptionPane
     *
     * @param ex Argumento de tipo Exception del cual obtenemos el mensaje de
     * error de una excepción.
     */
    @Override
    public void mensajeError(Exception ex) {
        JOptionPane.showMessageDialog(null,
                "La operación introducida no es válida\n "
                + ex.getMessage(), "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    public boolean campoTextoIsEmpty() {
        if (this.campoTexto.getText().equals("")) {
            return true;
        } else {
            return false;
        }
    }
}
