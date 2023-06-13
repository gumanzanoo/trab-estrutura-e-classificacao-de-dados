package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int quantidadeNumeros = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de números a serem cadastrados:"));
        int[] numeros = new int[quantidadeNumeros];

        for (int i = 0; i < quantidadeNumeros; i++) {
            String numeroStr = JOptionPane.showInputDialog("Número " + (i + 1) + ":");
            int numero = Integer.parseInt(numeroStr);
            numeros[i] = numero;
        }

        ordenarRange(numeros);

        int opcao;

        String[] opcoes = {"Realizar Pesquisa", "Sair"};

        do {
            opcao = JOptionPane.showOptionDialog(null, null, "Pesquisa Linear em Ordem Crescente",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, null);

            switch (opcao) {
                case 0 -> {
                    int numeroPesquisa = Integer.parseInt(JOptionPane.showInputDialog("Digite o número a ser pesquisado:"));
                    realizarPesquisaLinear(numeros, numeroPesquisa);
                }
                case 1 -> JOptionPane.showMessageDialog(null, "Encerrando o programa...");
                default -> JOptionPane.showMessageDialog(null, "Opção inválida. Digite novamente.");
            }
        } while (opcao != 1);
    }

    private static void ordenarRange(int[] array) {
        int tamanho = array.length;

        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = 0; j < tamanho - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static void realizarPesquisaLinear(int[] numeros, int numeroPesquisa) {
        boolean encontrado = false;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == numeroPesquisa) {
                JOptionPane.showMessageDialog(null, "Número encontrado na posição: " + (i + 1));
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Número não encontrado.");
        }
    }
}