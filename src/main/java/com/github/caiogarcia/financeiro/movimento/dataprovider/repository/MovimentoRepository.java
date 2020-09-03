package com.github.caiogarcia.financeiro.movimento.dataprovider.repository;

import com.github.caiogarcia.financeiro.movimento.dataprovider.repository.model.MovimentoModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentoRepository extends JpaRepository<MovimentoModel, Integer> {
    
}
