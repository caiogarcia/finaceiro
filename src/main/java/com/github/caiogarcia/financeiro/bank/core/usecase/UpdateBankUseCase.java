package com.github.caiogarcia.financeiro.bank.core.usecase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.caiogarcia.financeiro.bank.core.IUpdateBankUseCase;
import com.github.caiogarcia.financeiro.bank.core.gateway.IRetrieveBankGateway;
import com.github.caiogarcia.financeiro.bank.core.gateway.IUpdateBankGateway;
import com.github.caiogarcia.financeiro.bank.core.model.Bank;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UpdateBankUseCase implements IUpdateBankUseCase {

    private IUpdateBankGateway updateGateway;
    private IRetrieveBankGateway retrieveGateway;

    @Override
    public Bank execute(Bank bank) {
        if (bank == null) {
            throw new RuntimeException("O Banco não pode ser nulo.");
        }

        Optional<Bank> bancoAtual = this.retrieveGateway.execute(bank.getIdBank());
        if (!bancoAtual.isPresent()) {
            throw new RuntimeException("Banco não encontrado.");
        }

        return updateGateway.execute(bank);
    }

}
