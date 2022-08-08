public class Bus {
    //관련 요소 선언
    int busNum;
    int intake=0;
    int oil= 100;
    int speed;
    int changSpeed;
    int possible_passenger = 30;
    int passenger;
    int price = 1000;
    String mode ="운행중";
    String mode_change;
    // 버스 생성
    public Bus(int num){
        this.busNum = num;
    }
    // 버스에 사람 태우기
    public void take(int passenger) {
        if (passenger > possible_passenger) {
            System.out.println("최대 승객 수 초과");
        } else {
            this.passenger += passenger;
            this.intake += this.price * passenger;
            this.possible_passenger -= this.passenger;
            System.out.println("\n탑승 승객 수 = " + this.passenger + "\n잔여 승객 수 = " + this.possible_passenger + "\n요금확인 = " + this.price * passenger);
        }
    }
    // 버스 기름 사용량
    public void oilUse(int usage){
        this.oil -= usage;
        if(this.oil >= 10){
            System.out.println("\n주유량 = " + this.oil);
        }else {
            this.mode = "차고지행";
            System.out.println("\n주유량 = " + this.oil + "\n상태 = " + this.mode);
            System.out.println("주유 필요");
        }
    }
    // 버스 주유
    public void oilCharge(int content){
        this.oil += content;
        System.out.println("\n상태 = " +this.mode + "\n 주유량 = " + this.oil);
    }
    // 버스의 운행 상태를 변경
    public void modeChange(){
        if(this.mode == "차고지행"){
            this.mode = "운행중";
            this.possible_passenger = 30;
            this.passenger = 0;
        } else if(this.mode == "운행중"){
            this.mode = "차고지행";
        }
    }
    // 버스의 상황을 보여주기
    public void checkStatus(){
        if(this.oil >= 10){
            System.out.println("버스번호" + this.busNum+"\n주유량 = " + this.oil + "\n상태 = " + this.mode);
        } else{
            System.out.println("버스번호" + this.busNum+"\n주유량 = " + this.oil + "\n상태 = " + this.mode);
        }

    }
    // 버스 현황
    public void showInfo(){
        System.out.println("Bus "+ this.busNum + "\ngot " + this.passenger + "\nleft " + this.possible_passenger
                + "\noil " + this.oil + "\n운행 모드: " + this.mode+ "\n수익 : " + this.intake);
    }
}
