package com.github.caiogarcia.financeiro.bank.core.gateway;

import java.util.List;

import com.github.caiogarcia.financeiro.bank.core.model.Bank;

public interface IListBankGateway {
    List<Bank> execute();
}
