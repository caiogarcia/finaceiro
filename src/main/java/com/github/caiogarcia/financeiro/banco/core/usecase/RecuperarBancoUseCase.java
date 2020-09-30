package com.github.caiogarcia.financeiro.banco.core.usecase;

import java.util.Optional;

import com.github.caiogarcia.financeiro.banco.core.IRecuperarBancoUseCase;
import com.github.caiogarcia.financeiro.banco.core.gateway.IRecuperarBancoGateway;
import com.github.caiogarcia.financeiro.banco.core.model.Banco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RecuperarBancoUseCase implements IRecuperarBancoUseCase {

    private IRecuperarBancoGateway gateway;

    @Override
    public Optional<Banco> executar(Integer idBanco) {
        if (idBanco == null) {
            throw new RuntimeException("O idBanco não pode ser nulo.");
        }

        return gateway.executar(idBanco);
    }

}
