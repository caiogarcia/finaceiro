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
public class AtualizarBancoDataProviderTest {

    @Mock
    private BancoRepository repository;

    private AtualizarBancoDataProvider dataProvider;

    @BeforeEach
    public void beforeEach() {
        dataProvider = new AtualizarBancoDataProvider(repository);
    }

    @Test
    public void dadoUmBancoValidoQuandoAtualizarDeveSalvarORepositorioERetornarOBanco() {
        Banco banco = Banco.builder().idBanco(1).codigo("123").nome("ACME Bank").build();
        BancoModel model = BancoModel.builder().idBanco(1).codigo("123").nome("ACME Bank").build();
        when(repository.save(any(BancoModel.class))).thenReturn(model);

        Banco actual = dataProvider.executar(banco);

        assertEquals(banco, actual);
        verify(repository, times(1)).save(any(BancoModel.class));
    }
}
