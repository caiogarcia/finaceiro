package com.github.caiogarcia.financeiro.banco.dataprovider.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.List;

import com.github.caiogarcia.financeiro.banco.core.model.Banco;
import com.github.caiogarcia.financeiro.banco.dataprovider.repository.model.BancoModel;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@Tag("Unit")
public class BancoModelMapperTest {

  @Test
  public void givenAValidBancoWhenMaptoModelThenReturnABanco() {
    Banco banco = Banco.builder().nome("Foo Bar").idBanco(123).codigo("456").build();
    BancoModel expected = BancoModel.builder().nome("Foo Bar").idBanco(123).codigo("456").build();

    BancoModel actual = BancoModelMapper.toModel(banco);

    assertEquals(expected, actual);
  }

  @Test
  public void givenANullBancoWhenMaptoModelThenReturnANullBanco() {
    Banco banco = null;

    BancoModel actual = BancoModelMapper.toModel(banco);

    assertNull(actual);
  }

  @Test
  public void givenAValidListBancoWhenMaptoModelThenReturnAListBanco() {
    List<Banco> Bancos = Arrays.asList(Banco.builder().nome("Foo").idBanco(123).codigo("456").build(),
        Banco.builder().nome("Bar").idBanco(321).codigo("654").build());
    List<BancoModel> expected = Arrays.asList(BancoModel.builder().nome("Foo").idBanco(123).codigo("456").build(),
        BancoModel.builder().nome("Bar").idBanco(321).codigo("654").build());

    List<BancoModel> actual = BancoModelMapper.toModelList(Bancos);

    assertEquals(expected, actual);
  }

  @Test
  public void givenANullListBancoWhenMaptoModelThenReturnAEmptyListBancoModel() {
    List<Banco> bancos = null;

    List<BancoModel> actual = BancoModelMapper.toModelList(bancos);

    assertThat(actual).isEmpty();
  }

  @Test
  public void givenAValidBancoModelWhenMaptoThenReturnABanco() {
    BancoModel bancoModel = BancoModel.builder().nome("Foo").idBanco(123).codigo("456").build();
    Banco expected = Banco.builder().nome("Foo").idBanco(123).codigo("456").build();

    Banco actual = BancoModelMapper.toEntity(bancoModel);

    assertEquals(expected, actual);
  }

  @Test
  public void givenANullBancoModelWhenMaptoThenReturnANullBanco() {
    BancoModel Banco = null;

    Banco actual = BancoModelMapper.toEntity(Banco);

    assertNull(actual);
  }

  @Test
  public void givenAValidListBancoModelWhenMaptoThenReturnAListBanco() {
    List<BancoModel> Bancos = Arrays.asList(BancoModel.builder().nome("Foo").idBanco(123).codigo("456").build(),
        BancoModel.builder().nome("Bar").idBanco(321).codigo("654").build());
    List<Banco> expected = Arrays.asList(Banco.builder().nome("Foo").idBanco(123).codigo("456").build(),
        Banco.builder().nome("Bar").idBanco(321).codigo("654").build());

    List<Banco> actual = BancoModelMapper.toEntityList(Bancos);

    assertEquals(expected, actual);
  }

  @Test
  public void givenANullListBancoModelWhenMaptoThenReturnAEmptyListBanco() {
    List<BancoModel> Bancos = null;

    List<Banco> actual = BancoModelMapper.toEntityList(Bancos);

    assertThat(actual).isEmpty();
  }
}
