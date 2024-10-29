package dev.nathan.petshop.repositories;

import dev.nathan.petshop.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
