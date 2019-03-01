package pl.yahoo.pawelpiedel.beaconbackend.domain.place;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import pl.yahoo.pawelpiedel.beaconbackend.domain.beacon.Beacon;
import pl.yahoo.pawelpiedel.beaconbackend.domain.beacon.BeaconRepository;
import pl.yahoo.pawelpiedel.beaconbackend.presentation.dto.PlaceDto;
import pl.yahoo.pawelpiedel.beaconbackend.presentation.transformer.PlaceDtoTransformer;

import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

class PlaceFinderTest {
    private static final String MAC_ADDRESS = "testMacAdress";

    @Mock
    private BeaconRepository beaconRepository;
    @Mock
    private PlaceDtoTransformer transformer;
    @Mock
    private Beacon beacon;
    @Mock
    private Place place;
    @Mock
    private PlaceDto placeDto;

    private PlaceFinder placeFinder;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        placeFinder = new PlaceFinder(beaconRepository, transformer);
    }

    @Test
    void shouldReturnPlaceByMacAddress() {
        when(beaconRepository.findById(MAC_ADDRESS)).thenReturn(Optional.of(beacon));
        when(beacon.getPlace()).thenReturn(place);
        when(transformer.transform(place)).thenReturn(placeDto);

        ResponseEntity<PlaceDto> placeDtoResponseEntity = placeFinder.findPlaceByLinkedBeaconMacAddress(MAC_ADDRESS);

        assertThat(placeDtoResponseEntity.getStatusCode()).isEqualTo(OK);
        assertThat(placeDtoResponseEntity.getBody()).isEqualTo(placeDto);
    }

    @Test
    void shouldReturnEmptyOptionalWhenNoBeaconFoundForProvidedMacAddress() {
        when(beaconRepository.findById(MAC_ADDRESS)).thenReturn(Optional.empty());

        ResponseEntity<PlaceDto> placeDtoResponseEntity = placeFinder.findPlaceByLinkedBeaconMacAddress(MAC_ADDRESS);

        assertThat(placeDtoResponseEntity.getStatusCode()).isEqualTo(NO_CONTENT);
        assertThat(placeDtoResponseEntity.getBody()).isNull();
    }
}