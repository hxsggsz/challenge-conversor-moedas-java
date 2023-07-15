package org.example;

import org.example.enums.country;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String value;
        String errorMessage;
        String INITIAL_VALUE_PROPERTY = "1";
        String title = "Ensira o valor de converção";
        country[] options = {country.BRL, country.DOL, country.EUR};

        Object optionToConvert = JOptionPane.showInputDialog(
                null,
                "Escolha uma opção para ser convertido: ",
                "conversor",
                1,
                null,
                options,
                options[0]
        );

        value = JOptionPane.showInputDialog(title, INITIAL_VALUE_PROPERTY);

        System.out.println(value);

        if (value.isEmpty()) {
            errorMessage = "valor em branco";
            JOptionPane.showMessageDialog(null, errorMessage, errorMessage, 0);
            return;
        }

        if (!value.matches("^[0-9]*$")) {
            errorMessage = "Apenas valores numéricos";
            JOptionPane.showMessageDialog(null, errorMessage, errorMessage, 0);
            return;
        }

        Object optionToBeConverted = JOptionPane.showInputDialog(
            null,
            "Escolha uma opção para ser convertido: ",
            "conversor",
            1,
            null,
            options,
            options[0]
        );
        System.out.println(optionToBeConverted);
    }
}