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
 *         &lt;element name="GetOnekyRepair_List_ByHCHLResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "getOnekyRepairListByHCHLResult" })
@XmlRootElement(name = "GetOnekyRepair_List_ByHCHLResponse")
public class GetOnekyRepairListByHCHLResponse {

	@XmlElement(name = "GetOnekyRepair_List_ByHCHLResult")
	protected String getOnekyRepairListByHCHLResult;

	/**
	 * Gets the value of the getOnekyRepairListByHCHLResult property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getGetOnekyRepairListByHCHLResult() {
		return getOnekyRepairListByHCHLResult;
	}

	/**
	 * Sets the value of the getOnekyRepairListByHCHLResult property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setGetOnekyRepairListByHCHLResult(String value) {
		this.getOnekyRepairListByHCHLResult = value;
	}

}
