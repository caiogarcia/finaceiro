package com.github.caiogarcia.financeiro.banco.entrypoint;

import com.github.caiogarcia.financeiro.banco.core.IDeletarBancoUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/banco/{idBanco}")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DeletarBancoEntryPoint {

    private IDeletarBancoUseCase useCase;

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable(name = "idBanco") Integer idBanco) {

        useCase.executar(idBanco);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
