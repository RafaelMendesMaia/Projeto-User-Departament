package com.devsuperior.userdept.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_user")
public class User {

    @Id // anotação para chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Anotação para gerar o valor da chave primeira automatico
    private Long id;
    private String name;
    private String email;

    @ManyToOne// Anotação para declarar a relação da chave Estrangeira!
    @JoinColumn(name = "department_id")
    private Department department; // Associação entre Entidades !!!!!

    public User(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
