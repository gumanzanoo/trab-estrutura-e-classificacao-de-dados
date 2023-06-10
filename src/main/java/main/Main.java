package main;

import models.ContaBancaria;
import services.BuscarConta;
import services.CadastrarConta;
import services.ExibirContas;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
    private static final ArrayList<ContaBancaria> contas = new ArrayList<>();

    public static void main(String[] args) {
        String[] opcoes = { "Opção 1", "Opção 2", "Opção 3", "Opção 4" };

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (String opcao : opcoes) {
            JButton botao = new JButton(opcao);
            botao.setAlignmentX(JButton.CENTER_ALIGNMENT);
            botao.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String opcaoSelecionada = ((JButton) e.getSource()).getText();
                    switch (opcaoSelecionada) {
                        case "Opção 1" -> {
                            contas.addAll(CadastrarConta.cadastrar());
                        }

                        case "Opção 2" -> {
                            ExibirContas.exibir(contas);
                        }

                        case "Opção 3" -> {
                            System.out.println(BuscarConta.buscar(contas).toString());
                        }

                        case "Opção 4" -> System.out.println("Opção 4 selecionada");
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
}