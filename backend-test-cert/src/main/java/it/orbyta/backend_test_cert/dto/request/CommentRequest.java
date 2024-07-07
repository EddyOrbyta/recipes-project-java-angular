package it.orbyta.backend_test_cert.dto.request;

import lombok.Data;

@Data
public class CommentRequest {
    private int idRicetta;
    private String content;

}
