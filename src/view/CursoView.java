package view;


import controller.CursoController;
import controller.DisciplinaController;
import model.Curso;
import model.Disciplina;

import java.util.Scanner;

public class CursoView {

    public static void Show(Curso curso) {
        System.out.println("Nome: " + curso.getNome());
        System.out.println("Turno: " + curso.getTurno());
        System.out.println("Disciplinas: ");
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

        System.out.println("Informe o turno do curso: ");
        String turno = scan.next();

        DisciplinaController.ReadAll();

        System.out.println("Informe a quantidade de disciplinas que deseja vincular: ");
        int x = scan.nextInt();

        for (int i = 1; i <= x; i++) {
            System.out.println("Informe o id da " + i + "º" + "disciplina que deseja vincular:");
            int id = scan.nextInt();
            curso.setDisciplinas(DisciplinaController.disciplinaRetorno(id));

        }

        CursoController.gerarId(curso);
        curso.setNome(nome);
        curso.setTurno(turno);
    }

    public static int Read() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Informe o id do curso: ");
        int id = scan.nextInt();
        return id;
    }

    public static void Update(Curso curso) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Atualize o nome do curso: " + "(" + curso.getNome() + "): ");
        String nome = scan.next();

        System.out.println("Atualize o turno da curso: " + "(" + curso.getTurno() + "): ");
        String turno = scan.next();

        System.out.println("Atualize as disciplinas do curso: " + "(" + curso.getDisciplinas() + "): ");

        System.out.println("Informe a quantidade de disciplinas que deseja vincular: ");
        int x = scan.nextInt();

        for (int i = 1; i <= x; i++) {
            System.out.println("Informe o id da " + i + "º" + "disciplina que deseja vincular:");
            int id = scan.nextInt();
            curso.setDisciplinas(DisciplinaController.disciplinaRetorno(id));

        }

        curso.setNome(nome);
        curso.setTurno(turno);
    }
}

