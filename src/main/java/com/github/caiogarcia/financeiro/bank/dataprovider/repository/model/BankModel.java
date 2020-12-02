package com.github.caiogarcia.financeiro.bank.dataprovider.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bank")
public class BankModel {
    
    @Column(name = "id_bank")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBank;
    
    @Column(name = "name")
    @NotNull
    @Size(max = 50)
    private String name;

    @Column(name = "code")
    @NotNull
    @Size(max = 10)
    private String code;

}
