package com.example.esports.controllers;

import com.example.esports.dtos.JogoRecordDto;
import com.example.esports.models.JogoModel;
import com.example.esports.repositories.JogoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class JogoController {

    @Autowired
    JogoRepository jogoRepository;

    @PostMapping("/jogo")
    public ResponseEntity<Object> saveJogo(@RequestBody @Valid JogoRecordDto jogoRecordDto) {
        var jogoModel = new JogoModel();
        BeanUtils.copyProperties(jogoRecordDto, jogoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(jogoRepository.save(jogoModel));
    }

    @GetMapping("/jogo")
    public ResponseEntity<List<JogoModel>> getAllJogos() {
        return ResponseEntity.status(HttpStatus.OK).body(jogoRepository.findAll());
    }

    @GetMapping("/jogo/{id}")
    public ResponseEntity<Object> getOneJogo(@PathVariable(value = "id") UUID id) {
        Optional<JogoModel> jogoO = jogoRepository.findById(id);
        if (jogoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(jogoO.get());
    }

    @PutMapping("/jogo/{id}")
    public ResponseEntity<Object> updateJogo(@PathVariable(value = "id") UUID id,
                                             @RequestBody @Valid JogoRecordDto jogoRecordDto) {
        Optional<JogoModel> jogo0 = jogoRepository.findById(id);
        if (jogo0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game not found");
        }
        var jogoModel = jogo0.get();
        BeanUtils.copyProperties(jogoRecordDto, jogoModel);
        return ResponseEntity.status(HttpStatus.OK).body(jogoRepository.save(jogoModel));
    }

    @DeleteMapping("/jogo/{id}")
    public ResponseEntity<Object> deleteJogo(@PathVariable(value = "id") UUID id) {
        Optional<JogoModel> jogo0 = jogoRepository.findById(id);
        if (jogo0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game not found.");
        }
        jogoRepository.delete(jogo0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Game deleted successfully.");
    }
}
