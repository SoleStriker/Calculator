import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
// import com.

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] operatorButtons = new JButton[8];
    JButton addButton, subtractButton, multiplyButton, divideButton;
    JButton clearButton, clearAllButton;
    JButton decButton, equalButton, delButton, clrButton;
    JPanel panel;
    Font myFont = new Font("Serif", Font.BOLD, 30);

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
        frame.add(textField);

        ImageIcon img = new ImageIcon("assets/images/CalculatorIcon.png");
        frame.setIconImage(img.getImage());
//      textField.setEditable(false);


        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}

