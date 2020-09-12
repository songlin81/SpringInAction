package com.example.demo.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class SysRole {
    @Id@GeneratedValue
    private Integer id;

    @Column(unique=true)
    private String role;

    private String description;
    private Boolean available = Boolean.FALSE;

    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name="SysRolePermission",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="permissionId")})
    private List<SysPermission> permissions;

    @ManyToMany
    @JoinTable(name="SysUserRole",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="uid")})

    private List<Admin> admins;
}