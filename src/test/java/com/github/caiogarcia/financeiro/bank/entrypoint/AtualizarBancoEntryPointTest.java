package com.github.caiogarcia.financeiro.bank.entrypoint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.caiogarcia.financeiro.bank.core.IUpdateBankUseCase;
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
public class AtualizarBancoEntryPointTest {
    
    @Mock
    private IUpdateBankUseCase useCase;

    private UpdateBankEntryPoint entryPoint;

    @BeforeEach
    public void beforeEach(){
        entryPoint = new UpdateBankEntryPoint(useCase);
    }

    @Test
    public void dadoUmBancoValidoQuandoSolicitarAAlteracaoDeveretornarStatus200(){
        BankEntity bancoEntity = new BankEntity(null, "123", "banco Teste");
        
        Bank banco = new Bank(20, "123", "banco Teste");
        when(useCase.execute(banco)).thenReturn(banco);

        ResponseEntity<Void> actual = entryPoint.put(bancoEntity, 20);

        assertEquals(HttpStatus.OK, actual.getStatusCode());
        verify(useCase, times(1)).execute(banco);
    }
}
