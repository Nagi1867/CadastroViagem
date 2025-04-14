package com.CadastroViagem.resources;

import com.CadastroViagem.entities.Viagens;
import com.CadastroViagem.services.ViagemService;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/viagens")
public class ViagemResource {
    @Autowired
    private ViagemService service;

    @GetMapping
    public ResponseEntity<List<Viagens>> findAll() {
        List<Viagens> obj = service.findAll();
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Viagens> findById(@PathVariable Long id) {
        Viagens obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Viagens> insert(@RequestBody Viagens obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Viagens> update(@PathVariable Long id, @RequestBody Viagens obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
