package controller;

import dao.CursoDAO;
import model.Curso;
import view.CursoView;

import java.util.Optional;
import java.util.List;

public class CursoController {

    public static void Create() {
        Curso curso = new Curso();
        CursoView.Create(curso);
        if (!curso.getNome().isBlank()) {
            CursoDAO.Create(curso);
            CursoView.Message("Curso cadastrado com sucesso! ");
        } else {
            CursoView.Message("Curso não cadastrado! ");
        }
    }

    public static void Read() {
        String nome = CursoView.Read();
        Optional<Curso> curso = CursoDAO.Read(nome);
        if (curso.isPresent()) {
            CursoView.Message("Curso encontrado!");
            CursoView.Show(curso.get());
        } else {
            CursoView.Message("Curso não encontrado!");
        }
    }

    public static void Delete() {
        String nome = CursoView.Read();
        if (CursoDAO.Delete(nome)) {
            CursoView.Message("Curso excluido com sucesso!");
        } else {
            CursoView.Message("Curso não encontrado!");
        }

    }

    public static void Update() {
        String nome = CursoView.Read();
        Optional<Curso> curso = CursoDAO.GetCursoByNome(nome);
        if (curso.isPresent()) {
            CursoView.Update(curso.get());
        } else {
            CursoView.Message("Aluno não encontrado!");
        }
    }
}
