package com.github.caiogarcia.financeiro.bank.core.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.github.caiogarcia.financeiro.bank.core.gateway.ICreateBankGateway;
import com.github.caiogarcia.financeiro.bank.core.model.Bank;

@ExtendWith(MockitoExtension.class)
@Tag("Unit")
public class CadastrarBancoUseCaseTest {
    
    @Mock
    private ICreateBankGateway gateway;

    private CreateBankUseCase useCase;

    @BeforeEach
    public void beforeEach() {
        useCase = new CreateBankUseCase(gateway);
    }

    @Test
    public void dadoUmBancoValidoQuandoChamadoOUseCaseEntaoDeveRetornarOIdCadastrado(){
        Bank banco = Bank.builder().code("123").name("meu banco").build();

        Integer expectedId = 1;
        when(gateway.execute(banco)).thenReturn(1);

        Integer actual = useCase.execute(banco);

        verify(gateway, times(1)).execute(banco);
        assertEquals(expectedId, actual);
    }

    
    @Test
    public void dadoUmBancoNuloQuandoChamadoOUseCaseEntaoDeveRetornarUmaRuntimeException(){
        Bank banco = null;

        Assertions.assertThrows(RuntimeException.class, () -> {
            useCase.execute(banco);
        });

        verify(gateway, times(0)).execute(banco);
    }
}
