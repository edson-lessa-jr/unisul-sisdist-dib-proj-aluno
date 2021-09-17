package br.unisul.aula.projaluno.controller;

import br.unisul.aula.projaluno.dto.AlunoDTO;
import br.unisul.aula.projaluno.dto.NomesDTO;
import br.unisul.aula.projaluno.model.Aluno;
import br.unisul.aula.projaluno.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/{id}")
    public AlunoDTO localicarAluno(@PathVariable(name = "id") Long id) {
        AlunoDTO dto = new AlunoDTO(alunoRepository.findById(id).get());
        return dto;
    }
    @PostMapping("/info/")
    public List<AlunoDTO> localizarAlunoIDS(@RequestBody List<AlunoDTO> alunoDTOList) {
        List<AlunoDTO> dtos = new ArrayList<>();
        for (AlunoDTO alunoBuscado: alunoDTOList) {
            AlunoDTO dto = new AlunoDTO(alunoRepository.findById(alunoBuscado.getId()).get());
            dtos.add(dto);
        }
        System.out.println(dtos);
        return dtos;
    }

    @GetMapping("/nome/{nome}")
    public AlunoDTO localizarPorNome(@PathVariable(name = "nome") String nome) {
        AlunoDTO alunoDTO = new AlunoDTO(alunoRepository.findFirstByNome(nome));
        return alunoDTO;
    }

    @GetMapping("/")
    public List<AlunoDTO> listarAluno() {
        List<AlunoDTO> dtoList = new ArrayList<>();
        List<Aluno> alunoList = alunoRepository.findAll();
        for (int i = 0; i < alunoList.size(); i++) {
            Aluno aluno = alunoList.get(i);
            AlunoDTO dto = new AlunoDTO(aluno);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @PostMapping("/")
    public void incluirAluno(@RequestBody AlunoDTO dto) {
        Aluno aluno = dto.converteParaAluno();
        alunoRepository.save(aluno);

    }

    @PostMapping("/nome/")
    public List<AlunoDTO> localizarListaPorNome(@RequestBody List<NomesDTO> listaDeConsulta){
        List<AlunoDTO> dtos = new ArrayList<>();
        for (NomesDTO alunoPesquisado: listaDeConsulta){
            AlunoDTO alunoDTO = new AlunoDTO(alunoRepository
                    .findFirstByNome(alunoPesquisado.getNomeAluno()));
            dtos.add(alunoDTO);

        }
        return dtos;
    }
}
