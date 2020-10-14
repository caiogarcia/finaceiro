package com.github.caiogarcia.financeiro.banco.dataprovider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
public class RecuperarBancoDataProviderTest {

    @Mock
    private BancoRepository repository;

    private RecuperarBancoDataProvider dataProvider;

    @BeforeEach
    public void beforeEach() {
        dataProvider = new RecuperarBancoDataProvider(repository);
    }

    @Test
    public void dadoUmIdBancoValidoQuandoRecuperarDeveRetornarOBancoExistente() {
        Integer idBanco = 1;
        BancoModel model = BancoModel.builder().idBanco(1).codigo("123").nome("Foo Bank").build();
        Banco expected = Banco.builder().idBanco(1).codigo("123").nome("Foo Bank").build();
        when(repository.findById(idBanco)).thenReturn(Optional.of(model));

        Optional<Banco> actual = dataProvider.executar(idBanco);

        assertEquals(expected, actual.get());
        verify(repository, times(1)).findById(idBanco);
    }

    @Test
    public void dadoUmIdBancoInvalidoQuandoRecuperarDeveRetornarUmBancoVazio() {
        Integer idBanco = 1;
        when(repository.findById(idBanco)).thenReturn(Optional.empty());

        Optional<Banco> actual = dataProvider.executar(idBanco);

        assertFalse(actual.isPresent());
        verify(repository, times(1)).findById(idBanco);
    }
}
