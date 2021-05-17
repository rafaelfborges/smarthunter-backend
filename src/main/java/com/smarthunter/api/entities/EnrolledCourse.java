package com.smarthunter.api.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.smarthunter.api.contracts.requests.EnrolledCourseRequest;
import com.smarthunter.api.contracts.responses.EnrolledCourseResponse;
import com.smarthunter.api.utils.Convertible;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "enrolled_courses", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"course_id", "user_id"})
})
public class EnrolledCourse implements Serializable, Convertible<EnrolledCourseResponse> {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Course course;

    @ManyToOne
    private User user;

    @CreationTimestamp
    @Column(name = "register_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate registerDate;

    public EnrolledCourse(EnrolledCourseRequest request) {
        this.course = Course.builder()
                .id(request.getCourse().getId())
                .build();

        this.user = User.builder()
                .id(request.getUser().getId())
                .build();
    }

    @Override
    public EnrolledCourseResponse convert() {
        return new EnrolledCourseResponse(this);
    }
}
