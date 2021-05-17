package HouseRentApp.HouseService;

import HouseRentApp.HouseDomain.House;

import java.util.ArrayList;
import java.util.List;

/**
 * File Information
 *
 * @author CHEN Charlie
 * @Description:
 * @date: 2021/5/6 8:38
 * @version: 1.0
 */
public class Service {
    private List<House> houses;// save house object
    private int idCounter = 1; // rec next id

    public Service() {
        houses = new ArrayList<>();
    }
    // findById
    public House findById(int findId){
        for(House h:houses){
            if (h.getId()==findId){
                return h;
            }
        }
        return null;
    }

    // del
    public boolean del(int delId){
        for (int i = 0; i<houses.size(); i++){
            if (houses.get(i).getId()==delId){
                houses.remove(i);
                return true;
            }
        }
        return false;
    }

    // add
    public boolean add(House newHouse){
        newHouse.setId(idCounter++);
        /*
        for(House h : houses){
            if (h.getId()==newHouse.getId()){
                System.out.println("Same id already exists !!!");
                return false;
            }
        }
        */
        houses.add(newHouse);
        return true;
    }
    // list
    public  List<House> list() {
        return houses;
    }
}
