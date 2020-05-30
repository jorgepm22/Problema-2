package datetime;

import exceptions.ParseServeException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateServer {
    private String _date;
    private String _format;

    public DateServer(String _date, String _format) {
        this._date = _date;
        this._format = _format;
    }

    public String get_date() {
        return _date;
    }

    public void set_date(String _date) {
        this._date = _date;
    }

    public String get_format() {
        return _format;
    }

    public void set_format(String _format) {
        this._format = _format;
    }

    public void changeDate(SimpleDateFormat sdf) throws ParseServeException, ParseException {
        convertFormat();
        validateTimeZones();
        sdf.setTimeZone(TimeZone.getTimeZone(this._format));
        Date date;
        date = sdf.parse(this._date);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        this._date = sdf.format(date);
        this._format = "UTC";
    }

    private void convertFormat() {
        String[] list = this._format.split("/");
        this._format = "";
        for (int i = 0; i < list.length ; i++){
            if ( i == 0 ){
                if (list.length == 2)
                    this._format += list[i].substring(0,1).toUpperCase() + list[i].substring(1) + "/";
                else
                    this._format += list[i].substring(0,1).toUpperCase() + list[i].substring(1);
            } else {
                this._format += list[i].substring(0,1).toUpperCase() + list[i].substring(1);
            }
        }
    }

    private void validateTimeZones()  throws ParseServeException {
        boolean valid = false;
        String[] validIDs = TimeZone.getAvailableIDs();
        for (String str : validIDs) {
            if (str != null && str.equals(this._format)) {
                valid = true;
            }
        }
        if (!valid)
            throw new ParseServeException("Formato de TimeZone incorrecto");
    }
}
