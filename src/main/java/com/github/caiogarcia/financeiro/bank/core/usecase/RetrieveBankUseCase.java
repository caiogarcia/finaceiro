package com.github.caiogarcia.financeiro.bank.core.usecase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.caiogarcia.financeiro.bank.core.IRetrieveBankUseCase;
import com.github.caiogarcia.financeiro.bank.core.gateway.IRetrieveBankGateway;
import com.github.caiogarcia.financeiro.bank.core.model.Bank;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RetrieveBankUseCase implements IRetrieveBankUseCase {

    private IRetrieveBankGateway gateway;

    @Override
    public Optional<Bank> execute(Integer idBank) {
        if (idBank == null) {
            throw new RuntimeException("O idBanco não pode ser nulo.");
        }

        return gateway.execute(idBank);
    }

}
