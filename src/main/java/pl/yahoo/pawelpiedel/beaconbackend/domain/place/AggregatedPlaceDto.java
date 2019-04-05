package pl.yahoo.pawelpiedel.beaconbackend.domain.place;

import lombok.AllArgsConstructor;
import lombok.Value;
import pl.yahoo.pawelpiedel.beaconbackend.domain.beacon.BeaconDto;
import pl.yahoo.pawelpiedel.beaconbackend.presentation.dto.PlaceDto;

@Value
@AllArgsConstructor
public class AggregatedPlaceDto {
    private final PlaceDto place;
    private final BeaconDto beacon;
}
