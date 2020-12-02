package com.github.caiogarcia.financeiro.account.dataprovider.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class ContaBancariaModel {
    
    @Column(name = "id_account")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContaBancaria;
    
    @Column(name = "id_bank")
    private Integer idBanco;
    
    @Column(name = "branch")
    private String agencia;
    
    @Column(name = "account_number")
    private String conta;
    
    @Column(name = "dac")
    private String digito;
}
