package dev.nathan.petshop.services;

import dev.nathan.petshop.models.Animal;

import java.util.List;

public interface AnimalService {
    List<Animal> buscarTodos();

    Animal salvar(Animal animal);

    Animal buscarPorId(Long id);

    List<Animal> buscarPorCliente(Long clienteId);
}
