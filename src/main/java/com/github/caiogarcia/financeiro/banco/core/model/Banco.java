package com.github.caiogarcia.financeiro.banco.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Banco {

    private Integer idBanco;
    private String codigo;
    private String nome;

}
