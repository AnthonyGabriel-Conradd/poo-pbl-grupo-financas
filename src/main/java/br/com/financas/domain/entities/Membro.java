package br.com.financas.domain.entities;

public class Membro {

    private final String nome;
    private final String email;

    public Membro(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}