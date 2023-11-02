import GUI.Display;
import devices.Device;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Display ventana = new Display();
                ventana.setVisible(true);
            }
        });

    }
}