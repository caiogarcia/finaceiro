package com.github.caiogarcia.financeiro.bank.dataprovider;

import java.util.Arrays;
import java.util.List;

import com.github.caiogarcia.financeiro.bank.core.gateway.IListBankGateway;
import com.github.caiogarcia.financeiro.bank.core.model.Bank;
import com.github.caiogarcia.financeiro.bank.dataprovider.mapper.BankModelMapper;
import com.github.caiogarcia.financeiro.bank.dataprovider.repository.BankRepository;
import com.github.caiogarcia.financeiro.bank.dataprovider.repository.model.BankModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class ListBankDataProvider implements IListBankGateway {

    private BankRepository repository;

    @Override
    public List<Bank> execute() {
        List<BankModel> listBankModel = repository.findAll();
        if (listBankModel.isEmpty()) {
            return Arrays.asList();
        } else {
            List<Bank> listBank = BankModelMapper.toEntityList(listBankModel);
            return listBank;
        }

    }

}
