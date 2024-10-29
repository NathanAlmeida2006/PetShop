package dev.nathan.petshop.services.impl;

import dev.nathan.petshop.models.Agendamento;
import dev.nathan.petshop.repositories.AgendamentoRepository;
import dev.nathan.petshop.services.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoServiceImpl implements AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    @Autowired
    public AgendamentoServiceImpl(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    @Override
    public List<Agendamento> buscarTodos() {
        return agendamentoRepository.findAll();
    }

    @Override
    public Agendamento salvar(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    @Override
    public Agendamento atualizar(Long id, Agendamento agendamento) {
        agendamento.setId(id);
        return agendamentoRepository.save(agendamento);
    }
}
