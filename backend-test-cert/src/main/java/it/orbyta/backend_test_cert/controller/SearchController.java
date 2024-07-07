package it.orbyta.backend_test_cert.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("api/search")
public class SearchController {
    @GetMapping("try")
    public void search(@RequestParam String text) {
        log.info("Search called with text: " + text);
    }
}
