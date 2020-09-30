package com.github.caiogarcia.financeiro.banco.dataprovider;

import java.util.Arrays;
import java.util.List;

import com.github.caiogarcia.financeiro.banco.core.gateway.IListarBancoGateway;
import com.github.caiogarcia.financeiro.banco.dataprovider.mapper.BancoModelMapper;
import com.github.caiogarcia.financeiro.banco.dataprovider.repository.BancoRepository;
import com.github.caiogarcia.financeiro.banco.dataprovider.repository.model.BancoModel;
import com.github.caiogarcia.financeiro.banco.core.model.Banco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class ListarBancoDataProvider implements IListarBancoGateway {

    private BancoRepository repository;

    @Override
    public List<Banco> executar() {
        List<BancoModel> listaBancosModel = repository.findAll();
        if (listaBancosModel.isEmpty()) {
            return Arrays.asList();
        } else {
            List<Banco> listaBancos = BancoModelMapper.toEntityList(listaBancosModel);
            return listaBancos;
        }

    }

}
