package dev.nathan.petshop.controllers;

import dev.nathan.petshop.models.Agendamento;
import dev.nathan.petshop.services.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @Autowired
    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @GetMapping
    public List<Agendamento> buscarTodos() {
        return agendamentoService.buscarTodos();
    }

    @PostMapping
    public Agendamento criar(@RequestBody Agendamento agendamento) {
        return agendamentoService.salvar(agendamento);
    }

    @PutMapping("/{id}")
    public Agendamento atualizar(@PathVariable Long id, @RequestBody Agendamento agendamento) {
        return agendamentoService.atualizar(id, agendamento);
    }
}
