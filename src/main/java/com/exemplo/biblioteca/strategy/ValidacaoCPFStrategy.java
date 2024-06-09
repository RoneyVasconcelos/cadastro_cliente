package com.exemplo.biblioteca.strategy;

import com.exemplo.biblioteca.model.Usuario;

public class ValidacaoCPFStrategy implements ValidacaoStrategy {
    @Override
    public boolean validar(Usuario usuario) {
        // Lógica de validação de CPF
        return usuario.getCpf() != null && usuario.getCpf().matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
    }
}
