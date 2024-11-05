package dev.nathan.petshop.controllers;

import dev.nathan.petshop.models.Animal;
import dev.nathan.petshop.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animais/")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public List<Animal> buscarTodos() {
        return animalService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Animal buscarPorId(@PathVariable Long id) {
        return animalService.buscarPorId(id);
    }

    @GetMapping("/cliente/{clienteId}")
    public List<Animal> buscarPorCliente(@PathVariable Long clienteId) {
        return animalService.buscarPorCliente(clienteId);
    }

    @PostMapping
    public Animal criar(@RequestBody Animal animal) {
        return animalService.salvar(animal);
    }
}
