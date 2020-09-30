package com.github.caiogarcia.financeiro.banco.core.gateway;

import java.util.List;

import com.github.caiogarcia.financeiro.banco.core.model.Banco;

public interface IListarBancoGateway {
    List<Banco> executar();
}
