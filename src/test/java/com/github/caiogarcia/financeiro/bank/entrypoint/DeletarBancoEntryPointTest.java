package com.github.caiogarcia.financeiro.bank.entrypoint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.github.caiogarcia.financeiro.bank.core.IDeleteBankUseCase;

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
public class DeletarBancoEntryPointTest {
    
    @Mock
    private IDeleteBankUseCase useCase;

    private DeleteBankEntryPoint entryPoint;

    @BeforeEach
    public void beforeEach(){
        entryPoint = new DeleteBankEntryPoint(useCase);
    }

    @Test
    public void dadoUmIDBancoValidoQuandoSolicitarADeletarDeveretornarStatus200(){
    	Integer ID = 20;

        ResponseEntity<Void> actual = entryPoint.delete(ID);

        assertEquals(HttpStatus.OK, actual.getStatusCode());
        verify(useCase, times(1)).execute(any(Integer.class));
    }
}
