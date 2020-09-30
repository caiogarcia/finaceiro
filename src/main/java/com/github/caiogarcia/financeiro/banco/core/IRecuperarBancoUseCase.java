package com.github.caiogarcia.financeiro.banco.core;

import java.util.Optional;

import com.github.caiogarcia.financeiro.banco.core.model.Banco;

public interface IRecuperarBancoUseCase {
    Optional<Banco> executar(Integer idBanco);
}
