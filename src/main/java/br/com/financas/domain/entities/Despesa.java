package br.com.financas.domain.entities;

import br.com.financas.domain.valueobjects.Money;

import java.time.LocalDate;

public class Despesa {

    private final String descricao;
    private final Money valor;
    private final Categoria categoria;
    private final LocalDate data;
    private final Membro responsavel;

    public Despesa(
            String descricao,
            Money valor,
            Categoria categoria,
            LocalDate data,
            Membro responsavel
    ) {
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
        this.data = data;
        this.responsavel = responsavel;
    }

    public Money getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public LocalDate getData() {
        return data;
    }

    public Membro getResponsavel() {
        return responsavel;
    }
}