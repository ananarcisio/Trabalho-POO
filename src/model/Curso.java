package model;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    public int Id;
    public String Nome;
    public int CargaHorario;
    public List<Disciplina> disciplinas = new ArrayList<>();

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public int getCargaHorario() {
        return CargaHorario;
    }

    public void setCargaHorario(int cargaHorario) {
        CargaHorario = cargaHorario;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Disciplina disciplinas) {
        this.disciplinas.add(disciplinas);
    }


}
