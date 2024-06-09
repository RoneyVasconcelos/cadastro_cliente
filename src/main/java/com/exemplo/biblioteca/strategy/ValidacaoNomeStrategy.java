package com.exemplo.biblioteca.strategy;

import com.exemplo.biblioteca.model.Usuario;

public class ValidacaoNomeStrategy implements ValidacaoStrategy {
    @Override
    public boolean validar(Usuario usuario) {
        // Lógica de validação de nome
        return usuario.getNome() != null && !usuario.getNome().trim().isEmpty();
    }
}
