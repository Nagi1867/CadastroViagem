package com.CadastroViagem.config;

import com.CadastroViagem.entities.Viagens;
import com.CadastroViagem.repositories.ViagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private ViagemRepository repository;
    @Override
    public void run(String... args) throws Exception {
        Viagens viagens = new Viagens(null, "Alex", "BH", "Onibus", 1);
        repository.save(viagens);
    }
}
