package org.salesianos.dam.apimonumentos.apimonumentos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Monumento {

    @Id
    @GeneratedValue
    private Long id;
    private String codPais;
    private String pais;
    private String ciudad;
    private Double latitud;
    private Double longitud;
    private String nomMonumento;
    private String descripcion;
    private String imagen;
}
