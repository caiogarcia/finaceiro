package com.github.caiogarcia.financeiro.account.dataprovider.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.caiogarcia.financeiro.account.dataprovider.repository.model.ContaBancariaModel;

@Repository
public interface ContaBancariaRepository extends JpaRepository<ContaBancariaModel, Integer> {
    
}
