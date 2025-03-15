package com.example.demo.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "credencialesusuario")
public class Credencialesusuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Deja que la base de datos genere el ID
    @Column(name = "idcredencial")
    private Long idcredencial; 

    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    @OneToOne
    @JoinColumn(name = "identificacion", referencedColumnName = "identificacion", unique = true)
    private Usuario usuario;

    public Credencialesusuario() {}

    public Credencialesusuario(String contrasena, Usuario usuario) { 
        this.contrasena = contrasena;
        this.usuario = usuario;
    }

    public Long getIdcredencial() {
        return idcredencial;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
