public class Test {
    public static void main(String[] args){
        Bus bus100 = new Bus(100);
        Bus bus200 = new Bus(200);
        Taxi taxi2000 = new Taxi(2000);
        Taxi taxi1440 = new Taxi(1440);

//         택시 예제
        taxi1440.checkStatus();
        taxi1440.take(2,"서울역", 2);
        taxi1440.oilUse(80);
        taxi1440.charge();
        taxi1440.take(5,"테스트",4);
        taxi1440.take(3, "구로디지털단지",12);
        taxi1440.oilUse(20);
        taxi1440.checkStatus();
        taxi1440.charge();
        taxi1440.checkStatus();
        taxi1440.showInfo();

        // 버스 예제
        bus100.checkStatus();
        bus100.take(2);
        bus100.oilUse(50);
        bus100.modeChange();
        bus100.oilCharge(10);
        bus100.modeChange();
        bus100.take(45);
        bus100.take(5);
        bus100.oilUse(55);
    }

}
