package comp1110.ass2;

public enum Tiles {
    A0("Railway","Nothing","Nothing","Railway","Normal"),
    A1("Railway","Nothing","Railway","Nothing","Normal"),
    A2("Railway","Railway","Railway","Nothing","Normal"),
    A3("Highway","Highway","Highway","Nothing","Normal"),
    A4("Highway","Nothing","Highway","Nothing","Normal"),
    A5("Highway","Nothing","Nothing","Highway","Normal"),
    B0("Highway","Nothing","Railway","Nothing","Station"),
    B1("Highway","Railway","Nothing","Nothing","Station"),
    B2("Highway","Railway","Highway","Railway","Overpass"),
    S0("Highway","Highway","Railway","Highway","Station"),
    S1("Highway","Railway","Railway","Railway","Station"),
    S2("Highway","Highway","Highway","Highway","Normal"),
    S3("Railway","Railway","Railway","Railway","Normal"),
    S4("Highway","Railway","Railway","Highway","Station"),
    S5("Highway","Railway","Highway","Railway","Station");

    private String north;
    private String east;
    private String south;
    private String west;
    private String centre;

    Tiles(String north, String east, String south, String west, String centre) {
        this.north=north;
        this.east=east;
        this.south=south;
        this.west=west;
        this.centre=centre;
    }


}
