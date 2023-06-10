package services;

import models.ContaBancaria;

import javax.swing.*;

public class DepositoConta {
    public static void depositar(ContaBancaria conta) {
        double valor = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Informe o valor que deseja depositar."));

        do {
            if (valor < 10){
                valor = Double.parseDouble(JOptionPane.showInputDialog(null,
                        "Não é possível depositar menos de R$ 10,00. Tente novamente."));
            }
        } while (valor < 10);

        conta.setSaldo(valor);
    }
}
