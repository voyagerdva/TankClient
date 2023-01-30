package nn.radio.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimulatorThread_old2 extends JFrame implements ActionListener, MouseListener, KeyListener, Runnable {
    Scena scena1;

    SimulatorThread_old2(String name, Scena sc) {
        scena1 = sc;
        Thread t = new Thread(this, "SIMULATOR");
        setName(name);
        System.out.printf("Thread << %s : %s >> was created.", getName(), getState());
        t.start();
    }

    @Override
    public void run() {
        System.out.printf("Thread << %s : %s >> is RUN()", getName(), getState());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//====== ОБРАЗЕЦ ============================================
//        KeyEvent e = new KeyEvent(
//                Component source,
//                int id,
//                long when,
//                int modifiers,
//                int keyCode,
//                char keyChar,
//                int keyLocation);

//        KeyEvent e = new KeyEvent(
//                Component source,
//                int id,
//                long when,
//                int modifiers,
//                int keyCode);

        Button a = new Button("click");
//        KeyEvent ev = new KeyEvent(
//                a,
//                "Up",
//                "Undefined keyChar",
//                "KEY_LOCATION_STANDARD",
//                38,
//                0,
//                72,
//                0x26
//        );


        KeyEvent e1 = new KeyEvent(
                a,
                1,
                20,
                1,
                10,
                'a');

        KeyEvent e2 = new KeyEvent(
                a,
                KeyEvent.KEY_RELEASED,
                JComponent.WHEN_FOCUSED,
                KeyEvent.CTRL_DOWN_MASK,
                KeyEvent.VK_UP,
                KeyEvent.CHAR_UNDEFINED);

        e1.setKeyCode(KeyEvent.VK_UP);


//        e.setKeyChar();

//        scena1.keyPressed(e1);
//        System.out.println("e1: " + e1.toString());

        scena1.keyPressed(e1);
        System.out.println("e1: " + e1);
        scena1.keyReleased(e1);
        System.out.println("e1: " + e1);

        e1.toString();

        for (int i = 0; i < 100; i++) {
            scena1.keyPressed(e1);
            System.out.println("e1: " + e1);
            scena1.keyReleased(e1);
            System.out.println("e1: " + e1);
        }


    }

//=================================================================================================

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
