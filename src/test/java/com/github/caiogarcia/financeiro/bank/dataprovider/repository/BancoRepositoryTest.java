package com.github.caiogarcia.financeiro.bank.dataprovider.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.github.caiogarcia.financeiro.bank.dataprovider.repository.model.BankModel;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("test")
@Tag("Integration")
public class BancoRepositoryTest {
    
    @Autowired
    private BankRepository repository;
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void dadoUmaListaDeBancosNoDBQuandoPesquisarPeloIDEntaoDeveRetornarOBanco() {
        Optional<BankModel> banco = repository.findById(1);

        assertTrue(banco.isPresent());
    }

    @Test
    public void dadoUmBancoComNomeMaiorQue50QuandoSalvarDeveFalhar() {

        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            BankModel model = BankModel.builder()
                .name("This is a very long name witch will pass the maximum value")
                .code("123")
                .build();
            repository.save(model);
            entityManager.flush();
        });
    }

    @Test
    public void dadoUmBancoComNomeNuloQuandoSalvarDeveFalhar() {

        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            BankModel model = BankModel.builder()
                .code("123")
                .build();
            repository.save(model);
            entityManager.flush();
        });
    }

    @Test
    public void dadoUmBancoComCodigoMaiorQue10QuandoSalvarDeveFalhar() {

        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            BankModel model = BankModel.builder()
                .name("Meu Banco")
                .code("12345678901")
                .build();
            repository.save(model);
            entityManager.flush();
        });
    }

    @Test
    public void dadoUmBancoComCodigoNuloQuandoSalvarDeveFalhar() {

        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            BankModel model = BankModel.builder()
                .name("Meu Banco")
                .build();
            repository.save(model);
            entityManager.flush();
        });
    }


}
