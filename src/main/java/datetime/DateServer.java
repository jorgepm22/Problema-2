package datetime;

import exceptions.ParseServeException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateServer {
    private String time;
    private String timezone;

    public DateServer(String time, String timezone) {
        this.time = time;
        this.timezone = timezone;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public void changeDate(SimpleDateFormat sdf) throws ParseServeException, ParseException {
        convertFormat();
        validateTimeZones();
        sdf.setTimeZone(TimeZone.getTimeZone(this.timezone));
        Date date;
        date = sdf.parse(this.time);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        this.time = sdf.format(date);
        this.timezone = "UTC";
    }

    private void convertFormat() {
        String[] list = this.timezone.split("/");
        this.timezone = "";
        for (int i = 0; i < list.length ; i++){
            if ( i == 0 ){
                if (list.length == 2)
                    this.timezone += list[i].substring(0,1).toUpperCase() + list[i].substring(1) + "/";
                else
                    this.timezone += list[i].substring(0,1).toUpperCase() + list[i].substring(1);
            } else {
                this.timezone += list[i].substring(0,1).toUpperCase() + list[i].substring(1);
            }
        }
    }

    private void validateTimeZones()  throws ParseServeException {
        boolean valid = false;
        String[] validIDs = TimeZone.getAvailableIDs();
        for (String str : validIDs) {
            if (str != null && str.equals(this.timezone)) {
                valid = true;
            }
        }
        if (!valid)
            throw new ParseServeException("Formato de TimeZone incorrecto");
    }
}
