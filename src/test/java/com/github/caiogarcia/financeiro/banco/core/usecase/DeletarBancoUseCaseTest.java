package com.github.caiogarcia.financeiro.banco.core.usecase;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.github.caiogarcia.financeiro.banco.core.gateway.IDeletarBancoGateway;
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
public class DeletarBancoUseCaseTest {

    @Mock
    private IDeletarBancoGateway deletarGateway;
    @Mock
    private IRecuperarBancoGateway recuperarGateway;

    private DeletarBancoUseCase useCase;

    @BeforeEach
    public void beforeEach() {
        useCase = new DeletarBancoUseCase(deletarGateway, recuperarGateway);
    }

    @Test
    public void dadoUmBancoValidoQuandoChamadoOUseCaseEntaoDeveRetornarOIdCadastrado() {
        Integer idBanco = 1;
        Banco banco = Banco.builder().idBanco(1).codigo("123").nome("meu banco").build();
        when(recuperarGateway.executar(1)).thenReturn(Optional.of(banco));

        useCase.executar(idBanco);

        verify(deletarGateway, times(1)).executar(idBanco);
        verify(recuperarGateway, times(1)).executar(idBanco);

    }

    @Test
    public void dadoUmBancoInvalidoQuandoChamadoOUseCaseEntaoDeveRetornarUmaExcecao() {
        Integer idBanco = 1;
        when(recuperarGateway.executar(1)).thenReturn(Optional.empty());

        Assertions.assertThrows(RuntimeException.class, () -> {
            useCase.executar(idBanco);
        });

        verify(deletarGateway, times(0)).executar(idBanco);
        verify(recuperarGateway, times(1)).executar(idBanco);
    }

    @Test
    public void dadoUmBancoNuloQuandoChamadoOUseCaseEntaoDeveRetornarUmaRuntimeException() {
        Integer idBanco = null;

        Assertions.assertThrows(RuntimeException.class, () -> {
            useCase.executar(idBanco);
        });

        verify(deletarGateway, times(0)).executar(idBanco);
    }
}
