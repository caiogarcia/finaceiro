package com.github.caiogarcia.financeiro.bank.core.gateway;

import java.util.Optional;

import com.github.caiogarcia.financeiro.bank.core.model.Bank;

public interface IRetrieveBankGateway {
    Optional<Bank> execute(Integer idBank);
}
