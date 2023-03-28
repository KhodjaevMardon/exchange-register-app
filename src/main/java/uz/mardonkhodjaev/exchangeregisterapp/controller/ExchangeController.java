package uz.mardonkhodjaev.exchangeregisterapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.mardonkhodjaev.exchangeregisterapp.exception.ExchangeNotFoundException;
import uz.mardonkhodjaev.exchangeregisterapp.model.Exchange;
import uz.mardonkhodjaev.exchangeregisterapp.service.ExchangeService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/exchange")
public class ExchangeController {
    private final ExchangeService exchangeService;

    @Autowired
    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exchange> getExchange(@PathVariable UUID id) {
        try {
            Exchange result = exchangeService.findById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (ExchangeNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> createExchange(@RequestBody Exchange exchange) {
        Exchange result = exchangeService.create(exchange);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteExchange(@PathVariable UUID id) {
        exchangeService.delete(id);
    }

    @GetMapping("/")
    public ResponseEntity<List<Exchange>> getAllExchanges() {
        List<Exchange> result = exchangeService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
