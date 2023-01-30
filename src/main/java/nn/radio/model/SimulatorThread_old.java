package nn.radio.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimulatorThread_old extends JFrame implements ActionListener, MouseListener, KeyListener, Runnable {
    Scena scena1;
    KeyEvent ev;

    SimulatorThread_old(String name, Scena sc) {
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

        for (int i = 0; i < 7; i++) {

        }

//        KeyListener kl = new KeyListener() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//
//            }
//        };
//
//        kl.keyPressed(KeyEvent.VK_UP);

//====== ОБРАЗЕЦ ============================================
//        KeyEvent e = new KeyEvent(
//                Component source,
//                int id,
//                long when,
//                int modifiers,
//                int keyCode,
//                char keyChar,
//                int keyLocation);

//====== ОБРАЗЕЦ ============================================
//        ev.setSource(); = new KeyEvent(
//                38,
//                "Up",
//                "Undefined keyChar",
//                "KEY_LOCATION_STANDARD",
//                38,
//                0,
//                72,
//                0x26
//        );

        Button a = new Button("click");

//        KeyEvent e;
        ev = new KeyEvent(a,
                1,
                20,
                1,
                10,
                'a');


//        KeyEvent key = new KeyEvent(inputField, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, 'Z');
//        inputField.dispatchEvent(key);

//        DelegatingDefaultFocusManager textArea;
//        textArea.dispatchEvent(new KeyEvent(jFrame,
//                KeyEvent.KEY_TYPED, System.currentTimeMillis(),
//                0,
//                KeyEvent.VK_ENTER));
        
        
//        System.out.println("ev.toString(): " + ev.toString());
//
//        ev.setKeyCode(KeyEvent.VK_UP);
//
//        scena1.keyPressed(ev);

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
