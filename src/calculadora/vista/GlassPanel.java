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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package calculadora.vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

/**
 *
 * @author Félix Marín Ramírez | felixmurcia@gmail.com
 */
public class GlassPanel extends JComponent {

    Point point;

    @Override
    protected void paintComponent(Graphics g) {
        if (point != null) {
            g.setColor(Color.red);
            g.fillOval(point.x + 5, point.y + 72, 7, 7);
        }
    }

    /**
     *
     * @param p
     */
    public void setPoint(Point p) {
        point = p;
    }

    /**
     *
     * @param contentPane
     */
    public GlassPanel(Container contentPane) {
        CBListener listener = new CBListener(this, contentPane);
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }
}

/**
 * Listen for all events that our check box is likely to be interested in.
 * Redispatch them to the check box.
 */
class CBListener extends MouseInputAdapter {

    GlassPanel glassPane;
    Container contentPane;

    public CBListener(GlassPanel glassPane, Container contentPane) {

        this.glassPane = glassPane;
        this.contentPane = contentPane;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        redispatchMouseEvent(e, false);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        redispatchMouseEvent(e, false);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        redispatchMouseEvent(e, false);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        redispatchMouseEvent(e, false);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        redispatchMouseEvent(e, false);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        redispatchMouseEvent(e, false);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        redispatchMouseEvent(e, true);
    }

    //A basic implementation of redispatching events.
    private void redispatchMouseEvent(MouseEvent e,
            boolean repaint) {

        Point glassPanePoint = e.getPoint();
        Container container = contentPane;
        Point containerPoint = SwingUtilities.convertPoint(
                glassPane,
                glassPanePoint,
                contentPane);
        if (containerPoint.y < 0) { //we're not in the content pane
            if (containerPoint.y >= 0) {
                //The mouse event is over the menu bar.
                //Could handle specially.
            } else {
                // DO NOTHING
            }
        } else {
            //The mouse event is probably over the content pane.
            //Find out exactly which component it's over.  
            Component component =
                    SwingUtilities.getDeepestComponentAt(
                    container,
                    containerPoint.x,
                    containerPoint.y);

            if ((component != null) && (component instanceof JButton)) {
                //Forward events over the check box.
                Point componentPoint = SwingUtilities.convertPoint(
                        glassPane,
                        glassPanePoint,
                        component);
                component.dispatchEvent(new MouseEvent(component,
                        e.getID(),
                        e.getWhen(),
                        e.getModifiers(),
                        componentPoint.x,
                        componentPoint.y,
                        e.getClickCount(),
                        e.isPopupTrigger()));

                //Update the glass pane if requested.
                if (repaint) {
                    glassPane.setPoint(component.getLocation());
                    glassPane.repaint();
                }
            }
        }


    }
}
