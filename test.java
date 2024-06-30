import java.util.ArrayList;
import java.util.List;

class car {
    private String licencePlate;
    public car(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public String getLicencePlate() {
        return licencePlate;
    }
}
class ParkingSpot{
    int spot_number;
    boolean isAvailable;
    car car;

    public ParkingSpot(int spot_number) {
        this.spot_number = spot_number;
        this.isAvailable = true;
        this.car = null;
    }
    public void occupy(car car){
        this.car=car;
        isAvailable=false;
    }
    public void vacant(){
        this.car=null;
        isAvailable=true;
    }
}
class parkingLot{
    private List<ParkingSpot> spot;

    public parkingLot(int capacity) {
        this.spot=new ArrayList<>();
        for(int i=0;i<capacity;i++){
            spot.add(new ParkingSpot(i));
        }
    }
    public boolean Carpark(car car){
        for(ParkingSpot spot1:spot){
            if(spot1.isAvailable) {
                spot1.occupy(car);
                System.out.println("car with number: " + car.getLicencePlate() + " parked at the spot of: " + spot1.spot_number);
                return true;
            }
        }
        System.out.println("Sorry Parkoing is full");
        return false;
    }
    public boolean removeCar(String licencePlate){
        for(ParkingSpot spot1:spot){
            if(!spot1.isAvailable && spot1.car.getLicencePlate().equalsIgnoreCase(licencePlate)) {
                spot1.vacant();
                System.out.println("Car with: "+licencePlate+" romoved at the spot of: "+spot1.spot_number);
                return true;
            }
        }
        System.out.println("There is no car Found of number : "+licencePlate );
        return false;
    }
}
public class test{
    public static void main(String[] args) {
        parkingLot obj=new parkingLot(5);
        car car1=new car("up455546");
        car car2=new car("mp455546");
        car car3=new car("uk455546");
        car car4=new car("ad455546");
        car car5=new car("dl455546");
        car car6=new car("dl455546");

        obj.Carpark(car1);
        obj.Carpark(car2);
        obj.Carpark(car3);
        obj.Carpark(car4);
        obj.Carpark(car5);
        obj.Carpark(car6);
        obj.removeCar("up455546");
        obj.Carpark(car1);
    }
}