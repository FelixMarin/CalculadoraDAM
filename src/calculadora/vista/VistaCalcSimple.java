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

import calculadora.controlador.ControlSimple;
import calculadora.controlador.icommandSimple.ComandoDividir;
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
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 *
 * @author Félix Marín Ramírez | felixmurcia@gmail.com
 * @version 1.0
 */
public final class VistaCalcSimple extends JPanel implements Implementable {
    
    private ControlSimple cSimple;
    private GridBagLayout layout;
    private GridBagConstraints constraints;
    private JFormattedTextField campoTexto;
    private Vista vista;
    private JButton[] botones;

    /**
     * Constructor de la clase encargado de crear todos los elementos necesarios
     * para que la clase sea funcional.
     *
     * @param vista Párametro a través del cual se le pasa al constructor una
     * instacia de la clase Vista.
     */
    public VistaCalcSimple(Vista vista) {
        this.botones = arrayBotones();
        this.vista = vista;
        this.cSimple = new ControlSimple(this);
        this.establecerLayout();
        this.campoTexto = vista.crearPantalla(constraints, this);
        this.campoTexto.setText("");
        this.addButtonsToPanel();
        this.addMnemonics();
        this.defaultKey();
        this.addListeners();
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
     *
     * @return Devuelve un array con todos los botones.
     */
    public JButton[] getBotones() {
        return this.botones;
    }

    /**
     * Método que crea y añade los botones a un array de botones.
     *
     * @return Devuelve un array con todos los botones.
     */
    public JButton[] arrayBotones() {
        JButton[] bot = {
            new JButton("1"),//[0]
            new JButton("2"),//[1]
            new JButton("3"),//[2]
            new JButton("/"),//[3]
            new JButton("4"),//[4]
            new JButton("5"),//[5]
            new JButton("6"),//[6]
            new JButton("*"),//[7]
            new JButton("7"),//[8]
            new JButton("8"),//[9]
            new JButton("9"),//[10]
            new JButton("-"),//[11]
            new JButton("0"),//[12]
            new JButton(","),//[13]
            new JButton("C"),//[14]
            new JButton("+"),//[15]
            new JButton("=")};//[16]
        return bot;
    }

    /**
     * Método que devueve la instancia a la clase controlador ControlSimple.
     *
     * @return Devueve la instancia a la clase controlador ControlSimple.
     */
    public ControlSimple getControlSimple() {
        return cSimple;
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
        this.layout.setConstraints(this, this.constraints);
        this.setLayout(this.layout);
    }

    /**
     * Método que configura los botones de la calculadora a través del método
     * addButton.
     */
    @Override
    public void addButtonsToPanel() {
        this.addButton(this.getBotones()[0], 0, 4, cSimple, 1); // botón 1
        this.addButton(this.getBotones()[1], 1, 4, cSimple, 1); //botón 2
        this.addButton(this.getBotones()[2], 2, 4, cSimple, 1); //botón 3
        this.addButton(this.getBotones()[3], 3, 4, null, 1); // division
        this.addButton(this.getBotones()[4], 0, 5, cSimple, 1); //botón 4
        this.addButton(this.getBotones()[5], 1, 5, cSimple, 1); //botón 5
        this.addButton(this.getBotones()[6], 2, 5, cSimple, 1); //botón 6
        this.addButton(this.getBotones()[7], 3, 5, null, 1); // multiplicación
        this.addButton(this.getBotones()[8], 0, 6, cSimple, 1); //botón 7
        this.addButton(this.getBotones()[9], 1, 6, cSimple, 1); //botón 8
        this.addButton(this.getBotones()[10], 2, 6, cSimple, 1); // botón 9
        this.addButton(this.getBotones()[11], 3, 6, null, 1); // resta
        this.addButton(this.getBotones()[12], 0, 7, cSimple, 1); // botón 0
        this.addButton(this.getBotones()[13], 1, 7, null, 1); // coma
        this.addButton(this.getBotones()[14], 2, 7, null, 1); // clear
        this.addButton(this.getBotones()[15], 3, 7, null, 1); // suma
        this.addButton(this.getBotones()[16], 0, 8, null, 4); // igual
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
    
    @Override
    public void setSeparator() {
        // DO NOTHING
    }

    /**
     * Método en el cual se configuran los listeners de los componentes que lo
     * necesiten.
     */
    @Override
    public void addListeners() {

        // DIVISION
        this.botones[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //setAcumulador('/');
                cSimple.setOperando(e);
                cSimple.setICommand(new ComandoDividir());
            }
        });
        // FIN DIVISION

        // MULTIPLICACION
        this.botones[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //setAcumulador('*');
                cSimple.setOperando(e);
                cSimple.setICommand(new ComandoMultiplicar());
                
            }
        });
        // FIN MULTIPLICACION

        // RESTA
        this.botones[11].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //setAcumulador('-');
                cSimple.setOperando(e);
                cSimple.setICommand(new ComandoRestar());
                
            }
        });
        //FIN RESTA


        // COMA
        this.botones[13].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton) e.getSource();
                if (btn.getText().equals(",")) {
                    cSimple.setAcumulador(cSimple.getAcumulador() + ".");
                    getCampoTexto().setText("");
                    getCampoTexto().setText(cSimple.getAcumulador());
                }
            }
        });
        //FIN COMA

        // CLEAR
        this.botones[14].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getCampoTexto().setText("");
                cSimple.reset();
            }
        });
        //FIN CLEAR

        // SUMA
        this.botones[15].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //setAcumulador('+');
                cSimple.setOperando(e);
                cSimple.setICommand(new ComandoSumar());
            }
        });
        //FIN SUMA

        //IGUAL
        this.botones[16].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cSimple.setSegundoOperando(cSimple.getAcumulador());
                cSimple.setAcumulador("");
                addTexto("");
                if (getCampoTexto().getText().contains("=")) {
                    cSimple.reset();
                }
                cSimple.controlOperacion();
            }
        });
        // FIN IGUAL
    }

    /**
     * Método Untilizado para añadir los mnemonicos a los componentes de la
     * calculdaora.
     */
    @Override
    public void addMnemonics() {
        this.botones[0].setMnemonic(KeyEvent.VK_1);
        this.botones[1].setMnemonic(KeyEvent.VK_2);
        this.botones[2].setMnemonic(KeyEvent.VK_3);
        this.botones[3].setMnemonic(KeyEvent.VK_DIVIDE);
        this.botones[4].setMnemonic(KeyEvent.VK_4);
        this.botones[5].setMnemonic(KeyEvent.VK_5);
        this.botones[6].setMnemonic(KeyEvent.VK_6);
        this.botones[7].setMnemonic(KeyEvent.VK_MULTIPLY);
        this.botones[8].setMnemonic(KeyEvent.VK_7);
        this.botones[9].setMnemonic(KeyEvent.VK_8);
        this.botones[10].setMnemonic(KeyEvent.VK_9);
        this.botones[11].setMnemonic(KeyEvent.VK_MINUS);
        this.botones[12].setMnemonic(KeyEvent.VK_0);
        this.botones[13].setMnemonic(KeyEvent.VK_COMMA);
        this.botones[14].setMnemonic(KeyEvent.VK_DELETE);
        this.botones[15].setMnemonic(KeyEvent.VK_PLUS);
        this.botones[16].setMnemonic(KeyEvent.VK_ENTER);
    }
    
    private void defaultKey() {
        InputMap im = this.botones[16].getInputMap();
        im.put(KeyStroke.getKeyStroke("ENTER"), "pressed");
        im.put(KeyStroke.getKeyStroke("released ENTER"), "released");
    }
    
    public boolean campoTextoIsEmpty() {
        if (this.campoTexto.getText().equals("")) {
            return true;
        } else {
            return false;
        }
    }
}
