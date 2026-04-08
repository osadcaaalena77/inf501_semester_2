public class TripDate implements Comparable {
     int year;
     int month;
     int day;
     int hour;
     int min;

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMin() {
        return min;
    }

    public TripDate(String date) {
        String datePart = date.substring(0,date.indexOf(" "));
        String timePart = date.substring(date.indexOf(" ") + 1);
        this.year = Integer.parseInt(datePart.substring(0,4));
        this.month = Integer.parseInt(datePart.substring(5,7));
        this.day = Integer.parseInt(datePart.substring(8,10));
        this.hour = Integer.parseInt(timePart.substring(0,2));
        this.min = Integer.parseInt(timePart.substring(3));
    }

    @Override
    public int compareTo(Object o) {
        TripDate newO = (TripDate) o;
        if (this.getYear() != newO.getYear()) {
            return this.getYear() - newO.getYear();
        } else if (this.getMonth() != newO.getMonth()) {
            return this.getMonth() - newO.getMonth();
        } else if (this.getDay() != newO.getDay()) {
            return this.getDay() - newO.getDay();
        } else if (this.getHour() != newO.getHour()) {
            return this.getHour() - newO.getHour();
        } else {
            return this.getMin() - newO.getMin();
        }
    }

    @Override
    public String toString() {
        String result =  "" + year;
        if (month < 10) result += "-" + "0" + month;
        else result += "-" + month;
        if (day < 10) result += "-" + "0" + day + " ";
        else result += "-" + day + " ";
        if (hour < 10) result += "0" + hour + ":";
        else result += " " + hour + ":";
        if (min < 10) result += "0" + min;
        else result += min;
        return result;
    }
}
