package nn.radio.model;

import DB.DBAgent;

import  javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.sql.SQLException;

import static java.lang.Thread.sleep;
import static nn.radio.model.Constants.*;

public class appRunner {
    public static void main(String[] args) throws InterruptedException, IOException {

        var dbAgent = new DBAgent();
        try {
            dbAgent.connectionDB();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();
        GraphicsDevice gd = gs[0];

        Scena scena1 = new Scena();
        JFrame frame = new JFrame(gd.getDefaultConfiguration());

        frame.setTitle("TANKS MODEL");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(SCENA_WIDTH + SCENA_BORDER * 2, SCENA_HEIGTH + SCENA_BORDER * 2);
        frame.setBackground(backgroundColor);
        frame.setResizable(true);

        frame.add(scena1);
        frame.setVisible(true);

        SimulatorThread simulatorThread = new SimulatorThread("SIMULATOR", (KeyListener) scena1);
        simulatorThread.start();
    }
}
