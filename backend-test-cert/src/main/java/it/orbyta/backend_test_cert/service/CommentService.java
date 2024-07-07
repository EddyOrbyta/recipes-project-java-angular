package it.orbyta.backend_test_cert.service;

import it.orbyta.backend_test_cert.dto.request.CommentRequest;
import it.orbyta.backend_test_cert.entity.Comment;
import it.orbyta.backend_test_cert.entity.Ricetta;
import it.orbyta.backend_test_cert.repository.CommentRepository;
import it.orbyta.backend_test_cert.repository.RicettaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CommentService {

    private final CommentRepository commentRepository;
    private final RicettaRepository ricettaRepository;
    public void addComment(CommentRequest commentRequest, String userUid) {
        log.info("Adding comment of user {} with content for ricetta {}", userUid, commentRequest.getIdRicetta());
        Ricetta ricetta = ricettaRepository.findById(commentRequest.getIdRicetta()).orElseThrow(() -> new RuntimeException("Ricetta not found")); // TODO remove with appropriate exception

        commentRepository.save(populateComment(commentRequest, userUid, ricetta));
        log.info("Comment saved for ricetta {} created by user {}", commentRequest.getIdRicetta(), userUid);
    }

    private Comment populateComment(CommentRequest commentRequest, String userUid, Ricetta ricetta) {
        return Comment.builder()
                .content(commentRequest.getContent())
                .ricetta(ricetta)
                .userUid(userUid)
                .build();
    }

    public void getCommentsByRicetta(int idRicetta) {
        log.info("Getting comments for ricetta {}", idRicetta);

        Ricetta ricetta = ricettaRepository.findById(idRicetta).orElseThrow(() -> new RuntimeException("Ricetta not found"));
        List<Comment> comments = commentRepository.findAllByRicetta(ricetta);

        log.info("Got {} comments for ricetta {}", comments.size(), idRicetta);
    }

    public void modifyComment(int idComment, CommentRequest commentRequest) {
        log.info("Modifying comment with id {}", idComment);

        Comment comment = commentRepository.findById(idComment).orElseThrow(() -> new RuntimeException("Comment not found"));

        comment.setContent(commentRequest.getContent());
        commentRepository.save(comment);

        log.info("Comment with id {} modified", idComment);
    }

    public void deleteComment(int idComment) {
        log.info("Deleting comment with id {}", idComment);

        commentRepository.deleteById(idComment);

        log.info("Comment with id {} deleted", idComment);
    }
}
