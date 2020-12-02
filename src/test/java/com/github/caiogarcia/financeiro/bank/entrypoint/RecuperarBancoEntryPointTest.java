package com.github.caiogarcia.financeiro.bank.entrypoint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.github.caiogarcia.financeiro.bank.core.IRetrieveBankUseCase;
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
public class RecuperarBancoEntryPointTest {
    
    @Mock
    private IRetrieveBankUseCase useCase;

    private RetrieveBankEntryPoint entryPoint;

    @BeforeEach
    public void beforeEach(){
        entryPoint = new RetrieveBankEntryPoint(useCase);
    }

    @Test
    public void dadoUmIDBancoValidoQuandoSolicitarARecuperarDeveretornarOBancoCadastrado(){
    	Integer ID = 20;
        Bank banco = new Bank(ID, "123", "banco Teste");
        BankEntity expected = new BankEntity(ID, "123", "banco Teste");
        
        when(useCase.execute(any(Integer.class))).thenReturn(Optional.of(banco));

        ResponseEntity<BankEntity> actual = entryPoint.get(ID);

        assertEquals(expected, actual.getBody());
        assertEquals(HttpStatus.OK, actual.getStatusCode());
        verify(useCase, times(1)).execute(any(Integer.class));
    }
    
    @Test
    public void dadoUmIDBancoInvalidoQuandoSolicitarARecuperarDeveretornarStatus404(){
        Integer ID = 20;
        
        when(useCase.execute(any(Integer.class))).thenReturn(Optional.empty());

        ResponseEntity<BankEntity> actual = entryPoint.get(ID);

        assertEquals(HttpStatus.NOT_FOUND, actual.getStatusCode());
        verify(useCase, times(1)).execute(any(Integer.class));
    }
}
