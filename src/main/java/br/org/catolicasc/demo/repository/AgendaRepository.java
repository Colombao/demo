package br.org.catolicasc.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.org.catolicasc.demo.entity.AgendaEntity;

public interface AgendaRepository extends JpaRepository<AgendaEntity, Long> {
}
