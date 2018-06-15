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
 *         &lt;element name="GetOnekyRepair_SMSInfoResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "getOnekyRepairSMSInfoResult" })
@XmlRootElement(name = "GetOnekyRepair_SMSInfoResponse")
public class GetOnekyRepairSMSInfoResponse {

	@XmlElement(name = "GetOnekyRepair_SMSInfoResult")
	protected String getOnekyRepairSMSInfoResult;

	/**
	 * Gets the value of the getOnekyRepairSMSInfoResult property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getGetOnekyRepairSMSInfoResult() {
		return getOnekyRepairSMSInfoResult;
	}

	/**
	 * Sets the value of the getOnekyRepairSMSInfoResult property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setGetOnekyRepairSMSInfoResult(String value) {
		this.getOnekyRepairSMSInfoResult = value;
	}

}
