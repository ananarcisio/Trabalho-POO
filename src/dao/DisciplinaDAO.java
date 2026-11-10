package dao;

import model.Curso;
import model.Disciplina;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DisciplinaDAO {
    public static List<Disciplina> disciplinaList = new ArrayList<>();

    public static void Create(Disciplina disciplina) {
        disciplinaList.add(disciplina);
    }

    public static Optional<Disciplina> Read(int id) {
        return GetDisciplinaById(id);
    }

    public static List<Disciplina> ReadAll(){
        return new ArrayList<>(disciplinaList);
    }

    public static boolean Delete(int id) {
        Optional<Disciplina> disciplina = GetDisciplinaById(id);
        if (disciplina.isPresent()) {
            disciplinaList.remove(disciplina.get());
            return true;
        } else {
            return false;
        }

    }

    public static Optional<Disciplina> GetDisciplinaById(int id) {
        return disciplinaList.stream()
                .filter(disciplina -> disciplina.getId() == (id))
                .findFirst();
    }
}
