package com.github.caiogarcia.financeiro.banco.dataprovider;

import java.util.Optional;

import com.github.caiogarcia.financeiro.banco.core.gateway.IRecuperarBancoGateway;
import com.github.caiogarcia.financeiro.banco.dataprovider.mapper.BancoModelMapper;
import com.github.caiogarcia.financeiro.banco.dataprovider.repository.BancoRepository;
import com.github.caiogarcia.financeiro.banco.dataprovider.repository.model.BancoModel;
import com.github.caiogarcia.financeiro.banco.core.model.Banco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class RecuperarBancoDataProvider implements IRecuperarBancoGateway {

    private BancoRepository repository;

    @Override
    public Optional<Banco> executar(Integer idBanco) {

        Optional<BancoModel> modelOptional = repository.findById(idBanco);

        if (modelOptional.isPresent()) {
            return Optional.of(BancoModelMapper.toEntity(modelOptional.get()));
        }
        return Optional.empty();
    }

}
