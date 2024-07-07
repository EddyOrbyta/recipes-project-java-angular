package it.orbyta.backend_test_cert.service;

import it.orbyta.backend_test_cert.dto.request.IngredienteDto;
import it.orbyta.backend_test_cert.dto.request.IngredienteRequest;
import it.orbyta.backend_test_cert.entity.Ingrediente;
import it.orbyta.backend_test_cert.exceptions.IngredienteNotFoundException;
import it.orbyta.backend_test_cert.repository.IngredienteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class IngredienteService {
    private final IngredienteRepository ingredienteRepository;
    @Transactional //TODO dont allow duplicates based on name
    public boolean addIngrediente(IngredienteRequest ingredienteRequest) {

        log.info("Start method - addIngrediente - ingredienteRequest: {}", ingredienteRequest);
        List<Ingrediente> savedIngrendienti = new ArrayList<>();

        for (IngredienteDto ingredienteReq : ingredienteRequest.getIngredienti()) {

            Ingrediente ingredienteSaved = ingredienteRepository.save(populateIngrediente(ingredienteReq));
            savedIngrendienti.add(ingredienteSaved);
        }

        log.info("End method - addIngrediente - ingredienteRequest: {}", ingredienteRequest);
        return savedIngrendienti.size() == ingredienteRequest.getIngredienti().size();
    }

    private Ingrediente populateIngrediente(IngredienteDto ingredienteReq) {
    return Ingrediente.builder()
            .nome(ingredienteReq.getNome())
            .descrizione(ingredienteReq.getDescrizione())
            .foto(ingredienteReq.getFoto())
            .build();
    }

    public boolean deleteIngrediente(int id) {
        log.info("Start method - deleteIngrediente - id: {}", id);

        Ingrediente ingrediente = ingredienteRepository.findById(id).orElse(null);
        if (ingrediente == null) {
            log.info("End method - deleteIngrediente - ingrediente wiht id: {} not found", id);
            return false;
        }

        ingredienteRepository.deleteById(id);
        log.info("End method - deleteIngrediente - id: {}", id);
        return true;
    }

    public void updateIngrediente(Integer id, IngredienteDto ingredienteToUpdate) throws IngredienteNotFoundException {
        log.info("Start method - updateIngrediente - id: {}, ingredienteToUpdate: {}", id, ingredienteToUpdate);

        Ingrediente ingredienteOpt = ingredienteRepository.findById(id).orElse(null);
        if(ingredienteOpt == null)
            throw new IngredienteNotFoundException("Ingrediente not found");

        ingredienteOpt.setNome(ingredienteToUpdate.getNome());
        ingredienteOpt.setDescrizione(ingredienteToUpdate.getDescrizione());
        ingredienteOpt.setFoto(ingredienteToUpdate.getFoto());
        ingredienteRepository.save(ingredienteOpt);

        log.info("End method - updateIngrediente - id: {}, ingredienteToUpdate: {}", id, ingredienteToUpdate);
    }

    public List<Ingrediente> getIngredienti() {
        return ingredienteRepository.findAll();
    }
}
