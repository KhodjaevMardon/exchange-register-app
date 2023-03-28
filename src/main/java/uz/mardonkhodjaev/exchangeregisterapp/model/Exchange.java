package uz.mardonkhodjaev.exchangeregisterapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Exchange {
    @Id
    @JsonProperty(value = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_a_id", referencedColumnName = "id")
    @JsonProperty(value = "personAId")
    private Person personA;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_b_id", referencedColumnName = "id")
    @JsonProperty(value = "personBId")
    private Person personB;

    @ElementCollection
    @JsonProperty(value = "personAGoods")
    private List<String> personAGoods;

    @ElementCollection
    @JsonProperty(value = "personBGoods")
    private List<String> personBGoods;

    @JsonProperty(value = "date")
    private Date date;
}
