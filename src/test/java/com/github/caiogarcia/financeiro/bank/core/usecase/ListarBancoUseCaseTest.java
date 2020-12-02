package com.github.caiogarcia.financeiro.bank.core.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.*;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.github.caiogarcia.financeiro.bank.core.gateway.IListBankGateway;
import com.github.caiogarcia.financeiro.bank.core.model.Bank;

@ExtendWith(MockitoExtension.class)
@Tag("Unit")
public class ListarBancoUseCaseTest {
    
    @Mock
    private IListBankGateway gateway;

    private ListBankUseCase useCase;

    @BeforeEach
    public void beforeEach() {
        useCase = new ListBankUseCase(gateway);
    }

    @Test
    public void dadoUmBancoValidoQuandoChamadoOUseCaseEntaoDeveRetornarOIdCadastrado(){
        List<Bank> listaBancos = Arrays.asList(
            Bank.builder().idBank(1).code("123").name("meu banco").build(),
            Bank.builder().idBank(2).code("456").name("meu outro banco").build()
        );

        when(gateway.execute()).thenReturn(listaBancos);

        List<Bank> actual = useCase.execute();

        verify(gateway, times(1)).execute();
        assertEquals(listaBancos, actual);
    }
}
