package controller;

import GizmoBallInterface.IOInterface;
import entity.Barrier;
import entity.BarrierWrapper;
import entity.BouncingBall;
import layout.GamePane;

import javax.swing.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class IOHandler implements IOInterface {
    private GamePane win;
    ArrayList<BarrierWrapper> barriers;

    @Override
    public ArrayList<BarrierWrapper> loadFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(BarrierWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            // Reading XML from the file and unmarshalling.
            barriers = (ArrayList<BarrierWrapper>) um.unmarshal(file);

        } catch (Exception e) { // catches ANY exception
            Object[] options = {"确定"};
            JOptionPane.showOptionDialog(null, "无法对文件进行读取", "Error",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,
                    null, options, options[0]);
        }
        return barriers;
    }

    @Override
    public void saveFile(File file) {
        try {
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
            JAXBContext context = JAXBContext
                    .newInstance(BarrierWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            m.marshal(barriers, file);


        } catch (Exception e) { // catches ANY exception
            Object[] options = {"确定"};
            JOptionPane.showOptionDialog(null, "无法对文件进行写入", "Error",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,
                    null, options, options[0]);
        }
    }
}
