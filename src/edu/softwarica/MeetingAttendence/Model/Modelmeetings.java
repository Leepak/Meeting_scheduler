package edu.softwarica.MeetingAttendence.Model;

public class Modelmeetings {

    private String event_id, eventName, eventDate, eventTime, eventLocation, eventDescription, eventMinatt, eventInvitation, eventThresmin;

    public String getE_id() {
        return event_id;
    }

    public void setE_id(String event_id) {
        this.event_id = event_id;
    }

    public String getEname() {
        return eventName;
    }

    public void setEname(String eventName) {
        this.eventName = eventName;
    }

    public String getEdate() {
        return eventDate;
    }

    public void setEdate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEtime() {
        return eventTime;
    }

    public void setEtime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getElocation() {
        return eventLocation;
    }

    public void setElocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEdesc() {
        return eventDescription;
    }

    public void setEdesc(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEminatt() {
        return eventMinatt;
    }

    public void setEminatt(String eventMinatt) {
        this.eventMinatt = eventMinatt;
    }

    public String getEinvitatten() {
        return eventInvitation;
    }

    public void setEinvitatten(String eventInvitation) {
        this.eventInvitation = eventInvitation;
    }

    public String getEthresmin() {
        return eventThresmin;
    }

    public void setEthresmin(String eventThresmin) {
        this.eventThresmin = eventThresmin;
    }

}
