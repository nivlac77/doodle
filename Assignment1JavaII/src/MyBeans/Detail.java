package MyBeans;

import java.io.Serializable;
import java.util.Date;

public class Detail implements Serializable {
	
	private int id;
	private int eventFK;
	private String startTime;
	private String endTime;
	private String date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEventFK() {
		return eventFK;
	}

	public void setEventFK(int eventFK) {
		this.eventFK = eventFK;
	}

	public Detail(String date) {
		super();
		this.date = date;
	}

	public Detail(){}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
