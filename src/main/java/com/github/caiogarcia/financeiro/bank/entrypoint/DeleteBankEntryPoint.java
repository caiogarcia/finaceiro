package com.github.caiogarcia.financeiro.bank.entrypoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.caiogarcia.financeiro.bank.core.IDeleteBankUseCase;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/bank/{idBank}")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DeleteBankEntryPoint {

    private IDeleteBankUseCase useCase;

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable(name = "idBank") Integer idBank) {

        useCase.execute(idBank);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
