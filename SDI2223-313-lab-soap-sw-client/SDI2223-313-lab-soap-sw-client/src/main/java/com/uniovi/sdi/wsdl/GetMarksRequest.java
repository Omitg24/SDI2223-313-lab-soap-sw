//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v2.3.7 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2023.04.26 a las 03:28:45 PM CEST 
//


package com.uniovi.sdi.wsdl;

import javax.xml.bind.annotation.*;


/**
 * <p>Clase Java para anonymous complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="dni" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "dni"
})
@XmlRootElement(name = "getMarksRequest")
public class GetMarksRequest {

    @XmlElement(required = true)
    protected String dni;

    /**
     * Obtiene el valor de la propiedad dni.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDni() {
        return dni;
    }

    /**
     * Define el valor de la propiedad dni.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDni(String value) {
        this.dni = value;
    }

}
