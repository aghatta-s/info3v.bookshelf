package br.edu.ifrn.bookshelf.modelo;

public class Livro {
  
    private String titulo;
    private String autor;
    private int quantidadeExemplares;
    private int exemplaresEmprestados;
    private Long id;

    public int getExemplaresDisponiveis() {

        return this.quantidadeExemplares - this.exemplaresEmprestados;
    }

    public boolean isIndisponivel() {

        return this.exemplaresEmprestados >= this.quantidadeExemplares;
    }

    // Getters e Setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getQuantidadeExemplares() {
        return quantidadeExemplares;
    }

    public void setQuantidadeExemplares(int quantidadeExemplares) {
        this.quantidadeExemplares = quantidadeExemplares;
    }

    public int getExemplaresEmprestados() {
        return exemplaresEmprestados;
    }

    public void setExemplaresEmprestados(int exemplaresEmprestados) {
        this.exemplaresEmprestados = exemplaresEmprestados;
    }
  
    public Long getId() {

    return id;
    }

    public void setId(Long id) {

    this.id = id;

    }
}


