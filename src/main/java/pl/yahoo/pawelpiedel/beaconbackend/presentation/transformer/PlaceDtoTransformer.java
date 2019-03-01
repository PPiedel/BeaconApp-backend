package pl.yahoo.pawelpiedel.beaconbackend.presentation.transformer;

import org.springframework.stereotype.Service;
import pl.yahoo.pawelpiedel.beaconbackend.domain.place.Place;
import pl.yahoo.pawelpiedel.beaconbackend.presentation.dto.PlaceDto;

@Service
public class PlaceDtoTransformer {

    public PlaceDto transform(Place place) {
        return new PlaceDto()
                .withName(place.getName())
                .withDescription(place.getDescription())
                .withPlaceType(place.getPlaceType().toString());
    }
}
