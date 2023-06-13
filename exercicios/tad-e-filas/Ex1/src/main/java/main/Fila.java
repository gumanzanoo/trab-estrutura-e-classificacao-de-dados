package main;

public class Fila {
    private final String[] vetorDados;
    private int frente;
    private int fim;
    private int qtdItens;

    public Fila(int tamanho) {
        vetorDados = new String[tamanho];
        frente = 0;
        fim = -1;
        qtdItens = 0;
    }

    public void enqueue(String nome) {
        if (fim == vetorDados.length - 1) {
            fim = -1;
        }

        vetorDados[++fim] = nome;
        qtdItens++;
    }

    public String dequeue() {
        String aux = vetorDados[frente++];
        if (frente == vetorDados.length) {
            frente = 0;
        }
        qtdItens--;
        return aux;
    }

    public boolean isEmpty() {
        return qtdItens == 0;
    }

    public boolean isFull() {
        return qtdItens == vetorDados.length;
    }
}