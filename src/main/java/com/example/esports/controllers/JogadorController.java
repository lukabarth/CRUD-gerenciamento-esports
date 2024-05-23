package com.example.esports.controllers;

import com.example.esports.dtos.JogadorRecordDto;
import com.example.esports.models.JogadorModel;
import com.example.esports.repositories.JogadorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class JogadorController {

    @Autowired
    JogadorRepository jogadorRepository;

    @PostMapping("/jogador")
    public ResponseEntity<JogadorModel> saveJogador(@RequestBody @Valid JogadorRecordDto jogadorRecordDto) {
        var jogadorModel = new JogadorModel();
        BeanUtils.copyProperties(jogadorRecordDto, jogadorModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(jogadorRepository.save(jogadorModel));
    }

    @GetMapping("/jogador")
    public ResponseEntity<List<JogadorModel>> getAllJogadores() {
        return ResponseEntity.status(HttpStatus.OK).body(jogadorRepository.findAll());
    }

    @GetMapping("/jogador/{id}")
    public ResponseEntity<Object> getOneJogador(@PathVariable(value = "id") UUID id) {
        Optional<JogadorModel> jogadorO = jogadorRepository.findById(id);
        if (jogadorO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(jogadorO.get());
    }

    @PutMapping("/jogador/{id}")
    public ResponseEntity<Object> updateJogador(@PathVariable(value = "id") UUID id,
                                                @RequestBody @Valid JogadorRecordDto jogadorRecordDto) {
        Optional<JogadorModel> jogadorO = jogadorRepository.findById(id);
        if (jogadorO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player not found.");
        }
        var jogadorModel = jogadorO.get();
        BeanUtils.copyProperties(jogadorRecordDto, jogadorModel);
        return ResponseEntity.status(HttpStatus.OK).body(jogadorRepository.save(jogadorModel));
    }

    @DeleteMapping("/jogador/{id}")
    public ResponseEntity<Object> deleteJogador(@PathVariable(value = "id") UUID id) {
        Optional<JogadorModel> jogadorO = jogadorRepository.findById(id);
        if (jogadorO.isEmpty()) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player not found.");
        }
        jogadorRepository.delete(jogadorO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Player deleted successfully.");
    }
}
