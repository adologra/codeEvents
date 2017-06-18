package CustomsEvents;

import java.util.EventObject;

public class EventInfo extends EventObject {
	private String tag;
	private CustomEventsListener scope;
		
	public EventInfo (String tag, CustomEventsListener source) {
		super(source);
		this.scope = source;
		this.tag = tag;
	}
	
	public String getTag () {
		return this.tag;
	}
	
	public CustomEventsListener getScope () {
		return scope;
	}
}
