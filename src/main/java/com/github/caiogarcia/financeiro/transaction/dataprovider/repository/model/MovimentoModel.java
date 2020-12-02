package com.github.caiogarcia.financeiro.transaction.dataprovider.repository.model;

import java.math.BigDecimal;
import java.time.LocalDate;

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
@Table(name = "transaction")
public class MovimentoModel {
    
    @Column(name = "id_transaction")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMovimento;
    
    @Column(name = "id_account")
    private Integer idContaBancaria;
    
    @Column(name = "id_category")
    private Integer idCategoria;
    
    @Column(name = "is_income")
    private Boolean isEntrada;
    
    @Column(name = "transaction_date")
    private LocalDate data;
    
    @Column(name = "amount")
    private BigDecimal valor;
    
    @Column(name = "settlement")
    private String estabelecimento;
    
    @Column(name = "notes")
    private String notas;
}
