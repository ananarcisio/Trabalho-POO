package dao;

import model.Aluno;
import model.Curso;

import java.sql.*;
import java.util.Optional;

public class AlunoDAO {

    public static void Create(Aluno aluno) {
        String sql = "INSERT INTO aluno (matricula, nome, idade, curso_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, aluno.getMatricula());
            stmt.setString(2, aluno.getNome());
            stmt.setInt(3, aluno.getIdade());
            if (aluno.getCursos() != null) {
                stmt.setInt(4, aluno.getCursos().getId());
            } else {
                stmt.setNull(4, Types.INTEGER);
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar aluno: " + e.getMessage());
        }
    }

    public static Optional<Aluno> Read(int matricula) {
        return GetAlunoByMatricula(matricula);
    }

    public static boolean Delete(int matricula) {
        String sql = "DELETE FROM aluno WHERE matricula = ?";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, matricula);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao excluir aluno: " + e.getMessage());
        }
        return false;
    }

    public static Optional<Aluno> GetAlunoByMatricula(int matricula) {
        String sql = "SELECT * FROM aluno WHERE matricula = ?";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, matricula);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setMatricula(rs.getInt("matricula"));
                aluno.setNome(rs.getString("nome"));
                aluno.setIdade(rs.getInt("idade"));
                int cursoId = rs.getInt("curso_id");
                if (!rs.wasNull()) {
                    CursoDAO.Read(cursoId).ifPresent(aluno::setCursos);
                }
                return Optional.of(aluno);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar aluno: " + e.getMessage());
        }
        return Optional.empty();
    }

    public static boolean Update(Aluno aluno, int matriculaOriginal) {
        String sql = "UPDATE aluno SET matricula = ?, nome = ?, idade = ?, curso_id = ? WHERE matricula = ?";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, aluno.getMatricula());
            stmt.setString(2, aluno.getNome());
            stmt.setInt(3, aluno.getIdade());
            if (aluno.getCursos() != null) {
                stmt.setInt(4, aluno.getCursos().getId());
            } else {
                stmt.setNull(4, Types.INTEGER);
            }
            stmt.setInt(5, matriculaOriginal);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar aluno: " + e.getMessage());
        }
        return false;
    }
}

/*package dao;

import model.Aluno;

import java.sql.*;
import java.util.Optional;

public class AlunoDAO {

    public static void Create(Aluno aluno) {
        String sql = "INSERT INTO aluno (matricula, nome, idade, curso_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, aluno.getMatricula());
            stmt.setString(2, aluno.getNome());
            stmt.setInt(3, aluno.getIdade());
            if (aluno.getCursos() != null) stmt.setInt(4, aluno.getCursos().getId());
            else stmt.setNull(4, Types.INTEGER);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar aluno: " + e.getMessage());
        }
    }

    public static Optional<Aluno> Read(int matricula) {
        return GetAlunoByMatricula(matricula);
    }

    public static boolean Delete(int matricula) {
        String sql = "DELETE FROM aluno WHERE matricula = ?";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, matricula);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao excluir aluno: " + e.getMessage());
        }
        return false;
    }

    public static Optional<Aluno> GetAlunoByMatricula(int matricula) {
        String sql = "SELECT * FROM aluno WHERE matricula = ?";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, matricula);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setMatricula(rs.getInt("matricula"));
                aluno.setNome(rs.getString("nome"));
                aluno.setIdade(rs.getInt("idade"));
                int cursoId = rs.getInt("curso_id");
                if (!rs.wasNull()) CursoDAO.Read(cursoId).ifPresent(aluno::setCursos);
                return Optional.of(aluno);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar aluno: " + e.getMessage());
        }
        return Optional.empty();
    }

    public static boolean Update(Aluno aluno, int matriculaOriginal) {
        String sql = "UPDATE aluno SET matricula=?, nome=?, idade=?, curso_id=? WHERE matricula=?";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, aluno.getMatricula());
            stmt.setString(2, aluno.getNome());
            stmt.setInt(3, aluno.getIdade());
            if (aluno.getCursos() != null) stmt.setInt(4, aluno.getCursos().getId());
            else stmt.setNull(4, Types.INTEGER);
            stmt.setInt(5, matriculaOriginal);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar aluno: " + e.getMessage());
        }
        return false;
    }
}*/
