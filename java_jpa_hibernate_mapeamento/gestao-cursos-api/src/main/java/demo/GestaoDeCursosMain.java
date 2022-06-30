package demo;

import entities.*;
import models.AlunoModel;
import models.CursoModel;

import java.util.ArrayList;
import java.util.List;

public class GestaoDeCursosMain {
    public static void main (String[] args) {
        AlunoModel alunoModel = new AlunoModel();
        CursoModel cursoModel = new CursoModel();

        Aluno aluno = new Aluno();
        aluno.setNomeCompleto("John Doe");
        aluno.setMatricula("1");
        //aluno.setId(1l);

        Endereco endereco = new Endereco();
        endereco.setEndereco("Rua 1");
        //endereco.setId(1l);
        List<Endereco> enderecos = new ArrayList<>();
        enderecos.add(endereco);

        Telefone telefone = new Telefone();
        telefone.setNumero("21");
        //telefone.setId(1l);
        List<Telefone> telefones = new ArrayList<>();
        telefones.add(telefone);

        aluno.setEnderecos(enderecos);
        aluno.setTelefones(telefones);

        Professor professor = new Professor();
        //professor.setId(1l);
        professor.setNomeCompleto("Jane Doe");
        professor.setMatricula("2");

        MaterialCurso materialCurso = new MaterialCurso();
        //materialCurso.setId(1l);
        materialCurso.setUrl("url");

        List<Aluno> alunos = new ArrayList<>();
        alunos.add(aluno);

        Curso curso = new Curso();
        //curso.setId(1l);
        curso.setNome("Curso 1");
        curso.setAlunos(alunos);
        curso.setMaterialCurso(materialCurso);
        curso.setProfessor(professor);
        List<Curso> cursos = new ArrayList<>();
        professor.setCursos(cursos);
        aluno.setCursos(cursos);

        alunoModel.create(aluno);
        System.out.println(alunoModel.findById(aluno));
        aluno.setEmail("john@email.com");
        alunoModel.update(aluno);
        System.out.println(alunoModel.findById(aluno));
        System.out.println(alunoModel.findAll());

        cursoModel.create(curso);
        System.out.println(cursoModel.findById(curso));
        curso.setSigla("C1");
        cursoModel.update(curso);
        System.out.println(cursoModel.findById(curso));
        System.out.println(cursoModel.findAll());

        alunoModel.delete(aluno);
        cursoModel.delete(curso);
    }
}
