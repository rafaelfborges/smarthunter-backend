package com.smarthunter.api.entities;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lessons")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Lesson implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Lesson Id", example = "1", dataType = "integer")
    private Long id;

    @NotBlank
    @ApiModelProperty(value = "Lesson Name", required = true, example = "Basic concepts", position = 1)
    private String name;

    @NotBlank
    @ApiModelProperty(value = "Lesson Description", required = true, example = "XYZ", position = 2)
    private String description;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "lesson_activities",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id")
    )
    @ApiModelProperty(value = "Lesson Activities", required = true, dataType = "List", position = 3)
    private List<Activity> activities = new ArrayList<>();
}
