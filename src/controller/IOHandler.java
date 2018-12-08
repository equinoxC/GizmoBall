package controller;

import GizmoBallInterface.IOInterface;
import entity.Barrier;
import entity.BarrierSerialization;
import entity.BarrierWrapper;
import entity.BouncingBall;
import layout.GamePane;
import main.MainApp;

import javax.swing.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.prefs.Preferences;

public class IOHandler implements IOInterface {
    private GamePane win;
    private ArrayList<BarrierSerialization> barriers;

    public File getPersonFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }

    public void setPersonFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());
        } else {
            prefs.remove("filePath");
        }
    }


    @Override
    public ArrayList<BarrierSerialization> loadFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(BarrierWrapper.class);
            Unmarshaller um = context.createUnmarshaller();
            BarrierWrapper barrierWrapper = (BarrierWrapper) um.unmarshal(file);
            barriers = barrierWrapper.getBarrierList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
            barriers = new ArrayList<BarrierSerialization>();
            int x = win.getX_axis();
            int y = win.getY_axis();
            for(int i = 1;i<=x;++i){
                for(int j = 1;j<=y;++j){
                    if(win.getPoint(i,j).isPiece())
                        barriers.add(new BarrierSerialization(i,j,win.getPoint(i,j).getPiece().getName()));
                }
            }
            BarrierWrapper barrierWrapper = new BarrierWrapper();
            barrierWrapper.setBarrierList(barriers);
            JAXBContext context = JAXBContext.newInstance(BarrierWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            m.marshal(barrierWrapper, file);
            Object[] options = {"确定"};
            JOptionPane.showOptionDialog(null, "保存成功", "提示",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Object[] options = {"确定"};
            JOptionPane.showOptionDialog(null, "无法对文件进行写入", "Error",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,
                    null, options, options[0]);
        }
    }
}
