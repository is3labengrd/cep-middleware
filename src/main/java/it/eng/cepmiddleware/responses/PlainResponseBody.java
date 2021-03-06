package it.eng.cepmiddleware.responses;

public class PlainResponseBody {

	protected String message;

	public PlainResponseBody(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "PlainResponseBody [message=" + message + "]";
	}

}
