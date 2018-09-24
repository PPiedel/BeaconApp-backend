package pl.yahoo.pawelpiedel.beaconbackend.beacon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeaconRepository extends JpaRepository<Beacon, String> {
}
