package wsclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the wsclient package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _Querybalance_QNAME = new QName(
			"http://imp.domain/", "querybalance");
	private final static QName _Login_QNAME = new QName("http://imp.domain/",
			"login");
	private final static QName _Deposit_QNAME = new QName("http://imp.domain/",
			"deposit");
	private final static QName _LoginResponse_QNAME = new QName(
			"http://imp.domain/", "loginResponse");
	private final static QName _DepositResponse_QNAME = new QName(
			"http://imp.domain/", "depositResponse");
	private final static QName _FetchResponse_QNAME = new QName(
			"http://imp.domain/", "fetchResponse");
	private final static QName _QuerybalanceResponse_QNAME = new QName(
			"http://imp.domain/", "querybalanceResponse");
	private final static QName _Fetch_QNAME = new QName("http://imp.domain/",
			"fetch");
	private final static QName _ChangepinResponse_QNAME = new QName(
			"http://imp.domain/", "changepinResponse");
	private final static QName _Changepin_QNAME = new QName(
			"http://imp.domain/", "changepin");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: wsclient
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link Querybalance }
	 * 
	 */
	public Querybalance createQuerybalance() {
		return new Querybalance();
	}

	/**
	 * Create an instance of {@link Login }
	 * 
	 */
	public Login createLogin() {
		return new Login();
	}

	/**
	 * Create an instance of {@link ChangepinResponse }
	 * 
	 */
	public ChangepinResponse createChangepinResponse() {
		return new ChangepinResponse();
	}

	/**
	 * Create an instance of {@link Fetch }
	 * 
	 */
	public Fetch createFetch() {
		return new Fetch();
	}

	/**
	 * Create an instance of {@link FetchResponse }
	 * 
	 */
	public FetchResponse createFetchResponse() {
		return new FetchResponse();
	}

	/**
	 * Create an instance of {@link Deposit }
	 * 
	 */
	public Deposit createDeposit() {
		return new Deposit();
	}

	/**
	 * Create an instance of {@link QuerybalanceResponse }
	 * 
	 */
	public QuerybalanceResponse createQuerybalanceResponse() {
		return new QuerybalanceResponse();
	}

	/**
	 * Create an instance of {@link DepositResponse }
	 * 
	 */
	public DepositResponse createDepositResponse() {
		return new DepositResponse();
	}

	/**
	 * Create an instance of {@link Changepin }
	 * 
	 */
	public Changepin createChangepin() {
		return new Changepin();
	}

	/**
	 * Create an instance of {@link LoginResponse }
	 * 
	 */
	public LoginResponse createLoginResponse() {
		return new LoginResponse();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Querybalance }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://imp.domain/", name = "querybalance")
	public JAXBElement<Querybalance> createQuerybalance(Querybalance value) {
		return new JAXBElement<Querybalance>(_Querybalance_QNAME,
				Querybalance.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://imp.domain/", name = "login")
	public JAXBElement<Login> createLogin(Login value) {
		return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Deposit }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://imp.domain/", name = "deposit")
	public JAXBElement<Deposit> createDeposit(Deposit value) {
		return new JAXBElement<Deposit>(_Deposit_QNAME, Deposit.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://imp.domain/", name = "loginResponse")
	public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
		return new JAXBElement<LoginResponse>(_LoginResponse_QNAME,
				LoginResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link DepositResponse }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://imp.domain/", name = "depositResponse")
	public JAXBElement<DepositResponse> createDepositResponse(
			DepositResponse value) {
		return new JAXBElement<DepositResponse>(_DepositResponse_QNAME,
				DepositResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link FetchResponse }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://imp.domain/", name = "fetchResponse")
	public JAXBElement<FetchResponse> createFetchResponse(FetchResponse value) {
		return new JAXBElement<FetchResponse>(_FetchResponse_QNAME,
				FetchResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link QuerybalanceResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://imp.domain/", name = "querybalanceResponse")
	public JAXBElement<QuerybalanceResponse> createQuerybalanceResponse(
			QuerybalanceResponse value) {
		return new JAXBElement<QuerybalanceResponse>(
				_QuerybalanceResponse_QNAME, QuerybalanceResponse.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Fetch }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://imp.domain/", name = "fetch")
	public JAXBElement<Fetch> createFetch(Fetch value) {
		return new JAXBElement<Fetch>(_Fetch_QNAME, Fetch.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ChangepinResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://imp.domain/", name = "changepinResponse")
	public JAXBElement<ChangepinResponse> createChangepinResponse(
			ChangepinResponse value) {
		return new JAXBElement<ChangepinResponse>(_ChangepinResponse_QNAME,
				ChangepinResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Changepin }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://imp.domain/", name = "changepin")
	public JAXBElement<Changepin> createChangepin(Changepin value) {
		return new JAXBElement<Changepin>(_Changepin_QNAME, Changepin.class,
				null, value);
	}

}
