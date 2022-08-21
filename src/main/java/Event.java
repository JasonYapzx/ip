public class Event extends Task {

    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }

    /**
     * Rewrites this event task into the save file format
     * @return String to be stored in save file
     */
    @Override
    public String saveData() {
        String marked = this.isDone ? "1" : "0";
        return "E | " + marked + " | " + this.description + " | " + this.at;
    }
}