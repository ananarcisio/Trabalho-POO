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
        int id = CursoView.Read();
        Optional<Curso> curso = CursoDAO.Read(id);
        if (curso.isPresent()) {
            CursoView.Message("Curso encontrado!");
            CursoView.Show(curso.get());
        } else {
            CursoView.Message("Curso não encontrado!");
        }
    }



    public static void ReadAll(){
        List<Curso> curso = CursoDAO.ReadAll();
        if(!curso.isEmpty()){
            System.out.println("--------Cursos Disponíveis--------");
            for(Curso c : curso){
                System.out.println("    " + c.getId() + " - " + c.getNome());
            }
        }else{
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
        Optional<Curso> curso = CursoDAO.GetCursoById(id);
        if (curso.isPresent()) {
            CursoView.Update(curso.get());
        } else {
            CursoView.Message("Curso não encontrado!");
        }
    }
    public static void gerarId(Curso curso){
        int i = CursoDAO.cursoList.size();
        curso.setId(i + 1);
    }

}
