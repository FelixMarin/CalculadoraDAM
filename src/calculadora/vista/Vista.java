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

import calculadora.vista.primos.VistaCalcPrimos;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 *
 * @author Félix Marín Ramírez | felixmurcia@gmail.com
 * @version 1.0
 */
public final class Vista extends JFrame {

    private VistaCalcSimple vcSimple;
    private VistaCalcProgramador vcProgramador;
    private VistaCalcCientifica vcCientifica;
    private VistaCalcPrimos vPrimos;
    private JPanel panelCard;
    private final String[] TIPOS = {"SIMPLE", "PROGRAMADOR", "CIENTIFICA", "PRIMOS"};
    //DEFINICION DE VARIABLES DE PARA EL MENÚ
    private JMenuBar barraMenu;
    private JMenu menuFile;
    private JMenu menuEdit;
    private JMenu submenuTipo;
    private JMenu submenuColor;
    private JMenuItem itemColorFont;
    private JMenuItem itemColorBack;
    private ButtonGroup grupoRadio;
    private JRadioButtonMenuItem rdSimple;
    private JRadioButtonMenuItem rdProgramador;
    private JRadioButtonMenuItem rdCientifica;
    private JRadioButtonMenuItem rdPrimos;
    //FIN DEFINICION DE VARIABLES DE PARA EL MENÚ
    private Color color;

    /**
     * Constructor de la clase encargado de crear todos los elementos necesarios
     * para que la clase sea funcional.
     */
    public Vista() {
        vcSimple = new VistaCalcSimple(this);
        vcProgramador = new VistaCalcProgramador(this);
        vcCientifica = new VistaCalcCientifica(this);
        vcSimple = new VistaCalcSimple(this);
        vPrimos = new VistaCalcPrimos();

        this.crearVentana(new Dimension(509, 660));
        this.setVistaLayout();
        this.setPanelCard();
        this.getBarraMenus();
        this.setListeners();

//        GlassPanel mgp = new GlassPanel(this.getContentPane());
//        this.setGlassPane(mgp);
//        mgp.setVisible(true);
    }

