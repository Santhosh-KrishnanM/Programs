package Exercises;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SimpleCalculator10 extends JFrame implements ActionListener {
    // Create GUI components
    private JTextField display;
    private JButton[] numberButtons;
    private JButton add, subButton, mulButton, divButton, modButton, equButton, clrButton;

    private double num1, num2, result;
    private char operator;

    public SimpleCalculator() {
        // Frame settings
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Display
        display = new JTextField();
        display.setSize(50,400);
        display.setFont(new Font("Time New Roman",Font.PLAIN,50));
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Panel for buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4));

        // Number buttons
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            panel.add(numberButtons[i]);
        }

        // Operation buttons
        add = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        modButton = new JButton("%");
        equButton = new JButton("=");
        clrButton = new JButton("C");
        

        // Add action listeners
        add.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        modButton.addActionListener(this);
        equButton.addActionListener(this);
        clrButton.addActionListener(this);

        // Add operation buttons to the panel
        panel.add(add);
        panel.add(subButton);
        panel.add(mulButton);
        panel.add(divButton);
        panel.add(modButton);
        panel.add(equButton);
        panel.add(clrButton);

        add(panel, BorderLayout.CENTER);
    }

    //@Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                display.setText(display.getText() + i);
            }
        }

        if (e.getSource() == add) {
            num1 = Double.parseDouble(display.getText());
            operator = '+';
            display.setText("");
        } else if (e.getSource() == subButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '-';
            display.setText("");
        } else if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '*';
            display.setText("");
        } else if (e.getSource() == divButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '/';
            display.setText("");
        }
        else if (e.getSource() == modButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '%';
            display.setText("");
        }
        else if (e.getSource() == equButton) {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                case '%':
                	result = num1 % num2;
                	break;
            }
            display.setText(String.valueOf(result));
        } else if (e.getSource() == clrButton) {
            display.setText("");
            num1 = num2 = result = 0;
        }
    }

    public static void main(String[] args) {
       SimpleCalculator calculator = new SimpleCalculator();
       calculator.setVisible(true);
    }
}
