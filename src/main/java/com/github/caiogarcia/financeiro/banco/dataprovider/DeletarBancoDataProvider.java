package com.github.caiogarcia.financeiro.banco.dataprovider;

import com.github.caiogarcia.financeiro.banco.core.gateway.IDeletarBancoGateway;
import com.github.caiogarcia.financeiro.banco.dataprovider.repository.BancoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class DeletarBancoDataProvider implements IDeletarBancoGateway {

    private BancoRepository repository;

    @Override
    public void executar(Integer idBanco) {
        repository.deleteById(idBanco);
    }
    
}
