package wsclient;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.1.3-hudson-390-
 * Generated source version: 2.0
 * <p>
 * An example of how this class may be used:
 * 
 * <pre>
 * AccountManagerService service = new AccountManagerService();
 * AccountManagerDelegate portType = service.getAccountManagerPort();
 * portType.fetch(...);
 * </pre>
 * 
 * </p>
 * 
 */
@WebServiceClient(name = "AccountManagerService", targetNamespace = "http://imp.domain/", wsdlLocation = "http://localhost:8080/boc3/AccountManagerPort?wsdl")
public class AccountManagerService extends Service {

	private final static URL ACCOUNTMANAGERSERVICE_WSDL_LOCATION;
	private final static Logger logger = Logger
			.getLogger(wsclient.AccountManagerService.class.getName());

	static {
		URL url = null;
		try {
			URL baseUrl;
			baseUrl = wsclient.AccountManagerService.class.getResource(".");
			url = new URL(baseUrl,
					"http://localhost:8080/boc3/AccountManagerPort?wsdl");
		} catch (MalformedURLException e) {
			logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:8080/boc3/AccountManagerPort?wsdl', retrying as a local file");
			logger.warning(e.getMessage());
		}
		ACCOUNTMANAGERSERVICE_WSDL_LOCATION = url;
	}

	public AccountManagerService(URL wsdlLocation, QName serviceName) {
		super(wsdlLocation, serviceName);
	}

	public AccountManagerService() {
		super(ACCOUNTMANAGERSERVICE_WSDL_LOCATION, new QName(
				"http://imp.domain/", "AccountManagerService"));
	}

	/**
	 * 
	 * @return returns AccountManagerDelegate
	 */
	@WebEndpoint(name = "AccountManagerPort")
	public AccountManagerDelegate getAccountManagerPort() {
		return super.getPort(new QName("http://imp.domain/",
				"AccountManagerPort"), AccountManagerDelegate.class);
	}

}