    /**
     * Método encargado de definir la visivilidad y el tamaño del marco de la
     * ventana principal.
     *
     * @param d Párametro que define el tamaño de la ventana.
     */
    public void crearVentana(Dimension d) {
        this.setName("Calculadora");
        this.setVisible(true);
        this.setMinimumSize(d);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Método en el cual se configura el layout del JFrame.
     */
    public void setVistaLayout() {
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
    }

    /**
     * Método encargado de configurar el JPanel en el que se añadirán los
     * paneles correspondientes a los distintos tipos de calculadoras.
     */
    public void setPanelCard() {
        panelCard = new JPanel();
        panelCard.setLayout(new CardLayout());
        panelCard.add(vcSimple.getJPanel(), TIPOS[0]);
        panelCard.add(vcProgramador.getJPanel(), TIPOS[1]);
        panelCard.add(vcCientifica.getJPanel(), TIPOS[2]);
        panelCard.add(vPrimos.getJPanel(), TIPOS[3]);
        this.getContentPane().add(panelCard);
    }

    /**
     * Método encargado de inicializar los métodos que componen la barra de
     * menús del JFrame.
     */
    public void getBarraMenus() {
        this.crearBarraMenus();
        this.creaMenuFile();
        this.crearMenuEdit();
        this.crearSubmenuTipo();
        this.crearSubmenuColor();
        this.crearSubmenuColorTexto();
        this.crearSubmenuColorFondo();
        this.crearRadioItems();
    }

    /**
     * Crea y añade la barra de menús al JFrame.
     */
    public void crearBarraMenus() {
        barraMenu = new JMenuBar();
        this.setJMenuBar(barraMenu);
    }

    /**
     * Crea y añade el menú File a la barra de menús.
     */
    public void creaMenuFile() {
        menuFile = new JMenu("File");
        menuFile.setMnemonic(KeyEvent.VK_I);
        barraMenu.add(menuFile);
    }

    /**
     * Crea y añade el menú Edit a la barra de menús.
     */
    public void crearMenuEdit() {
        menuEdit = new JMenu("Edit");
        menuEdit.setMnemonic(KeyEvent.VK_E);
        barraMenu.add(menuEdit);
    }

    /**
     * Crea y añade el submenú Tipo al menú File.
     */
    public void crearSubmenuTipo() {
        submenuTipo = new JMenu("Tipo");
        submenuTipo.setMnemonic(KeyEvent.VK_T);
        menuFile.add(submenuTipo);
    }

    /**
     * Crea y añade el submenú Color al menú Edit.
     */
    public void crearSubmenuColor() {
        submenuColor = new JMenu("Color");
        submenuColor.setMnemonic(KeyEvent.VK_R);
        menuEdit.add(submenuColor);
    }

    /**
     * Crea el item de menú color de texto y lo añade al submenú Color.
     */
    public void crearSubmenuColorTexto() {
        itemColorFont = new JMenuItem("Cambiar color fuente");
        itemColorFont.setMnemonic(KeyEvent.VK_A);
        submenuColor.add(itemColorFont);
    }

    /**
     * Crea el item de menú color de fondo y lo añade al submenú Color.
     */
    public void crearSubmenuColorFondo() {
        itemColorBack = new JMenuItem("Cambiar color fondo");
        itemColorBack.setMnemonic(KeyEvent.VK_B);
        submenuColor.add(itemColorBack);
    }

    /**
     * Este método crea los radio items, los añade a un grupo y por último los
     * añade al submenú Tipo.
     */
    public void crearRadioItems() {

        rdSimple = new JRadioButtonMenuItem("Simple");
        rdSimple.setMnemonic(KeyEvent.VK_S);
        rdSimple.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.ALT_MASK));
        rdSimple.setSelected(true);
        //--//
        rdProgramador = new JRadioButtonMenuItem("Programador");
        rdProgramador.setMnemonic(KeyEvent.VK_P);
        rdProgramador.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_P, ActionEvent.ALT_MASK));
        //--//
        rdCientifica = new JRadioButtonMenuItem("Científica");
        rdCientifica.setMnemonic(KeyEvent.VK_F);
        rdCientifica.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_F, ActionEvent.ALT_MASK));
        //--//     
        rdPrimos = new JRadioButtonMenuItem("Primos");
        rdPrimos.setMnemonic(KeyEvent.VK_M);
        rdPrimos.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_M, ActionEvent.ALT_MASK));
        //--//
        grupoRadio = new ButtonGroup();
        grupoRadio.add(rdSimple);
        grupoRadio.add(rdProgramador);
        grupoRadio.add(rdCientifica);
        grupoRadio.add(rdPrimos);
        //--//
        submenuTipo.add(rdSimple);
        submenuTipo.add(rdProgramador);
        submenuTipo.add(rdCientifica);
        submenuTipo.add(rdPrimos);
    }

    /**
     * Metodo encargado de crear la pantalla de la calculadora, la cual, solo es
     * un campo de texto con la opcion editable a false.
     *
     * @param constraints Parámetro de tipo GridBagConstraints con el que se
     * indicará la posición del elemento. Solo válido para el layout
     * GridBagLayout.
     * @param panel Parámetro que contiene el contenedor donde se insertará la
     * pantalla.
     * @return Devuelve el campo de texto ya configurado.
     */
    public JFormattedTextField crearPantalla(GridBagConstraints constraints, JPanel panel) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(3);
        JFormattedTextField campoTexto = new JFormattedTextField(nf);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 3;
        constraints.gridwidth = 4;
        constraints.ipadx = 20;
        constraints.ipady = 80;
        campoTexto.setToolTipText("Panatalla de resultados");
        campoTexto.setEditable(false);
        campoTexto.setHorizontalAlignment(JTextField.RIGHT);
        campoTexto.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        campoTexto.setBackground(Color.WHITE);
        campoTexto.setFont(new Font("sanserif", Font.BOLD, 25));
        panel.add(campoTexto, constraints);
        return campoTexto;
    }

    /**
     * Método que prepara e inserta los botones numéricos en la posición
     * indicada en las coordenadas x e y.
     *
     * @param boton Parámetro de tipo JButton que cotiene el botón que será
     * insertado en el contenedor.
     * @param gbc
     * @param x Posición con respecto al eje x en la que se insertará el botón.
     * @param y Posición con respecto al eje y en la que se insertará el botón.
     * @param al Argumento que contiene la clase listener para el componente.
     * @param ancho Ancho que tendrá el componente.
     * @param panel Parámetro que contiene el contenedor donde se insertarán los
     * botones.
     */
    public void addButton(JButton boton, GridBagConstraints gbc,
            int x, int y, ActionListener al, int ancho, JPanel panel) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridheight = 1;
        gbc.gridwidth = ancho;
        gbc.ipadx = 20;
        gbc.ipady = 20;
        boton.setFont(new Font("sanserif", Font.BOLD, 25));
        boton.addActionListener(al);
        panel.add(boton, gbc);
    }

    /**
     * Método en el cual se configuran los listeners de los componentes que lo
     * necesiten.
     */
    public void setListeners() {
        rdSimple.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                vcSimple.getControlSimple().reset();
                vcSimple.addTexto("");
                ((CardLayout) panelCard.getLayout())
                        .show(panelCard, TIPOS[0]);
            }
        });

        rdProgramador.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                vcProgramador.getControlProgramador().reset();
                vcProgramador.addTexto("");
                ((CardLayout) panelCard.getLayout())
                        .show(panelCard, TIPOS[1]);
            }
        });

        rdCientifica.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                vcCientifica.getControlCientifica().reset();
                vcCientifica.addTexto("");
                ((CardLayout) panelCard.getLayout())
                        .show(panelCard, TIPOS[2]);
            }
        });

        rdPrimos.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                ((CardLayout) panelCard.getLayout())
                        .show(panelCard, TIPOS[3]);
                getContentPane().setMinimumSize(new Dimension(300, 300));
                getContentPane().repaint();
            }
        });

        itemColorFont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarColor('F');
            }
        });

        itemColorBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarColor('B');
            }
        });

    }

    /**
     * Método utilizado para cambiar el color del fondo del campo de texto o el
     * color de la fuente según indique el parámetro de tipo char que se le pasa
     * como argumento.
     *
     * @param c Parámetro de tipo char que indica si el color a cambiar es el
     * del texto o el del fondo.
     */
    public void cambiarColor(char c) {

        color = JColorChooser.showDialog(
                Vista.this, "Elije un Color", color);

        if (c == 'F') {
            vcSimple.getCampoTexto().setForeground(color);
            vcProgramador.getCampoTexto().setForeground(color);
            vcCientifica.getCampoTexto().setForeground(color);
        } else if (c == 'B') {
            vcSimple.getCampoTexto().setBackground(color);
            vcProgramador.getCampoTexto().setBackground(color);
            vcCientifica.getCampoTexto().setBackground(color);
        } else {
            //DO NOTHING
        }
        //--//
        vcSimple.repaint();
        vcProgramador.repaint();
        vcCientifica.repaint();
    }
}
