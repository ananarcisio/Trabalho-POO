package view.SubMenus;

import view.Menu;

import java.util.Scanner;

public class SubMenuAluno {

    Menu menuInicial = new Menu();

    public void gerenciarAluno(){
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("------------Aluno------------");
            System.out.println("1- Cadastrar Aluno");
            System.out.println("2- Consultar Aluno");
            System.out.println("3- Remover Aluno");
            System.out.println("4- Atualizar Aluno");
            System.out.println("5- Voltar ao menu inicial!");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> cadastrarAluno();
                case 2 -> consultarAluno();
                case 3 -> removerAluno();
                case 4 -> atualizarAluno();
                case 5 ->
                        System.out.println("Voltando ao menu inicial!");
                        menuInicial.exibirMenu();
                break;
                default -> System.out.println("Opção inválida!");

            }
        } while (opcao != 6);
    }
}
