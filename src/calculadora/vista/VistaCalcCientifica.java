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

import calculadora.controlador.ControlCientifica;
import calculadora.controlador.icommandCientifica.ComandoAnd;
import calculadora.controlador.icommandCientifica.ComandoCoseno;
import calculadora.controlador.icommandCientifica.ComandoNot;
import calculadora.controlador.icommandCientifica.ComandoOr;
import calculadora.controlador.icommandCientifica.ComandoPotencia;
import calculadora.controlador.icommandCientifica.ComandoRaiz;
import calculadora.controlador.icommandCientifica.ComandoSeno;
import calculadora.controlador.icommandCientifica.ComandoTangente;
import calculadora.controlador.icommandCientifica.ComandoXor;
import calculadora.controlador.icommandSimple.ComandoDividir;
import calculadora.controlador.icommandSimple.ComandoMultiplicar;
import calculadora.controlador.icommandSimple.ComandoRestar;
import calculadora.controlador.icommandSimple.ComandoSumar;
import java.awt.Dimension;
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
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

/**
 *
 * @author Félix Marín Ramírez | felixmurcia@gmail.com
 * @version 1.0
 */
public final class VistaCalcCientifica extends JPanel implements Implementable {

    private GridBagLayout layout;
    private ControlCientifica cCientifica;
    private VistaCalcSimple vcSimple;
    private GridBagConstraints constraints;
    private JFormattedTextField campoTexto;
    private JSeparator separador;
    private final JButton[] BOTONES;

