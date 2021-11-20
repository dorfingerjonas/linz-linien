package at.htl.linzlinien.entity;

import javax.persistence.*;

@Entity(name = "LL_LINE")
public class Line {

    @Id
    @Column(name = "LI_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "LI_NAME", unique = true)
    private String name;

    //region constructors
    public Line() {
    }

    public Line(String name) {
        this.name = name;
    }
    //endregion

    //region getter and setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //endregion


    @Override
    public String toString() {
        return String.format("%d: %s", id, name);
    }
}
