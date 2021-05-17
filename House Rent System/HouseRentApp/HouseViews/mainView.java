package HouseRentApp.HouseViews;

import HouseRentApp.HouseDomain.House;
import HouseRentApp.HouseService.Service;
import HouseRentApp.Utility.utils;

import java.util.List;

/**
 * File Information
 *
 * @author CHEN Charlie
 * @Description: 1. show main menu 2.accept input order 3. finish according operation
 * @date: 2021/5/6 8:35
 * @version: 1.0
 */

public class mainView {
    private boolean loop = true;
    private char command = ' ';
    private Service houseService = new Service();


    // show main menu
    public void Menu(){
        do {
            System.out.println("\n=============房屋出租系统菜单============");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t3 删 除 房 屋 信 息");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t6 退      出");
            System.out.print("请输入你的选择(1-6): ");
            command = utils.readChar();

            switch (command){
                case '1':
                    add();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    del();
                    break;
                case '4':
                    updateHouse();
                    break;
                case '5':
                    printList();
                    break;
                case '6':
                    exit();
                    break;
            }

        }while (loop);
    }

    // find house information by HouseId
    public void findHouse(){
        System.out.println("=============查找房屋信息============");
        System.out.print("请输入要查找的id: ");
        int findId = utils.readInt();
        House res = houseService.findById(findId);
        if (res!=null){
            System.out.println(res);
        }else{
            System.out.println("=============查找房屋信息id不存在============");
        }
    }

    // update house information by HouseId
    public void updateHouse(){
        System.out.println("=============修改房屋信息============");
        System.out.println("请选择待修改房屋编号(-1表示退出)");
        int updateId = utils.readInt();
        if (updateId == -1) {
            System.out.println("=============你放弃修改房屋信息============");
            return;
        }

        House house = houseService.findById(updateId);
        if (house == null) {
            System.out.println("=============修改房屋信息编号不存在..============");
            return;
        }

        System.out.print("姓名(" + house.getHost_name() + "): ");
        String name = utils.readString(8, "");//这里如果用户直接回车表示不修改该信息,默认""
        if (!"".equals(name)) {//修改
            house.setHost_name(name);
        }

        System.out.print("电话(" + house.getPhone_num() + "):");
        String phone = utils.readString(12, "");
        if (!"".equals(phone)) {
            house.setPhone_num(phone);
        }
        System.out.print("地址(" + house.getAddress() + "): ");
        String address = utils.readString(18, "");
        if (!"".equals(address)) {
            house.setAddress(address);
        }
        System.out.print("租金(" + house.getRent() + "):");
        double rent = utils.readInt(-1);
        if (rent != -1) {
            house.setRent(rent);
        }
        System.out.print("状态(" + house.getState() + "):");
        String state = utils.readString(3, "");
        if (!"".equals(state)) {
            house.setState(state);
        }
        System.out.println("=============修改房屋信息成功============");

    }

    // add house into list
    public void add(){
        System.out.println("=============添加房屋============");
        System.out.print("姓名: ");
        String name = utils.readString(8);
        System.out.print("电话: ");
        String phone = utils.readString(12);
        System.out.print("地址: ");
        String address = utils.readString(16);
        System.out.print("月租: ");
        double rent = utils.readInt();
        System.out.print("状态: ");
        String state = utils.readString(3);
        //创建一个新的House对象, 注意id 是系统分配的，
        House newHouse = new House(0,rent,phone,address,name,state);
        if (houseService.add(newHouse)) {
            System.out.println("=============添加房屋成功============");
        } else {
            System.out.println("=============添加房屋失败============");
        }
    }

    // delete house information from list
    public void del(){
        System.out.println("=============删除房屋信息============");
        System.out.print("请输入待删除房屋的编号(-1退出):");
        int delId = utils.readInt();
        if(delId==-1){
            System.out.println("=============放弃删除房屋信息============");
            return;
        }
        char confirm = utils.readConfirmSelection();
        if (confirm=='Y'){
            if(houseService.del(delId)){
                System.out.println("=============删除房屋信息成功============");
            }else{
                System.out.println("=============房屋编号不存在，删除失败============");
            }
        }else{
            System.out.println("=============放弃删除房屋信息============");
        }
    }

    // print house list
    public void printList(){
        System.out.println("=============房屋列表============");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        List<House> houses = houseService.list();//得到所有房屋信息
        for (House i : houses){
            System.out.println(i);
        }
        System.out.println("=============房屋列表显示完毕============");
    }

    // exit from main menu
    public void exit(){
        char confirm = utils.readConfirmSelection();
        if (confirm=='Y'){
            loop = false;
        }
    }
}
