package com.github.caiogarcia.financeiro.bank.dataprovider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public class ListarBancoDataProviderTest {

    @Mock
    private BankRepository repository;

    private ListBankDataProvider dataProvider;

    @BeforeEach
    public void beforeEach() {
        dataProvider = new ListBankDataProvider(repository);
    }

    @Test
    public void dadoUmIdBankValidoQuandoListarDeveRetornarOBancoExistente() {
        List<BankModel> models = Arrays.asList(BankModel.builder().idBank(1).code("123").name("Foo Bank").build(),
                BankModel.builder().idBank(1).code("123").name("Foo Bank").build());

        List<Bank> expected = Arrays.asList(Bank.builder().idBank(1).code("123").name("Foo Bank").build(),
                Bank.builder().idBank(1).code("123").name("Foo Bank").build());

        when(repository.findAll()).thenReturn(models);

        List<Bank> actual = dataProvider.execute();

        assertEquals(expected, actual);
        verify(repository, times(1)).findAll();
    }

    @Test
    public void dadoUmIdBankInvalidoQuandoListarDeveRetornarUmBancoVazio() {
        when(repository.findAll()).thenReturn(new ArrayList<>());

        List<Bank> actual = dataProvider.execute();

        assertTrue(actual.isEmpty());
        verify(repository, times(1)).findAll();
    }
}
