package com.github.caiogarcia.financeiro.bank.entrypoint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.caiogarcia.financeiro.bank.core.ICreateBankUseCase;
import com.github.caiogarcia.financeiro.bank.core.model.Bank;
import com.github.caiogarcia.financeiro.bank.entrypoint.entity.BankEntity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
@Tag("Unit")
public class CadastrarBancoEntryPointTest {
    
    @Mock
    private ICreateBankUseCase useCase;

    private CreateBankEntryPoint entryPoint;

    @BeforeEach
    public void beforeEach(){
        entryPoint = new CreateBankEntryPoint(useCase);
    }

    @Test
    public void dadoUmBancoValidoQuandoSolicitarOCadastroDeveretornaroIdDoBancoCadastrado(){
        BankEntity bancoEntity = new BankEntity(null, "123", "banco Teste");
        Integer expectedID = 20;
        when(useCase.execute(any(Bank.class))).thenReturn(expectedID);

        ResponseEntity<Integer> actual = entryPoint.post(bancoEntity);

        assertEquals(expectedID, actual.getBody());
        assertEquals(HttpStatus.CREATED, actual.getStatusCode());
        verify(useCase, times(1)).execute(any(Bank.class));
    }
}
