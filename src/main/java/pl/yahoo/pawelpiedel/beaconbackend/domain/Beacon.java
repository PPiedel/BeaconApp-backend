package pl.yahoo.pawelpiedel.beaconbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Beacon {
    @Id
    private String macAdress;
    @ManyToOne
    private Place place;
    private String name;
}
