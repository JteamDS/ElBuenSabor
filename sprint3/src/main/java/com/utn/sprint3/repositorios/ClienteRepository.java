package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente, Long> {
}
