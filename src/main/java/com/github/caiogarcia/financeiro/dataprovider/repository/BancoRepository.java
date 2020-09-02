package com.github.caiogarcia.financeiro.dataprovider.repository;

import com.github.caiogarcia.financeiro.dataprovider.repository.model.BancoModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BancoRepository extends JpaRepository<BancoModel, Integer> {

}
