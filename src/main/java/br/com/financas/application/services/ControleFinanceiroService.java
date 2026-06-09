package br.com.financas.application.services;

import br.com.financas.domain.entities.Despesa;
import br.com.financas.domain.valueobjects.Money;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ControleFinanceiroService {

    private final List<Despesa> despesas = new ArrayList<>();

    public void adicionarDespesa(Despesa despesa) {
        despesas.add(despesa);
    }

    public int quantidadeDespesas() {
        return despesas.size();
    }

    public Money calcularTotal() {

        BigDecimal total = BigDecimal.ZERO;

        for (Despesa despesa : despesas) {
            total = total.add(
                    despesa.getValor().getValor()
            );
        }

        return new Money(total);
    }
}