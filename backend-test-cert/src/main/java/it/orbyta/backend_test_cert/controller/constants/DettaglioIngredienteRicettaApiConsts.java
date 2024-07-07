package it.orbyta.backend_test_cert.controller.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DettaglioIngredienteRicettaApiConsts {
    public static final String BASE_URL = "/api/dettaglioIngredienteRicetta";
    public static final String ADD_INGREDIENTE_TO_RICETTA = "/add";
    public static final String REMOVE_INGREDIENTE_FROM_RICETTA = "/remove/{idRicetta}/{idIngrediente}";
    public static final String GET_ALL_INGREDIENTI_OF_RICETTA = "/ingredienti/{idRicetta}";
    public static final String MODIFY_INGREDIENTI_OF_RICETTA = "/modify/{idRicetta}";
}
