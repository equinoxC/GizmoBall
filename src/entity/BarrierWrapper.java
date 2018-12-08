package entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "Barriers")
public class BarrierWrapper {
    private ArrayList<BarrierSerialization> barrierList;

    @XmlElement(name = "barrier")
    public ArrayList<BarrierSerialization> getBarrierList(){
        return barrierList;
    }


    public void setBarrierList(ArrayList<BarrierSerialization> barrierList){
        this.barrierList = barrierList;
    }

}
