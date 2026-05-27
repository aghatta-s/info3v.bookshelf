package br.edu.ifrn;

import br.edu.ifrn.bookshelf.modelo.Livro;
import br.edu.ifrn.bookshelf.servico.LivroServico;

public class Main {

    public static void main(String[] args) {

        LivroServico service = new LivroServico();

        Livro livro1 = new Livro();

        livro1.setTitulo("Dom Casmurro");
        livro1.setAutor("Machado de Assis");
        livro1.setQuantidadeExemplares(5);
        livro1.setExemplaresEmprestados(2);

        System.out.println("---- Teste de Cadastro ----");

        try {

            service.cadastrarLivro(livro1);

        } catch (Exception e) {

            System.err.println("Erro ao cadastrar: " + e.getMessage());
        }

        System.out.println("\n---- Status do Livro ----");

        System.out.println("Título: " + livro1.getTitulo());

        System.out.println("Autor: " + livro1.getAutor());

        System.out.println("Quantidade Total: "
                + livro1.getQuantidadeExemplares());

        System.out.println("Exemplares Disponíveis: "
                + livro1.getExemplaresDisponiveis());

        if (livro1.isIndisponivel()) {

            System.out.println("Atenção: Livro indisponível!");

        } else {

            System.out.println("Status: Há exemplares disponíveis.");
        }
    }
}