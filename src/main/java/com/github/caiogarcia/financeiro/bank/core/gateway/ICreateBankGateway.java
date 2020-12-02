package com.github.caiogarcia.financeiro.bank.core.gateway;

import com.github.caiogarcia.financeiro.bank.core.model.Bank;

public interface ICreateBankGateway {

    Integer execute(Bank banco);
}