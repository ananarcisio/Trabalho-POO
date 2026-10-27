package view.SubMenus;

import view.Menu;

import java.util.Scanner;

public class SubMenuDisciplina {
    Menu menuInicial = new Menu();

    public void gerenciarDisciplina(){
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("------------Disciplina------------");
            System.out.println("1- Cadastrar Disciplina");
            System.out.println("2- Consultar Disciplina");
            System.out.println("3- Remover Disciplina");
            System.out.println("4- Atualizar Disciplina");
            System.out.println("5- Voltar ao menu inicial!");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> cadastrarDisciplina();
                case 2 -> consultarDisciplina();
                case 3 -> removerDisciplina();
                case 4 -> atualizarDisciplina();
                case 5 -> {
                    System.out.println("Voltando ao menu inicial!");
                    menuInicial.exibirMenu();
                    break;
                }
                default -> System.out.println("Opção inválida!");

            }
        } while (opcao != 6);
    }

    public void atualizarDisciplina() {
        System.out.println("Disciplina atualizada");
    }

    public void removerDisciplina() {
        System.out.println("Disciplina removida");
    }

    public void consultarDisciplina() {
        System.out.println("Disciplina consultada");
    }

    public void cadastrarDisciplina() {
        System.out.println("Disciplina cadastrada");
    }
}
