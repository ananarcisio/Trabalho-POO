package dao;

import model.Aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlunoDAO {
    public static List<Aluno> alunoList = new ArrayList<>();

    public static void Create(Aluno aluno) {
        alunoList.add(aluno);
    }

    public static Optional<Aluno> Read(int matricula) {
        return GetAlunoByMatricula(matricula);
    }

    public static boolean Delete(int matricula) {
        Optional<Aluno> aluno = GetAlunoByMatricula(matricula);
        if (aluno.isPresent()) {
            alunoList.remove(aluno.get());
            return true;
        } else {
            return false;
        }

    }

    public static Optional<Aluno> GetAlunoByMatricula(int matricula) {
        return alunoList.stream().filter(aluno -> aluno.getMatricula() == matricula).findFirst();
    }
}
