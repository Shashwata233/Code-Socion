import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SetProfileImage extends JFrame implements ActionListener {
    private JButton browseButton, saveButton;
    private JLabel imageLabel;
    private File selectedFile;

    public SetProfileImage() {
        setTitle("Set Profile Image");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        browseButton = new JButton("Browse");
        saveButton = new JButton("Save");
        imageLabel = new JLabel();

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(browseButton);
        buttonPanel.add(saveButton);

        add(buttonPanel, BorderLayout.NORTH);
        add(imageLabel, BorderLayout.CENTER);

        browseButton.addActionListener(this);
        saveButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == browseButton) {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();
                try {
                    Image image = ImageIO.read(selectedFile);
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
                    imageLabel.setIcon(icon);
                } catch (IOException ex) {
                    System.out.println("Error reading image file");
                }
            }
        } else if (e.getSource() == saveButton) {
            if (selectedFile != null) {
                // Here you can write code to save the image file to a specific directory
                JOptionPane.showMessageDialog(null, "Profile image saved");
            } else {
                JOptionPane.showMessageDialog(null, "Please select an image file first");
            }
        }
    }

    public static void main(String[] args) {
        SetProfileImage frame = new SetProfileImage();
        frame.setVisible(true);
    }
}
