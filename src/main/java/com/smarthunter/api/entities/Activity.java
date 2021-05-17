package com.smarthunter.api.entities;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "activities")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Activity implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Activity Id", example = "1", dataType = "integer")
    private Long id;

    @NotBlank
    @ApiModelProperty(
            required = true, value = "Activity Title", example = "Java History", dataType = "integer", position = 1
    )
    private String title;

    @NotBlank
    @ApiModelProperty(
            required = true, value = "Activity Video URL", example = "https://vimeo.com/23901832", position = 2
    )
    private String urlVideo;
}
