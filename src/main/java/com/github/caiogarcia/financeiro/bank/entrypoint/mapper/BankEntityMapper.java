package com.github.caiogarcia.financeiro.bank.entrypoint.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.github.caiogarcia.financeiro.bank.core.model.Bank;
import com.github.caiogarcia.financeiro.bank.entrypoint.entity.BankEntity;

import org.springframework.util.CollectionUtils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BankEntityMapper {

  public static BankEntity toEntity(Bank entity) {
    if (Objects.isNull(entity))
      return null;

    return BankEntity.builder().idBank(entity.getIdBank()).name(entity.getName()).code(entity.getCode()).build();
  }

  public static List<BankEntity> toEntityList(List<Bank> entityList) {
    if (CollectionUtils.isEmpty(entityList))
      return Collections.emptyList();

    return entityList.stream().map(BankEntityMapper::toEntity).collect(Collectors.toList());
  }

  public static Bank toModel(BankEntity model) {
    if (Objects.isNull(model))
      return null;

    return Bank.builder().idBank(model.getIdBank()).name(model.getName()).code(model.getCode()).build();
  }

  public static List<Bank> toModelList(List<BankEntity> ModelList) {
    if (CollectionUtils.isEmpty(ModelList))
      return Collections.emptyList();

    return ModelList.stream().map(BankEntityMapper::toModel).collect(Collectors.toList());
  }
}
