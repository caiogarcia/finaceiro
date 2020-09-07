package com.github.caiogarcia.financeiro.banco.entrypoint.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BancoEntity {
    private Integer idBanco;
    private String codigo;
    private String nome;
}
