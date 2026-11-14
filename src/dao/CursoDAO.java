package dao;

import model.Curso;
import model.Disciplina;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CursoDAO {

    public static void Create(Curso curso) {
        String sql = "INSERT INTO curso (nome, turno) VALUES (?, ?) RETURNING id";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getTurno());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) curso.setId(rs.getInt("id"));
            for (Disciplina d : curso.getDisciplinas()) {
                linkDisciplina(conn, curso.getId(), d.getId());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar curso: " + e.getMessage());
        }
    }

    private static void linkDisciplina(Connection conn, int cursoId, int disciplinaId) throws SQLException {
        String sql = "INSERT INTO curso_disciplina (curso_id, disciplina_id) VALUES (?, ?) ON CONFLICT DO NOTHING";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cursoId);
            stmt.setInt(2, disciplinaId);
            stmt.executeUpdate();
        }
    }

    public static Optional<Curso> Read(int id) {
        String sql = "SELECT * FROM curso WHERE id = ?";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Curso curso = new Curso();
                curso.setId(rs.getInt("id"));
                curso.setNome(rs.getString("nome"));
                curso.setTurno(rs.getString("turno"));
                carregarDisciplinas(conn, curso);
                return Optional.of(curso);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar curso: " + e.getMessage());
        }
        return Optional.empty();
    }

    public static List<Curso> ReadAll() {
        List<Curso> lista = new ArrayList<>();
        String sql = "SELECT * FROM curso";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Curso curso = new Curso();
                curso.setId(rs.getInt("id"));
                curso.setNome(rs.getString("nome"));
                curso.setTurno(rs.getString("turno"));
                lista.add(curso);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar cursos: " + e.getMessage());
        }
        return lista;
    }

    private static void carregarDisciplinas(Connection conn, Curso curso) throws SQLException {
        String sql = "SELECT d.* FROM disciplina d JOIN curso_disciplina cd ON d.id = cd.disciplina_id WHERE cd.curso_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, curso.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Disciplina d = new Disciplina();
                d.setId(rs.getInt("id"));
                d.setNome(rs.getString("nome"));
                d.setCargaHorario(rs.getInt("carga_horaria"));
                curso.setDisciplinas(d);
            }
        }
    }

    public static boolean Delete(int id) {
        String sql = "DELETE FROM curso WHERE id = ?";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao excluir curso: " + e.getMessage());
        }
        return false;
    }

    public static Optional<Curso> GetCursoById(int id) {
        return Read(id);
    }

    public static boolean Update(Curso curso) {
        String sql = "UPDATE curso SET nome = ?, turno = ? WHERE id = ?";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getTurno());
            stmt.setInt(3, curso.getId());
            if (stmt.executeUpdate() > 0) {
                try (PreparedStatement del = conn.prepareStatement("DELETE FROM curso_disciplina WHERE curso_id = ?")) {
                    del.setInt(1, curso.getId());
                    del.executeUpdate();
                }
                for (Disciplina d : curso.getDisciplinas()) {
                    linkDisciplina(conn, curso.getId(), d.getId());
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar curso: " + e.getMessage());
        }
        return false;
    }
}
