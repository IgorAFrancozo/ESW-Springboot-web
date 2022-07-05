package com.example.testingweb.builders;

import com.example.testingweb.carrinho.CarrinhoDeCompra;
import com.example.testingweb.carrinho.ItemDoCarrinho;
import com.example.testingweb.produto.Produto;
import com.example.testingweb.produto.ValorInvalido;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompraBuilder {

  private static final int UM_UNIDADE = 1;
  private Produto geladeira;
  private Produto liquidificador;
  private Produto pratos;
  private List<ItemDoCarrinho> itens = new ArrayList<>() {};

  public CarrinhoDeCompraBuilder() throws ValorInvalido {
    geladeira = new Produto("Geladeira", 450.0);
    liquidificador = new Produto("Liquidificador", 250.0);
    pratos = new Produto("Jogo de pratos", 70.0);
  }

  public CarrinhoDeCompraBuilder emOrdemCrescente() {
    itens.add(new ItemDoCarrinho(pratos, UM_UNIDADE));
    itens.add(new ItemDoCarrinho(liquidificador, UM_UNIDADE));
    itens.add(new ItemDoCarrinho(geladeira, UM_UNIDADE));
    return this;
  }

  public CarrinhoDeCompraBuilder comItemDoCarrinho(
    ItemDoCarrinho itemDoCarrinho
  ) {
    itens.add(itemDoCarrinho);
    return this;
  }

  public CarrinhoDeCompraBuilder emOrdemDecrescente() {
    itens.add(new ItemDoCarrinho(geladeira, UM_UNIDADE));
    itens.add(new ItemDoCarrinho(liquidificador, UM_UNIDADE));
    itens.add(new ItemDoCarrinho(pratos, UM_UNIDADE));
    return this;
  }

  public CarrinhoDeCompra construir() {
    CarrinhoDeCompra carrinhoDeCompra = new CarrinhoDeCompra();
    for (ItemDoCarrinho itemDoCarrinho : itens) {
      carrinhoDeCompra.adicionar(itemDoCarrinho);
    }
    return carrinhoDeCompra;
  }
}
