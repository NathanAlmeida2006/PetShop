package dev.nathan.petshop.services.impl;

import dev.nathan.petshop.models.Animal;
import dev.nathan.petshop.repositories.AnimalRepository;
import dev.nathan.petshop.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public List<Animal> buscarTodos() {
        return animalRepository.findAll();
    }

    @Override
    public Animal salvar(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public Animal buscarPorId(Long id) {
        return animalRepository.findById(id).orElseThrow(() -> new RuntimeException("Animal não encontrado"));
    }

    @Override
    public List<Animal> buscarPorCliente(Long clienteId) {
        return animalRepository.findByClienteId(clienteId);
    }
}
