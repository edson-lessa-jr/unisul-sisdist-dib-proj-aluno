package br.unisul.aula.projaluno.dto;

public class NomesDTO {
    private String nomeAluno;

    public NomesDTO(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public NomesDTO() {
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }
}
