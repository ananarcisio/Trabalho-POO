package controller;

import dao.CursoDAO;
import model.Curso;
import view.CursoView;

import java.util.List;
import java.util.Optional;

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
        int id = CursoView.Read();
        Optional<Curso> curso = CursoDAO.Read(id);
        if (curso.isPresent()) {
            CursoView.Message("Curso encontrado!");
            CursoView.Show(curso.get());
        } else {
            CursoView.Message("Curso não encontrado!");
        }
    }

    public static void ReadAll() {
        List<Curso> cursos = CursoDAO.ReadAll();
        if (!cursos.isEmpty()) {
            System.out.println("--------Cursos Disponíveis--------");
            for (Curso c : cursos) {
                System.out.println("    " + c.getId() + " - " + c.getNome());
            }
        } else {
            CursoView.Message("Nenhum curso cadastrado!");
        }
    }

    public static void Delete() {
        int id = CursoView.Read();
        if (CursoDAO.Delete(id)) {
            CursoView.Message("Curso excluido com sucesso!");
        } else {
            CursoView.Message("Curso não encontrado!");
        }
    }

    public static void Update() {
        int id = CursoView.Read();
        Optional<Curso> cursoOpt = CursoDAO.GetCursoById(id);
        if (cursoOpt.isPresent()) {
            Curso curso = cursoOpt.get();
            CursoView.Update(curso);
            if (CursoDAO.Update(curso)) {
                CursoView.Message("Curso atualizado com sucesso!");
            } else {
                CursoView.Message("Erro ao atualizar curso!");
            }
        } else {
            CursoView.Message("Curso não encontrado!");
        }
    }

    public static void gerarId(Curso curso) {
        // ID gerado automaticamente pelo banco (SERIAL)
    }
}
