package com.github.caiogarcia.financeiro.banco.core;

import com.github.caiogarcia.financeiro.banco.core.model.Banco;

public interface ICadastrarBancoUseCase {
    
    Integer executar(Banco banco);
}
