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


    public java.util.List<Tank> tankList = new ArrayList<>();
    public java.util.List<KeyEvent> events = new ArrayList<>();


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

        ClientSimulatorThread simulator = new ClientSimulatorThread("SIMULATOR", events, tankList);
        simulator.start();


        events.forEach(e -> {
            System.out.println(e.toString());

        });
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
//        System.out.println(e.toString());
        System.out.println(e.getSource());
        if (e.getKeyCode() == KeyEvent.VK_END) {
            ClientSimulatorThread simulator = new ClientSimulatorThread("SIMULATOR", events, tankList);
            simulator.start();
        }
        events.add(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e.toString());
        events.add(e);
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
