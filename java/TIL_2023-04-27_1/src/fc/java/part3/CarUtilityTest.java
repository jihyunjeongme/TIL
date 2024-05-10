package fc.java.part3;

import fc.java.model.CarDTO;
import fc.java.model.CarUtility;

public class CarUtilityTest {
    public static void main(String[] args) {
        // 자동차 정모를 출력 하는 동작을 가지고 있는 Utility 클래스를 설계하시오
        int carSn=1100;
        String carName="LexusIS250";
        int carPrince=9000000;
        String carOwner="정지현";
        int carYear=2023;
        String carType="G";

        CarDTO car=new CarDTO();
        car.carSn=carSn;
        car.carName=carName;
        car.carPrice=carPrince;
        car.carOwner=carOwner;
        car.carYear=carYear;
        car.carType=carType;
//        CarPrint(car);

        CarUtility carUtil=new CarUtility();
        carUtil.carPrint(car);
    }
    // 매개변수로 자동차의 정보를 입력받아서 출력하는 메서드를 정의하세요.

}
