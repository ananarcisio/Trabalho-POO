package model;

public class Alunos {
    public int Matricula;
    public String Nome;
    public int Idade;
    public Cursos cursos;

    public Alunos(int matricula, String nome, int idade, Cursos cursos) {
        Matricula = matricula;
        Nome = nome;
        Idade = idade;
        this.cursos = cursos;
    }

    public int getMatricula() {
        return Matricula;
    }

    public void setMatricula(int matricula) {
        Matricula = matricula;
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
