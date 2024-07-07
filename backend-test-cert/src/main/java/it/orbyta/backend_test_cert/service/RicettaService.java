package it.orbyta.backend_test_cert.service;

import it.orbyta.backend_test_cert.dto.response.ListRicettaResponse;
import it.orbyta.backend_test_cert.dto.response.ListRicettaResponseWithScore;
import it.orbyta.backend_test_cert.dto.request.RicettaRequest;
import it.orbyta.backend_test_cert.dto.response.RicettaWithScoreResponse;
import it.orbyta.backend_test_cert.entity.Ricetta;
import it.orbyta.backend_test_cert.repository.RicettaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class RicettaService {
    private final RicettaRepository ricettaRepository;
    public void addRicetta(RicettaRequest ricettaReq, String userUid) {
        log.info("Start method - addRicetta - ricettaReq: {}", ricettaReq);

        ricettaRepository.save(buildRicetta(ricettaReq, userUid));

        log.info("End method - addRicetta - ricettaReq: {}", ricettaReq);

    }

    private Ricetta buildRicetta(RicettaRequest ricettaReq, String userUid) {
    return Ricetta.builder()
            .nome(ricettaReq.getNome())
            .descrizione(ricettaReq.getDescrizione())
            .foto(ricettaReq.getFoto())
            .video(ricettaReq.getVideo())
            .preparazione(ricettaReq.getPreparazione())
            .tempoPreparazione(ricettaReq.getTempoPreparazione())
            .numPersone(ricettaReq.getNumPersone())
            .difficolta(ricettaReq.getDifficolta())
            .categoria(ricettaReq.getCategoria())
            .tipo(ricettaReq.getTipo())
            .userUid(userUid)
            .build();
    }

    public ListRicettaResponse getListRicette(Pageable pageable, String userId, String ricettaFilter) {

        log.info("Start method - getListRicette - userId: {}, ricettaFilter: {}", userId, ricettaFilter);
        Page<Ricetta> ricettaList = ricettaRepository.findByUserUid(userId, pageable);
        ListRicettaResponse response = new ListRicettaResponse();

        response.setRicettaList(ricettaList.getContent());
        response.setCurrentPage(ricettaList.getNumber());
        response.setTotalElements(ricettaList.getNumberOfElements());

        response.setTotalPages(ricettaList.getTotalPages());

        log.info("End method - getListRicette - userId: {}, ricettaFilter: {}", userId, ricettaFilter);
        return response;
    }
    public ListRicettaResponseWithScore getListRicetteBestRating(Pageable pageable, String userId, String ricettaFilter) {
        log.info("Start method - getListRicetteBestRating - userId: {}, ricettaFilter: {}", userId, ricettaFilter);
        Page<Object> ricettaList = ricettaRepository.findRicetteWithHighAvgScoreByUser(userId, pageable);

        List<RicettaWithScoreResponse> responseContent = getRicettaWithScoreResponses(ricettaList);

        ListRicettaResponseWithScore response = new ListRicettaResponseWithScore();

        response.setRicettaList(responseContent);
        response.setCurrentPage(ricettaList.getNumber());
        response.setTotalElements(ricettaList.getNumberOfElements());

        response.setTotalPages(ricettaList.getTotalPages());

        log.info("End method - getListRicetteBestRating - userId: {}, ricettaFilter: {}", userId, ricettaFilter);
        return response;
    }

    private static List<RicettaWithScoreResponse> getRicettaWithScoreResponses(Page<Object> ricettaList) {
        List<RicettaWithScoreResponse> responseContent = new ArrayList<>();

        for (Object obj : ricettaList) {
            Object[] fields = (Object[]) obj;
            Ricetta ricetta = (Ricetta) fields[0];
            Double score = (Double) fields[1];

            RicettaWithScoreResponse ricettaWithScoreResponse = new RicettaWithScoreResponse();
            ricettaWithScoreResponse.setRicetta(ricetta);
            ricettaWithScoreResponse.setScore(score);

            responseContent.add(ricettaWithScoreResponse);
        }
        return responseContent;
    }

    public ListRicettaResponse getListRicetteMostEasy(Pageable pageable, String userId, String ricettaFilter) {
        log.info("Start method - getListRicetteBestRating - userId: {}, ricettaFilter: {}", userId, ricettaFilter);
        Page<Ricetta> ricettaList = ricettaRepository.findRicetteEasyByUser(userId, pageable);


        ListRicettaResponse response = new ListRicettaResponse();

        response.setRicettaList(ricettaList.getContent());
        response.setCurrentPage(ricettaList.getNumber());
        response.setTotalElements(ricettaList.getNumberOfElements());

        response.setTotalPages(ricettaList.getTotalPages());

        log.info("End method - getListRicetteBestRating - userId: {}, ricettaFilter: {}", userId, ricettaFilter);
        return response;
    }
}
