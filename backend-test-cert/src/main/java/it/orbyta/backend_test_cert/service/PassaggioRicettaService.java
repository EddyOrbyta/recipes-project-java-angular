package it.orbyta.backend_test_cert.service;

import it.orbyta.backend_test_cert.dto.request.PassaggioRicettaForRicettaRequest;
import it.orbyta.backend_test_cert.dto.response.PassaggioRicettaListResponse;
import it.orbyta.backend_test_cert.entity.PassaggioRicetta;
import it.orbyta.backend_test_cert.entity.Ricetta;
import it.orbyta.backend_test_cert.exceptions.PassaggioForRicettaAlreadyExistsException;
import it.orbyta.backend_test_cert.exceptions.RicettaNotFoundException;
import it.orbyta.backend_test_cert.repository.PassaggioRicettaRepository;
import it.orbyta.backend_test_cert.repository.RicettaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@AllArgsConstructor
@Slf4j
public class PassaggioRicettaService {

    private final PassaggioRicettaRepository passaggioRicettaRepository;
    private final RicettaRepository ricettaRepository;

    public PassaggioRicettaListResponse getListByRicetta (int idRicetta) throws RicettaNotFoundException {
        log.info("findByRicetta: ricetta: {}", idRicetta);

        List<PassaggioRicetta> passaggi = findPassaggiByIdRicetta(idRicetta);

        PassaggioRicettaListResponse response = new PassaggioRicettaListResponse();
        response.setPassaggi(passaggi);

        return response;
    }
    private List<PassaggioRicetta> findPassaggiByIdRicetta(int idRicetta) throws RicettaNotFoundException {
        Ricetta ricetta = ricettaRepository.findById(idRicetta).orElseThrow(() -> new RicettaNotFoundException("Ricetta not found: " + idRicetta));
        List<PassaggioRicetta> passaggi = passaggioRicettaRepository.findByRicetta(ricetta);
        return passaggi;
    }
    @Transactional
    public void addComment(PassaggioRicettaForRicettaRequest request) throws RicettaNotFoundException, PassaggioForRicettaAlreadyExistsException {
        List<PassaggioRicetta> list = findPassaggiByIdRicetta(request.getIdRicetta());

        boolean alreadyExists = list.stream().anyMatch(passaggioRicetta -> passaggioRicetta.getNumPassaggio() == request.getNumPassaggio());

        if (alreadyExists) {
            throw new PassaggioForRicettaAlreadyExistsException("Passaggio already exists");
        }

        PassaggioRicetta passaggioRicetta = createPassaggioRicetta(request);
        
        passaggioRicettaRepository.save(passaggioRicetta);
    }
    @Transactional

    private PassaggioRicetta createPassaggioRicetta(PassaggioRicettaForRicettaRequest request) {

        Ricetta ricetta = ricettaRepository.findById(request.getIdRicetta()).orElseThrow(() -> new RuntimeException("Ricetta not found: " + request.getIdRicetta()));

        PassaggioRicetta passaggioRicetta = new PassaggioRicetta();
        passaggioRicetta.setNumPassaggio(request.getNumPassaggio());
        passaggioRicetta.setRicetta(ricetta);
        passaggioRicetta.setTipoPassaggio(request.getTipoPassaggio());
        passaggioRicetta.setDescrizione(request.getDescrizione());
        return passaggioRicetta;
    }
}
