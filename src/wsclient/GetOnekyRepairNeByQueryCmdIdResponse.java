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
 *         &lt;element name="GetOnekyRepair_Ne_ByQueryCmdIdResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "getOnekyRepairNeByQueryCmdIdResult" })
@XmlRootElement(name = "GetOnekyRepair_Ne_ByQueryCmdIdResponse")
public class GetOnekyRepairNeByQueryCmdIdResponse {

	@XmlElement(name = "GetOnekyRepair_Ne_ByQueryCmdIdResult")
	protected String getOnekyRepairNeByQueryCmdIdResult;

	/**
	 * Gets the value of the getOnekyRepairNeByQueryCmdIdResult property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getGetOnekyRepairNeByQueryCmdIdResult() {
		return getOnekyRepairNeByQueryCmdIdResult;
	}

	/**
	 * Sets the value of the getOnekyRepairNeByQueryCmdIdResult property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setGetOnekyRepairNeByQueryCmdIdResult(String value) {
		this.getOnekyRepairNeByQueryCmdIdResult = value;
	}

}
