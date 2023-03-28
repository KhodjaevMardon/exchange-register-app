package uz.mardonkhodjaev.exchangeregisterapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.mardonkhodjaev.exchangeregisterapp.exception.ExchangeNotFoundException;
import uz.mardonkhodjaev.exchangeregisterapp.model.Exchange;
import uz.mardonkhodjaev.exchangeregisterapp.repository.ExchangeRepository;
import uz.mardonkhodjaev.exchangeregisterapp.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ExchangeService {
    private final ExchangeRepository exchangeRepository;

    @Autowired
    public ExchangeService(ExchangeRepository exchangeRepository) {
        this.exchangeRepository = exchangeRepository;
    }

    public Exchange create(Exchange exchange) {
        if (exchange.getId() == null) {
            exchange.setId(UUID.randomUUID());
        }
        return this.exchangeRepository.save(exchange);
    }

    public Exchange findById(UUID id) throws ExchangeNotFoundException {
        Optional<Exchange> result = exchangeRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new ExchangeNotFoundException();
        }
    }

    public List<Exchange> findAll() {
        return exchangeRepository.findAll();
    }

    public List<Exchange> findAllOrderByDate() {
        return exchangeRepository.findAll();
    }

    public List<Exchange> findAllByPersonId(UUID id) {
        List<Exchange> result = exchangeRepository.findAllByPersonA(id);
        result.addAll(exchangeRepository.findAllByPersonB(id));

        return result;
    }

    public void delete(UUID id) {
        exchangeRepository.deleteById(id);
    }
}
