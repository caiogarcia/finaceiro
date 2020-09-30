package com.github.caiogarcia.financeiro.banco.core.usecase;

import java.util.Optional;

import com.github.caiogarcia.financeiro.banco.core.IAtualizarBancoUseCase;
import com.github.caiogarcia.financeiro.banco.core.gateway.IAtualizarBancoGateway;
import com.github.caiogarcia.financeiro.banco.core.gateway.IRecuperarBancoGateway;
import com.github.caiogarcia.financeiro.banco.core.model.Banco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AtualizarBancoUseCase implements IAtualizarBancoUseCase {

    private IAtualizarBancoGateway atualizarGateway;
    private IRecuperarBancoGateway recuperarGateway;

    @Override
    public Banco executar(Banco banco) {
        if (banco == null) {
            throw new RuntimeException("O Banco não pode ser nulo.");
        }

        Optional<Banco> bancoAtual = this.recuperarGateway.executar(banco.getIdBanco());
        if (!bancoAtual.isPresent()) {
            throw new RuntimeException("Banco não encontrado.");
        }

        return atualizarGateway.executar(banco);
    }

}
