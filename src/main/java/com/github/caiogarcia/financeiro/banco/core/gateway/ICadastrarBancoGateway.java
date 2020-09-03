package com.github.caiogarcia.financeiro.banco.core.gateway;

import com.github.caiogarcia.financeiro.banco.core.model.Banco;

/**
 * ICadastrarBancoGateway
 */
public interface ICadastrarBancoGateway {

    Integer executar(Banco banco);
}