public class Street {
    private Integer id;
    private Integer startIntersection;
    private Integer endIntersection;
    private String name;
    private Integer streetLength;

    public Street(Integer id, Integer startIntersection, Integer endIntersection, String name, Integer streetLength) {
        this.id = id;
        this.startIntersection = startIntersection;
        this.endIntersection = endIntersection;
        this.name = name;
        this.streetLength = streetLength;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStartIntersection() {
        return startIntersection;
    }

    public void setStartIntersection(Integer startIntersection) {
        this.startIntersection = startIntersection;
    }

    public Integer getEndIntersection() {
        return endIntersection;
    }

    public void setEndIntersection(Integer endIntersection) {
        this.endIntersection = endIntersection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStreetLength() {
        return streetLength;
    }

    public void setStreetLength(Integer streetLength) {
        this.streetLength = streetLength;
    }
}
