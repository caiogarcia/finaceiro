package com.github.caiogarcia.financeiro.banco.core.gateway;

import java.util.Optional;

import com.github.caiogarcia.financeiro.banco.core.model.Banco;

public interface IRecuperarBancoGateway {
    Optional<Banco> executar(Integer idInteger);
}
