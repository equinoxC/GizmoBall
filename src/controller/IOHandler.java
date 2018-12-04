package controller;

import GizmoBallInterface.IOInterface;
import entity.Barrier;
import entity.BarrierWrapper;
import entity.BouncingBall;
import layout.GamePane;

import java.util.ArrayList;
import java.util.List;

public class IOHandler implements IOInterface {
    private GamePane win;
    ArrayList<BarrierWrapper> barriers;

    @Override
    public ArrayList<BarrierWrapper> loadFile() {
        barriers = new ArrayList<BarrierWrapper>();
        return barriers;
    }

    @Override
    public void saveFile() {
        win = BouncingBall.getInstance().getWin();
        barriers = new ArrayList<BarrierWrapper>();
        int x = win.getX_axis();
        int y = win.getY_axis();
        for(int i = 1;i<=x;++i){
            for(int j = 1;j<=y;++j){
                if(win.getPoint(i,j).isPiece())
                    barriers.add(new BarrierWrapper(i,j,win.getPoint(i,j).getPiece().getName()));
            }
        }
    }
}
