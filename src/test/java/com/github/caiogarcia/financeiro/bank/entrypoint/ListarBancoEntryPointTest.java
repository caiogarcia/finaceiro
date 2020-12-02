package com.github.caiogarcia.financeiro.bank.entrypoint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.github.caiogarcia.financeiro.bank.core.IListBankUseCase;
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
public class ListarBancoEntryPointTest {
    
    @Mock
    private IListBankUseCase useCase;

    private ListBankEntryPoint entryPoint;

    @BeforeEach
    public void beforeEach(){
        entryPoint = new ListBankEntryPoint(useCase);
    }

    @Test
    public void quandoSolicitarListarBancosDeveretornarOsBancosCadastrados(){
    	List<Bank> bancos = Arrays.asList(
    		new Bank(1, "123", "banco Teste"),
    		new Bank(2, "456", "outro banco Teste")
    	);
    	List<BankEntity> expected = Arrays.asList(
        		new BankEntity(1, "123", "banco Teste"),
        		new BankEntity(2, "456", "outro banco Teste")
        	);
        
        when(useCase.execute()).thenReturn(bancos);

        ResponseEntity<List<BankEntity>> actual = entryPoint.get();

        assertEquals(expected, actual.getBody());
        assertEquals(HttpStatus.OK, actual.getStatusCode());
        verify(useCase, times(1)).execute();
    }
    
    @Test
    public void quandoSolicitarListarDeveretornarStatus404(){
        when(useCase.execute()).thenReturn(new ArrayList<Bank>());

        ResponseEntity<List<BankEntity>> actual = entryPoint.get();

        assertEquals(HttpStatus.NOT_FOUND, actual.getStatusCode());
        verify(useCase, times(1)).execute();
    }
}
