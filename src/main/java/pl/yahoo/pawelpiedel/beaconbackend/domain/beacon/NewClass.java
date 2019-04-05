package pl.yahoo.pawelpiedel.beaconbackend.domain.beacon;

import lombok.RequiredArgsConstructor;
import pl.yahoo.pawelpiedel.beaconbackend.presentation.transformer.PlaceDtoTransformer;

@RequiredArgsConstructor
public class NewClass {
    final PlaceDtoTransformer placeDtoTransformer;


    public BeaconDto transform(Beacon beacon) {
        BeaconDto beaconDto = new BeaconDto();
        beaconDto.setName(beacon.getName());
        beaconDto.setMacAddress(beacon.getMacAddress());
        beaconDto.setCalibratedStrength(beacon.getCalibratedStrength());
        beaconDto.setEnvironmentalConstant(beacon.getEnvironmentalConstant());
        beaconDto.setPlace(placeDtoTransformer.transform(beacon.getPlace()));
        return beaconDto;
    }
}