package com.example.testingweb.produto;

import com.example.testingweb.carrinho.CarrinhoDeCompra;
import com.example.testingweb.carrinho.ItemDoCarrinho;

public class MaiorEMenor {

  private Produto menor;

  private Produto maior;

  public void encontrar(CarrinhoDeCompra carrinho)
    throws CarrinhoVazioException {
    if (carrinho.getItensDoCarrinho() == null) {
      throw new CarrinhoVazioException();
    }
    for (ItemDoCarrinho item : carrinho.getItensDoCarrinho()) {
      if (
        menor == null ||
        item.getProduto().getValorUnitario() < menor.getValorUnitario()
      ) {
        menor = item.getProduto();
      }
      if (
        maior == null ||
        item.getProduto().getValorUnitario() > maior.getValorUnitario()
      ) {
        maior = item.getProduto();
      }
    }
  }

  public Produto getMenor() {
    return menor;
  }

  public Produto getMaior() {
    return maior;
  }
}
