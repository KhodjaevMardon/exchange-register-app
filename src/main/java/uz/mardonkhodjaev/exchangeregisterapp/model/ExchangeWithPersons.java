package uz.mardonkhodjaev.exchangeregisterapp.model;

import lombok.Data;

@Data
public class ExchangeWithPersons {
    private Exchange exchange;

    public ExchangeWithPersons(Exchange exchange, Person personA, Person personB) {
        this.exchange = exchange;
        this.personA = personA;
        this.personB = personB;
    }

    private Person personA;
    private Person personB;
}
