package com.github.caiogarcia.financeiro.banco.core.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.*;
import java.util.List;

import com.github.caiogarcia.financeiro.banco.core.gateway.IListarBancoGateway;
import com.github.caiogarcia.financeiro.banco.core.model.Banco;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@Tag("Unit")
public class ListarBancoUseCaseTest {
    
    @Mock
    private IListarBancoGateway gateway;

    private ListarBancoUseCase useCase;

    @BeforeEach
    public void beforeEach() {
        useCase = new ListarBancoUseCase(gateway);
    }

    @Test
    public void dadoUmBancoValidoQuandoChamadoOUseCaseEntaoDeveRetornarOIdCadastrado(){
        List<Banco> listaBancos = Arrays.asList(
            Banco.builder().idBanco(1).codigo("123").nome("meu banco").build(),
            Banco.builder().idBanco(2).codigo("456").nome("meu outro banco").build()
        );

        when(gateway.executar()).thenReturn(listaBancos);

        List<Banco> actual = useCase.executar();

        verify(gateway, times(1)).executar();
        assertEquals(listaBancos, actual);
    }
}
