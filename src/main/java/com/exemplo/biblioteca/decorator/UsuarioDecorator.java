package com.exemplo.biblioteca.decorator;

public abstract class UsuarioDecorator implements UsuarioComponent {
    protected UsuarioComponent decoratedUsuario;

    public UsuarioDecorator(UsuarioComponent decoratedUsuario) {
        this.decoratedUsuario = decoratedUsuario;
    }

    public String getDescricao() {
        return decoratedUsuario.getDescricao();
    }
}
