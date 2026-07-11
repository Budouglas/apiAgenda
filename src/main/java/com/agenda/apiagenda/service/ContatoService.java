package com.agenda.apiagenda.service;

import com.agenda.apiagenda.Model.Contato;
import com.agenda.apiagenda.Repository.ContatoRepository;
import com.agenda.apiagenda.dto.ContatoRequestDTO;
import com.agenda.apiagenda.dto.ContatoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContatoService {

    private final ContatoRepository contatoRepository;

    @Transactional
    public ContatoResponseDTO save(ContatoRequestDTO requestDTO) {

        Contato contato = new Contato();

        contato.setNome(requestDTO.nome());
        contato.setEmail(requestDTO.email());
        contato.setTelefone(requestDTO.telefone());
        contato.setDataNascimento(requestDTO.dataNascimento());

        Contato savedContato = contatoRepository.save(contato);

        return new ContatoResponseDTO(savedContato.getId(), savedContato.getNome(), savedContato.getEmail(), savedContato.getTelefone(), savedContato.getDataNascimento());
    }

    @Transactional(readOnly = true)
    public ContatoResponseDTO findById(Long id) {

        Contato contato = contatoRepository.findById(id).orElseThrow(() -> new RuntimeException("Contato não encontrado"));

        return new ContatoResponseDTO(contato.getId(), contato.getNome(), contato.getEmail(), contato.getTelefone(), contato.getDataNascimento());

    }

    @Transactional
    public void deleteById(Long id) {

        Contato contato = contatoRepository.findById(id).orElseThrow(() -> new RuntimeException("Contato não encontrado"));

        contatoRepository.deleteById(id);
    }

    @Transactional
    public ContatoResponseDTO updateById(Long id, ContatoRequestDTO requestDTO) {

        Contato contato = contatoRepository.findById(id).orElseThrow(() -> new RuntimeException("Contato não encontrado"));

        contato.setNome(requestDTO.nome());
        contato.setEmail(requestDTO.email());
        contato.setTelefone(requestDTO.telefone());
        contato.setDataNascimento(requestDTO.dataNascimento());

        contatoRepository.save(contato);

        return new ContatoResponseDTO(contato.getId(), contato.getNome(), contato.getEmail(), contato.getTelefone(), contato.getDataNascimento());
    }

    @Transactional(readOnly = true)
    public List<ContatoResponseDTO> findAll() {

        List<Contato> contatos = contatoRepository.findAll();

        return contatos.stream().map(c -> new ContatoResponseDTO(c.getId(), c.getNome(), c.getEmail(), c.getTelefone(), c.getDataNascimento())).collect(java.util.stream.Collectors.toList());
    }
}