package br.unisul.aula.projaluno.controller;

import br.unisul.aula.projaluno.dto.AlunoDTO;
import br.unisul.aula.projaluno.model.Aluno;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AlunoController {
    private List<Aluno> alunoList = new ArrayList<>();

    @GetMapping("/{id}")
    public AlunoDTO localicarAluno(@PathVariable(name = "id") Integer id){
        AlunoDTO dto = new AlunoDTO(alunoList.get(id));
        return dto;
    }

    @GetMapping("/")
    public List<AlunoDTO> listarAluno(){
        List<AlunoDTO> dtoList = new ArrayList<>();
        for (int i = 0; i < alunoList.size(); i++) {
            Aluno aluno = alunoList.get(i);
            AlunoDTO dto = new AlunoDTO(aluno);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @PostMapping("/")
    public void incluirAluno(@RequestBody AlunoDTO dto){
        Aluno aluno = dto.converteParaAluno();
        alunoList.add(aluno);

    }
}
