package autoservice.models;

public class Master {
    private String name;
    private boolean isAvailable;

    public Master(String name) {
        this.name = name;
        this.isAvailable = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return String.format("Master{name='%s', isAvailable=%b}", name, isAvailable);
    }
}