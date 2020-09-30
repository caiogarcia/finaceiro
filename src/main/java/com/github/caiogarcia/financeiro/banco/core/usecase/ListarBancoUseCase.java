package com.github.caiogarcia.financeiro.banco.core.usecase;

import java.util.List;

import com.github.caiogarcia.financeiro.banco.core.IListarBancoUseCase;
import com.github.caiogarcia.financeiro.banco.core.gateway.IListarBancoGateway;
import com.github.caiogarcia.financeiro.banco.core.model.Banco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ListarBancoUseCase implements IListarBancoUseCase {

    private IListarBancoGateway gateway;

    @Override
    public List<Banco> executar() {
        return gateway.executar();
    }

}
