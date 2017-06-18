package CustomsEvents.exceptions;

public class NotImplementedMethodException extends Exception {
	public NotImplementedMethodException () {
		super("This method has to be implemented, in order to manage the events");
	}
}
