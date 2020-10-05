package com.github.caiogarcia.financeiro.banco.entrypoint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.caiogarcia.financeiro.banco.core.IAtualizarBancoUseCase;
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
public class AtualizarBancoEntryPointTest {
    
    @Mock
    private IAtualizarBancoUseCase useCase;

    private AtualizarBancoEntryPoint entryPoint;

    @BeforeEach
    public void beforeEach(){
        entryPoint = new AtualizarBancoEntryPoint(useCase);
    }

    @Test
    public void dadoUmBancoValidoQuandoSolicitarAAlteracaoDeveretornarStatus200(){
        BancoEntity bancoEntity = new BancoEntity(null, "123", "banco Teste");
        
        Banco banco = new Banco(20, "123", "banco Teste");
        when(useCase.executar(banco)).thenReturn(banco);

        ResponseEntity<Void> actual = entryPoint.put(bancoEntity, 20);

        assertEquals(HttpStatus.OK, actual.getStatusCode());
        verify(useCase, times(1)).executar(banco);
    }
}
