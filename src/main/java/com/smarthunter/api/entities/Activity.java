package com.smarthunter.api.entities;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "activities")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Activity {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @ApiModelProperty(required = true,example = "Activity title",dataType = "string")
    private String title;

    @NotBlank
    @ApiModelProperty(required = true,example = "http:video/activity")
    private String urlVideo;
}
