package pl.yahoo.pawelpiedel.beaconbackend.domain.beacon;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BeaconController {

    private final BeaconFinder beaconFinder;

    @GetMapping("/beacons")
    public ResponseEntity<BeaconDto> getBeacon(@RequestParam(name = "mac") String macAddress) {
        log.info("Received mac address : {}", macAddress);
        return beaconFinder.fingBeaconByMacAddress(macAddress);
    }


}
