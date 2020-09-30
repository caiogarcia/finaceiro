package com.github.caiogarcia.financeiro.banco.dataprovider.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.github.caiogarcia.financeiro.banco.core.model.Banco;
import com.github.caiogarcia.financeiro.banco.dataprovider.repository.model.BancoModel;

import org.springframework.util.CollectionUtils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BancoModelMapper {

  public static BancoModel toModel(Banco entity) {
    if (Objects.isNull(entity))
      return null;

    return BancoModel.builder().idBanco(entity.getIdBanco()).nome(entity.getNome()).codigo(entity.getCodigo()).build();
  }

  public static List<BancoModel> toModelList(List<Banco> entityList) {
    if (CollectionUtils.isEmpty(entityList))
      return Collections.emptyList();

    return entityList.stream().map(BancoModelMapper::toModel).collect(Collectors.toList());
  }

  public static Banco toEntity(BancoModel model) {
    if (Objects.isNull(model))
      return null;

    return Banco.builder().idBanco(model.getIdBanco()).nome(model.getNome()).codigo(model.getCodigo()).build();
  }

  public static List<Banco> toEntityList(List<BancoModel> modelList) {
    if (CollectionUtils.isEmpty(modelList))
      return Collections.emptyList();

    return modelList.stream().map(BancoModelMapper::toEntity).collect(Collectors.toList());
  }
}
