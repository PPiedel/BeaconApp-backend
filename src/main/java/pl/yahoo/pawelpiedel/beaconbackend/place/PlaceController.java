package pl.yahoo.pawelpiedel.beaconbackend.place;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("/places")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceFinder placeFinder;

    @GetMapping
    public ResponseEntity<PlaceDto> placeByBeaconMacAddress(@RequestParam(name = "mac") String macAddress) {
        log.info("Mac address received : {}", macAddress);

        return placeFinder.findPlaceByLinkedBeaconMacAddress(macAddress);
    }
}
