package view;

import controller.DisciplinaController;
import model.Curso;
import model.Disciplina;

import java.util.Scanner;

public class DisciplinaView {
    public static void Show(Disciplina disciplina) {
        System.out.println("Nome: " + disciplina.getNome());
        System.out.println("Carga Horária: " + disciplina.getCargaHorario());
    }

    public static void Message(String message) {
        System.out.println(message);
    }
    public static void Create(Disciplina disciplina) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Informe o nome da disciplina: ");
        String nome = scan.next();

        System.out.println("Informe a carga horária do da disciplina: ");
        int cargaHoraria = scan.nextInt();

        disciplina.setNome(nome);
        disciplina.setCargaHorario(cargaHoraria);
        DisciplinaController.gerarId(disciplina);
    }

    public static int Read() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Informe o id da disciplina: ");
        int id = scan.nextInt();
        return id;
    }


    public static void Update(Disciplina disciplina) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Atualize o nome da disciplina: " + "(" + disciplina.getNome() + "): ");
        String nome = scan.next();

        System.out.println("Atualize a carga horária da disciplina: " + "(" + disciplina.getCargaHorario() + "): ");
        int cargaHoraria = scan.nextInt();

        disciplina.setNome(nome);
        disciplina.setCargaHorario(cargaHoraria);
    }
}
