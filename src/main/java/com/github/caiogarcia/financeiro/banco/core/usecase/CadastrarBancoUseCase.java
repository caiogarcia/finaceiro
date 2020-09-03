package com.github.caiogarcia.financeiro.banco.core.usecase;

import com.github.caiogarcia.financeiro.banco.core.ICadastrarBancoUseCase;
import com.github.caiogarcia.financeiro.banco.core.gateway.ICadastrarBancoGateway;
import com.github.caiogarcia.financeiro.banco.core.model.Banco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CadastrarBancoUseCase implements ICadastrarBancoUseCase {

    private ICadastrarBancoGateway gateway;

    @Override
    public Integer executar(Banco banco) {
        if(banco == null) {
            throw new RuntimeException("O Banco não pode ser nulo.");
        }

        return gateway.executar(banco);
    }
    
}
 