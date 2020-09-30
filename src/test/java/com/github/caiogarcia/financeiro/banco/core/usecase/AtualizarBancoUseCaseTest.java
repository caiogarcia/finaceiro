package com.github.caiogarcia.financeiro.banco.core.usecase;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.github.caiogarcia.financeiro.banco.core.gateway.IAtualizarBancoGateway;
import com.github.caiogarcia.financeiro.banco.core.gateway.IRecuperarBancoGateway;
import com.github.caiogarcia.financeiro.banco.core.model.Banco;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@Tag("Unit")
public class AtualizarBancoUseCaseTest {

    @Mock
    private IAtualizarBancoGateway atualizarGateway;
    @Mock
    private IRecuperarBancoGateway recuperarGateway;

    private AtualizarBancoUseCase useCase;

    @BeforeEach
    public void beforeEach() {
        useCase = new AtualizarBancoUseCase(atualizarGateway, recuperarGateway);
    }

    @Test
    public void dadoUmBancoValidoQuandoChamadoOUseCaseEntaoDeveAtualizarOBancoCadastrado() {
        Banco banco = Banco.builder().idBanco(1).codigo("123").nome("meu banco").build();

        when(recuperarGateway.executar(1)).thenReturn(Optional.of(banco));

        useCase.executar(banco);

        verify(atualizarGateway, times(1)).executar(banco);
        verify(recuperarGateway, times(1)).executar(1);
    }

    @Test
    public void dadoUmBancoNuloQuandoChamadoOUseCaseEntaoDeveRetornarUmaRuntimeException() {
        Banco banco = null;

        Assertions.assertThrows(RuntimeException.class, () -> {
            useCase.executar(banco);
        });

        verify(atualizarGateway, times(0)).executar(banco);
    }
}
