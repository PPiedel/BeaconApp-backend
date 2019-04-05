package pl.yahoo.pawelpiedel.beaconbackend.domain.beacon;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BeaconFinder {
    private final BeaconDtoTransformer beaconDtoTransformer;
    private final BeaconRepository beaconRepository;

    public ResponseEntity<BeaconDto> fingBeaconByMacAddress(String macAddress) {
        Optional<Beacon> beaconOptiona = beaconRepository.findById(macAddress);
        return new ResponseEntity<>(beaconDtoTransformer.transform(beaconOptiona.get()), HttpStatus.OK);
    }
}
