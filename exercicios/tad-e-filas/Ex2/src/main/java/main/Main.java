package main;

import models.Cliente;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Fila filaPrioritaria = new Fila();
        Fila filaNormal = new Fila();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> adicionarCliente(scanner, filaPrioritaria, filaNormal);
                case 2 -> chamarCliente(filaPrioritaria, filaNormal);
                default -> System.out.println("Opção inválida. Digite novamente.");
            }
        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("Sistema de Fila de Pagamentos no Caixa");
        System.out.println("1 - Adicionar cliente");
        System.out.println("2 - Chamar cliente");
        System.out.println("0 - Sair");
        System.out.print("Digite sua opção: ");
        System.out.print("\n");
    }

    private static void adicionarCliente(Scanner scanner, Fila filaPrioritaria, Fila filaNormal) {
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o ano de nascimento do cliente: ");
        int anoNascimento = scanner.nextInt();
        scanner.nextLine();

        Cliente cliente = new Cliente(nome, anoNascimento);
        if (cliente.isPrioritario()) {
            filaPrioritaria.enqueue(cliente);
            System.out.println("Cliente " + cliente.getNome() + " adicionado à fila prioritária.");
        } else {
            filaNormal.enqueue(cliente);
            System.out.println("Cliente " + cliente.getNome() + " adicionado à fila normal.");
        }
    }

    private static void chamarCliente(Fila filaPrioritaria, Fila filaNormal) {
        if (!filaPrioritaria.isEmpty()) {
            Cliente clientePrioritario = filaPrioritaria.dequeue();
            System.out.println("Cliente prioritário chamado: " + clientePrioritario.getNome());
        } else if (!filaNormal.isEmpty()) {
            Cliente clienteNormal = filaNormal.dequeue();
            System.out.println("Cliente normal chamado: " + clienteNormal.getNome());
        } else {
            System.out.println("Não há clientes na fila.");
        }
    }
}