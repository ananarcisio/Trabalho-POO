package controller;

import dao.CursoDAO;
import dao.DisciplinaDAO;
import model.Curso;
import model.Disciplina;
import view.AlunoView;
import view.CursoView;
import view.DisciplinaView;

import java.util.List;
import java.util.Optional;

public class DisciplinaController {

    public static void Create() {
        Disciplina disciplina = new Disciplina();
        DisciplinaView.Create(disciplina);
        if (!disciplina.getNome().isBlank()) {
            DisciplinaDAO.Create(disciplina);
            DisciplinaView.Message("Disciplina cadastrado com sucesso! ");
        } else {
            DisciplinaView.Message("Disciplina não cadastrado! ");
        }
    }


    public static void Read() {
        int id = DisciplinaView.Read();
        Optional<Disciplina> disciplina = DisciplinaDAO.Read(id);
        if (disciplina.isPresent()) {
            DisciplinaView.Message("Disciplina encontrado!");
            DisciplinaView.Show(disciplina.get());
        } else {
            DisciplinaView.Message("Disciplina não encontrado!");
        }
    }

    public static Disciplina disciplinaRetorno(){
        int id = DisciplinaView.disciplinaRetorno();
        Optional<Disciplina> disciplina = DisciplinaDAO.Read(id);
        if (disciplina.isPresent()) {
            return disciplina.get();
        } else {
            DisciplinaView.Message("Disciplina não encontrada!");
            return null;
        }
    }



    public static void ReadAll(){
        List<Disciplina> disciplina = DisciplinaDAO.ReadAll();
        if(!disciplina.isEmpty()){
            System.out.println("--------Disciplinas Disponíveis--------");
            for(Disciplina d : disciplina){
                System.out.println("    " + d.getId() + " - " + d.getNome());
            }
        }else{
            DisciplinaView.Message("Nenhuma disciplina cadastrada!");
        }
    }

    public static void Delete() {
        int id = DisciplinaView.Read();
        if (DisciplinaDAO.Delete(id)) {
            DisciplinaView.Message("Disciplina excluida com sucesso!");
        } else {
            DisciplinaView.Message("Disciplina não encontrada!");
        }

    }

    public static void Update() {
        int id = DisciplinaView.Read();
        Optional<Disciplina> disciplina = DisciplinaDAO.GetDisciplinaById(id);
        if (disciplina.isPresent()) {
            DisciplinaView.Update(disciplina.get());
        } else {
            DisciplinaView.Message("Disciplina não encontrada!");
        }
    }
    public static void gerarId(Disciplina disciplina){
        int i = DisciplinaDAO.disciplinaList.size();
        disciplina.setId(i + 1);
    }
}
