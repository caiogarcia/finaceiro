package com.github.caiogarcia.financeiro.banco.dataprovider.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.github.caiogarcia.financeiro.banco.dataprovider.repository.model.BancoModel;

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
}