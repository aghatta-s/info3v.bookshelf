package br.edu.ifrn.bookshelf.servico;

import br.edu.ifrn.bookshelf.modelo.Livro;

public class LivroServico {

    public void cadastrarLivro(Livro novoLivro) {

        if (novoLivro.getQuantidadeExemplares() <= 0) {

            throw new IllegalArgumentException(
                    "A quantidade de exemplares deve ser maior que zero.");
        }

        System.out.println("Livro \""
                + novoLivro.getTitulo()
                + "\" cadastrado com sucesso!");
    }
}


