package com.github.caiogarcia.financeiro.banco.entrypoint.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.github.caiogarcia.financeiro.banco.core.model.Banco;
import com.github.caiogarcia.financeiro.banco.entrypoint.entity.BancoEntity;

import org.springframework.util.CollectionUtils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BancoEntityMapper {

  public static BancoEntity toEntity(Banco entity) {
    if (Objects.isNull(entity))
      return null;

    return BancoEntity.builder().idBanco(entity.getIdBanco()).nome(entity.getNome()).codigo(entity.getCodigo()).build();
  }

  public static List<BancoEntity> toEntityList(List<Banco> entityList) {
    if (CollectionUtils.isEmpty(entityList))
      return Collections.emptyList();

    return entityList.stream().map(BancoEntityMapper::toEntity).collect(Collectors.toList());
  }

  public static Banco toModel(BancoEntity Model) {
    if (Objects.isNull(Model))
      return null;

    return Banco.builder().idBanco(Model.getIdBanco()).nome(Model.getNome()).codigo(Model.getCodigo()).build();
  }

  public static List<Banco> toModelList(List<BancoEntity> ModelList) {
    if (CollectionUtils.isEmpty(ModelList))
      return Collections.emptyList();

    return ModelList.stream().map(BancoEntityMapper::toModel).collect(Collectors.toList());
  }
}
