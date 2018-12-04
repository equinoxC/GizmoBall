package entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Barrier")
public class BarrierWrapper {
    @XmlElement(name = "x")
    public int x;

    @XmlElement(name = "y")
    public int y;

    @XmlElement(name = "name")
    public String name;

    public BarrierWrapper(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
