package it.orbyta.backend_test_cert.controller.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CommentApiConsts {
    public static final String BASE_PATH = "/api/comments";
    public static final String GET_BY_RICETTA = "/ricetta/{idRicetta}";
    public static final String ADD = "/add";
    public static final String MODIFY = "/modify/{idComment}";
    public static final String DELETE = "/delete/{idComment}";

}
