import SubMenus.SubMenuAluno;
import SubMenus.SubMenuCurso;
import SubMenus.SubMenuDisciplina;

import java.util.Scanner;

public class Menu {
    public static void Show(){
        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        do {
            System.out.println("------------Menu------------");
            System.out.println("1- Gerenciar Alunos");
            System.out.println("2- Gerenciar Disciplinas");
            System.out.println("3- Gerenciar Cursos");
            System.out.println("4- SAIR");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> SubMenuAluno.Show();
                case 2 -> SubMenuDisciplina.Show();
                case 3 -> SubMenuCurso.Show();
                case 4 -> {
                    System.out.println("Saindo!");
                    break;
                }
                default -> System.out.println("Opção inválida!");

            }
        } while (opcao != 5);
    }
}
