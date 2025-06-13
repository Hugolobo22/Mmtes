package com.mmtes.Mmtes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mmtes.Mmtes.models.entities.EstatisticaUsuario;

@Repository
public interface EstatisticaUsuarioRepository extends JpaRepository<EstatisticaUsuario, Long>{

}
