package view.SubMenus;

import view.Menu;

import java.util.Scanner;

public class SubMenuCurso {

    Menu menuInicial = new Menu();

    public void gerenciarCurso(){
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("------------Cursos------------");
            System.out.println("1- Cadastrar Curso");
            System.out.println("2- Consultar Curso");
            System.out.println("3- Remover Curso");
            System.out.println("4- Atualizar Curso");
            System.out.println("5- Voltar ao menu inicial!");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> cadastrarCurso();
                case 2 -> consultarCurso();
                case 3 -> removerCurso();
                case 4 -> atualizarCurso();
                case 5 ->
                        System.out.println("Voltando ao menu inicial!");
                        menuInicial.exibirMenu();
                break;
                default -> System.out.println("Opção inválida!");

            }
        } while (opcao != 6);
    }

}
