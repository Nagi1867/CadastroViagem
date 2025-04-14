package com.CadastroViagem.repositories;

import com.CadastroViagem.entities.Viagens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViagemRepository extends JpaRepository<Viagens,Long> {
}
