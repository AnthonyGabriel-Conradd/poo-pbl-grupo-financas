package br.com.financas.presentation;

import br.com.financas.application.services.ControleFinanceiroService;
import br.com.financas.domain.entities.Categoria;
import br.com.financas.domain.entities.Despesa;
import br.com.financas.domain.entities.Membro;
import br.com.financas.domain.valueobjects.Money;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        ControleFinanceiroService service =
                new ControleFinanceiroService();

        Categoria alimentacao = Categoria.ALIMENTACAO;
        Membro anthony =
                new Membro(
                        "Anthony Gabriel",
                        "anthony@email.com"
                );

        service.adicionarDespesa(
                new Despesa(
                        "Pizza",
                        new Money(new BigDecimal("50.00")),
                        alimentacao,
                        LocalDate.now(),
                        anthony
                )
        );

        service.adicionarDespesa(
                new Despesa(
                        "Hambúrguer",
                        new Money(new BigDecimal("25.00")),
                        alimentacao,
                        LocalDate.now(),
                        anthony
                )
        );

        System.out.println("===== SISTEMA DE FINANÇAS =====");

        System.out.println(
                "Quantidade de despesas: "
                        + service.quantidadeDespesas()
        );

        System.out.println(
                "Total gasto: R$ "
                        + service.calcularTotal().getValor()
        );
    }
}