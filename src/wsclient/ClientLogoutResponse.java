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
 *         &lt;element name="ClientLogoutResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "clientLogoutResult" })
@XmlRootElement(name = "ClientLogoutResponse")
public class ClientLogoutResponse {

	@XmlElement(name = "ClientLogoutResult")
	protected String clientLogoutResult;

	/**
	 * Gets the value of the clientLogoutResult property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getClientLogoutResult() {
		return clientLogoutResult;
	}

	/**
	 * Sets the value of the clientLogoutResult property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setClientLogoutResult(String value) {
		this.clientLogoutResult = value;
	}

}
