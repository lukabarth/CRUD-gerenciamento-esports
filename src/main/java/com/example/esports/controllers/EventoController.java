package com.example.esports.controllers;

import com.example.esports.dtos.EventoRecordDto;
import com.example.esports.models.EventoModel;
import com.example.esports.repositories.EventoRepository;
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
public class EventoController {

    @Autowired
    EventoRepository eventoRepository;

    @PostMapping("/evento")
    public ResponseEntity<EventoModel> saveEvento(@RequestBody @Valid EventoRecordDto eventoRecordDto) {
        var eventoModel = new EventoModel();
        BeanUtils.copyProperties(eventoRecordDto, eventoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(eventoRepository.save(eventoModel));
    }

    @GetMapping("/evento")
    public ResponseEntity<List<EventoModel>> getAllEventos() {
        return ResponseEntity.status(HttpStatus.OK).body(eventoRepository.findAll());
    }

    @GetMapping("/evento/{id}")
    public ResponseEntity<Object> getOneEvento(@PathVariable(value = "id") UUID id) {
        Optional<EventoModel> eventoO = eventoRepository.findById(id);
        if (eventoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(eventoO.get());
    }

    @PutMapping("/evento/{id}")
    public ResponseEntity<Object> updateEvento(@PathVariable(value = "id") UUID id,
                                               @RequestBody @Valid EventoRecordDto eventoRecordDto) {
        Optional<EventoModel> eventoO = eventoRepository.findById(id);
        if (eventoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event not found.");
        }
        var eventoModel = eventoO.get();
        BeanUtils.copyProperties(eventoRecordDto, eventoModel);
        return ResponseEntity.status(HttpStatus.OK).body(eventoRepository.save(eventoModel));
    }

    @DeleteMapping("/evento/{id}")
    public ResponseEntity<Object> deleteEvento(@PathVariable(value = "id") UUID id) {
        Optional<EventoModel> eventoO = eventoRepository.findById(id);
        if (eventoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event not found.");
        }
        eventoRepository.delete(eventoO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Event deleted successfully.");
    }
}
