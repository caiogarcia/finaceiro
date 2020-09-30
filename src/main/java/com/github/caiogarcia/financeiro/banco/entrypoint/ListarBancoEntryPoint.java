package com.github.caiogarcia.financeiro.banco.entrypoint;

import java.util.List;

import com.github.caiogarcia.financeiro.banco.core.IListarBancoUseCase;
import com.github.caiogarcia.financeiro.banco.core.model.Banco;
import com.github.caiogarcia.financeiro.banco.entrypoint.entity.BancoEntity;
import com.github.caiogarcia.financeiro.banco.entrypoint.mapper.BancoEntityMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/banco")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Validated
public class ListarBancoEntryPoint {

    private IListarBancoUseCase useCase;

    @GetMapping
    public ResponseEntity<List<BancoEntity>> get() {

        List<Banco> banco = useCase.executar();

        if (banco.isEmpty()) {
            return new ResponseEntity<List<BancoEntity>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<BancoEntity>>(BancoEntityMapper.toEntityList(banco), HttpStatus.OK);
    }

}
