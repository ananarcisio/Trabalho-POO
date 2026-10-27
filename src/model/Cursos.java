package model;

import java.util.List;

public class Cursos {
    public int Id;
    public String Nome;
    public int CargaHorario;
    public List<Disciplinas> disciplinas;

    public Cursos(int id, String nome, int cargaHorario, List<Disciplinas> disciplinas) {
        Id = id;
        Nome = nome;
        CargaHorario = cargaHorario;
        this.disciplinas = disciplinas;
    }
}
