package CustomsEvents;

import java.util.EventListener;

import CustomsEvents.exceptions.NotImplementedMethodException;

public interface CustomEventsListener extends EventListener {
	
	public void triggerTo (EventInfo evt,Object src) throws NotImplementedMethodException; 
	
}
