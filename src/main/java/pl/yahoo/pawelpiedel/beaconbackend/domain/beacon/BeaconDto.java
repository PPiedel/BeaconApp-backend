package pl.yahoo.pawelpiedel.beaconbackend.domain.beacon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;
import pl.yahoo.pawelpiedel.beaconbackend.presentation.dto.PlaceDto;

import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Wither
@Data
public class BeaconDto {
    private PlaceDto place;
    private String macAddress;
    private String name;
    private Double calibratedStrength;
    private Double environmentalConstant;
}
