package main;

import models.ContaBancaria;
import services.BuscarConta;
import services.CadastrarConta;
import services.TransacoesConta;
import services.ExibirContas;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
    private static final ArrayList<ContaBancaria> contas = new ArrayList<>();
    private static final ArrayList<ContaBancaria> contasSaldoNegativo = new ArrayList<>();

    public static void main(String[] args) {
        String[] opcoes = { "Opção 1", "Opção 2", "Opção 3", "Opção 4", "Opção 5"};

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (int i = 0; i < opcoes.length; i++) {
            JButton botao = new JButton(opcoes[i]);
            botao.setAlignmentX(JButton.CENTER_ALIGNMENT);
            int opcao = i;

            botao.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    switch (opcao) {
                        case 0 -> contas.addAll(CadastrarConta.cadastrar());
                        case 1 -> ExibirContas.exibir(contas);
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
                }
            });
            panel.add(botao);
            panel.setPreferredSize(new Dimension(500, 500));
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