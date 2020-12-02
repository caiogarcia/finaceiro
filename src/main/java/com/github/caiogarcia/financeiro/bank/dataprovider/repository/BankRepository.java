package com.github.caiogarcia.financeiro.bank.dataprovider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.caiogarcia.financeiro.bank.dataprovider.repository.model.BankModel;

@Repository
public interface BankRepository extends JpaRepository<BankModel, Integer> {

}
