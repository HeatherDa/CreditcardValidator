package com.Heather;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CCValidate extends JFrame{
    private JButton validateButton;
    private JTextField creditCardNumberTextField;
    private JPanel rootPanel;
    private JLabel validMessageLabel;
    private JButton quitButton;
    private JLabel instructionLabel;

    public CCValidate(){
        super("Credit Card Validator");
        setContentPane(rootPanel);
        setPreferredSize(new Dimension(400,250));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ccNumber=creditCardNumberTextField.getText();
                boolean valid=isVisaCreditCardNumberValid(ccNumber);
                if(valid){
                    validMessageLabel.setText("Credit card number is valid.");
                }else {
                    validMessageLabel.setText("Credit card number is not valid.");
                }
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private boolean isVisaCreditCardNumberValid(String ccNumber){//this is the part that tests whether the card number is valid or not.

            if (!ccNumber.startsWith("4") || (ccNumber.length() != 16)){
                System.out.println("Doesnt start with 4 or length wrong");
                return false;
            }

            int sum = 0;

            for (int i = 0; i < 16 ; i++ ) {
                int thisDigit = Integer.parseInt((ccNumber.substring(i, i+1)));
                if (i % 2 == 1) {
                    sum = sum + thisDigit;
                } else {
                    int doubled = thisDigit * 2;
                    if (doubled > 9 ) {
                        int toAdd = 1 + (doubled % 10);
                        sum = sum + toAdd;
                    } else {
                        sum = sum + (thisDigit * 2);
                    }
                }
            }
            if (sum % 10 == 0) {
                return true;
            }
            return false;
    }
}
