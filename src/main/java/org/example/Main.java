package org.example;

import javax.swing.*;


public class Main {



    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            JPanel panel = new JPanel();
            JTextField num1Field = new JTextField(5);
            JTextField num2Field = new JTextField(5);

            panel.add(new JLabel("Primer número:"));
            panel.add(num1Field);
            panel.add(new JLabel("Segundo número:"));
            panel.add(num2Field);

            String[] opciones = {"Suma", "Resta", "Multiplicación", "División", "Salir"};
            int opcion = JOptionPane.showOptionDialog(null, panel,
                    "Calculadora", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

            double num1 = 0;
            double num2 = 0;

            if (opcion == 4) {
                continuar = false;
                continue;
            }

            while (true) {
                try {
                    num1 = Double.parseDouble(num1Field.getText());
                    num2 = Double.parseDouble(num2Field.getText());

                    if (opcion == 3 && num2 == 0) {
                        throw new ArithmeticException("No se puede dividir por cero");
                    }

                    break; //Salimos del bucle
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                    num1Field.setText(""); // Limpiamos los campos de texto
                    num2Field.setText("");
                    opcion = JOptionPane.showOptionDialog(null, panel,
                            "Calculadora", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
                } catch (ArithmeticException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    num2Field.setText("");
                    opcion = JOptionPane.showOptionDialog(null, panel,
                            "Calculadora", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
                }
            }

            double resultado = 0;
            switch (opcion) {
                case 0:
                    resultado = suma(num1, num2);
                    break;
                case 1:
                    resultado = resta(num1, num2);
                    break;
                case 2:
                    resultado = multiplicacion(num1, num2);
                    break;
                case 3:
                    resultado = division(num1, num2);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }

            if (opcion != 4) {
                JOptionPane.showMessageDialog(null, "El resultado es: " + resultado);
            }
        }
    }

    public static double suma(double num1, double num2) {
        return num1 + num2;
    }

    public static double resta(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiplicacion(double num1, double num2) {
        return num1 * num2;
    }

    public static double division(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        } else {
            return num1 / num2;
        }
    }
}