    /**
     * Constructor de la clase encargado de crear todos los elementos necesarios
     * para que la clase sea funcional.
     *
     * @param vista Párametro a través del cual se le pasa al constructor una
     * instacia de la clase Vista.
     */
    public VistaCalcCientifica(Vista vista) {
        this.cCientifica = new ControlCientifica(this);
        this.vcSimple = new VistaCalcSimple(vista);
        this.BOTONES = arrayBotones();
        this.setSize(new Dimension(508, 659));
        this.establecerLayout();
        this.campoTexto = vista.crearPantalla(constraints, this);
        this.campoTexto.setText("");
        this.addButtonsToPanel();
        this.setSeparator();
        this.addMnemonics();
        this.defaultKey();
        this.addListeners();
        this.BOTONES[27].requestFocusInWindow();
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

    /**
     * Método que devueve la instancia a la clase controlador ControlCientifica.
     *
     * @return Devueve la instancia a la clase controlador ControlCientifica.
     */
    public ControlCientifica getControlCientifica() {
        return cCientifica;
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
        constraints.weighty = 1.0;
        this.layout.setConstraints(this, this.constraints);
        this.setLayout(this.layout);
    }

    /**
     * Método que configura los botones de la calculadora a través del método
     * addButton.
     */
    @Override
    public void addButtonsToPanel() {

        this.addButton(BOTONES[0], 0, 3, null); // botón x elevado a n
        this.addButton(BOTONES[1], 1, 3, null); //botón raiz
        this.addButton(BOTONES[2], 2, 3, null); //botón Sin
        this.addButton(BOTONES[3], 3, 3, null); // botón Cos
        this.addButton(BOTONES[4], 0, 4, null); //botón tan
        this.addButton(BOTONES[5], 1, 4, null); //botón AND
        this.addButton(BOTONES[6], 2, 4, null); //botón OR   
        this.addButton(BOTONES[7], 3, 4, null); // botón NOT
        this.addButton(BOTONES[8], 0, 5, null); //botón XOR
        this.addButton(BOTONES[9], 1, 5, null); //botón /
        this.addButton(BOTONES[10], 2, 5, null); // botón *
        this.addButton(BOTONES[11], 3, 5, null); // botón -
        this.addButton(BOTONES[12], 0, 6, null); // botón +
        this.addButton(BOTONES[13], 1, 6, null); // botón True
        this.addButton(BOTONES[14], 2, 6, null); // botón False
        this.addButton(BOTONES[15], 3, 6, null); // botón C        
        this.addButton(BOTONES[16], 0, 8, cCientifica); // botón 1
        this.addButton(BOTONES[17], 1, 8, cCientifica); // botón 2
        this.addButton(BOTONES[18], 2, 8, cCientifica); // botón 3
        this.addButton(BOTONES[19], 3, 8, cCientifica); //  botón 4
        this.addButton(BOTONES[20], 0, 9, cCientifica); // botón 5
        this.addButton(BOTONES[21], 1, 9, cCientifica); // botón 6
        this.addButton(BOTONES[22], 2, 9, cCientifica); // botón 7
        this.addButton(BOTONES[23], 3, 9, cCientifica); // botón 8
        this.addButton(BOTONES[24], 0, 10, cCientifica); // botón 9
        this.addButton(BOTONES[25], 1, 10, cCientifica); // botón 0
        this.addButton(BOTONES[26], 2, 10, null); // botón ,
        this.addButton(BOTONES[27], 3, 10, null); // botón =
    }

    /**
     *
     * @return Devuelve un array con todos los botones.
     */
    public JButton[] arrayBotones() {
        JButton[] bot = {
            new JButton("x\u2071"),//[0] x elevado a n
            new JButton("\u2071\u221An"),//[1] raiz
            new JButton("Sin"),//[2]
            new JButton("Cos"),//[3]
            new JButton("Tan"),//[4]
            new JButton("AND"),//[5]
            new JButton("OR"),//[6]
            new JButton("NOT"),//[7]
            new JButton("XOR"),//[8]
            this.vcSimple.getBotones()[3],//[9]
            this.vcSimple.getBotones()[7],//[10]
            this.vcSimple.getBotones()[11],//[11]
            this.vcSimple.getBotones()[15],//[12]
            new JButton("True"),//[13]
            new JButton("False"),//[14]
            this.vcSimple.getBotones()[14],//[15]
            this.vcSimple.getBotones()[0], //[16]
            this.vcSimple.getBotones()[1],//[17]
            this.vcSimple.getBotones()[2],//[18]
            this.vcSimple.getBotones()[4],//[19]
            this.vcSimple.getBotones()[5],//[20]
            this.vcSimple.getBotones()[6],//[21]
            this.vcSimple.getBotones()[8],//[22]
            this.vcSimple.getBotones()[9],//[23]
            this.vcSimple.getBotones()[10],//[24]
            this.vcSimple.getBotones()[12],//[25]
            this.vcSimple.getBotones()[13],//[26]
            this.vcSimple.getBotones()[16],//[27]
        };

        return bot;
    }

    /**
     * Método Untilizado para añadir los mnemonicos a los componentes de la
     * calculdaora.
     */
    @Override
    public void addMnemonics() {
        this.BOTONES[0].setMnemonic(KeyEvent.VK_U);
        this.BOTONES[1].setMnemonic(KeyEvent.VK_R);
        this.BOTONES[2].setMnemonic(KeyEvent.VK_S);
        this.BOTONES[3].setMnemonic(KeyEvent.VK_C);
        this.BOTONES[4].setMnemonic(KeyEvent.VK_T);
        this.BOTONES[5].setMnemonic(KeyEvent.VK_A);
        this.BOTONES[6].setMnemonic(KeyEvent.VK_O);
        this.BOTONES[7].setMnemonic(KeyEvent.VK_N);
        this.BOTONES[8].setMnemonic(KeyEvent.VK_X);
        this.BOTONES[13].setMnemonic(KeyEvent.VK_E);
        this.BOTONES[14].setMnemonic(KeyEvent.VK_F);
    }

    private void defaultKey() {
        InputMap im = BOTONES[27].getInputMap();
        im.put(KeyStroke.getKeyStroke("ENTER"), "pressed");
        im.put(KeyStroke.getKeyStroke("released ENTER"), "released");
    }

    /**
     * Método que crea un separador y lo añade al JPanel.
     */
    @Override
    public void setSeparator() {
        this.separador = new JSeparator();
        this.constraints.gridx = 0;
        this.constraints.gridy = 7;
        this.constraints.gridheight = 1;
        this.constraints.gridwidth = 4;
        this.constraints.ipadx = 1;
        this.constraints.ipady = 1;
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
            int x, int y, ActionListener al) {
        this.constraints.gridx = x;
        this.constraints.gridy = y;
        this.constraints.gridheight = 1;
        this.constraints.gridwidth = 1;
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
        // DIVISION 
        this.BOTONES[9].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cCientifica.setOperando(e);
                cCientifica.setICommand(new ComandoDividir());
            }
        });
        // FIN DIVISION        

        // MULTIPLICACION       
        this.BOTONES[10].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cCientifica.setOperando(e);
                cCientifica.setICommand(new ComandoMultiplicar());
            }
        });
        // FIN MULTIPLICACION

        // RESTA
        this.BOTONES[11].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cCientifica.setOperando(e);
                cCientifica.setICommand(new ComandoRestar());
            }
        });
        //FIN RESTA


        // COMA
        this.BOTONES[26].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton) e.getSource();
                if (btn.getText().equals(",")) {
                    cCientifica.setAcumulador(cCientifica.getAcumulador() + ".");
                    campoTexto.setText("");
                    campoTexto.setText(cCientifica.getAcumulador());

                }
            }
        });
        //FIN COMA

        // CLEAR
        this.BOTONES[15].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campoTexto.setText("");
                cCientifica.reset();
            }
        });
        //FIN CLEAR

        // SUMA
        this.BOTONES[12].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cCientifica.setOperando(e);
                cCientifica.setICommand(new ComandoSumar());
            }
        });
        //FIN SUMA       

        //IGUAL
        this.BOTONES[27].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cCientifica.setBolButtons(true);                                
                addTexto("");
                if (cCientifica.getOperacion() == 'a'
                        || cCientifica.getOperacion() == 'o'
                        || cCientifica.getOperacion() == 'n'
                        || cCientifica.getOperacion() == 'x') {
                    cCientifica.trueTables();                    
                } else {
                    cCientifica.setSegundoOperando(cCientifica.getAcumulador());
                    cCientifica.controlOperacion();
                }
                cCientifica.reset();
            }
        });
        // FIN IGUAL

        // POTENCIA
        this.BOTONES[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cCientifica.setOperando(e);
                cCientifica.setICommand(new ComandoPotencia());
            }
        });
        //FIN POTENCIA

        // RAIZ
        this.BOTONES[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cCientifica.setOperacion('r');
                cCientifica.setOperando(e);
                cCientifica.setICommand(new ComandoRaiz());
                //setAcumulador('r');
            }
        });
        //FIN RAIZ

        //SENO
        this.BOTONES[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cCientifica.setOperacion('e');
                cCientifica.setOperando(e);
                cCientifica.setICommand(new ComandoSeno());
            }
        });
        //FIN SENO

        //COSENO
        this.BOTONES[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cCientifica.setOperacion('c');
                cCientifica.setOperando(e);
                cCientifica.setICommand(new ComandoCoseno());
            }
        });
        //FIN COSENO

        //TANGENTE
        this.BOTONES[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cCientifica.setOperacion('t');
                cCientifica.setOperando(e);
                cCientifica.setICommand(new ComandoTangente());
            }
        });
        //FIN TANGENTE

        //AND        
        this.BOTONES[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cCientifica.setOperacion('a');
                cCientifica.setOperando(e);
                cCientifica.setiCommandBol(new ComandoAnd());
            }
        });
        //FIN AND

        //OR        
        this.BOTONES[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cCientifica.setOperacion('o');
                cCientifica.setOperando(e);
                cCientifica.setiCommandBol(new ComandoOr());
            }
        });
        //FIN OR

        //NOT        
        this.BOTONES[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cCientifica.setOperacion('n');
                cCientifica.setOperando(e);
                cCientifica.setiCommandBol(new ComandoNot());
            }
        });
        //FIN NOT

        //XOR        
        this.BOTONES[8].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cCientifica.limpiarResultadoAnterior();
                cCientifica.setOperacion('x');
                cCientifica.setOperando(e);
                cCientifica.setiCommandBol(new ComandoXor());
            }
        });
        //FIN XOR

        //TRUE
        this.BOTONES[13].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cCientifica.limpiarResultadoAnterior();
               
                if (cCientifica.isBolButtons()) {                    
                    cCientifica.setPrimerOperando("1");
                    cCientifica.setAcumulador("1");
                } else {
                    cCientifica.setAcumulador("");
                    cCientifica.setSegundoOperando("1");
                    cCientifica.setAcumulador("1");
                }
                 campoTexto.setText("Verdadero");
                cCientifica.setBolButtons(false);
                //cCientifica.setAcumulador(cCientifica.getAcumulador() + '1');
            }
        });
        //FIN TRUE

        //FALSE
        this.BOTONES[14].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cCientifica.limpiarResultadoAnterior();                
                if (campoTexto.getText().equals("")) {
                    cCientifica.setPrimerOperando("0");
                    cCientifica.setAcumulador("0");
                } else {
                    cCientifica.setAcumulador("");
                    cCientifica.setSegundoOperando("0");
                    cCientifica.setAcumulador("0");
                }
                campoTexto.setText("Falso");
                cCientifica.setBolButtons(false);
                //cCientifica.setAcumulador(cCientifica.getAcumulador() + '0');
            }
        });
        //FIN FALSE       
    }

    public boolean campoTextoIsEmpty() {
        if (this.campoTexto.getText().equals("")) {
            return true;
        } else {
            return false;
        }
    }
}
