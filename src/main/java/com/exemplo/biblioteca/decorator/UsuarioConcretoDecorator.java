package com.exemplo.biblioteca.decorator;

public class UsuarioConcretoDecorator extends UsuarioDecorator {
    public UsuarioConcretoDecorator(UsuarioComponent decoratedUsuario) {
        super(decoratedUsuario);
    }

    @Override
    public String getDescricao() {
        return decoratedUsuario.getDescricao() + ", com função extra.";
    }
}
