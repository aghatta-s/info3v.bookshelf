package br.edu.ifrn.bookshelf.repositorio;

import br.edu.ifrn.bookshelf.modelo.Livro;
import br.edu.ifrn.bookshelf.conexao.GerenciadorDeConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroRepositorio {

    // CREATE
    public void salvar(Livro livro) {

        String sql = "INSERT INTO livro (titulo, autor, quantidade_exemplares, exemplares_emprestados) VALUES (?, ?, ?, ?)";

        try (Connection conexao = GerenciadorDeConexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getQuantidadeExemplares());
            stmt.setInt(4, livro.getExemplaresEmprestados());

            stmt.executeUpdate();

            System.out.println("Livro salvo com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<Livro> listar() {

        List<Livro> livros = new ArrayList<>();

        String sql = "SELECT * FROM livro";

        try (Connection conexao = GerenciadorDeConexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Livro livro = new Livro();

                livro.setId(rs.getLong("id"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setAutor(rs.getString("autor"));
                livro.setQuantidadeExemplares(rs.getInt("quantidade_exemplares"));
                livro.setExemplaresEmprestados(rs.getInt("exemplares_emprestados"));

                livros.add(livro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return livros;
    }

    // UPDATE
    public void atualizar(Livro livro) {

        String sql = "UPDATE livro SET titulo = ?, autor = ?, quantidade_exemplares = ?, exemplares_emprestados = ? WHERE id = ?";

        try (Connection conexao = GerenciadorDeConexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getQuantidadeExemplares());
            stmt.setInt(4, livro.getExemplaresEmprestados());
            stmt.setLong(5, livro.getId());

            stmt.executeUpdate();

            System.out.println("Livro atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void excluir(Long id) {

        String sql = "DELETE FROM livro WHERE id = ?";

        try (Connection conexao = GerenciadorDeConexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setLong(1, id);

            stmt.executeUpdate();

            System.out.println("Livro excluído com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
