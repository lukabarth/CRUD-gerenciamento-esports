package com.example.esports.controllers;

import com.example.esports.dtos.EquipeRecordDto;
import com.example.esports.models.EquipeModel;
import com.example.esports.repositories.EquipeRepository;
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
public class EquipeController {

    @Autowired
    EquipeRepository equipeRepository;

    @PostMapping("/equipe")
    public ResponseEntity<EquipeModel> saveEquipe(@RequestBody @Valid EquipeRecordDto equipeRecordDto) {
        var equipeModel = new EquipeModel();
        BeanUtils.copyProperties(equipeRecordDto, equipeModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(equipeRepository.save(equipeModel));
    }

    @GetMapping("/equipe")
    public ResponseEntity<List<EquipeModel>> getAllEquipes() {
        return ResponseEntity.status(HttpStatus.OK).body(equipeRepository.findAll());
    }

    @GetMapping("/equipe/{id}")
    public ResponseEntity<Object> getOneEquipe(@PathVariable(value = "id")UUID id) {
        Optional<EquipeModel> equipeO = equipeRepository.findById(id);
        if (equipeO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Team not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(equipeO.get());
    }

    @PutMapping("/equipe/{id}")
    public ResponseEntity<Object> updateEquipe(@PathVariable(value = "id") UUID id,
                                               @RequestBody @Valid EquipeRecordDto equipeRecordDto) {
        Optional<EquipeModel> equipeO = equipeRepository.findById(id);
        if (equipeO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Team not found.");
        }
        var equipeModel = equipeO.get();
        BeanUtils.copyProperties(equipeRecordDto, equipeModel);
        return ResponseEntity.status(HttpStatus.OK).body(equipeRepository.save(equipeModel));
    }

    @DeleteMapping("/equipe/{id}")
    public ResponseEntity<Object> deleteEquipe(@PathVariable(value = "id") UUID id) {
        Optional<EquipeModel> equipe0 = equipeRepository.findById(id);
        if (equipe0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Team not found.");
        }
        equipeRepository.delete(equipe0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Team deleted successfully");
    }
}
