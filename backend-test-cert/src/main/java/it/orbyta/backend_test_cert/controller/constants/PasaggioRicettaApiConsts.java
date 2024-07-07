package it.orbyta.backend_test_cert.controller.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PasaggioRicettaApiConsts {
    public static final String BASE_PATH = "/add";

    public static final String ADD = "/add";
    public static final String MODIFY = "/{id}/modify";
    public static final String DELETE = "/{id}/delete";
    public static final String GET_BY_RICETTA = "/ricetta/{idRicetta}";
}
