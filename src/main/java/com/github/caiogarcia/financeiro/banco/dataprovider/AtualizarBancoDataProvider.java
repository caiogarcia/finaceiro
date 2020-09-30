package com.github.caiogarcia.financeiro.banco.dataprovider;

import com.github.caiogarcia.financeiro.banco.core.gateway.IAtualizarBancoGateway;
import com.github.caiogarcia.financeiro.banco.core.model.Banco;
import com.github.caiogarcia.financeiro.banco.dataprovider.mapper.BancoModelMapper;
import com.github.caiogarcia.financeiro.banco.dataprovider.repository.BancoRepository;
import com.github.caiogarcia.financeiro.banco.dataprovider.repository.model.BancoModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class AtualizarBancoDataProvider implements IAtualizarBancoGateway {

    private BancoRepository repository;

    @Override
    public Banco executar(Banco banco) {
        BancoModel model = BancoModelMapper.toModel(banco);

        return BancoModelMapper.toEntity(repository.save(model));
    }

}
