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

    public static Optional<Curso> Read(int id) {
        return GetCursoById(id);
    }

    public static List<Curso> ReadAll(){
        return new ArrayList<>(cursoList);
    }

    public static boolean Delete(int id) {
        Optional<Curso> curso = GetCursoById(id);
        if (curso.isPresent()) {
            cursoList.remove(curso.get());
            return true;
        } else {
            return false;
        }

    }

    public static Optional<Curso> GetCursoById(int id) {
        return cursoList.stream()
                .filter(curso -> curso.getId() == (id))
                .findFirst();
    }

}
