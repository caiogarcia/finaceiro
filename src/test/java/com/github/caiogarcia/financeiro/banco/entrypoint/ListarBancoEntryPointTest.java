package com.github.caiogarcia.financeiro.banco.entrypoint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.github.caiogarcia.financeiro.banco.core.IListarBancoUseCase;
import com.github.caiogarcia.financeiro.banco.core.model.Banco;
import com.github.caiogarcia.financeiro.banco.entrypoint.entity.BancoEntity;

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
    private IListarBancoUseCase useCase;

    private ListarBancoEntryPoint entryPoint;

    @BeforeEach
    public void beforeEach(){
        entryPoint = new ListarBancoEntryPoint(useCase);
    }

    @Test
    public void quandoSolicitarListarBancosDeveretornarOsBancosCadastrados(){
    	List<Banco> bancos = Arrays.asList(
    		new Banco(1, "123", "banco Teste"),
    		new Banco(2, "456", "outro banco Teste")
    	);
    	List<BancoEntity> expected = Arrays.asList(
        		new BancoEntity(1, "123", "banco Teste"),
        		new BancoEntity(2, "456", "outro banco Teste")
        	);
        
        when(useCase.executar()).thenReturn(bancos);

        ResponseEntity<List<BancoEntity>> actual = entryPoint.get();

        assertEquals(expected, actual.getBody());
        assertEquals(HttpStatus.OK, actual.getStatusCode());
        verify(useCase, times(1)).executar();
    }
    
    @Test
    public void quandoSolicitarListarDeveretornarStatus404(){
        when(useCase.executar()).thenReturn(new ArrayList<Banco>());

        ResponseEntity<List<BancoEntity>> actual = entryPoint.get();

        assertEquals(HttpStatus.NOT_FOUND, actual.getStatusCode());
        verify(useCase, times(1)).executar();
    }
}
