package com.github.caiogarcia.financeiro.banco.entrypoint;

import java.util.Optional;

import com.github.caiogarcia.financeiro.banco.core.IRecuperarBancoUseCase;
import com.github.caiogarcia.financeiro.banco.core.model.Banco;
import com.github.caiogarcia.financeiro.banco.entrypoint.entity.BancoEntity;
import com.github.caiogarcia.financeiro.banco.entrypoint.mapper.BancoEntityMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/banco/{idBanco}")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RecuperarBancoEntryPoint {

    private IRecuperarBancoUseCase useCase;

    @GetMapping
    public ResponseEntity<BancoEntity> get(@PathVariable(name = "idBanco") Integer idBanco) {

        Optional<Banco> banco = useCase.executar(idBanco);

        if (banco.isPresent()) {
            return new ResponseEntity<BancoEntity>(BancoEntityMapper.toEntity(banco.get()), HttpStatus.OK);
        }
        return new ResponseEntity<BancoEntity>(HttpStatus.NOT_FOUND);
    }

}
