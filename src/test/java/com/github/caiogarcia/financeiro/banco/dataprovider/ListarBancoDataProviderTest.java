package com.github.caiogarcia.financeiro.banco.dataprovider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
public class ListarBancoDataProviderTest {

    @Mock
    private BancoRepository repository;

    private ListarBancoDataProvider dataProvider;

    @BeforeEach
    public void beforeEach() {
        dataProvider = new ListarBancoDataProvider(repository);
    }

    @Test
    public void dadoUmIdBancoValidoQuandoListarDeveRetornarOBancoExistente() {
        List<BancoModel> models = Arrays.asList(BancoModel.builder().idBanco(1).codigo("123").nome("Foo Bank").build(),
                BancoModel.builder().idBanco(1).codigo("123").nome("Foo Bank").build());

        List<Banco> expected = Arrays.asList(Banco.builder().idBanco(1).codigo("123").nome("Foo Bank").build(),
                Banco.builder().idBanco(1).codigo("123").nome("Foo Bank").build());

        when(repository.findAll()).thenReturn(models);

        List<Banco> actual = dataProvider.executar();

        assertEquals(expected, actual);
        verify(repository, times(1)).findAll();
    }

    @Test
    public void dadoUmIdBancoInvalidoQuandoListarDeveRetornarUmBancoVazio() {
        when(repository.findAll()).thenReturn(new ArrayList<>());

        List<Banco> actual = dataProvider.executar();

        assertTrue(actual.isEmpty());
        verify(repository, times(1)).findAll();
    }
}
