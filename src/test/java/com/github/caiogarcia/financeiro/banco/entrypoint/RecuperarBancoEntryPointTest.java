package com.github.caiogarcia.financeiro.banco.entrypoint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.github.caiogarcia.financeiro.banco.core.IRecuperarBancoUseCase;
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
public class RecuperarBancoEntryPointTest {
    
    @Mock
    private IRecuperarBancoUseCase useCase;

    private RecuperarBancoEntryPoint entryPoint;

    @BeforeEach
    public void beforeEach(){
        entryPoint = new RecuperarBancoEntryPoint(useCase);
    }

    @Test
    public void dadoUmIDBancoValidoQuandoSolicitarARecuperarDeveretornarOBancoCadastrado(){
    	Integer ID = 20;
        Banco banco = new Banco(ID, "123", "banco Teste");
        BancoEntity expected = new BancoEntity(ID, "123", "banco Teste");
        
        when(useCase.executar(any(Integer.class))).thenReturn(Optional.of(banco));

        ResponseEntity<BancoEntity> actual = entryPoint.get(ID);

        assertEquals(expected, actual.getBody());
        assertEquals(HttpStatus.OK, actual.getStatusCode());
        verify(useCase, times(1)).executar(any(Integer.class));
    }
    
    @Test
    public void dadoUmIDBancoInvalidoQuandoSolicitarARecuperarDeveretornarStatus404(){
        Integer ID = 20;
        
        when(useCase.executar(any(Integer.class))).thenReturn(Optional.empty());

        ResponseEntity<BancoEntity> actual = entryPoint.get(ID);

        assertEquals(HttpStatus.NOT_FOUND, actual.getStatusCode());
        verify(useCase, times(1)).executar(any(Integer.class));
    }
}
