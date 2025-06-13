package com.mmtes.Mmtes.repository;

import com.mmtes.Mmtes.models.entities.TarefaCategoria;
import com.mmtes.Mmtes.models.entities.TarefaCategoriaId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaCategoriaRepository extends JpaRepository<TarefaCategoria, TarefaCategoriaId> {

}