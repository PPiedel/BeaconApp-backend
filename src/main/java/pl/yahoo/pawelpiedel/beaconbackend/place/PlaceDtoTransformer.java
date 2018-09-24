package pl.yahoo.pawelpiedel.beaconbackend.place;

import org.springframework.stereotype.Service;

@Service
public class PlaceDtoTransformer {

    public PlaceDto transform(Place place) {
        return new PlaceDto()
                .withName(place.getName())
                .withDescription(place.getDescription())
                .withPlaceType(place.getPlaceType().toString());
    }
}
