package com.github.caiogarcia.financeiro.bank.core.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.caiogarcia.financeiro.bank.core.IListBankUseCase;
import com.github.caiogarcia.financeiro.bank.core.gateway.IListBankGateway;
import com.github.caiogarcia.financeiro.bank.core.model.Bank;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ListBankUseCase implements IListBankUseCase {

    private IListBankGateway gateway;

    @Override
    public List<Bank> execute() {
        return gateway.execute();
    }

}
