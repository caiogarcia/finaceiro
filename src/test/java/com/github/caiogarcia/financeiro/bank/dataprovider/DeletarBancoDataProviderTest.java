package com.github.caiogarcia.financeiro.bank.dataprovider;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.github.caiogarcia.financeiro.bank.dataprovider.repository.BankRepository;

@ExtendWith(MockitoExtension.class)
@Tag("Unit")
public class DeletarBancoDataProviderTest {

    @Mock
    private BankRepository repository;

    private DeleteBankDataProvider dataProvider;

    @BeforeEach
    public void beforeEach() {
        dataProvider = new DeleteBankDataProvider(repository);
    }

    @Test
    public void dadoUmIdBancoValidoQuandoDeletarDeveSalvarORepositorio() {
        Integer idBanco = 1;

        dataProvider.execute(idBanco);

        verify(repository, times(1)).deleteById(idBanco);
    }
}
