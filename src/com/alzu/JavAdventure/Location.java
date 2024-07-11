
public class Location {
    
    private int id;
    private String name;
    private String description;
    private boolean hasMonsters;
    public Location locationNorth;
    public Location locationSouth;
    public Location locationEast;
    public Location locationWest;
    public static Location home;
    public static Location forest;
    public static Location city;
    public static Location hut;

public Location(int id, String name, String description, boolean hasMonsters) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.hasMonsters = hasMonsters;
}

public int getID() {
    return this.id;
}

public String getName() {
    return this.name;
}

public void setName(String name) {
    this.name = name;
}

public String getDescription() {
    return this.description;
}

public boolean hasMonsters() {
    return this.hasMonsters;
}

public void setDescription(String description) {
    this.description = description;
}

}