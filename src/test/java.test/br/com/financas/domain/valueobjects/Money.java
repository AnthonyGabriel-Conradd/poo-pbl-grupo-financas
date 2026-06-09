package br.com.financas.domain.valueobjects;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void deveCriarValorValido() {

        Money money = new Money(new BigDecimal("100"));

        assertEquals(
                new BigDecimal("100"),
                money.getValor()
        );
    }

    @Test
    void deveLancarExcecaoQuandoValorNegativo() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Money(new BigDecimal("-10"))
        );
    }
}