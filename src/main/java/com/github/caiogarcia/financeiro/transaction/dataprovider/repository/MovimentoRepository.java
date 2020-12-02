package com.github.caiogarcia.financeiro.transaction.dataprovider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.caiogarcia.financeiro.transaction.dataprovider.repository.model.MovimentoModel;

@Repository
public interface MovimentoRepository extends JpaRepository<MovimentoModel, Integer> {
    
}
