package models;

public class Cliente {
    private int senha;
    private String nome;
    private int anoNascimento;

    public Cliente(String nome, int anoNascimento) {
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        gerarSenha();
    }

    public int getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public boolean isPrioritario() {
        int idade = calcularIdade();
        return idade >= 65;
    }

    private int calcularIdade() {
        int anoAtual = java.time.Year.now().getValue();
        return anoAtual - anoNascimento;
    }

    private void gerarSenha() {
        senha = (int) (Math.random() * 1000); // Gera uma senha aleatória de 0 a 999
    }
}
