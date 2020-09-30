package com.github.caiogarcia.financeiro.banco.core;

import com.github.caiogarcia.financeiro.banco.core.model.Banco;

public interface IAtualizarBancoUseCase {
    Banco executar(Banco banco);
}
