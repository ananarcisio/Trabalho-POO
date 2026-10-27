package model;

public class Disciplinas {
    public int Id;
    public String Nome;
    public Cursos Curso;

    public Disciplinas(int id, String nome, Cursos curso) {
        Id = id;
        Nome = nome;
        Curso = curso;
    }

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

    public Cursos getCurso() {
        return Curso;
    }

    public void setCurso(Cursos curso) {
        Curso = curso;
    }
}
