package com.morcineck.usuario.infrastructure.repository;

import com.morcinek.aprendendospring.infrastructure.entity.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(String email);

    Optional<Usuario> findByEmail(String email); // evita que retorne NULL como erro

    @Transactional
    void deleteByEmail(String email);
}
