package com.github.caiogarcia.financeiro.bank.core.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.caiogarcia.financeiro.bank.core.ICreateBankUseCase;
import com.github.caiogarcia.financeiro.bank.core.gateway.ICreateBankGateway;
import com.github.caiogarcia.financeiro.bank.core.model.Bank;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CreateBankUseCase implements ICreateBankUseCase {

    private ICreateBankGateway gateway;

    @Override
    public Integer execute(Bank bank) {
        if (bank == null) {
            throw new RuntimeException("O Banco não pode ser nulo.");
        }

        return gateway.execute(bank);
    }

}
