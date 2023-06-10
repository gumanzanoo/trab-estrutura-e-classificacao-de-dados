package services;

import models.ContaBancaria;

import javax.swing.*;
import java.util.ArrayList;

public class CadastrarConta {
    public static ArrayList<ContaBancaria> cadastrar() {
        ArrayList<ContaBancaria> contas = new ArrayList<>();

        int qtdContas = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Informe quantas contas deseja cadastrar: "));

        int option;
        do {
            option = JOptionPane.showConfirmDialog(null,
                    "Deseja mesmo cadastrar " + qtdContas + " contas?");
            if (option == 1) {
                qtdContas = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Confirme novamente quantas contas deseja cadastrar: "));

                continue;
            } else if (option == 2) {
                System.exit(0);
            }
        } while (option == 1);

        int i = 0;
        do {
            int numConta = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Informe o número da " + (i+1) + "ª" + " conta:"));

            String nmTitular = JOptionPane.showInputDialog(null,
                    "Informe o nome do titular:");

            int saldo = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Informe o saldo inicial:"));

            ContaBancaria contaBancaria = new ContaBancaria();
            contaBancaria.setNumConta(numConta);
            contaBancaria.setNmTitular(nmTitular);
            contaBancaria.setSaldo(saldo);

            contas.add(contaBancaria);

            i++;
        } while (i < qtdContas);

        return contas;
    }
}
