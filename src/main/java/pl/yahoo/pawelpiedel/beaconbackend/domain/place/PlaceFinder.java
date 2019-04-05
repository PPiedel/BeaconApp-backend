package pl.yahoo.pawelpiedel.beaconbackend.domain.place;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.yahoo.pawelpiedel.beaconbackend.domain.beacon.Beacon;
import pl.yahoo.pawelpiedel.beaconbackend.domain.beacon.BeaconRepository;
import pl.yahoo.pawelpiedel.beaconbackend.presentation.dto.PlaceDto;
import pl.yahoo.pawelpiedel.beaconbackend.presentation.transformer.PlaceDtoTransformer;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlaceFinder {
    private final BeaconRepository beaconRepository;
    private final PlaceDtoTransformer transformer;

    public ResponseEntity<PlaceDto> findPlaceByLinkedBeaconMacAddress(String macAddress) {
        Optional<Beacon> beaconOptional = beaconRepository.findById(macAddress);

        if (beaconOptional.isPresent()) {
            Beacon beacon = beaconOptional.get();

            log.info("Found beacon {} ", beacon);

            return new ResponseEntity<>(transformer.transform(beacon.getPlace()), HttpStatus.OK);
        } else {
                   log.info("Beacon not found!");

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
