package com.github.caiogarcia.financeiro.banco.core.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.github.caiogarcia.financeiro.banco.core.gateway.IRecuperarBancoGateway;
import com.github.caiogarcia.financeiro.banco.core.model.Banco;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@Tag("Unit")
public class RecuperarBancoUseCaseTest {

    @Mock
    private IRecuperarBancoGateway gateway;

    private RecuperarBancoUseCase useCase;

    @BeforeEach
    public void beforeEach() {
        useCase = new RecuperarBancoUseCase(gateway);
    }

    @Test
    public void dadoUmBancoValidoQuandoChamadoOUseCaseEntaoDeveRetornarOBancoCadastrado() {
        Optional<Banco> banco = Optional.of(Banco.builder().idBanco(1).codigo("123").nome("meu banco").build());

        Integer idBanco = 1;
        when(gateway.executar(idBanco)).thenReturn(banco);

        Optional<Banco> actual = useCase.executar(idBanco);

        verify(gateway, times(1)).executar(idBanco);
        assertEquals(banco, actual);
    }

}
