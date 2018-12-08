package entity;

import javax.xml.bind.annotation.XmlAttribute;

public class BarrierSerialization {
    private int x;
    private int y;
    private String barrierName;

    public BarrierSerialization(int x, int y, String barrierName) {
        this.x = x;
        this.y = y;
        this.barrierName = barrierName;
    }

    public BarrierSerialization(){
        this(0,0,null);
    }

    @XmlAttribute(name = "X")
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @XmlAttribute(name = "Y")
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @XmlAttribute(name = "BarrierName")
    public String getBarrierName() {
        return barrierName;
    }

    public void setBarrierName(String barrierName) {
        this.barrierName = barrierName;
    }
}
