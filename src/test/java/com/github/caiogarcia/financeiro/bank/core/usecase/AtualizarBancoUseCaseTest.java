package com.github.caiogarcia.financeiro.bank.core.usecase;

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
import com.github.caiogarcia.financeiro.bank.core.gateway.IUpdateBankGateway;
import com.github.caiogarcia.financeiro.bank.core.model.Bank;

@ExtendWith(MockitoExtension.class)
@Tag("Unit")
public class AtualizarBancoUseCaseTest {

    @Mock
    private IUpdateBankGateway atualizarGateway;
    @Mock
    private IRetrieveBankGateway recuperarGateway;

    private UpdateBankUseCase useCase;

    @BeforeEach
    public void beforeEach() {
        useCase = new UpdateBankUseCase(atualizarGateway, recuperarGateway);
    }

    @Test
    public void dadoUmBancoValidoQuandoChamadoOUseCaseEntaoDeveAtualizarOBancoCadastrado() {
        Bank banco = Bank.builder().idBank(1).code("123").name("meu banco").build();

        when(recuperarGateway.execute(1)).thenReturn(Optional.of(banco));

        useCase.execute(banco);

        verify(atualizarGateway, times(1)).execute(banco);
        verify(recuperarGateway, times(1)).execute(1);
    }

    @Test
    public void dadoUmBancoInvalidoQuandoChamadoOUseCaseEntaoDeveRetornarUmaExcecao() {
        Bank banco = Bank.builder().idBank(1).code("123").name("meu banco").build();
        when(recuperarGateway.execute(1)).thenReturn(Optional.empty());

        Assertions.assertThrows(RuntimeException.class, () -> {
            useCase.execute(banco);
        });

        verify(atualizarGateway, times(0)).execute(banco);
        verify(recuperarGateway, times(1)).execute(1);
    }

    @Test
    public void dadoUmBancoNuloQuandoChamadoOUseCaseEntaoDeveRetornarUmaRuntimeException() {
        Bank banco = null;

        Assertions.assertThrows(RuntimeException.class, () -> {
            useCase.execute(banco);
        });

        verify(atualizarGateway, times(0)).execute(banco);
    }
}
