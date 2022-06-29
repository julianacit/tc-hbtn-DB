package demo;

import models.*;
import entities.*;
import java.util.*;

public class AdministrativoApp {

    public static void main(String[] args) {
        ProdutoModel produtoModel = new ProdutoModel();
        PessoaModel pessoaModel = new PessoaModel();

        Produto p1 = new Produto();
        p1.setNome("TV");
        p1.setPreco(300.0);
        p1.setQuantidade(100);
        p1.setStatus(true);

        // 1) Criando um produto
        produtoModel.create(p1);

        //2) Buscando todos os produtos na base de dados
        List<Produto> produtos = produtoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + produtos.size());

        //3) Buscando produto por id
        Produto res = produtoModel.findById(p1);
        System.out.println(res.getNome());

        //4) Update
        p1.setStatus(false);
        produtoModel.update(p1);

        //5) Delete
        produtoModel.delete(p1);

        Pessoa p2 = new Pessoa();
        p2.setNome("Jane Doe");
        p2.setEmail("email@email.com");
        p2.setIdade(30);
        p2.setCpf("111.111.111-11");
        p2.setDataDeNascimento("12/11/1991");

        pessoaModel.create(p2);

        List<Pessoa> pessoas = pessoaModel.findAll();
        System.out.println("Qtde de pessoas encontradas : " + pessoas.size());

        Pessoa res2 = pessoaModel.findById(p2);
        System.out.println(res2.getNome());

        p2.setNome("Jane");
        pessoaModel.update(p2);

        pessoaModel.delete(p2);
    }
}