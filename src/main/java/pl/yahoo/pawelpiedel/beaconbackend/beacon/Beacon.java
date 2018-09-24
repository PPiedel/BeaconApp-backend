package pl.yahoo.pawelpiedel.beaconbackend.beacon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;
import pl.yahoo.pawelpiedel.beaconbackend.place.Place;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Wither
public class Beacon {
    @Id
    private String macAdress;
    @ManyToOne
    private Place place;
    private String name;
}
