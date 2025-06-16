package com.mmtes.Mmtes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mmtes.Mmtes.models.entities.Categoria;
import com.mmtes.Mmtes.models.entities.Tarefa;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    List<Categoria> findByUsuarioIdUsuario(Long idUsuario);
}
