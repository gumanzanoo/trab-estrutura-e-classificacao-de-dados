package main;

public class Main {
    public static void main(String[] args) {
        int resultado = soma(50);
        System.out.println(resultado);
    }

    public static int soma(int numero) {
        if (numero == 1) {
            return 1;
        }
        return numero + soma(numero - 1);
    }
}