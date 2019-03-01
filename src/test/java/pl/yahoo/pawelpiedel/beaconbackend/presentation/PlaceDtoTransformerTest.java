package pl.yahoo.pawelpiedel.beaconbackend.presentation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.yahoo.pawelpiedel.beaconbackend.domain.place.Place;
import pl.yahoo.pawelpiedel.beaconbackend.presentation.dto.PlaceDto;
import pl.yahoo.pawelpiedel.beaconbackend.domain.place.PlaceType;
import pl.yahoo.pawelpiedel.beaconbackend.presentation.transformer.PlaceDtoTransformer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class PlaceDtoTransformerTest {
    private static final String DESCRIPTION = "Description";
    private static final String NAME = "name";
    private static final PlaceType PLACE_TYPE = PlaceType.DANGER;

    @Mock
    private Place place;

    private PlaceDtoTransformer transformer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        transformer = new PlaceDtoTransformer();
    }

    @Test
    void shouldTransform() {
        when(place.getDescription()).thenReturn(DESCRIPTION);
        when(place.getName()).thenReturn(NAME);
        when(place.getPlaceType()).thenReturn(PLACE_TYPE);

        PlaceDto placeDto = transformer.transform(place);

        assertThat(placeDto.getDescription()).isEqualTo(DESCRIPTION);
        assertThat(placeDto.getName()).isEqualTo(NAME);
        assertThat(placeDto.getPlaceType()).isEqualTo(PLACE_TYPE.toString());
    }

}