package it.orbyta.backend_test_cert.controller.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class RicettaApiConsts {
    public static final String BASE_URL = "/api/ricetta";
    public static final String ADD_RICETTA = "/add";
    public static final String UPDATE_RICETTA = "/update/{id}";
    public static final String REMOVE_RICETTA = "/remove{id}";
    public static final String GET_ALL_RICETTE = "/all";
    public static final String GET_RICETTA_BY_ID = "/get/{id}";
    public static final String GET_RICETTE_5_STAR = "/5star";
    public static final String GET_RICETTE_EASY = "/easy";
}
