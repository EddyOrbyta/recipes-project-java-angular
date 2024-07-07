package it.orbyta.backend_test_cert.repository;

import it.orbyta.backend_test_cert.entity.Comment;
import it.orbyta.backend_test_cert.entity.Ricetta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByRicetta(Ricetta ricetta);
}
