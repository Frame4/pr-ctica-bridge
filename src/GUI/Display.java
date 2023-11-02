package GUI;

import controlDevices.Alexa;
import controlDevices.Control;
import controlDevices.Smartphone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.File;

public class Device extends JFrame {
    private JLabel imagenLabel;
    private JComboBox<String> comboBox;
    private JButton volumeUpButton;
    private JButton volumeDownButton;
    private JButton uploadButton;
    private Alexa alexa;
    private Smartphone smartphone;

    public Device() {
        // Configurar la ventana principal
        setTitle("Ejercicio bridge");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Configurar el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        getContentPane().add(panel);

        // Crear el JLabel para mostrar la imagen en el centro
        imagenLabel = new JLabel();
        panel.add(imagenLabel, BorderLayout.CENTER);

        // Crear el JComboBox en la parte inferior y agregar elementos
        comboBox = new JComboBox<>();
        alexa = new Alexa();
        smartphone = new Smartphone();
        comboBox.addItem(smartphone.getDeviceName());
        comboBox.addItem(alexa.getDeviceName());


        // Crear los botones de "Volume Up", "Volume Down" y "Upload Picture"
        volumeUpButton = new JButton("Volume Up");
        volumeDownButton = new JButton("Volume Down");
        uploadButton = new JButton("Upload Picture");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(comboBox);
        buttonPanel.add(volumeUpButton);
        buttonPanel.add(volumeDownButton);
        buttonPanel.add(uploadButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Agregar ActionListener al JComboBox
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> source = (JComboBox<String>) e.getSource();
                String seleccion = (String) source.getSelectedItem();

                // Realiza acciones basadas en la selección del JComboBox
                if ("Smartphone".equals(seleccion)) {
                    // Agregar tu lógica para "Smartphone" aquí
                } else if ("Alexa".equals(seleccion)) {
                    // Agregar tu lógica para "Alexa" aquí
                }
            }
        });

        // Agregar ActionListener para el botón "Volume Up"
        volumeUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Agregar tu lógica aquí
            }
        });

        // Agregar ActionListener para el botón "Volume Down"
        volumeDownButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Agregar tu lógica aquí
            }
        });

        // Agregar ActionListener para el botón "Upload Picture"
        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home") + File.separator + "Desktop"));
                int resultado = fileChooser.showOpenDialog(null);
                if (resultado == JFileChooser.APPROVE_OPTION) {
                    // Obtener la imagen seleccionada
                    String rutaImagen = fileChooser.getSelectedFile().getAbsolutePath();
                    ImageIcon imagen = new ImageIcon(rutaImagen);

                    // Escalar la imagen para que se ajuste al tamaño de la ventana
                    int anchoVentana = imagenLabel.getWidth();
                    int altoVentana = imagenLabel.getHeight();

                    Image imagenEscalada = imagen.getImage().getScaledInstance(anchoVentana, altoVentana, Image.SCALE_SMOOTH);
                    ImageIcon imagenEscaladaIcon = new ImageIcon(imagenEscalada);

                    imagenLabel.setIcon(imagenEscaladaIcon);
                }
            }
        });
    }
}
