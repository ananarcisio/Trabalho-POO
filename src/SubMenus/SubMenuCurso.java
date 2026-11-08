package SubMenus;

import controller.CursoController;

import java.awt.*;
import java.util.Scanner;

public class SubMenuCurso {


    public static void Show(){
        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        do {
            System.out.println("------------Cursos------------");
            System.out.println("1- Cadastrar Curso");
            System.out.println("2- Consultar Curso");
            System.out.println("3- Remover Curso");
            System.out.println("4- Atualizar Curso");
            System.out.println("5- Voltar ao menu inicial!");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> CursoController.Create();
                case 2 -> CursoController.Read();
                case 3 -> CursoController.Delete();
                case 4 -> CursoController.Update();
                case 5 -> System.out.println("Voltando ao menu inicial!");
                default -> System.out.println("Opção inválida!");

            }
        } while (opcao != 5);
    }

}
