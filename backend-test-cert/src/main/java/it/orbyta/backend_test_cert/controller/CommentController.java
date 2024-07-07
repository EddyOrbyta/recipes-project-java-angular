package it.orbyta.backend_test_cert.controller;

import it.orbyta.backend_test_cert.controller.constants.CommentApiConsts;
import it.orbyta.backend_test_cert.dto.request.CommentRequest;
import it.orbyta.backend_test_cert.service.CommentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping(CommentApiConsts.BASE_PATH)
public class CommentController {

    private final CommentService commentService;

    @PostMapping(CommentApiConsts.ADD)
    public ResponseEntity<String> addComment(@RequestBody CommentRequest commentRequest, String userUid) {
        commentService.addComment(commentRequest, userUid);
        return ResponseEntity.ok("comment added");
    }
    @GetMapping(CommentApiConsts.GET_BY_RICETTA)
    public ResponseEntity<String> getCommentsByRicetta(@PathVariable("idRicetta") int idRicetta) {
        commentService.getCommentsByRicetta(idRicetta);
        return null;
    }

    @PutMapping(CommentApiConsts.MODIFY)
    public ResponseEntity<String> modifyComment(@PathVariable("idComment") int idComment, @RequestBody CommentRequest commentRequest) {
        commentService.modifyComment(idComment, commentRequest);
        return null;
    }

    @DeleteMapping(CommentApiConsts.DELETE)
    public ResponseEntity<String> deleteComment(@PathVariable("idComment") int idComment) {
        commentService.deleteComment(idComment);
        return null;
    }

}

