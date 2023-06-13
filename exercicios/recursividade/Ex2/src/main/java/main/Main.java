package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um número: "));

        double fatorial = calcularFatorial(numero);

        JOptionPane.showMessageDialog(null, "O fatorial de " + numero + " é: " + fatorial);
    }

    private static long calcularFatorial(int numero) {
        if (numero == 0) {
            return 1;
        } else {
            return numero * calcularFatorial(numero - 1);
        }
    }
}