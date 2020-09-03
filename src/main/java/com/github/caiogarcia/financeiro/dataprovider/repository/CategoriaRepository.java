package com.github.caiogarcia.financeiro.dataprovider.repository;

import com.github.caiogarcia.financeiro.dataprovider.repository.model.CategoriaModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Integer> {
    
}
