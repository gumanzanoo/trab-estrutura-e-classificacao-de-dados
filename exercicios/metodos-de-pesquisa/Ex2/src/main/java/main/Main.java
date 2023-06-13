package main;

import models.Cliente;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();

        int quantidadeClientes = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de clientes a serem cadastrados:"));

        for (int i = 0; i < quantidadeClientes; i++) {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Cliente " + (i + 1) + "\nCódigo:"));
            String nome = JOptionPane.showInputDialog("Nome:");
            String dataNascimento = JOptionPane.showInputDialog("Data de Nascimento:");
            String cpf = JOptionPane.showInputDialog("CPF:");

            Cliente cliente = new Cliente(codigo, nome, dataNascimento, cpf);
            clientes.add(cliente);
        }

        ordenarRange(clientes);

        int codigoPesquisa = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do cliente a ser pesquisado:"));

        int indice = pesquisaBinaria(clientes, codigoPesquisa);
        if (indice != -1) {
            Cliente clienteEncontrado = clientes.get(indice);
            JOptionPane.showMessageDialog(null,
                    clienteEncontrado.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
        }
    }

    private static void ordenarRange(List<Cliente> clientes) {
        int tamanho = clientes.size();

        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = 0; j < tamanho - i - 1; j++) {
                if (clientes.get(j).getCodigo() > clientes.get(j + 1).getCodigo()) {
                    Cliente temp = clientes.get(j);
                    clientes.set(j, clientes.get(j + 1));
                    clientes.set(j + 1, temp);
                }
            }
        }
    }

    private static int pesquisaBinaria(List<Cliente> clientes, int codigoPesquisa) {
        int esquerda = 0;
        int direita = clientes.size() - 1;

        while (esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2;
            int codigoAtual = clientes.get(meio).getCodigo();

            if (codigoAtual == codigoPesquisa) {
                return meio;
            }

            if (codigoAtual < codigoPesquisa) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }

        return -1;
    }
}