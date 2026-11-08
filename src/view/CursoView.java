package view;


import model.Curso;
import model.Disciplina;

import java.util.Scanner;

public class CursoView {

    public static void Show(Curso curso) {
        System.out.println("Nome: " + curso.getNome());
        System.out.println("Carga Horária: " + curso.getCargaHorario());
        System.out.println("Disciplinas: " + curso.getDisciplinas());
        for (Disciplina d : curso.getDisciplinas()) {
            System.out.println("  " + d.getId() + " - " + d.getNome());
        }
    }

    public static void Message(String message) {
        System.out.println(message);
    }
    public static void Create(Curso curso) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Informe o nome do curso: ");
        String nome = scan.next();

        System.out.println("Informe a carga horária do curso: ");
        int cargaHoraria = scan.nextInt();

        System.out.println("Informe a quantidade de disciplinas do curso: ");
        int x = scan.nextInt();

        for (int i = 0; i < x; i++) {
            System.out.println("Informe o nome da disciplina " + (i + 1) + ":");
            String nomeDisciplina = scan.next();
            System.out.println("Informe o id da disciplina " + (i + 1) + ":");
            int idDisciplina = scan.nextInt();
            Disciplina disciplina = new Disciplina(idDisciplina, nomeDisciplina);
            curso.setDisciplinas(disciplina);
        }

        curso.setNome(nome);
        curso.setCargaHorario(cargaHoraria);
    }

    public static String Read() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Informe o nome do curso: ");
        String nome = scan.next();
        return nome;
    }

    public static void Update(Curso curso) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Atualize o nome do curso: " + "(" + curso.getNome() + "): ");
        String nome = scan.next();

        System.out.println("Atualize a carga horária da disciplina: " + "(" + curso.getCargaHorario() + "): ");
        int cargaHoraria = scan.nextInt();

        System.out.println("Atualize as disciplinas do curso: " + "(" + curso.getDisciplinas() + "): ");
        System.out.println("Informe a nova quantidade de disciplinas do curso: ");
        int x = scan.nextInt();

        for (int i = 0; i < x; i++) {
            System.out.println("Informe o nome da disciplina " + (i + 1) + ":");
            String nomeDisciplina = scan.next();
            System.out.println("Informe o id da disciplina " + (i + 1) + ":");
            int idDisciplina = scan.nextInt();
            Disciplina disciplina = new Disciplina(idDisciplina, nomeDisciplina);
            curso.setDisciplinas(disciplina);
        }

        curso.setNome(nome);
        curso.setCargaHorario(cargaHoraria);
    }
}

