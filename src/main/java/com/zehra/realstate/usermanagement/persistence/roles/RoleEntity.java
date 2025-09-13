package com.zehra.realstate.usermanagement.persistence.roles;

import jakarta.persistence.*;
import lombok.Builder;

@Builder
@Entity(name = "zehrars_role")
public class RoleEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    private String active;
}
