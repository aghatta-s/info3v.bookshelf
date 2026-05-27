package br.edu.ifrn.bookshelf.servico;

import br.edu.ifrn.bookshelf.modelo.Emprestimo;
import br.edu.ifrn.bookshelf.modelo.Livro;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EmprestimoServico {

    // RF3 — Registro de Empréstimo

    public void realizarEmprestimo(Emprestimo emprestimo) {

        Livro livro = emprestimo.getLivro();

        if (livro.isIndisponivel()) {

            throw new IllegalArgumentException(
                    "Não há exemplares disponíveis.");
        }

        livro.setExemplaresEmprestados(
                livro.getExemplaresEmprestados() + 1
        );

        emprestimo.setDataEmprestimo(LocalDate.now());

        emprestimo.setDataPrevistaDevolucao(
                LocalDate.now().plusDays(7)
        );

        System.out.println(
                "Empréstimo realizado com sucesso!");
    }

    // RF4 — Registro de Devolução

    public void registrarDevolucao(Emprestimo emprestimo) {

        Livro livro = emprestimo.getLivro();

        if (emprestimo.isDevolvido()) {

            throw new IllegalArgumentException(
                    "Esse empréstimo já foi devolvido.");
        }

        livro.setExemplaresEmprestados(
                livro.getExemplaresEmprestados() - 1
        );

        emprestimo.setDevolvido(true);

        System.out.println(
                "Devolução registrada com sucesso!");
    }

    // RF5 — Controle de Atrasos

    public long calcularDiasAtraso(Emprestimo emprestimo) {

        if (LocalDate.now().isAfter(
                emprestimo.getDataPrevistaDevolucao())) {

            return ChronoUnit.DAYS.between(
                    emprestimo.getDataPrevistaDevolucao(),
                    LocalDate.now()
            );
        }

        return 0;
    }
}