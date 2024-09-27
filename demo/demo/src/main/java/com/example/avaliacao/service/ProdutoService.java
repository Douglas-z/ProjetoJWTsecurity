package com.example.avaliacao.service;

import com.example.avaliacao.model.Produtos;
import com.example.avaliacao.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produtos criarProduto(Produtos produto) {
        return produtoRepository.save(produto);
    }

    public List<Produtos> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produtos atualizarProduto(Long id, Produtos produto) {
        Produtos existente = produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado."));
        existente.setNome(produto.getNome());
        existente.setDescricao(produto.getDescricao());
        existente.setPreco(produto.getPreco());
        return produtoRepository.save(existente);
    }
}
