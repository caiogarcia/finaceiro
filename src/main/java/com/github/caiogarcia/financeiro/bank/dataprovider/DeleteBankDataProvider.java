package com.github.caiogarcia.financeiro.bank.dataprovider;

import com.github.caiogarcia.financeiro.bank.core.gateway.IDeleteBankGateway;
import com.github.caiogarcia.financeiro.bank.dataprovider.repository.BankRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class DeleteBankDataProvider implements IDeleteBankGateway {

    private BankRepository repository;

    @Override
    public void execute(Integer idBank) {
        repository.deleteById(idBank);
    }
    
}
