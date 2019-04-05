package pl.yahoo.pawelpiedel.beaconbackend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import pl.yahoo.pawelpiedel.beaconbackend.domain.beacon.Beacon;
import pl.yahoo.pawelpiedel.beaconbackend.domain.beacon.BeaconDto;
import pl.yahoo.pawelpiedel.beaconbackend.domain.beacon.BeaconRepository;
import pl.yahoo.pawelpiedel.beaconbackend.domain.place.Place;
import pl.yahoo.pawelpiedel.beaconbackend.domain.place.PlaceRepository;
import pl.yahoo.pawelpiedel.beaconbackend.domain.place.PlaceType;
import pl.yahoo.pawelpiedel.beaconbackend.presentation.dto.PlaceDto;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class BeaconIntegrationTest {
    private static final Long PLACE_ID = 1L;
    private static final String PLACE_NAME = "name";
    private static final String DESCRIPTION = "placeDescription";
    private static final PlaceType PLACE_TYPE = PlaceType.DANGER;
    private static final String BEACON_NAME = "beaconName";
    private static final String MAC_ADDRESS = "53-DD-55-EF-HH";
    private static final String LOCALHOST = "http://localhost:";
    private static final String MAC = "mac";
    private static final double CALIBRATED_STRENGTH = 52d;
    private static final double ENVIRONMENTAL_CONSTANT = 1.7;
    private static final String DANGER = "DANGER";

    @LocalServerPort
    private int port;

    @Autowired
    PlaceRepository placeRepository;

    @Autowired
    BeaconRepository beaconRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldReturnBeaoonByMacAddress() {
        Place place = bootstrapPlace();
        bootstrapBeacon(place);

        String uri = LOCALHOST + port + "/beacons?" + MAC + "=" + MAC_ADDRESS;
        BeaconDto beaconDto = restTemplate.getForObject(uri, BeaconDto.class);

        assertThat(beaconDto.getEnvironmentalConstant()).isEqualTo(ENVIRONMENTAL_CONSTANT);
        assertThat(beaconDto.getCalibratedStrength()).isEqualTo(CALIBRATED_STRENGTH);
        assertThat(beaconDto.getName()).isEqualTo(BEACON_NAME);
        assertThat(beaconDto.getPlace()).isEqualTo(new PlaceDto()
                .withName(PLACE_NAME)
                .withDescription(DESCRIPTION)
                .withPlaceType(DANGER));
    }

    private void bootstrapBeacon(Place entity) {
        Beacon beacon = new Beacon()
                .withCalibratedStrength(CALIBRATED_STRENGTH)
                .withEnvironmentalConstant(ENVIRONMENTAL_CONSTANT)
                .withMacAddress(MAC_ADDRESS)
                .withName(BEACON_NAME)
                .withPlace(entity);
        beaconRepository.save(beacon);
    }

    private Place bootstrapPlace() {
        Place entity = new Place()
                .withDescription(DESCRIPTION)
                .withId(PLACE_ID)
                .withName(PLACE_NAME)
                .withPlaceType(PLACE_TYPE);
        placeRepository.save(entity);
        return entity;
    }
}