package pl.yahoo.pawelpiedel.beaconbackend.place;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;
import pl.yahoo.pawelpiedel.beaconbackend.beacon.Beacon;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Wither
public class Place {
    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private PlaceType placeType;

    @OneToMany(mappedBy = "place")
    private List<Beacon> beacons;

    private String name;
    private String description;

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", placeType=" + placeType +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
