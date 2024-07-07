package it.orbyta.backend_test_cert.controller.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class RatingApiConsts {

    public static final String BASE_PATH = "/api/ratings";

    public static final String GET_BY_RICETTA = "/ricetta/{idRicetta}";
    public static final String GET_BY_USER = "/user";

    public static final String ADD = "/add/{idRicetta}";

    public static final String MODIFY = "/modify/{idRating}";

    public static final String DELETE = "/delete/{idRating}";

}
