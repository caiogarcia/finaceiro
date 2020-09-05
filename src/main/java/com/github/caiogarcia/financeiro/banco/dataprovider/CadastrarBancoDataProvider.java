package com.github.caiogarcia.financeiro.banco.dataprovider;

import com.github.caiogarcia.financeiro.banco.core.gateway.ICadastrarBancoGateway;
import com.github.caiogarcia.financeiro.banco.core.model.Banco;
import com.github.caiogarcia.financeiro.banco.dataprovider.repository.BancoRepository;
import com.github.caiogarcia.financeiro.banco.dataprovider.repository.model.BancoModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class CadastrarBancoDataProvider implements ICadastrarBancoGateway {

    private BancoRepository repository;

    @Override
    public Integer executar(Banco banco) {
        BancoModel model = BancoModel.builder()
            .nome(banco.getNome())
            .codigo(banco.getCodigo())
            .build();

        return repository.save(model).getIdBanco();
    }
    
}
