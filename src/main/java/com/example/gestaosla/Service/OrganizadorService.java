package com.example.gestaosla.Service;

import com.example.gestaosla.model.Organizador;
import com.example.gestaosla.repository.OrganizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class OrganizadorService {

    @Autowired
    private OrganizadorRepository organizadorRepository;

    public List<Organizador> getAllOrganizador() {
        return organizadorRepository.findAll();
    }

    public Optional<Organizador> getOrganizadorById(Long sala) {
        return organizadorRepository.findById(sala);
    }

    public Organizador createOrganizador(Organizador organizador) {
        return
                organizadorRepository.save(organizador);
    }

    public Organizador updateOrganizador(Long sala, Organizador organizador) {
        Optional<Organizador> existingOrganizador= organizadorRepository.findById(sala);
        if (existingOrganizador.isPresent()) {
            Organizador updateOrganizador = existingOrganizador.get();

            updateOrganizador.setId(organizador.getId());
            updateOrganizador.setEmail(organizador.getEmail());
            updateOrganizador.setNome(organizador.getNome());

        }
        return null;
    }

    public void deleteOrganizador(Long sala) {
        organizadorRepository.deleteById(sala);
    }

}
