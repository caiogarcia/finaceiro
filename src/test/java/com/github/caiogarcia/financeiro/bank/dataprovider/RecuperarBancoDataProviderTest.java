package com.github.caiogarcia.financeiro.bank.dataprovider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.github.caiogarcia.financeiro.bank.core.model.Bank;
import com.github.caiogarcia.financeiro.bank.dataprovider.repository.BankRepository;
import com.github.caiogarcia.financeiro.bank.dataprovider.repository.model.BankModel;

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
    private BankRepository repository;

    private RetrieveBankDataProvider dataProvider;

    @BeforeEach
    public void beforeEach() {
        dataProvider = new RetrieveBankDataProvider(repository);
    }

    @Test
    public void dadoUmIdBankValidoQuandoRecuperarDeveRetornarOBancoExistente() {
        Integer idBank = 1;
        BankModel model = BankModel.builder().idBank(1).code("123").name("Foo Bank").build();
        Bank expected = Bank.builder().idBank(1).code("123").name("Foo Bank").build();
        when(repository.findById(idBank)).thenReturn(Optional.of(model));

        Optional<Bank> actual = dataProvider.execute(idBank);

        assertEquals(expected, actual.get());
        verify(repository, times(1)).findById(idBank);
    }

    @Test
    public void dadoUmIdBankInvalidoQuandoRecuperarDeveRetornarUmBancoVazio() {
        Integer idBank = 1;
        when(repository.findById(idBank)).thenReturn(Optional.empty());

        Optional<Bank> actual = dataProvider.execute(idBank);

        assertFalse(actual.isPresent());
        verify(repository, times(1)).findById(idBank);
    }
}
