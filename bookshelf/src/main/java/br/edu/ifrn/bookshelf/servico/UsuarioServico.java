package br.edu.ifrn.bookshelf.servico;

import br.edu.ifrn.bookshelf.modelo.Usuario;

public class UsuarioServico {

    public void cadastrarUsuario(Usuario usuario) {

        if (usuario.getNome() == null
                || usuario.getNome().isEmpty()) {

            throw new IllegalArgumentException(
                    "O nome do usuário é obrigatório.");
        }

        if (usuario.getMatricula() == null
                || usuario.getMatricula().isEmpty()) {

            throw new IllegalArgumentException(
                    "A matrícula é obrigatória.");
        }

        System.out.println("Usuário cadastrado com sucesso!");
    }
}