
package com.fol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bonusFundCompensationRequestVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bonusFundCompensationRequestVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ts_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bonusFundCompensationRequestVO", propOrder = {
    "tsId"
})
public class BonusFundCompensationRequestVO {

    @XmlElement(name = "ts_id")
    protected String tsId;

    /**
     * Gets the value of the tsId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTsId() {
        return tsId;
    }

    /**
     * Sets the value of the tsId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTsId(String value) {
        this.tsId = value;
    }

}
