
package domain.imp.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "querybalanceResponse", namespace = "http://imp.domain/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "querybalanceResponse", namespace = "http://imp.domain/")
public class QuerybalanceResponse {

    @XmlElement(name = "return", namespace = "")
    private double _return;

    /**
     * 
     * @return
     *     returns double
     */
    public double getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(double _return) {
        this._return = _return;
    }

}
