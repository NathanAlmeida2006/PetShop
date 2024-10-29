package dev.nathan.petshop.services;

import dev.nathan.petshop.models.Agendamento;

import java.util.List;

public interface AgendamentoService {
    List<Agendamento> buscarTodos();

    Agendamento salvar(Agendamento agendamento);

    Agendamento atualizar(Long id, Agendamento agendamento);
}
