package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um número:"));

        System.out.println("Sequência de Fibonacci até " + numero + ":");
        for (int i = 0; i <= numero; i++) {
            int fibonacci = calcularFibonacci(i);
            System.out.print(fibonacci + "\n");
        }
    }

    private static int calcularFibonacci(int numero) {
        if (numero <= 1) {
            return numero;
        } else {
            return calcularFibonacci(numero - 1) + calcularFibonacci(numero - 2);
        }
    }
}