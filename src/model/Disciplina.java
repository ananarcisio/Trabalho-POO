package model;

public class Disciplina {
    private int Id;
    private String Nome;
    private int CargaHorario;

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
}
