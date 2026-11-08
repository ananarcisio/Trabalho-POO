package model;

public class Disciplina {
    public int Id;
    public String Nome;

    public Disciplina(int id, String nome) {
        Id = id;
        Nome = nome;
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

}
