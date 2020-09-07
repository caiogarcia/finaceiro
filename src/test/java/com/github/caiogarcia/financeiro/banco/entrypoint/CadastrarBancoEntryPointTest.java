package com.github.caiogarcia.financeiro.banco.entrypoint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.caiogarcia.financeiro.banco.core.ICadastrarBancoUseCase;
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
public class CadastrarBancoEntryPointTest {
    
    @Mock
    private ICadastrarBancoUseCase useCase;

    private CadastrarBancoEntryPoint entryPoint;

    @BeforeEach
    public void beforeEach(){
        entryPoint = new CadastrarBancoEntryPoint(useCase);
    }

    @Test
    public void dadoUmBancoValidoQuandoSolicitarOCadastroDeveretornaroIdDoBancoCadastrado(){
        BancoEntity bancoEntity = new BancoEntity(null, "123", "banco Teste");
        Integer expectedID = 20;
        when(useCase.executar(any(Banco.class))).thenReturn(expectedID);

        ResponseEntity<Integer> actual = entryPoint.post(bancoEntity);

        assertEquals(expectedID, actual.getBody());
        assertEquals(HttpStatus.CREATED, actual.getStatusCode());
        verify(useCase, times(1)).executar(any(Banco.class));
    }
}
