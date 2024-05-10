package fc.java.part3;

import fc.java.model.CarDAO;
import fc.java.model.CarDTO;

import java.util.Scanner;

public class CarInsertTest {
    public static void main(String[] args) {
        // 자동차 정보를 키보드로 부터 입력을 받아서 DB에 저장하세요.(JDBC)
        Scanner scan=new Scanner(System.in);
        System.out.print("자동차 일련번호:");
        int carSn=scan.nextInt();

        scan.nextLine();

        System.out.print("자동차 이름:");
        String carName=scan.nextLine();

        System.out.print("자동차 가격:");
        int carPrice=scan.nextInt();

        scan.nextLine();

        System.out.print("자동차 소유자:");
        String  carOwner=scan.nextLine();

        System.out.print("자동차 녀식:");
        int carYear=scan.nextInt();

        scan.nextLine();

        System.out.print("자동차 타입:");
        String carType=scan.nextLine();


//        System.out.println(carSn+"\t"+carName+"\t"+carPrice+"\t"+carOwner+"\t"+carYear+"\t"+carType);
        CarDTO car=new CarDTO();
        car.carSn=carSn;
        car.carName=carName;
        car.carPrice=carPrice;
        car.carOwner=carOwner;
        car.carYear=carYear;
        car.carType=carType;


        CarDAO dao=new CarDAO();
        dao.carInsert(car);
//        carInfoPrint(car);
    }
}
