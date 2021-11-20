package at.htl.linzlinien.entity;

import javax.persistence.*;

@Entity(name = "LL_STATION")
@NamedQueries({
        @NamedQuery(
                name = "Station.stationsPerLine",
                query = "select s from LL_STATION s where s.line.name like :LINENAME"
        )
})
public class Station {

    @Id
    @Column(name = "ST_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ST_LI_ID")
    private Line line;

    @ManyToOne
    @JoinColumn(name = "ST_LO_ID")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "ST_PREVIOUS_ID")
    private Station prevStation;

    //region constructors

    public Station() {
    }

    public Station(Line line, Location location, Station prevStation) {
        this.line = line;
        this.location = location;
        this.prevStation = prevStation;
    }

    //endregion

    //region getter and setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Station getPrevStation() {
        return prevStation;
    }

    public void setPrevLocation(Station station) {
        this.prevStation = station;
    }
    //endregion


    @Override
    public String toString() {
        return String.format(
                "Linie %s - Station %s (vorherige Station: %s)",
                line.getName(),
                location.getName(),
                (prevStation == null) ? "n/a" : prevStation.getLocation().getName()
        );
    }
}
