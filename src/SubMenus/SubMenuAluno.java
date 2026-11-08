package SubMenus;

import controller.AlunoController;

import java.awt.*;
import java.util.Scanner;

public class SubMenuAluno {


    public static void Show(){
        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        do {
            System.out.println("------------Aluno------------");
            System.out.println("1- Cadastrar Aluno");
            System.out.println("2- Consultar Aluno");
            System.out.println("3- Remover Aluno");
            System.out.println("4- Atualizar Aluno");
            System.out.println("5- Voltar ao menu inicial!");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> AlunoController.Create();
                case 2 -> AlunoController.Read();
                case 3 -> AlunoController.Delete();
                case 4 -> AlunoController.Update();
                case 5 -> System.out.println("Voltando ao menu inicial!");
                default -> System.out.println("Opção inválida!");

            }
        } while (opcao != 5);
    }



}
