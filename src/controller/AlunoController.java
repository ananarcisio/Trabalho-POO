package controller;

import dao.AlunoDAO;
import dao.CursoDAO;
import model.Aluno;
import model.Curso;
import view.AlunoView;
import view.CursoView;

import java.util.Optional;

public class AlunoController {

    public static void Create() {
        Aluno aluno = new Aluno();
        AlunoView.Create(aluno);
        if (aluno.getMatricula() != 0) {
            AlunoDAO.Create(aluno);
            AlunoView.Message("Usuario cadastrado com sucesso! ");
        } else {
            AlunoView.Message("Usuario nao cadastrado! ");
        }
    }

    public static Curso cursoRetorno(){
        int id = AlunoView.cursoRetorno();
        Optional<Curso> curso = CursoDAO.Read(id);
        if (curso.isPresent()) {
            return curso.get();
        } else {
            CursoView.Message("Curso não encontrado!");
            return null;
        }
    }

    public static void Read() {
        int matricula = AlunoView.Read();
        Optional<Aluno> aluno = AlunoDAO.Read(matricula);
        if (aluno.isPresent()) {
            AlunoView.Message("Aluno encontrado!");
            AlunoView.Show(aluno.get());
        } else {
            AlunoView.Message("Aluno não encontrado!");
        }
    }

    public static void Delete() {
        int matricula = AlunoView.Read();
        if (AlunoDAO.Delete(matricula)) {
            AlunoView.Message("Aluno excluido com sucesso!");
        } else {
            AlunoView.Message("Aluno não encontrado!");
        }

    }

    public static void Update() {
        int matricula = AlunoView.Read();
        Optional<Aluno> aluno = AlunoDAO.GetAlunoByMatricula(matricula);
        if (aluno.isPresent()) {
            AlunoView.Update(aluno.get());
        } else {
            AlunoView.Message("Aluno não encontrado!");
        }
    }


}
