package org.example;

import static javax.swing.JOptionPane.*;

public class Main {
    public static void main(String[] args) {
        String value;
        String errorMessage;
        String INITIAL_VALUE_PROPERTY = "1";
        String title = "Ensira o valor de converção";
        value = showInputDialog(title, INITIAL_VALUE_PROPERTY);
        int userValueNumber = Integer.parseInt(value);
        System.out.println(userValueNumber);

        if (value.isEmpty()) {
            errorMessage = "valor em branco";
            showMessageDialog(null, errorMessage, errorMessage, 0);
        }


    }
}