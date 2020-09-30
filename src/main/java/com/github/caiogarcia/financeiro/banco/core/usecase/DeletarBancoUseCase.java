package com.github.caiogarcia.financeiro.banco.core.usecase;

import java.util.Optional;

import com.github.caiogarcia.financeiro.banco.core.IDeletarBancoUseCase;
import com.github.caiogarcia.financeiro.banco.core.gateway.IDeletarBancoGateway;
import com.github.caiogarcia.financeiro.banco.core.gateway.IRecuperarBancoGateway;
import com.github.caiogarcia.financeiro.banco.core.model.Banco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DeletarBancoUseCase implements IDeletarBancoUseCase {

    private IDeletarBancoGateway deletargateway;
    private IRecuperarBancoGateway recuperarGateway;

    @Override
    public void executar(Integer idBanco) {
        if (idBanco == null) {
            throw new RuntimeException("O idBanco não pode ser nulo.");
        }
        Optional<Banco> bancoAtual = this.recuperarGateway.executar(idBanco);
        if (!bancoAtual.isPresent()) {
            throw new RuntimeException("Banco não encontrado.");
        }

        deletargateway.executar(idBanco);
    }

}
