package SubMenus;

import controller.DisciplinaController;

import java.util.Scanner;

public class SubMenuDisciplina {

    public static void Show(){
        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        do {
            System.out.println("------------Disciplina------------");
            System.out.println("1- Cadastrar Disciplina");
            System.out.println("2- Consultar Disciplina");
            System.out.println("3- Remover Disciplina");
            System.out.println("4- Atualizar Disciplina");
            System.out.println("5- Voltar ao menu inicial!");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> DisciplinaController.Create();
                case 2 -> DisciplinaController.Read();
                case 3 -> DisciplinaController.Delete();
                case 4 -> DisciplinaController.Update();
                case 5 -> System.out.println("Voltando ao menu inicial!");
                default -> System.out.println("Opção inválida!");

            }
        } while (opcao != 5);
    }


}
