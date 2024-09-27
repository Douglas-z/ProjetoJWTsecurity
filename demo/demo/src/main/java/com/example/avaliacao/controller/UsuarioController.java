package com.example.avaliacao.controller;

import com.example.avaliacao.model.Usuarios;
import com.example.avaliacao.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuarios> criarUsuario(@RequestBody Usuarios usuario) {
        return ResponseEntity.ok(usuarioService.criarUsuario(usuario));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuarios usuario) {
        String token = usuarioService.login(usuario.getLogin(), usuario.getSenha());
        return ResponseEntity.ok(token);
    }

    @GetMapping
    public ResponseEntity<List<Usuarios>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @GetMapping("/{login}")
    public ResponseEntity<Usuarios> buscarPorLogin(@PathVariable String login) {
        return ResponseEntity.of(usuarioService.buscarPorLogin(login));
    }
}