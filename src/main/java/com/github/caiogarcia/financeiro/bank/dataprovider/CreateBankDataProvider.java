package com.github.caiogarcia.financeiro.bank.dataprovider;

import com.github.caiogarcia.financeiro.bank.core.gateway.ICreateBankGateway;
import com.github.caiogarcia.financeiro.bank.core.model.Bank;
import com.github.caiogarcia.financeiro.bank.dataprovider.mapper.BankModelMapper;
import com.github.caiogarcia.financeiro.bank.dataprovider.repository.BankRepository;
import com.github.caiogarcia.financeiro.bank.dataprovider.repository.model.BankModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class CreateBankDataProvider implements ICreateBankGateway {

    private BankRepository repository;

    @Override
    public Integer execute(Bank bank) {
        BankModel model = BankModelMapper.toModel(bank);

        return repository.save(model).getIdBank();
    }

}
