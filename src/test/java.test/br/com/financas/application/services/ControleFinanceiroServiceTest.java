package br.com.financas.application.services;

import br.com.financas.domain.entities.Categoria;
import br.com.financas.domain.entities.Despesa;
import br.com.financas.domain.entities.Membro;
import br.com.financas.domain.valueobjects.Money;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControleFinanceiroServiceTest {

    @Test
    void deveAdicionarDespesa() {

        ControleFinanceiroService service =
                new ControleFinanceiroService();

        Categoria categoria =
                new Categoria("Alimentação");

        Membro membro =
                new Membro(
                        "Anthony",
                        "anthony@email.com"
                );

        Despesa despesa =
                new Despesa(
                        "Pizza",
                        new Money(new BigDecimal("50.00")),
                        categoria,
                        LocalDate.now(),
                        membro
                );

        service.adicionarDespesa(despesa);

        assertEquals(
                1,
                service.quantidadeDespesas()
        );
    }

    @Test
    void deveCalcularTotalDasDespesas() {

        ControleFinanceiroService service =
                new ControleFinanceiroService();

        Categoria categoria =
                new Categoria("Alimentação");

        Membro membro =
                new Membro(
                        "Anthony",
                        "anthony@email.com"
                );

        service.adicionarDespesa(
                new Despesa(
                        "Pizza",
                        new Money(new BigDecimal("50.00")),
                        categoria,
                        LocalDate.now(),
                        membro
                )
        );

        service.adicionarDespesa(
                new Despesa(
                        "Hamburguer",
                        new Money(new BigDecimal("25.00")),
                        categoria,
                        LocalDate.now(),
                        membro
                )
        );

        assertEquals(
                new BigDecimal("75.00"),
                service.calcularTotal().getValor()
        );
    }
}