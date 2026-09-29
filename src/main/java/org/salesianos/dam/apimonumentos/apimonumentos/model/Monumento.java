package org.salesianos.dam.apimonumentos.apimonumentos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Monumento {

    @Id
    private Float id;
    private String codPais;
    private String ciudad;
    private String pais;
    private Map<Long, Long> localizacion;
    private String nomMonumento;
    private String descripcion;
    private String imagen;
}
