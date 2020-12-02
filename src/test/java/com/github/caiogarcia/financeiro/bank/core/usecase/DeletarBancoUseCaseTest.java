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

import com.github.caiogarcia.financeiro.bank.core.gateway.IDeleteBankGateway;
import com.github.caiogarcia.financeiro.bank.core.gateway.IRetrieveBankGateway;
import com.github.caiogarcia.financeiro.bank.core.model.Bank;

@ExtendWith(MockitoExtension.class)
@Tag("Unit")
public class DeletarBancoUseCaseTest {

    @Mock
    private IDeleteBankGateway deletarGateway;
    @Mock
    private IRetrieveBankGateway recuperarGateway;

    private DeleteBankUseCase useCase;

    @BeforeEach
    public void beforeEach() {
        useCase = new DeleteBankUseCase(deletarGateway, recuperarGateway);
    }

    @Test
    public void dadoUmBancoValidoQuandoChamadoOUseCaseEntaoDeveRetornarOIdCadastrado() {
        Integer idBanco = 1;
        Bank banco = Bank.builder().idBank(1).code("123").name("meu banco").build();
        when(recuperarGateway.execute(1)).thenReturn(Optional.of(banco));

        useCase.execute(idBanco);

        verify(deletarGateway, times(1)).execute(idBanco);
        verify(recuperarGateway, times(1)).execute(idBanco);

    }

    @Test
    public void dadoUmBancoInvalidoQuandoChamadoOUseCaseEntaoDeveRetornarUmaExcecao() {
        Integer idBanco = 1;
        when(recuperarGateway.execute(1)).thenReturn(Optional.empty());

        Assertions.assertThrows(RuntimeException.class, () -> {
            useCase.execute(idBanco);
        });

        verify(deletarGateway, times(0)).execute(idBanco);
        verify(recuperarGateway, times(1)).execute(idBanco);
    }

    @Test
    public void dadoUmBancoNuloQuandoChamadoOUseCaseEntaoDeveRetornarUmaRuntimeException() {
        Integer idBanco = null;

        Assertions.assertThrows(RuntimeException.class, () -> {
            useCase.execute(idBanco);
        });

        verify(deletarGateway, times(0)).execute(idBanco);
    }
}
