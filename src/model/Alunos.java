package model;

public class Alunos {
    public int Id;
    public String Nome;
    public int Idade;
    public Cursos cursos;

    public Alunos(int id, String nome, int idade, Cursos cursos) {
        Id = id;
        Nome = nome;
        Idade = idade;
        this.cursos = cursos;
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

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int idade) {
        Idade = idade;
    }

    public Cursos getCursos() {
        return cursos;
    }

    public void setCursos(Cursos cursos) {
        this.cursos = cursos;
    }
}
