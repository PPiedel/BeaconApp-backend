package pl.yahoo.pawelpiedel.beaconbackend.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

@Wither
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlaceDto {
    private String placeType;
    private String name;
    private String description;
}
