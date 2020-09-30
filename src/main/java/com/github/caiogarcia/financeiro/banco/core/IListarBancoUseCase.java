package com.github.caiogarcia.financeiro.banco.core;

import java.util.List;

import com.github.caiogarcia.financeiro.banco.core.model.Banco;

public interface IListarBancoUseCase {
    List<Banco> executar();
}
