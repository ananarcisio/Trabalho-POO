package view;

import java.util.Scanner;

public class Menu {
    public void exibirMenu(){
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("------------Menu------------");
            System.out.println("1- Gerenciar Alunos");
            System.out.println("2- Gerenciar Disciplinas");
            System.out.println("3- Gerenciar Cursos");
            System.out.println("4- SAIR");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> gerenciarAluno();
                case 2 -> gerenciarDisciplinas();
                case 3 -> gerenciarCursos();
                case 4 ->
                        System.out.println("Saindo!");
                break;
                default -> System.out.println("Opção inválida!");

            }
        } while (opcao != 5);
    }
}
