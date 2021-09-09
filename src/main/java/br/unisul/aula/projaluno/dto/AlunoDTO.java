package br.unisul.aula.projaluno.dto;

import br.unisul.aula.projaluno.model.Aluno;

public class AlunoDTO {
    private String nome;
    private String dataNascimento;

    public AlunoDTO() {
    }

    public AlunoDTO(String nome, String dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public AlunoDTO(Aluno aluno) {
        this.nome = aluno.getNome();
        this.dataNascimento = aluno.getDataNascimentoFormada();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "AlunoDTO: \n" +
                "nome=" + nome + ",\n" +
                "dataNascimento=" + dataNascimento ;
    }

    public Aluno converteParaAluno() {
        Aluno aluno = new Aluno();
        aluno.setNome(this.nome);
        aluno.setDataNascimento(this.dataNascimento);
        return aluno;
    }
}
