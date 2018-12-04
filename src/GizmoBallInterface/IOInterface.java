package GizmoBallInterface;

import entity.Barrier;
import entity.BarrierWrapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public interface IOInterface {
    public ArrayList<BarrierWrapper> loadFile(File file);
    public void saveFile(File file);
}
