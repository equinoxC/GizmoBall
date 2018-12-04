package GizmoBallInterface;

import entity.Barrier;
import entity.BarrierWrapper;

import java.util.ArrayList;
import java.util.List;

public interface IOInterface {
    public ArrayList<BarrierWrapper> loadFile();
    public void saveFile();
}
