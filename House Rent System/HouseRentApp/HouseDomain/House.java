package HouseRentApp.HouseDomain;

/**
 * File Information
 *
 * @author CHEN Charlie
 * @Description: Information of a single house
 * @date: 2021/5/6 8:21
 * @version: 1.0
 */
public class House {
    // var : id host phone_number address rent state

    private int id;
    //private static id = 0;
    private Double rent;
    private String phone_num;
    private String address;
    private String host_name;
    private String state;

    /* define constructor */
    public House( int id, Double rent, String phone_num, String address, String host_name, String state) {
        this.id = id;
        this.rent = rent;
        this.phone_num = phone_num;
        this.address = address;
        this.host_name = host_name;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getRent() {
        return rent;
    }

    public void setRent(Double rent) {
        this.rent = rent;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHost_name() {
        return host_name;
    }

    public void setHost_name(String host_name) {
        this.host_name = host_name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return id+
                "\t\t"+host_name+
                "\t"+phone_num+
                "\t\t"+address+
                "\t"+rent+
                "\t"+state;
    }
}
