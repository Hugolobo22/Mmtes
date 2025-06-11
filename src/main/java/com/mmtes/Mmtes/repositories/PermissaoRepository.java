package com.mmtes.Mmtes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mmtes.Mmtes.models.entities.Permissao;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Long>{

}
