package GUI;

import controlDevices.*;
import devices.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Display extends JFrame {
    private JLabel imagenLabel, volumeLabel;
    private JComboBox<Control> controlComboBox;
    private JComboBox<Device> deviceComboBox;
    private JButton volumeUpButton;
    private JButton volumeDownButton;
    private JButton uploadButton;
    private Laptop laptop;
    private SmartTV smartTV;
    private Alexa alexa;
    private GoogleHome googleHome;

    public Display() {
        // Configurar la ventana principal
        setTitle("Ejercicio bridge");
        setSize(950, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Configurar el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        getContentPane().add(panel);

        // Crear el JLabel para mostrar la imagen en el centro
        imagenLabel = new JLabel();
        panel.add(imagenLabel, BorderLayout.CENTER);

        // Crear el JComboBox de dispositivos en la parte inferior y agregar elementos
        deviceComboBox = new JComboBox<>();
        laptop = new Laptop();
        smartTV = new SmartTV();
        deviceComboBox.addItem(laptop);
        deviceComboBox.addItem(smartTV);

        // Crear el JComboBox de control en la parte inferior y agregar elementos
        controlComboBox = new JComboBox<>();
        googleHome = new GoogleHome((Device) deviceComboBox.getSelectedItem());
        alexa = new Alexa((Device) deviceComboBox.getSelectedItem());
        controlComboBox.addItem(googleHome);
        controlComboBox.addItem(alexa);


        // Crear los botones de "Volume Up", "Volume Down" y "Upload Picture"
        volumeUpButton = new JButton("Volume Up");
        volumeDownButton = new JButton("Volume Down");
        uploadButton = new JButton("Upload Picture");

        volumeLabel = new JLabel("Volume: ");


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(deviceComboBox);
        buttonPanel.add(controlComboBox);
        buttonPanel.add(volumeUpButton);
        buttonPanel.add(volumeDownButton);
        buttonPanel.add(uploadButton);
        buttonPanel.add(volumeLabel);
        panel.add(buttonPanel, BorderLayout.SOUTH);


        // Agregar ActionListener para el botón "Volume Up"
        volumeUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controlComboBox.getSelectedItem() == googleHome) {
                    googleHome.volumeUp();
                    volumeLabel.setText("Volume: " + googleHome.getVolume());
                }else {
                    alexa.volumeUp();
                    volumeLabel.setText("Volume: " + alexa.getVolume());
                }
            }
        });

        // Agregar ActionListener para el botón "Volume Down"
        volumeDownButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controlComboBox.getSelectedItem()== googleHome) {
                    googleHome.volumeDown();
                    volumeLabel.setText("Volume: " + googleHome.getVolume());
                }else {
                    alexa.volumeDown();
                    volumeLabel.setText("Volume: " + alexa.getVolume());
                }
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

                    if(controlComboBox.getSelectedItem()== googleHome) {
                        googleHome.setImage(imagenEscaladaIcon);
                    }else {
                        alexa.setImage(imagenEscaladaIcon);
                    }
                }
            }
        });
    }
}
