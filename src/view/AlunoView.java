package view;

import model.Aluno;
import model.Curso;
import model.Disciplina;

import java.util.Scanner;

public class AlunoView {

    public static void Show(Aluno aluno) {
        System.out.println("Matricula: " + aluno.getMatricula());
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("Idade: " + aluno.getIdade());
        if (aluno.getCursos() != null) {
            System.out.println("Curso: " + aluno.getCursos().getNome());
            System.out.println("    Disciplinas: ");
            for (Disciplina d : aluno.getCursos().getDisciplinas()) {
                System.out.println("    " + d.getId() + " - " + d.getNome());
            }

        } else {
            System.out.println("Curso: (nenhum)");
        }
    }

    public static void Message(String message) {
        System.out.println(message);
    }
    public static void Create(Aluno aluno) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Informe sua matricula: ");
        int matricula = scan.nextInt();

        System.out.println("Informe o seu nome: ");
        String nome = scan.next();

        System.out.println("Informe sua idade: ");
        int idade = scan.nextInt();

        System.out.println("Informe o id do seu curso: ");
        for (Curso c : ) {
            System.out.println("    " + c.getId() + " - " + c.getNome());
        }
        int curso = scan.nextInt();

        aluno.setMatricula(matricula);
        aluno.setNome(nome);
        aluno.setIdade(idade);
        aluno.setCursos();
    }

    public static int Read() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Informe o numero da matricula: ");
        return scan.nextInt();
    }

    public static void Update(Aluno aluno) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Atualize sua matricula: " + "(" + aluno.getMatricula() + "): ");
        int matricula = scan.nextInt();

        System.out.println("Atualize seu nome: " + "(" + aluno.getNome() + "): ");
        String nome = scan.next();

        System.out.println("Atualize sua idade: " + "(" + aluno.getIdade() + "): ");
        int idade = scan.nextInt();

        aluno.setMatricula(matricula);
        aluno.setNome(nome);
        aluno.setIdade(idade);
    }
}
