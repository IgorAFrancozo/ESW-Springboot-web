package com.example.testingweb.produto;

public class CarrinhoVazioException extends Exception {

  @Override
  public String getMessage() {
    return "O Carrinho de compras não pode estar vazio.";
  }
}
