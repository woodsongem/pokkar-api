package org.cana.resources.roundpoint.models;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class RoundPointModel {
    @NotBlank(message = "Pokkar.Api.{0}.{1}.GamePoint.IsNull")
    @NotEmpty(message = "Pokkar.Api.{0}.{1}.GamePoint.IsEmpty")
    private String point;
}
