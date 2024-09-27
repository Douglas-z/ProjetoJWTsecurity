package com.example.avaliacao.controller;


import com.example.avaliacao.model.Produtos;
import com.example.avaliacao.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produtos> criarProduto(@RequestBody Produtos produto) {
        return ResponseEntity.ok(produtoService.criarProduto(produto));
    }

    @GetMapping
    public ResponseEntity<List<Produtos>> listarProdutos() {
        return ResponseEntity.ok(produtoService.listarProdutos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produtos> atualizarProduto(@PathVariable Long id, @RequestBody Produtos produto) {
        return ResponseEntity.ok(produtoService.atualizarProduto(id, produto));
    }
}
