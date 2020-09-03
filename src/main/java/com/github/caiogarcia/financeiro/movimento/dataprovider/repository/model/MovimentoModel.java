package com.github.caiogarcia.financeiro.movimento.dataprovider.repository.model;

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
@Table(name = "movimento")
public class MovimentoModel {
    
    @Column(name = "id_movimento")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMovimento;
    
    @Column(name = "id_conta_bancaria")
    private Integer idContaBancaria;
    
    @Column(name = "id_categoria")
    private Integer idCategoria;
    
    @Column(name = "is_entrada")
    private Boolean isEntrada;
    
    @Column(name = "data")
    private LocalDate data;
    
    @Column(name = "valor")
    private BigDecimal valor;
    
    @Column(name = "estabelecimento")
    private String estabelecimento;
    
    @Column(name = "notas")
    private String notas;
}
