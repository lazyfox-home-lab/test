package ru.lazyfox.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lazyfox.dto.AsciiArtDto;

@RestController
@RequestMapping("/test")
@Slf4j
@RequiredArgsConstructor
public class TestController {

    private final AsciiArtDto asciiArtDto;

    @GetMapping("/hello")
    public ResponseEntity<String> test() {
        String asciiArt = asciiArtDto.getStringList().get((int) (Math.random() * 17));
        String html = "<html><head><meta charset='UTF-8'></head><body><pre style='font-size:16px;'>" + asciiArt + "</pre></body></html>";
        return ResponseEntity.ok()
                .header("Content-Type", "text/html; charset=UTF-8")
                .body(html);
    }

}