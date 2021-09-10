package br.unisul.aula.projaluno.dto;

import br.unisul.aula.projaluno.model.Aluno;

public class AlunoDTO {
    private Long id;
    private String nome;
    private String dataNascimento;

    public AlunoDTO() {
    }

    public AlunoDTO(Aluno aluno) {
        this.id = aluno.getId();
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (this.id!=null){
            aluno.setId(this.id);
        } else {
            aluno.setId(null);
        }
        return aluno;
    }
}
