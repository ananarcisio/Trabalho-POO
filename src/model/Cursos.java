package model;

import java.util.List;

public class Cursos {
    public int Id;
    public String Nome;
    public int CargaHorario;
    public List<Disciplinas> disciplinas;

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

    public List<Disciplinas> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplinas> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Cursos(int id, String nome, int cargaHorario, List<Disciplinas> disciplinas) {
        Id = id;
        Nome = nome;
        CargaHorario = cargaHorario;
        this.disciplinas = disciplinas;
    }
}
