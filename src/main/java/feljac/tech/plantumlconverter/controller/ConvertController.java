package feljac.tech.plantumlconverter.controller;

import feljac.tech.plantumlconverter.service.ConvertService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class ConvertController {

   private final ConvertService convertService;

    public ConvertController(ConvertService convertService) {
        this.convertService = convertService;
    }

    @PostMapping("/yaml/text")
    public ResponseEntity<String> yamlToUML(@RequestBody String text) {
        return new ResponseEntity<>(convertService.convertFromText(text), HttpStatus.OK);
    }
}
