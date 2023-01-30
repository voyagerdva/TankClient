package nn.radio.model;

import java.awt.*;
import java.awt.event.*;

public class SimulatorThread extends Thread implements ActionListener, MouseListener, KeyListener {
    Scena scena1;

    Button a = new Button("click");
    KeyEvent e = new KeyEvent(a, 1, 20, 1, 10, 'a');

    SimulatorThread(String name, Scena sc) {
        scena1 = sc;
        setName(name);
        System.out.printf("Thread << %s : %s >> was created.", getName(), getState());
    }

    @Override
    public void run() {
        System.out.printf("Thread << %s : %s >> is RUN()", getName(), getState());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 20; i++) {
            moveForward(200);
            turnLeft(3);
        }


    }

//=================================================================================================

    public void moveForward(int dist) {
        e.setKeyCode(KeyEvent.VK_UP);
        for (int i = 0; i < dist; i++) {
            scena1.keyPressed(e);
        }
        scena1.keyReleased(e);
    }

    public void moveBack(int dist) {
        e.setKeyCode(KeyEvent.VK_DOWN);
        for (int i = 0; i < dist; i++) {
            scena1.keyPressed(e);
        }
        scena1.keyReleased(e);
    }

    public void turnLeft(int step) {
        e.setKeyCode(KeyEvent.VK_LEFT);
        for (int i = 0; i < step; i++) {
            scena1.keyPressed(e);
        }
        scena1.keyReleased(e);
    }
    public void moveRight(int step) {
        e.setKeyCode(KeyEvent.VK_RIGHT);
        for (int i = 0; i < step; i++) {
            scena1.keyPressed(e);
        }
        scena1.keyReleased(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyReleased(KeyEvent e) {

    }


//=================================================================================================

    @Override
    public void actionPerformed(ActionEvent e) {

    }


    @Override
    public void mouseClicked(MouseEvent e) {

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
