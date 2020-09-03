package com.github.caiogarcia.financeiro.contabancaria.dataprovider.repository;


import com.github.caiogarcia.financeiro.contabancaria.dataprovider.repository.model.ContaBancariaModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaBancariaRepository extends JpaRepository<ContaBancariaModel, Integer> {
    
}
