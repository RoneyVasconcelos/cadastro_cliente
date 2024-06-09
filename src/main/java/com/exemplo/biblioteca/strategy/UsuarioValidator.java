package com.exemplo.biblioteca.strategy;

import com.exemplo.biblioteca.model.Usuario;

public class UsuarioValidator {
    private ValidacaoStrategy strategy;

    public void setStrategy(ValidacaoStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validar(Usuario usuario) {
        return strategy.validar(usuario);
    }
}
