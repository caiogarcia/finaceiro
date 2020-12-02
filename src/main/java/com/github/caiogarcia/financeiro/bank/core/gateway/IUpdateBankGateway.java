package com.github.caiogarcia.financeiro.bank.core.gateway;

import com.github.caiogarcia.financeiro.bank.core.model.Bank;

public interface IUpdateBankGateway {

    Bank execute(Bank bank);
}