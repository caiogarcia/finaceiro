package com.github.caiogarcia.financeiro.contabancaria.dataprovider.repository.model;

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
@Table(name = "conta_bancaria")
public class ContaBancariaModel {
    
    @Column(name = "id_conta_bancaria")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContaBancaria;
    
    @Column(name = "id_banco")
    private Integer idBanco;
    
    @Column(name = "agencia")
    private String agencia;
    
    @Column(name = "conta")
    private String conta;
    
    @Column(name = "dac")
    private String digito;
}
