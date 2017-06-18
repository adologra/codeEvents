package CustomsEvents;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashMap;
import java.util.ListIterator;

import CustomsEvents.exceptions.NotImplementedMethodException;
import jdk.internal.util.xml.impl.Pair;

/**
 * @author Adolfo Lopez Granados
 * 
 *
 */

public final class BusEvents {
	
	private static HashMap<String, ArrayList<EventInfo>> eventsMap = 
			new HashMap<String, ArrayList<EventInfo>> ();
	
	public static void addEventListener(String eventKey, CustomEventsListener listener) {
		EventInfo evtInfo = new EventInfo(eventKey, listener);
		
		if (!eventsMap.containsKey(eventKey)) {
        	eventsMap.put(eventKey, new ArrayList<EventInfo> ());
        	
        }
        
        eventsMap.get(eventKey).add(evtInfo);
    }
	
	public static void triggerEvents(String key, Object evt) {
		try {
			ListIterator li = eventsMap.get(key).listIterator();
	        while (li.hasNext()) {
	        	EventInfo evtItem = (EventInfo) li.next();
	        	try {
	        		evtItem.getScope().triggerTo(evtItem,evt);
	        	} catch (NotImplementedMethodException ex) {
	        		System.out.println(ex.getMessage());
	        	}
	        }
		}catch (NullPointerException e ) {
			System.out.println("The list of listeners is empty");
		}		
    }
}
