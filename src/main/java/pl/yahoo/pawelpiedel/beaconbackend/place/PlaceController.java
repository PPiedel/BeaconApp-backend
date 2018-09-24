package pl.yahoo.pawelpiedel.beaconbackend.place;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.yahoo.pawelpiedel.beaconbackend.beacon.Beacon;
import pl.yahoo.pawelpiedel.beaconbackend.beacon.BeaconRepository;

import java.util.Optional;

@RestController("/places")
@Slf4j
@AllArgsConstructor
public class PlaceController {

    private final BeaconRepository beaconRepository;
    private final PlaceDtoTransformer transformer;

    @GetMapping
    public ResponseEntity<PlaceDto> placeByBeaconMacAddress(@RequestParam(name = "mac") String macAddress) {
        log.info("Mac address get : {}", macAddress);

        Optional<Beacon> beaconOptional = beaconRepository.findById(macAddress);

        if (beaconOptional.isPresent()) {
            Beacon beacon = beaconOptional.get();

            log.info("Found beacon {} ", beacon);

            return beacon.getPlace() != null ? new ResponseEntity<>(transformer.transform(beacon.getPlace()), HttpStatus.OK) : null;

        } else {
            log.info("Beacon not found!");

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
}
