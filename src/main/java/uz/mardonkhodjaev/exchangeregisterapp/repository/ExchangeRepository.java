package uz.mardonkhodjaev.exchangeregisterapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.mardonkhodjaev.exchangeregisterapp.model.Exchange;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, UUID> {
    List<Exchange> findAllByPersonA(UUID id);

    List<Exchange> findAllByPersonB(UUID id);
}
