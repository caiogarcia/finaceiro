package com.github.caiogarcia.financeiro.bank.dataprovider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
public class CadastrarBancoDataProviderTest {

    @Mock
    private BankRepository repository;

    private CreateBankDataProvider dataProvider;

    @BeforeEach
    public void beforeEach() {
        dataProvider = new CreateBankDataProvider(repository);
    }

    @Test
    public void DadoUmBancoValidoQuandoCadastrarDeveSalvarOBancoERetornarOIdSalvo() {
        Integer expected = 1;
        Bank banco = Bank.builder().code("123").name("ACME Bank").build();
        BankModel model = BankModel.builder().idBank(expected).code("123").name("ACME Bank").build();
        when(repository.save(any(BankModel.class))).thenReturn(model);

        Integer actual = dataProvider.execute(banco);

        assertEquals(expected, actual);
        verify(repository, times(1)).save(any(BankModel.class));
    }
}
