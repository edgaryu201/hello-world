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
 *         &lt;element name="GetOnekyRepair_Ne_ByPoolIdResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "getOnekyRepairNeByPoolIdResult" })
@XmlRootElement(name = "GetOnekyRepair_Ne_ByPoolIdResponse")
public class GetOnekyRepairNeByPoolIdResponse {

	@XmlElement(name = "GetOnekyRepair_Ne_ByPoolIdResult")
	protected String getOnekyRepairNeByPoolIdResult;

	/**
	 * Gets the value of the getOnekyRepairNeByPoolIdResult property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getGetOnekyRepairNeByPoolIdResult() {
		return getOnekyRepairNeByPoolIdResult;
	}

	/**
	 * Sets the value of the getOnekyRepairNeByPoolIdResult property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setGetOnekyRepairNeByPoolIdResult(String value) {
		this.getOnekyRepairNeByPoolIdResult = value;
	}

}
