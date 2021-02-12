package org.cana.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class BaseDto {
    private String createdBy;
    private Date createdOn;
    private String modifiedBy;
    private Date modifiedOn;
}
