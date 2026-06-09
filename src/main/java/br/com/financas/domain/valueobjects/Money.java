package br.com.financas.domain.valueobjects;

import java.math.BigDecimal;

public class Money {

    private final BigDecimal valor;

    public Money(BigDecimal valor) {

        if (valor == null) {
            throw new IllegalArgumentException(
                    "Valor não pode ser nulo"
            );
        }

        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    "Valor não pode ser negativo"
            );
        }

        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }
}