package wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetOnekyRepair_Ne_ByCityResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "getOnekyRepairNeByCityResult" })
@XmlRootElement(name = "GetOnekyRepair_Ne_ByCityResponse")
public class GetOnekyRepairNeByCityResponse {

	@XmlElement(name = "GetOnekyRepair_Ne_ByCityResult")
	protected String getOnekyRepairNeByCityResult;

	/**
	 * Gets the value of the getOnekyRepairNeByCityResult property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getGetOnekyRepairNeByCityResult() {
		return getOnekyRepairNeByCityResult;
	}

	/**
	 * Sets the value of the getOnekyRepairNeByCityResult property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setGetOnekyRepairNeByCityResult(String value) {
		this.getOnekyRepairNeByCityResult = value;
	}

}
