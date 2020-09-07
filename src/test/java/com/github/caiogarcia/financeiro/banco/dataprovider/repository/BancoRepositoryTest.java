package com.github.caiogarcia.financeiro.banco.dataprovider.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;

import com.github.caiogarcia.financeiro.banco.dataprovider.repository.model.BancoModel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("test")
@Tag("Integration")
public class BancoRepositoryTest {
    
    @Autowired
    private BancoRepository repository;
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void dadoUmaListaDeBancosNoDBQuandoPesquisarPeloIDEntaoDeveRetornarOBanco() {
        Optional<BancoModel> banco = repository.findById(1);

        assertTrue(banco.isPresent());
    }

    @Test
    public void dadoUmBancoComNomeMaiorQue50QuandoSalvarDeveFalhar() {

        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            BancoModel model = BancoModel.builder()
                .nome("This is a very long name witch will pass the maximum value")
                .codigo("123")
                .build();
            repository.save(model);
            entityManager.flush();
        });
    }

    @Test
    public void dadoUmBancoComNomeNuloQuandoSalvarDeveFalhar() {

        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            BancoModel model = BancoModel.builder()
                .codigo("123")
                .build();
            repository.save(model);
            entityManager.flush();
        });
    }

    @Test
    public void dadoUmBancoComCodigoMaiorQue10QuandoSalvarDeveFalhar() {

        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            BancoModel model = BancoModel.builder()
                .nome("Meu Banco")
                .codigo("12345678901")
                .build();
            repository.save(model);
            entityManager.flush();
        });
    }

    @Test
    public void dadoUmBancoComCodigoNuloQuandoSalvarDeveFalhar() {

        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            BancoModel model = BancoModel.builder()
                .nome("Meu Banco")
                .build();
            repository.save(model);
            entityManager.flush();
        });
    }


}
