package com.exemplo.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.biblioteca.decorator.UsuarioComponent;
import com.exemplo.biblioteca.decorator.UsuarioConcreteComponent;
import com.exemplo.biblioteca.decorator.UsuarioConcretoDecorator;
import com.exemplo.biblioteca.model.Usuario;
import com.exemplo.biblioteca.repository.UsuarioRepository;
import com.exemplo.biblioteca.strategy.UsuarioValidator;
import com.exemplo.biblioteca.strategy.ValidacaoCPFStrategy;
import com.exemplo.biblioteca.strategy.ValidacaoNomeStrategy;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario salvar(Usuario usuario) {
        // Uso do Decorator
        UsuarioComponent usuarioComponent = new UsuarioConcreteComponent(usuario);
        UsuarioComponent usuarioDecorado = new UsuarioConcretoDecorator(usuarioComponent);
        System.out.println(usuarioDecorado.getDescricao());

        // Uso do Strategy
        UsuarioValidator validator = new UsuarioValidator();

        validator.setStrategy(new ValidacaoCPFStrategy());
        boolean isCpfValido = validator.validar(usuario);
        System.out.println("CPF válido: " + isCpfValido);

        validator.setStrategy(new ValidacaoNomeStrategy());
        boolean isNomeValido = validator.validar(usuario);
        System.out.println("Nome válido: " + isNomeValido);

        if (isCpfValido && isNomeValido) {
            return usuarioRepository.save(usuario);
        } else {
            throw new IllegalArgumentException("Validação falhou");
        }
    }

    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
