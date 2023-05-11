import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ThemeChange extends JFrame {
    private JLabel label;
    private JButton button;
    private JPanel panel;
    private JRadioButton blueButton, redButton;

    public ThemeChange() {
        setTitle("Theme Change Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        
        label = new JLabel("Select a theme:");
        blueButton = new JRadioButton("Blue");
        redButton = new JRadioButton("Red");

        ButtonGroup group = new ButtonGroup();
        group.add(blueButton);
        group.add(redButton);
        
        button = new JButton("Change Theme");
        button.addActionListener(new ThemeChangeListener());

        panel = new JPanel();
        panel.add(label);
        panel.add(blueButton);
        panel.add(redButton);
        panel.add(button);
        
        getContentPane().add(panel);
        setVisible(true);
    }

    private class ThemeChangeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (blueButton.isSelected()) {
                UIManager.put("Panel.background", Color.BLUE);
                UIManager.put("OptionPane.background", Color.BLUE);
            } else if (redButton.isSelected()) {
                UIManager.put("Panel.background", Color.RED);
                UIManager.put("OptionPane.background", Color.RED);
            }

            SwingUtilities.updateComponentTreeUI(panel);
            SwingUtilities.updateComponentTreeUI(button);
            SwingUtilities.updateComponentTreeUI(label);
        }
    }

    public static void main(String[] args) {
        new ThemeChange();
    }
}
