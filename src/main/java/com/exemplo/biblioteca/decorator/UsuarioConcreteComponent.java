package com.exemplo.biblioteca.decorator;

import com.exemplo.biblioteca.model.Usuario;

public class UsuarioConcreteComponent implements UsuarioComponent {
    private Usuario usuario;

    public UsuarioConcreteComponent(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String getDescricao() {
        return "Usuário: " + usuario.getNome();
    }
}

