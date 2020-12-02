package com.github.caiogarcia.financeiro.category.dataprovider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.caiogarcia.financeiro.category.dataprovider.repository.model.CategoriaModel;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Integer> {
    
}
