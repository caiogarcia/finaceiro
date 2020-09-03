package com.github.caiogarcia.financeiro.banco.core.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.caiogarcia.financeiro.banco.core.gateway.ICadastrarBancoGateway;
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
public class CadastrarBancoUseCaseTest {
    
    @Mock
    private ICadastrarBancoGateway gateway;

    private CadastrarBancoUseCase useCase;

    @BeforeEach
    public void beforeEach() {
        useCase = new CadastrarBancoUseCase(gateway);
    }

    @Test
    public void dadoUmBancoValidoQuandoChamadoOUseCaseEntaoDeveRetornarOIdCadastrado(){
        Banco banco = Banco.builder().codigo("123").nome("meu banco").build();

        Integer expectedId = 1;
        when(gateway.executar(banco)).thenReturn(1);

        Integer actual = useCase.executar(banco);

        verify(gateway, times(1)).executar(banco);
        assertEquals(expectedId, actual);
    }

    
    @Test
    public void dadoUmBancoNuloQuandoChamadoOUseCaseEntaoDeveRetornarUmaRuntimeException(){
        Banco banco = null;

        Assertions.assertThrows(RuntimeException.class, () -> {
            useCase.executar(banco);
        });

        verify(gateway, times(0)).executar(banco);
    }
}
