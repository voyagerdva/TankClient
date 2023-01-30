package nn.radio.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.IntStream;

import static nn.radio.model.Constants.*;

public class Scena extends JPanel implements ActionListener, MouseListener, KeyListener {


//===========================================================================


    java.util.List<Tank> tankList = new ArrayList<>();


    public Scena() throws IOException {
        super();
        this.setFocusable(true);
        this.requestFocusInWindow();

        addMouseListener(this);
        addKeyListener(this);

        grabFocus();

        tankList.add(new Tank(400F, 200F));
        tankList.add(new Tank(500F, 300F));
        tankList.add(new Tank(600F, 400F));



    }


    @Override
    public void paintComponent(Graphics g) {
        // отрисовка всех объектов
        drawTanks(g);
        repaint();
    }

    public void drawTanks(Graphics g) {
        tankList.forEach(t -> t.move(g));
    }

//===================================================================================

    @Override
    public void keyPressed(KeyEvent e) {
        tankList.stream().filter(t -> t.isFocusable())
                .limit(1)
                .forEach(t -> {
                    try {
                        t.keyEventPressed(e);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                });
    }

    @Override
    public void keyReleased(KeyEvent e) {
        tankList.stream().filter(t -> t.isFocusable())
                .limit(1)
                .forEach(t -> t.keyEventReleased(e));
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

//===================================================================================

    @Override
    public void mouseClicked(MouseEvent e) {
        tankList.forEach(t -> t.mouseEventClicked(e));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
