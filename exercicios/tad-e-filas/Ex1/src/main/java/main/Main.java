package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Fila filaPacientes = new Fila(20);
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o nome do paciente: ");
                    String nomePaciente = scanner.nextLine();
                    adicionarPaciente(filaPacientes, nomePaciente);
                }
                case 2 -> chamarProximoPaciente(filaPacientes);
                default -> System.out.println("Opção inválida. Digite novamente.");
            }
        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("Sistema de Fila de Pacientes");
        System.out.println("1 - Adicionar um paciente");
        System.out.println("2 - Chamar próximo paciente");
        System.out.println("0 - Sair");
        System.out.print("Digite sua opção: ");
        System.out.print("\n");
    }

    private static void adicionarPaciente(Fila filaPacientes, String nomePaciente) {
        if (filaPacientes.isFull()) {
            System.out.println("A capacidade máxima da fila foi atingida.");
            return;
        }

        filaPacientes.enqueue(nomePaciente);
        System.out.println("O paciente " + nomePaciente + " adicionado à fila com sucesso.");
    }

    private static void chamarProximoPaciente(Fila filaPacientes) {
        if (filaPacientes.isEmpty()) {
            System.out.println("Não há pacientes para chamar.");
            return;
        }

        String proximoPaciente = filaPacientes.dequeue();
        System.out.println("Próximo paciente: " + proximoPaciente);
    }
}
