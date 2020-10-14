package com.github.caiogarcia.financeiro.banco.dataprovider;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.github.caiogarcia.financeiro.banco.dataprovider.repository.BancoRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@Tag("Unit")
public class DeletarBancoDataProviderTest {

    @Mock
    private BancoRepository repository;

    private DeletarBancoDataProvider dataProvider;

    @BeforeEach
    public void beforeEach() {
        dataProvider = new DeletarBancoDataProvider(repository);
    }

    @Test
    public void dadoUmIdBancoValidoQuandoDeletarDeveSalvarORepositorio() {
        Integer idBanco = 1;

        dataProvider.executar(idBanco);

        verify(repository, times(1)).deleteById(idBanco);
    }
}
