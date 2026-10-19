
public class LogMessage{

    private final String date;
    private final String type;
    private final String text;

    public LogMessage(String date, String type, String text){

        this.date = date;
        this.type = type;
        this.text = text;
    
    }
    

    public String getDate(){
        return date;
    }

    public String getType(){
        return type;
    }

    public String getText(){
        return text;
    }
    
    public String toLogString(){
        return  date + " [" + type + "] " + text;
    }
}