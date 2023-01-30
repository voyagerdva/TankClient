package nn.radio.model;

import java.awt.*;
import java.awt.event.*;

public class SimulatorThread extends Thread{
    KeyListener listner;

    Button a = new Button("click");
    KeyEvent e;

    SimulatorThread(String name, KeyListener kl) {
        listner = kl;
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

        System.out.println("MOVE");

        for (int i = 0; i < 15; i++) {
            moveForward(200);
            turnLeft(3);
        }


    }

//=================================================================================================

    public void moveForward(int dist) {
        e = new KeyEvent(a, 1, 20, 1, KeyEvent.VK_UP, 'a');
        for (int i = 0; i < dist; i++) {
            listner.keyPressed(e);
        }
        listner.keyReleased(e);
    }

    public void moveBack(int dist) {
        e = new KeyEvent(a, 1, 20, 1, KeyEvent.VK_DOWN, 'a');
        for (int i = 0; i < dist; i++) {
            listner.keyPressed(e);
        }
        listner.keyReleased(e);
    }

    public void turnLeft(int step) {
        e = new KeyEvent(a, 1, 20, 1, KeyEvent.VK_LEFT, 'a');
        for (int i = 0; i < step; i++) {
            listner.keyPressed(e);
        }
        listner.keyReleased(e);
    }
    public void turnRight(int step) {
        e = new KeyEvent(a, 1, 20, 1, KeyEvent.VK_RIGHT, 'a');
        for (int i = 0; i < step; i++) {
            listner.keyPressed(e);
        }
        listner.keyReleased(e);
    }

}
