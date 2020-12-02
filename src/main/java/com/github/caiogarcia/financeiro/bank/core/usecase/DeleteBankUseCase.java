package com.github.caiogarcia.financeiro.bank.core.usecase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.caiogarcia.financeiro.bank.core.IDeleteBankUseCase;
import com.github.caiogarcia.financeiro.bank.core.gateway.IDeleteBankGateway;
import com.github.caiogarcia.financeiro.bank.core.gateway.IRetrieveBankGateway;
import com.github.caiogarcia.financeiro.bank.core.model.Bank;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DeleteBankUseCase implements IDeleteBankUseCase {

    private IDeleteBankGateway deletargateway;
    private IRetrieveBankGateway recuperarGateway;

    @Override
    public void execute(Integer idBank) {
        if (idBank == null) {
            throw new RuntimeException("O idBanco não pode ser nulo.");
        }
        Optional<Bank> bancoAtual = this.recuperarGateway.execute(idBank);
        if (!bancoAtual.isPresent()) {
            throw new RuntimeException("Banco não encontrado.");
        }

        deletargateway.execute(idBank);
    }

}
