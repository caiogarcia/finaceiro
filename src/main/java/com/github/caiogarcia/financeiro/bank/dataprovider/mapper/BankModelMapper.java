package com.github.caiogarcia.financeiro.bank.dataprovider.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.github.caiogarcia.financeiro.bank.core.model.Bank;
import com.github.caiogarcia.financeiro.bank.dataprovider.repository.model.BankModel;

import org.springframework.util.CollectionUtils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BankModelMapper {

  public static BankModel toModel(Bank entity) {
    if (Objects.isNull(entity))
      return null;

    return BankModel.builder().idBank(entity.getIdBank()).name(entity.getName()).code(entity.getCode()).build();
  }

  public static List<BankModel> toModelList(List<Bank> entityList) {
    if (CollectionUtils.isEmpty(entityList))
      return Collections.emptyList();

    return entityList.stream().map(BankModelMapper::toModel).collect(Collectors.toList());
  }

  public static Bank toEntity(BankModel model) {
    if (Objects.isNull(model))
      return null;

    return Bank.builder().idBank(model.getIdBank()).name(model.getName()).code(model.getCode()).build();
  }

  public static List<Bank> toEntityList(List<BankModel> modelList) {
    if (CollectionUtils.isEmpty(modelList))
      return Collections.emptyList();

    return modelList.stream().map(BankModelMapper::toEntity).collect(Collectors.toList());
  }
}
