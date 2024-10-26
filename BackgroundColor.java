package Exercises;
import java.awt.Color;
import java.awt.event.*;
//import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.*;

public class BackgroundColor extends JFrame {
    private JButton[] colorButtons;
    private String[] str = {"RED", "GREEN", "BLUE"};
    
    public BackgroundColor() {
        setTitle("Background Color");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        colorButtons = new JButton[3]; // Create buttons array

        for (int i = 0; i < str.length; i++) {
            colorButtons[i] = new JButton(str[i]);
            //colorButtons[i].setPreferredSize(new java.awt.Dimension(100, 80));
            colorButtons[i].addActionListener(new ColorActionListener(str[i], buttonPanel)); // Using the same ActionListener for all buttons
            buttonPanel.add(colorButtons[i]);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    private class ColorActionListener implements ActionListener {
        private String colorName;
        private JPanel panel;

        public ColorActionListener(String colorName, JPanel panel) {
            this.colorName = colorName;
            this.panel = panel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (colorName) {
                case "RED":
                    panel.setBackground(Color.RED);
                    break;
                case "GREEN":
                    panel.setBackground(Color.GREEN);
                    break;
                case "BLUE":
                    panel.setBackground(Color.BLUE);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        BackgroundColor bgc = new BackgroundColor();
        bgc.setVisible(true);
    }
}
