package model;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private int Id;
    public String Nome;
    private String Turno;
    private List<Disciplina> disciplinas = new ArrayList<>();

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

    public String getTurno() {
        return Turno;
    }
    public void setTurno(String turno) {Turno = turno;}

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Disciplina disciplinas) {
        this.disciplinas.add(disciplinas);
    }


}
