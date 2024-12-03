package repository;

import models.Contato;
import config.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContatoRepository {

  // Criar um novo contato
  public void adicionarContato(Contato contato) {
      String sql = "INSERT INTO contatos (nome, email, telefone) VALUES (?, ?, ?)";

      try (Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

          stmt.setString(1, contato.getNome());
          stmt.setString(2, contato.getEmail());
          stmt.setString(3, contato.getTelefone());

          int linhasAfetadas = stmt.executeUpdate();
          if (linhasAfetadas > 0) {
              System.out.println("Contato adicionado com sucesso!");
          }

      } catch (SQLException e) {
          System.out.println("Erro ao adicionar contato.");
          e.printStackTrace();
      }
  }

  // Obter todos os contatos
  public List<Contato> obterTodosContatos() {
    List<Contato> contatos = new ArrayList<>();
    String sql = "SELECT * FROM contatos";

    try (Connection conn = DbConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            Contato contato = new Contato(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("email"),
                rs.getString("telefone")
            );
            contatos.add(contato);
        }

    } catch (SQLException e) {
        System.out.println("Erro ao obter contatos.");
        e.printStackTrace();
    }

    return contatos;
  }

  // Obter contato por ID
  public Contato obterContatoPorId(int id) {
    String sql = "SELECT * FROM contatos WHERE id = ?";
    Contato contato = null;

    try (Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            contato = new Contato(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("email"),
                rs.getString("telefone")
            );
        }

    } catch (SQLException e) {
        System.out.println("Erro ao obter contato por ID.");
        e.printStackTrace();
    }

    return contato;
  }

  // Atualizar um contato
  public void atualizarContato(Contato contato) {
    String sql = "UPDATE contatos SET nome = ?, email = ?, telefone = ? WHERE id = ?";
    
    try (Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, contato.getNome());
        stmt.setString(2, contato.getEmail());
        stmt.setString(3, contato.getTelefone());
        stmt.setInt(4, contato.getId());
        
        int linhasAfetadas = stmt.executeUpdate();
        if (linhasAfetadas > 0) {
            System.out.println("Contato atualizado com sucesso!");
        } else {
            System.out.println("Contato não encontrado.");
        }
    } catch (SQLException e) {
        System.out.println("Erro ao atualizar contato.");
        e.printStackTrace();
    }
  }

  // Deletar um contato
  public void deletarContato(int id) {
    String sql = "DELETE FROM contatos WHERE id = ?";
    
    try (Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setInt(1, id);
        
        int linhasAfetadas = stmt.executeUpdate();
        if (linhasAfetadas > 0) {
            System.out.println("Contato deletado com sucesso!");
        } else {
            System.out.println("Contato não encontrado.");
        }
    } catch (SQLException e) {
        System.out.println("Erro ao deletar contato.");
        e.printStackTrace();
    }
  }

}
