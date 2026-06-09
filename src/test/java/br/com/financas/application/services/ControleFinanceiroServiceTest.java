package br.com.financas.application.services;

import br.com.financas.domain.entities.*;
import br.com.financas.domain.valueobjects.Money;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ControleFinanceiroServiceTest {

    @Test
    void deveAdicionarDespesa() {

        ControleFinanceiroService service = new ControleFinanceiroService();

        Membro membro = new Membro(
                "Anthony",
                "anthony@email.com"
        );

        Despesa despesa = new Despesa(
                "Aluguel",
                new Money(new BigDecimal("1000")),
                Categoria.MORADIA,
                LocalDate.now(),
                membro
        );

        service.adicionarDespesa(despesa);

        assertEquals(1, service.quantidadeDespesas());
    }

    @Test
    void deveCalcularTotalCorretamente() {

        ControleFinanceiroService service = new ControleFinanceiroService();

        Membro membro = new Membro(
                "Anthony",
                "anthony@email.com"
        );

        service.adicionarDespesa(new Despesa(
                "Aluguel",
                new Money(new BigDecimal("1000")),
                Categoria.MORADIA,
                LocalDate.now(),
                membro
        ));

        service.adicionarDespesa(new Despesa(
                "Internet",
                new Money(new BigDecimal("200")),
                Categoria.MORADIA,
                LocalDate.now(),
                membro
        ));

        Money total = service.calcularTotal();

        assertEquals(new BigDecimal("1200"), total.getValor());
    }

    @Test
    void deveRetornarZeroQuandoNaoHouverDespesas() {

        ControleFinanceiroService service = new ControleFinanceiroService();

        Money total = service.calcularTotal();

        assertEquals(new BigDecimal("0"), total.getValor());
    }
}