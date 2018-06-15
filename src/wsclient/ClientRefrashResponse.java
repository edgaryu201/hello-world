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
 *         &lt;element name="ClientRefrashResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "clientRefrashResult" })
@XmlRootElement(name = "ClientRefrashResponse")
public class ClientRefrashResponse {

	@XmlElement(name = "ClientRefrashResult")
	protected String clientRefrashResult;

	/**
	 * Gets the value of the clientRefrashResult property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getClientRefrashResult() {
		return clientRefrashResult;
	}

	/**
	 * Sets the value of the clientRefrashResult property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setClientRefrashResult(String value) {
		this.clientRefrashResult = value;
	}

}
