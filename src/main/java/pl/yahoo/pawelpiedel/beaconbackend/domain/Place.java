package pl.yahoo.pawelpiedel.beaconbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Place {
    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    private PlaceType placeType;
    @OneToMany
    private List<Beacon> beacons;
    private String name;
    private String description;
}
