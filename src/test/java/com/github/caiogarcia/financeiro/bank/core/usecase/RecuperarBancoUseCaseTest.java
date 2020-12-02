package com.github.caiogarcia.financeiro.bank.core.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.github.caiogarcia.financeiro.bank.core.gateway.IRetrieveBankGateway;
import com.github.caiogarcia.financeiro.bank.core.model.Bank;

@ExtendWith(MockitoExtension.class)
@Tag("Unit")
public class RecuperarBancoUseCaseTest {

    @Mock
    private IRetrieveBankGateway gateway;

    private RetrieveBankUseCase useCase;

    @BeforeEach
    public void beforeEach() {
        useCase = new RetrieveBankUseCase(gateway);
    }

    @Test
    public void dadoUmBancoValidoQuandoChamadoOUseCaseEntaoDeveRetornarOBancoCadastrado() {
        Optional<Bank> banco = Optional.of(Bank.builder().idBank(1).code("123").name("meu banco").build());

        Integer idBanco = 1;
        when(gateway.execute(idBanco)).thenReturn(banco);

        Optional<Bank> actual = useCase.execute(idBanco);

        verify(gateway, times(1)).execute(idBanco);
        assertEquals(banco, actual);
    }

    @Test
    public void dadoUmBancoNuloQuandoChamadoOUseCaseEntaoDeveRetornarUmaExcecao() {

        Integer idBanco = null;
        Assertions.assertThrows(RuntimeException.class, () -> {
            useCase.execute(idBanco);
        });

        verify(gateway, times(0)).execute(idBanco);
    }

}
