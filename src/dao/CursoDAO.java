package dao;

import model.Aluno;
import model.Curso;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CursoDAO {
    public static List<Curso> cursoList = new ArrayList<>();

    public static void Create(Curso curso) {
        cursoList.add(curso);
    }

    public static Optional<Curso> Read(String nome) {
        return GetCursoByNome(nome);
    }

    public static boolean Delete(String nome) {
        Optional<Curso> curso = GetCursoByNome(nome);
        if (curso.isPresent()) {
            cursoList.remove(curso.get());
            return true;
        } else {
            return false;
        }

    }

    public static Optional<Curso> GetCursoByNome(String nome) {
        return cursoList.stream()
                .filter(curso -> curso.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }
}
