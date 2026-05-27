package br.edu.ifrn.bookshelf.modelo;

import java.time.LocalDate;

public class Emprestimo {

    private Livro livro;
    private Usuario usuario;

    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;

    private boolean devolvido;

    public Livro getLivro() {

        return livro;
    }

    public void setLivro(Livro livro) {

        this.livro = livro;
    }

    public Usuario getUsuario() {

        return usuario;
    }

    public void setUsuario(Usuario usuario) {

        this.usuario = usuario;
    }

    public LocalDate getDataEmprestimo() {

        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {

        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataPrevistaDevolucao() {

        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(
            LocalDate dataPrevistaDevolucao) {

        this.dataPrevistaDevolucao =
                dataPrevistaDevolucao;
    }

    public boolean isDevolvido() {

        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {

        this.devolvido = devolvido;
    }
}