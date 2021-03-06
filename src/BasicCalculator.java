import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.BoxLayout;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasicCalculator extends JPanel implements ActionListener {
    private JTextField display;
    private JPanel buttonsPanel;

    private JButton zero;
    private JButton one;
    private JButton two;
    private JButton three;
    private JButton four;
    private JButton five;
    private JButton six;
    private JButton seven;
    private JButton eight;
    private JButton nine;
    private JButton point;

    private JButton plus;
    private JButton minus;
    private JButton times;
    private JButton divide;

    private JButton equals;
    private JButton delete;
    private JButton clear;

    private boolean calcDone = true;
    private boolean operationPressed = false;

    private double num = 0;
    private double ans = 0;

    private int operationType;
    private final int NON = 0;
    private final int ADD = 1;
    private final int SUB = 2;
    private final int MUL = 3;
    private final int DIV = 4;

    public BasicCalculator() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        display = new JTextField("0.0");
        display.setEditable(false);
        display.setPreferredSize(new Dimension(400, 200));

        buttonsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        zero = new JButton("0");
        zero.addActionListener(this);

        one = new JButton("1");
        one.addActionListener(this);

        two = new JButton("2");
        two.addActionListener(this);

        three = new JButton("3");
        three.addActionListener(this);

        four = new JButton("4");
        four.addActionListener(this);

        five = new JButton("5");
        five.addActionListener(this);

        six = new JButton("6");
        six.addActionListener(this);

        seven = new JButton("7");
        seven.addActionListener(this);

        eight = new JButton("8");
        eight.addActionListener(this);

        nine = new JButton("9");
        nine.addActionListener(this);

        point = new JButton(".");
        point.addActionListener(this);

        plus = new JButton("\u002B");
        plus.addActionListener(this);

        minus = new JButton("\u002D");
        minus.addActionListener(this);

        times = new JButton("\u00D7");
        times.addActionListener(this);

        divide = new JButton("\u00F7");
        divide.addActionListener(this);

        equals = new JButton("\u003D");
        equals.addActionListener(this);

        delete = new JButton("del");
        delete.addActionListener(this);

        clear = new JButton("C");
        clear.addActionListener(this);

        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonsPanel.add(delete, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        buttonsPanel.add(clear, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        buttonsPanel.add(times, gbc);
        gbc.gridx = 3;
        gbc.gridy = 0;
        buttonsPanel.add(divide, gbc);
        gbc.gridx = 3;
        gbc.gridy = 1;
        buttonsPanel.add(plus, gbc);
        gbc.gridx = 3;
        gbc.gridy = 2;
        buttonsPanel.add(minus, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        buttonsPanel.add(seven, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        buttonsPanel.add(eight, gbc);
        gbc.gridx = 2;
        gbc.gridy = 1;
        buttonsPanel.add(nine, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        buttonsPanel.add(four, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        buttonsPanel.add(five, gbc);
        gbc.gridx = 2;
        gbc.gridy = 2;
        buttonsPanel.add(six, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        buttonsPanel.add(one, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        buttonsPanel.add(two, gbc);
        gbc.gridx = 2;
        gbc.gridy = 3;
        buttonsPanel.add(three, gbc);
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        buttonsPanel.add(zero, gbc);
        gbc.gridwidth = 1;
        gbc.gridx = 2;
        gbc.gridy = 4;
        buttonsPanel.add(point, gbc);
        gbc.gridheight = 2;
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        buttonsPanel.add(equals, gbc);

        this.add(display);
        this.add(buttonsPanel);
    }

    public void calculation() {
        double input;
        switch(operationType) {
            case ADD:
                try {
                    input = Double.parseDouble(display.getText());
                } catch(NumberFormatException nfe) {
                    input = 0.0;
                }
                ans = num += input;
                display.setText(ans + "");
                break;
            case SUB:
                try {
                    input = Double.parseDouble(display.getText());
                } catch(NumberFormatException nfe) {
                    input = 0.0;
                }
                ans = num -= input;
                display.setText(ans + "");
                break;
            case MUL:
                try {
                    input = Double.parseDouble(display.getText());
                } catch(NumberFormatException nfe) {
                    input = 0.0;
                }
                ans = num *= input;
                display.setText(ans + "");
                break;
            case DIV:
                try {
                    input = Double.parseDouble(display.getText());
                } catch(NumberFormatException nfe) {
                    input = 0.0;
                }
                if(input != 0.0) {
                    ans = num /= input;
                    display.setText(ans + "");
                } else {
                    display.setText("Cannot divide by zero");
                }
                break;

        }
        operationType = NON;
        calcDone = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(calcDone && e.getSource() != equals && e.getSource() != plus && e.getSource() != minus && e.getSource() != times && e.getSource() != divide) {
            display.setText("");
            calcDone = false;
        }
        if(e.getSource() == zero) {
            if(operationPressed) {
                display.setText("");
                operationPressed = false;
            }
            display.setText(display.getText() + "0");

        }
        if(e.getSource() == one) {
            if(operationPressed) {
                display.setText("");
                operationPressed = false;
            }
            display.setText(display.getText() + "1");

        }
        if(e.getSource() == two) {
            if(operationPressed) {
                display.setText("");
                operationPressed = false;
            }
            display.setText(display.getText() + "2");

        }
        if(e.getSource() == three) {
            if(operationPressed) {
                display.setText("");
                operationPressed = false;
            }
            display.setText(display.getText() + "3");

        }
        if(e.getSource() == four) {
            if(operationPressed) {
                display.setText("");
                operationPressed = false;
            }
            display.setText(display.getText() + "4");

        }
        if(e.getSource() == five) {
            if(operationPressed) {
                display.setText("");
                operationPressed = false;
            }
            display.setText(display.getText() + "5");

        }
        if(e.getSource() == six) {
            if(operationPressed) {
                display.setText("");
                operationPressed = false;
            }
            display.setText(display.getText() + "6");

        }
        if(e.getSource() == seven) {
            if(operationPressed) {
                display.setText("");
                operationPressed = false;
            }
            display.setText(display.getText() + "7");

        }
        if(e.getSource() == eight) {
            if(operationPressed) {
                display.setText("");
                operationPressed = false;
            }
            display.setText(display.getText() + "8");

        }
        if(e.getSource() == nine) {
            if(operationPressed) {
                display.setText("");
                operationPressed = false;
            }
            display.setText(display.getText() + "9");

        }
        if(e.getSource() == point) {
            display.setText(display.getText() + ".");

        }
        if(e.getSource() == plus) {
//            display.setText(display.getText() + "\u002B");
            operationType = ADD;
            try {
                num = Double.parseDouble(display.getText());
            } catch (NumberFormatException nfe) {
                num = 0;
            }
            operationPressed = true;
//            display.setText("");
        }
        if(e.getSource() == minus) {
//            display.setText(display.getText() + "\u002D");
            operationType = SUB;
            try {
                num = Double.parseDouble(display.getText());
            } catch (NumberFormatException nfe) {
                num = 0;
            }
            operationPressed = true;
//            display.setText("");
        }
        if(e.getSource() == times) {
//            display.setText(display.getText() + "\u00D7");
            operationType = MUL;
            try {
                num = Double.parseDouble(display.getText());
            } catch (NumberFormatException nfe) {
                num = 0;
            }
            operationPressed = true;
//            display.setText("");
        }
        if(e.getSource() == divide) {
//            display.setText(display.getText() + "\u00F7");
            operationType = DIV;
            try {
                num = Double.parseDouble(display.getText());
            } catch (NumberFormatException nfe) {
                num = 0;
            }
            operationPressed = true;
//            display.setText("");
        }
        if(e.getSource() == equals) {
//            display.setText(display.getText() + "\u003D");
            if(operationType != NON) {
                calculation();
            }
        }
        if(e.getSource() == delete) {
//            display.setText(display.getText().substring(0, display.getText().length()-1));
            int len = display.getText().length();
            if(len>1) {
                display.setText(display.getText().substring(0, len - 1));
            } else if(len == 1) {
                display.setText("0.0");
                calcDone = true;
            }
        }
        if(e.getSource() == clear) {
            display.setText("0.0");
            calcDone = true;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Basic Calculator");
        BasicCalculator calc = new BasicCalculator();
        frame.add(calc);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
