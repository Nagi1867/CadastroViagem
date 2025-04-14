package com.CadastroViagem.services;

import com.CadastroViagem.entities.Viagens;
import com.CadastroViagem.repositories.ViagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ViagemService {
    @Autowired
    private ViagemRepository repository;

    public List<Viagens> findAll() {
        return repository.findAll();
    }

    public Viagens findById(Long id) {
        Optional<Viagens> obj = repository.findById(id);
        return obj.get();
    }

    public Viagens insert(Viagens obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Viagens update(Long id, Viagens obj) {
        Viagens entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Viagens entity, Viagens obj) {
        entity.setNomePassageiro(obj.getNomePassageiro());
        entity.setLocal(obj.getLocal());
        entity.setTransporte(obj.getTransporte());
        entity.setLocal(obj.getLocal());
    }
}
