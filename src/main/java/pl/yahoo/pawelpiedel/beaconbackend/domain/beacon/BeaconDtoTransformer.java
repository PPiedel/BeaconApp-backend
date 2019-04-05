package pl.yahoo.pawelpiedel.beaconbackend.domain.beacon;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.yahoo.pawelpiedel.beaconbackend.presentation.transformer.PlaceDtoTransformer;

@Service
@RequiredArgsConstructor
public class BeaconDtoTransformer {

    private final PlaceDtoTransformer placeDtoTransformer;

    public BeaconDto transform(Beacon beacon) {
        return new BeaconDto()
                .withCalibratedStrength(beacon.getCalibratedStrength())
                .withEnvironmentalConstant(beacon.getEnvironmentalConstant())
                .withMacAddress(beacon.getMacAddress())
                .withName(beacon.getName())
                .withPlace(placeDtoTransformer.transform(beacon.getPlace()));
    }
}
