package com.github.caiogarcia.financeiro.banco.dataprovider.repository.model;

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
@Table(name = "banco")
public class BancoModel {
    
    @Column(name = "id_banco")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBanco;
    
    @Column(name = "nome")
    @NotNull
    @Size(max = 50)
    private String nome;

    @Column(name = "codigo")
    @NotNull
    @Size(max = 10)
    private String codigo;

}
