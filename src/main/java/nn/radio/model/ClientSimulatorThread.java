package nn.radio.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClientSimulatorThread extends Thread implements ActionListener, MouseListener, KeyListener {

    java.util.List<KeyEvent> events;
    java.util.List<Tank> tankList;

    KeyEvent ev = null;


    ClientSimulatorThread(String name, java.util.List<KeyEvent> eve, java.util.List<Tank> tList) {
        tankList = tList;
        events = eve;
        setName(name);
        System.out.printf("%s : %s : %s  was created...\n", getName(), getPriority(), getState());
    }

    @Override
    public void run() {
        System.out.printf("%s : %s : %s  is RUN() ...\n", getName(), getPriority(), getState());
        System.out.println(events.toArray().toString());

//        ev.setKeyCode(KeyEvent.VK_UP);
//        ev.setSource(KeyEvent.KEY_RELEASED);
//
//        for (int i = 0; i < 10; i++) {
//            ifkeyPressed(ev);
//
//        }
        events.forEach(e -> {
            try {
                if (e.toString().contains("KEY_PRESSED")) {
                    ifkeyPressed(e);
                }

                if (e.toString().contains("KEY_RELEASED")) {
                        ifKeyReleased(e);
                }

                Thread.sleep(100);

            } catch (Exception ex) {
                System.err.println(">>> HANDELD EXCEPTION if events.forEach()");
                ex.printStackTrace();
            }

        });

        events = null;
        while (true) {

        }

    }

    public void ifkeyPressed(KeyEvent e) {
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

    public void ifKeyReleased(KeyEvent e) {
        tankList.stream().filter(t -> t.isFocusable())
                .limit(1)
                .forEach(t -> {
                    try {
                        t.keyEventReleased(e);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                });
    }



//=========================================================================

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        e.setKeyCode(KeyEvent.VK_UP);
    }

    @Override
    public void keyReleased(KeyEvent e) {

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
