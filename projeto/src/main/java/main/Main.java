package main;

import models.ContaBancaria;
import services.BuscarConta;
import services.CadastrarConta;
import services.TransacoesConta;
import services.ExibirContas;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {
    private static final ArrayList<ContaBancaria> contas = new ArrayList<>();
    private static final ArrayList<ContaBancaria> contasSaldoNegativo = new ArrayList<>();

    public static void main(String[] args) {
        String[] opcoes = {
                "Cadastrar conta",
                "Exibir contas",
                "Realizar transação",
                "Saldo total do Banco",
                "Contas com saldo negativo"
        };

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        for (int i = 0; i < opcoes.length; i++) {
            final int opcaoIndex = i;

            JButton botao = new JButton(opcoes[i]);
            botao.addActionListener(e -> {
                switch (opcaoIndex) {
                    case 0 -> contas.addAll(CadastrarConta.cadastrar());
                    case 1 -> {
                        ExibirContas.exibir(contas);
                    }
                    case 2 -> {
                        ContaBancaria conta = BuscarConta.buscar(contas);
                        TransacoesConta.transacao(conta);
                    }
                    case 3 -> {
                        double saldoTotalBanco = calcularSaldoTotal();
                        JOptionPane.showMessageDialog(null,
                                "O saldo total do banco atualmente é: R$ " + saldoTotalBanco);
                    }
                    case 4 -> {
                        if (!contasSaldoNegativo.isEmpty()) {
                            JOptionPane.showMessageDialog(null,
                                    "Contas com saldo negativo: " + contasSaldoNegativo.toString());
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Não há nenhuma conta com saldo negativo");
                        }
                    }
                    default -> System.out.println("Nenhuma opção selecionada");
                }
            });

            gbc.gridx = 0;
            gbc.gridy = i;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            panel.add(botao, gbc);
        }

        JOptionPane.showOptionDialog(null, panel, "Banco Unipar Central",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
    }

    public static double calcularSaldoTotal() {
        return calcularSaldoTotalRecursivo(contas, 0);
    }

    private static double calcularSaldoTotalRecursivo(ArrayList<ContaBancaria> contas, int i) {
        if (i == contas.size()) {
            return 0;
        } else {
            ContaBancaria contaAtual = contas.get(i);
            double saldoContaAtual = contaAtual.getSaldo();
            if (saldoContaAtual < 0) {
                contasSaldoNegativo.add(contaAtual);
            }
            double saldoTotalRestante = calcularSaldoTotalRecursivo(contas, i + 1);
            return saldoContaAtual + saldoTotalRestante;
        }
    }
}