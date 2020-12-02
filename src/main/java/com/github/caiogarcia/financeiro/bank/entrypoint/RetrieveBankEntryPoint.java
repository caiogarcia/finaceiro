package com.github.caiogarcia.financeiro.bank.entrypoint;

import java.util.Optional;

import com.github.caiogarcia.financeiro.bank.core.IRetrieveBankUseCase;
import com.github.caiogarcia.financeiro.bank.core.model.Bank;
import com.github.caiogarcia.financeiro.bank.entrypoint.entity.BankEntity;
import com.github.caiogarcia.financeiro.bank.entrypoint.mapper.BankEntityMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/bank/{idBank}")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RetrieveBankEntryPoint {

    private IRetrieveBankUseCase useCase;

    @GetMapping
    public ResponseEntity<BankEntity> get(@PathVariable(name = "idBank") Integer idBank) {

        Optional<Bank> bank = useCase.execute(idBank);

        if (bank.isPresent()) {
            return new ResponseEntity<BankEntity>(BankEntityMapper.toEntity(bank.get()), HttpStatus.OK);
        }
        return new ResponseEntity<BankEntity>(HttpStatus.NOT_FOUND);
    }

}
