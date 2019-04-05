package pl.yahoo.pawelpiedel.beaconbackend.presentation.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.constraintvalidators.bv.number.bound.decimal.DecimalMinValidatorForNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.yahoo.pawelpiedel.beaconbackend.domain.place.PlaceFinder;
import pl.yahoo.pawelpiedel.beaconbackend.presentation.dto.PlaceDto;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceFinder placeFinder;

    @GetMapping("/places")
    public ResponseEntity<PlaceDto> findByMac(@RequestParam(name = "mac") String macAddress) {
        log.info("Mac address received : {}", macAddress);
        return placeFinder.findPlaceByLinkedBeaconMacAddress(macAddress);
    }
}
