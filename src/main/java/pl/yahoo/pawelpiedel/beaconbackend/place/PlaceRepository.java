package pl.yahoo.pawelpiedel.beaconbackend.place;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.yahoo.pawelpiedel.beaconbackend.beacon.Beacon;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    Place findByBeacons(Beacon beacon);
}
