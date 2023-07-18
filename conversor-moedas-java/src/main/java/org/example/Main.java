package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.swing.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        String value;
        String errorMessage;
        String INITIAL_VALUE_PROPERTY = "1";
        String title = "Ensira o valor de converção";
        String[] options = {"BRL", "USD", "EUR"};
        boolean isPaused = false;

        while(!isPaused) {
            String optionToConvert = (String) JOptionPane.showInputDialog(
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
                isPaused = true;
                return;
            }

            if (!value.matches("^[0-9]*$")) {
                errorMessage = "Apenas valores numéricos";
                JOptionPane.showMessageDialog(null, errorMessage, errorMessage, 0);
                isPaused = true;
                return;
            }

            String optionToBeConverted = (String) JOptionPane.showInputDialog(
                    null,
                    "Escolha uma opção para ser convertido: ",
                    "conversor",
                    1,
                    null,
                    options,
                    options[0]
            );

            if (optionToConvert.equals(optionToBeConverted)) {
                errorMessage = "Não pode converter as moedas iguais";
                JOptionPane.showMessageDialog(null, errorMessage, errorMessage, 0);
                isPaused = true;
                return;
            }

            RequestFinalValue requestFinalValue = new RequestFinalValue();

            String valueToShow = requestFinalValue.getFinalValue(optionToConvert, optionToBeConverted, value);
            String messageValue = "The result is: ";

            JOptionPane.showMessageDialog(null, messageValue + valueToShow, messageValue + valueToShow, 1);

            String[] finalOptions = { "OK", "CANCEL" };
            Object continueOrCancel = JOptionPane.showOptionDialog(null, "Click OK to continue or cancel", "Warning",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, finalOptions, finalOptions[0]);
            System.out.println(continueOrCancel);
            int convertValue = Integer.parseInt(continueOrCancel.toString());
            if (convertValue == 1){
                isPaused = true;
            }
        }
    }
}