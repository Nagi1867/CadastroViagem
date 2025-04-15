package com.CadastroViagem.services;

import com.CadastroViagem.entities.Viagens;
import com.CadastroViagem.repositories.ViagemRepository;
import com.CadastroViagem.services.exceptions.DatabaseException;
import com.CadastroViagem.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Viagens insert(Viagens obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Viagens update(Long id, Viagens obj) {
        try {
            Viagens entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Viagens entity, Viagens obj) {
        entity.setNomePassageiro(obj.getNomePassageiro());
        entity.setLocal(obj.getLocal());
        entity.setTransporte(obj.getTransporte());
        entity.setLocal(obj.getLocal());
    }
}
