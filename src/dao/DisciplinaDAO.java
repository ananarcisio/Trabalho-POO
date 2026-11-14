package dao;

import model.Disciplina;

import java.sql.*;
        import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DisciplinaDAO {

    public static void Create(Disciplina disciplina) {
        String sql = "INSERT INTO disciplina (nome, carga_horaria) VALUES (?, ?) RETURNING id";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, disciplina.getNome());
            stmt.setInt(2, disciplina.getCargaHorario());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) disciplina.setId(rs.getInt("id"));
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar disciplina: " + e.getMessage());
        }
    }

    public static Optional<Disciplina> Read(int id) {
        String sql = "SELECT * FROM disciplina WHERE id = ?";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Disciplina d = new Disciplina();
                d.setId(rs.getInt("id"));
                d.setNome(rs.getString("nome"));
                d.setCargaHorario(rs.getInt("carga_horaria"));
                return Optional.of(d);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar disciplina: " + e.getMessage());
        }
        return Optional.empty();
    }

    public static List<Disciplina> ReadAll() {
        List<Disciplina> lista = new ArrayList<>();
        String sql = "SELECT * FROM disciplina";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Disciplina d = new Disciplina();
                d.setId(rs.getInt("id"));
                d.setNome(rs.getString("nome"));
                d.setCargaHorario(rs.getInt("carga_horaria"));
                lista.add(d);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar disciplinas: " + e.getMessage());
        }
        return lista;
    }

    public static boolean Delete(int id) {
        String sql = "DELETE FROM disciplina WHERE id = ?";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao excluir disciplina: " + e.getMessage());
        }
        return false;
    }

    public static Optional<Disciplina> GetDisciplinaById(int id) {
        return Read(id);
    }

    public static boolean Update(Disciplina disciplina) {
        String sql = "UPDATE disciplina SET nome = ?, carga_horaria = ? WHERE id = ?";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, disciplina.getNome());
            stmt.setInt(2, disciplina.getCargaHorario());
            stmt.setInt(3, disciplina.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar disciplina: " + e.getMessage());
        }
        return false;
    }
}
