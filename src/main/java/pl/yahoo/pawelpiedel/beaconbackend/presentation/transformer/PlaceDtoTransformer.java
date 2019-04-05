package pl.yahoo.pawelpiedel.beaconbackend.presentation.transformer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.yahoo.pawelpiedel.beaconbackend.domain.beacon.Beacon;
import pl.yahoo.pawelpiedel.beaconbackend.domain.place.Place;
import pl.yahoo.pawelpiedel.beaconbackend.presentation.dto.PlaceDto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class PlaceDtoTransformer {

    public PlaceDto transform(Place place) {
        return new PlaceDto()
                .withName(place.getName())
                .withDescription(place.getDescription())
                .withPlaceType(place.getPlaceType().toString());
    }
}
