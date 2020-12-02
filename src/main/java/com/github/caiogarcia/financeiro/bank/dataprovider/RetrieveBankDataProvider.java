package com.github.caiogarcia.financeiro.bank.dataprovider;

import java.util.Optional;

import com.github.caiogarcia.financeiro.bank.core.gateway.IRetrieveBankGateway;
import com.github.caiogarcia.financeiro.bank.core.model.Bank;
import com.github.caiogarcia.financeiro.bank.dataprovider.mapper.BankModelMapper;
import com.github.caiogarcia.financeiro.bank.dataprovider.repository.BankRepository;
import com.github.caiogarcia.financeiro.bank.dataprovider.repository.model.BankModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class RetrieveBankDataProvider implements IRetrieveBankGateway {

    private BankRepository repository;

    @Override
    public Optional<Bank> execute(Integer idBank) {

        Optional<BankModel> model = repository.findById(idBank);

        if (model.isPresent()) {
            return Optional.of(BankModelMapper.toEntity(model.get()));
        }
        return Optional.empty();
    }

}
