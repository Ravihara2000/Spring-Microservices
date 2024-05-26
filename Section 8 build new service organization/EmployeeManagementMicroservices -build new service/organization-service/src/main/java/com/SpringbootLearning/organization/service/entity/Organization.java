package com.SpringbootLearning.organization.service.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String organizationName;
    private String organizationDescription;
    @Column(nullable = false,unique = true)
    private String organizationCode;

    @CreationTimestamp
    private LocalDateTime createdDate;

}
