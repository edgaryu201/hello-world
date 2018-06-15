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
 *         &lt;element name="GetOnekyRepair_GetQueryCmdResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "getOnekyRepairGetQueryCmdResult" })
@XmlRootElement(name = "GetOnekyRepair_GetQueryCmdResponse")
public class GetOnekyRepairGetQueryCmdResponse {

	@XmlElement(name = "GetOnekyRepair_GetQueryCmdResult")
	protected String getOnekyRepairGetQueryCmdResult;

	/**
	 * Gets the value of the getOnekyRepairGetQueryCmdResult property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getGetOnekyRepairGetQueryCmdResult() {
		return getOnekyRepairGetQueryCmdResult;
	}

	/**
	 * Sets the value of the getOnekyRepairGetQueryCmdResult property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setGetOnekyRepairGetQueryCmdResult(String value) {
		this.getOnekyRepairGetQueryCmdResult = value;
	}

}
