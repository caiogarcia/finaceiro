package com.github.caiogarcia.financeiro.banco.dataprovider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.caiogarcia.financeiro.banco.core.model.Banco;
import com.github.caiogarcia.financeiro.banco.dataprovider.repository.BancoRepository;
import com.github.caiogarcia.financeiro.banco.dataprovider.repository.model.BancoModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@Tag("Unit")
public class CadastrarBancoDataProviderTest {
    
    @Mock
    private BancoRepository repository;

    private CadastrarBancoDataProvider dataProvider;

    @BeforeEach
    public void beforeEach() {
        dataProvider = new CadastrarBancoDataProvider(repository);
    }

    @Test
    public void test() {
        Integer expected = 1;
        Banco banco = Banco.builder().codigo("123").nome("ACME Bank").build();
        BancoModel model =  BancoModel.builder().idBanco(expected).codigo("123").nome("ACME Bank").build();
        when(repository.save(any(BancoModel.class))).thenReturn(model);

        Integer actual = dataProvider.executar(banco);

        assertEquals(expected, actual);
        verify(repository, times(1)).save(any(BancoModel.class));
    }
}
