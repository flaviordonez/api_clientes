package com.espe.api_clientes.model;
import jakarta.persistence.*; 
import jakarta.validation.constraints.*;

@Entity 
@Table(name = "clientes")
public class Cliente {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    @NotBlank
    @NotNull
    @Column(unique = true, nullable = false)
    private String ci;  
    @NotBlank 
    private String nombres; 
    @NotBlank 
    private String apellidos; 
    @NotBlank 
    private String direccion;

    public Long getId() { return id; } 
    public void setId(Long id) { this.id = id; } 

    public String getCi() { return ci; }
    public void setCi(String ci) { this.ci = ci; }

    public String getNombres() { return nombres; } 
    public void setNombres(String nombres) { this.nombres = nombres; } 

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; } 
}
