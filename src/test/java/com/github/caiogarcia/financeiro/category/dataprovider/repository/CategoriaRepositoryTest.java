package com.github.caiogarcia.financeiro.category.dataprovider.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.github.caiogarcia.financeiro.category.dataprovider.repository.model.CategoriaModel;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("test")
@Tag("Integration")
public class CategoriaRepositoryTest {
 
    @Autowired
    private CategoriaRepository repository;
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void dadoUmaListaDeCategoriasNoDBQuandoPesquisarPeloIDEntaoDeveRetornarACategoria() {
        Optional<CategoriaModel> categoria = repository.findById(1);

        assertTrue(categoria.isPresent());
    }
}
