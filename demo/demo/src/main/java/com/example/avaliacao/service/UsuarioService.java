package com.example.avaliacao.service;

import com.example.avaliacao.config.ProvedorTokenJwt;
import com.example.avaliacao.model.Usuarios;
import com.example.avaliacao.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProvedorTokenJwt provedorTokenJwt;

    public Usuarios criarUsuario(Usuarios usuario) {
        return usuarioRepository.save(usuario);
    }

    public String login(String login, String senha) {
        Usuarios usuario = usuarioRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado."));
        if (!usuario.getSenha().equals(senha)) {
            throw new BadCredentialsException("Senha incorreta.");
        }
        return provedorTokenJwt.criarToken(usuario.getLogin());
    }

    public List<Usuarios> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuarios> buscarPorLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }
}


