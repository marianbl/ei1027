package es.uji.ei1027.clubesportiu.model;

import java.sql.Time;

public class Standing {
	
	String swimmerName;
	String eventName;
	int position;
	Time finishTime;

	public String getSwimmerName() { return swimmerName; }
	public void setSwimmerName(String swimmerName) { this.swimmerName = swimmerName; }

	public String getEventName() { return eventName; }
	public void setEventName(String eventName) { this.eventName = eventName; }

	public int getPosition() { return position; }
	public void setPosition(int position) { this.position = position; }

	public Time getFinishTime() { return finishTime; }
	public void setFinishTime(Time finishTime) { this.finishTime = finishTime; }

	@Override
	public String toString() {
		return "Classificacio [position=" + position + ", finishTime=" + finishTime + "]";
	}
}
