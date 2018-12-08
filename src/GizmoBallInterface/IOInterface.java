package GizmoBallInterface;

import entity.Barrier;
import entity.BarrierSerialization;
import entity.BarrierWrapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public interface IOInterface {
    public ArrayList<BarrierSerialization> loadFile(File file);
    public void saveFile(File file);
}
