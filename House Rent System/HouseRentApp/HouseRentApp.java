package HouseRentApp;

import HouseRentApp.HouseService.Service;
import HouseRentApp.HouseViews.mainView;
import java.util.HashMap;

public class HouseRentApp {
    public static void main(String[] args) {


        //创建HouseView对象,并且显示主菜单，是整个程序的入口
        new mainView().Menu();
        System.out.println("===Exit out of System==");
    }
}
