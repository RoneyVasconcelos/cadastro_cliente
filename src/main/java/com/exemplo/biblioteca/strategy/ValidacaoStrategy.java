package com.exemplo.biblioteca.strategy;

import com.exemplo.biblioteca.model.Usuario;

public interface ValidacaoStrategy {
    boolean validar(Usuario usuario);
}
