package com.github.caiogarcia.financeiro.banco.core.gateway;

import com.github.caiogarcia.financeiro.banco.core.model.Banco;

/**
 * IAtualizarBancoGateway
 */
public interface IAtualizarBancoGateway {

    Banco executar(Banco banco);
}