package controller;

import model.Alunos;
import model.Cursos;
//import dao.AlunoDAO;
//import dao.CursoDAO;
//import view.AlunoView;

import java.util.Optional;

//public class AlunoController {

    //public static void create() {
        // Alunos aluno = AlunoView.create();

        // Validações para verificar se aluno n possui matricula ou nome nulo ou idade inferior a 0
        // if (aluno.getMatricula() <= 0 || aluno.getNome().trim().isEmpty() || aluno.getIdade() <= 0) {
        //     AlunoView.message("Dados do aluno inválidos!");
        //     return;
        // }

        // Verificando se Aluno pertence obrigatoriamente a um Curso
        // if (aluno.getCurso() == null) {
        //     AlunoView.message("O aluno deve estar vinculado a um Curso.");
        //     return;
        // }

        // Valida se o curso informado existe no projeto
        // Optional<Cursos> curso = CursoDAO.read(aluno.getCurso().getCodigo());
        // if (!curso.isPresent()) {
        //     AlunoView.message("O curso informado não existe.");
        //     return;
        // }

        // Associa o curso completo (com a lista de disciplinas) ao aluno
        // aluno.setCurso(curso.get());

        // Cria o aluno
        // AlunoDAO.create(aluno);

        // Mesasgem de Aluno cadastro no sistema
        // AlunoView.message("Aluno cadastrado com sucesso!");
    //}

   // public static void read() {
        // int matricula = AlunoView.read();
        // Optional<Alunos> alunoOpt = AlunoDAO.read(matricula);

        // veriifcar se o aluno existe para visualizar seus dados
        // if (alunoOpt.isPresent()) {
        //     Alunos aluno = alunoOpt.get();
        //     AlunoView.message("Aluno encontrado!");

        //     Ao consultar o aluno, exibe seu curso e TODAS as disciplinas vinculadas
        //     AlunoView.show(aluno);
        // Caso o aluno não exista aparece a messagem sinalizando.
        // } else {
        //     AlunoView.message("Aluno não encontrado!");
        // }
    //}

   // public static void update() {
        // int matricula = AlunoView.read();
        // Optional<Alunos> alunoOpt = AlunoDAO.read(matricula);

        // verifica se o aluno existe para realizar a atualização
        // if (alunoOpt.isPresent()) {
        //     Alunos alunoAtualizado = AlunoView.update(alunoOpt.get());

        //     Revalida a associação do Curso se for alterado
        //     Optional<Curso> cursoOpt = CursoDAO.read(alunoAtualizado.getCurso().getCodigo());

        //     se o curso digitado existe
        //     if (cursoOpt.isPresent()) {
        //         alunoAtualizado.setCurso(cursoOpt.get());
        //         AlunoDAO.update(alunoAtualizado);
        //         AlunoView.message("Aluno atualizado com sucesso!");
        //     } else {
        //         AlunoView.message("Erro: Curso informado não encontrado!");
        //     }
        // } else {
        //     AlunoView.message("Aluno não encontrado!");
        // }
    //}

   // public static void delete() {
        // int matricula = AlunoView.read();

        // deleta o aluno se ele for encontrado no DAO
        // if (AlunoDAO.delete(matricula)) {
        //     AlunoView.message("Aluno excluído com sucesso!");
        // Caso o aluno não exista aparece a mensagem sinalizando.
        // } else {
        //     AlunoView.message("Aluno não encontrado!");
        // }
    //}
//}