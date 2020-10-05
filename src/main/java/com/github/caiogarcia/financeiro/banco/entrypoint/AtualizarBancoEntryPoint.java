package com.github.caiogarcia.financeiro.banco.entrypoint;

import javax.validation.Valid;

import com.github.caiogarcia.financeiro.banco.core.IAtualizarBancoUseCase;
import com.github.caiogarcia.financeiro.banco.entrypoint.entity.BancoEntity;
import com.github.caiogarcia.financeiro.banco.entrypoint.mapper.BancoEntityMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/banco/{idBanco}")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Validated
public class AtualizarBancoEntryPoint {

    private IAtualizarBancoUseCase useCase;

    @PutMapping
    public ResponseEntity<Void> put(@Valid @RequestBody BancoEntity bancoEntity,
            @PathVariable(name = "idBanco") Integer idBanco) {

        bancoEntity.setIdBanco(idBanco);
        useCase.executar(BancoEntityMapper.toModel(bancoEntity));

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
