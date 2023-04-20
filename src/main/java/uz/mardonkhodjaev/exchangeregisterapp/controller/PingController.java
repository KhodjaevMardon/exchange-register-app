package uz.mardonkhodjaev.exchangeregisterapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ping")
public class PingController {

    @Autowired
    public PingController() {
    }

    @PostMapping("/")
    public ResponseEntity<String> createPerson() {
        return new ResponseEntity<>("Hey yo ma nigga", HttpStatus.OK);
    }
}
