package com.github.caiogarcia.financeiro.dataprovider.repository;

import com.github.caiogarcia.financeiro.dataprovider.repository.model.MovimentoModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentoRepository extends JpaRepository<MovimentoModel, Integer> {
    
}
