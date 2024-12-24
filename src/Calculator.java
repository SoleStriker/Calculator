import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] operatorButtons = new JButton[9];
    JButton addButton, subtractButton, multiplyButton, divideButton, negButton;
    JButton clearButton, clearAllButton;
    JButton decButton, equalButton, delButton, clrButton;
    JPanel panel;
    Font myFont = new Font("IBM Plex Mono", Font.BOLD, 30);


    double num1 = 0,num2 = 0, result = 0;
    char operator;

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black));
        frame.setResizable(false);
        frame.setVisible(true);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);


        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        decButton = new JButton(".");
        equalButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");
        operatorButtons[0] = addButton;
        operatorButtons[1] = subtractButton;
        operatorButtons[2] = multiplyButton;
        operatorButtons[3] = divideButton;
        operatorButtons[4] = decButton;
        operatorButtons[5] = equalButton;
        operatorButtons[6] = delButton;
        operatorButtons[7] = clrButton;
        operatorButtons[8] = negButton;

        for (int i = 0; i < 9; i++) {
            operatorButtons[i].addActionListener(this);
            operatorButtons[i].setFont(myFont);
            operatorButtons[i].setFocusable(true);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }
        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(205, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.GRAY);

        
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subtractButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multiplyButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(divideButton);



        frame.add(panel);
        frame.add(textField);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(negButton);
        frame.setVisible(true);
        ImageIcon img = new ImageIcon("assets/images/CalculatorIcon.png");
        frame.setIconImage(img.getImage());
        textField.setEditable(false);
        
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // System.out.println("Hello World");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++) {
            if(e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subtractButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == multiplyButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divideButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == equalButton) {
            num2 = Double.parseDouble(textField.getText());
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
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            textField.setText("");
        }
        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for(int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));
        }
    }
}

