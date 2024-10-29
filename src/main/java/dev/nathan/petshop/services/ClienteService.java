package dev.nathan.petshop.services;

import dev.nathan.petshop.models.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> buscarTodos();

    Cliente salvar(Cliente cliente);

    Cliente buscarPorId(Long id);
}
