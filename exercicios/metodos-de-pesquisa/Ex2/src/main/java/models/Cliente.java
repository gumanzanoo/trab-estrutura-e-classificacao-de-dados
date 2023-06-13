package models;

public class Cliente {
    private int codigo;
    private String nome;
    private String dataNascimento;
    private String cpf;

    public Cliente(int codigo, String nome, String dataNascimento, String cpf) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return  "Cliente encontrado:\n" +
                "Código: " + this.getCodigo() + "\n" +
                "Nome: " + this.getNome() + "\n" +
                "Data de Nascimento: " + this.getDataNascimento() + "\n" +
                "CPF: " + this.getCpf();
    }
}
