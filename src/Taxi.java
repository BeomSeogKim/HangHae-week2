public class Taxi {
    // 관련 요소 선언
    int taxiNum;
    int oil = 100; /*초기 oil 값은 100*/
    int speed = 0; /*초기 속도는 0으로*/
    String object;
    int baseDistance = 2; /*기본 거리 : 2km*/
    int targetDistance; /*목적지 까지의 거리*/
    int elementPrice = 4000;
    int price;  /*미터에 따른 요금 산정*/
    int passenger;  /*현재 탑승객 수*/
    int possible_passenger = 4; /*잔여좌석*/
    int intake; /*벌어들인 수입*/
    String mode = "일반";  /*세가지 모드 : 일반, 운행 중, 운행불가*/

    // 택시 생성
    public Taxi(int num){
        this.taxiNum = num;
    }
    // 택시 번호 생성
    public int getTaxiNum() {
        return taxiNum;
    }
    // 기본 정보 호출
    public void checkStatus(){
        if(this.oil >= 10){
            System.out.println("택시번호" + this.taxiNum+"\n주유량 = " + this.oil + "\n상태 = " + this.mode);
        } else{
            System.out.println("택시번호" + this.taxiNum+"\n주유량 = " + this.oil + "\n상태 = " + this.mode + "\n누적요금 = " + this.intake);
        }

    }
    // 손님 탑승
    public void take(int passenger, String object, int targetDistance) {
        if(mode =="운행 중"){
            System.out.println("운행이 불가합니다.");
        }else if(passenger > this.possible_passenger){
            System.out.println("최대 승객 수 초과");
        }else if(mode =="일반"){
            this.passenger += passenger;
            this.possible_passenger -= this.passenger;
            this.mode = "운행 중";
            this.object = object;
            this.targetDistance = targetDistance;
            if(targetDistance <= this.baseDistance){
                this.price = elementPrice;
            }else{
                this.price = 1000 * (targetDistance - this.baseDistance) + this.elementPrice;
            }
            System.out.println("\nTaxi"+ this.getTaxiNum() +"\n탑승 승객수 = "+ this.passenger + "\n잔여 승객 수 = " + this.possible_passenger
                    + "\n기본 요금 확인 = "+ this.elementPrice + "\n목적지 = " + this.object + "\n목적지까지 거리 = " + targetDistance + "km"+
                    "\n지불할 요금 = "+ this.price + "\n상태 = " + this.mode);
        }

    }

    // 기름 사용
    public void oilUse(int status){
        this.oil -= status;
        if(oil < 10){
            System.out.println("주유 필요");
            this.mode = "운행불가";
        }
    }
    // 기름 충전
    public void oilCharge(int status){
        this.oil += status;
        if(oil >= 10){
            this.mode = "일반";
        }
    }
    // 결제
    public void charge(){
        if(targetDistance <=this.baseDistance){
            this.intake += this.elementPrice;
            this.passenger = 0;
            this.possible_passenger = 4;
            if (this.oil < 10){
                this.mode = "운행불가";
            }else{
                this.mode = "일반";
            }
        }else{
            this.intake += this.price;
            this.passenger = 0;
            this.possible_passenger = 4;
            if (this.oil < 10){
                this.mode = "운행불가";
            }else{
                this.mode = "일반";
            }
        }
        System.out.println("\n주유량 = " + this.oil + "\n누적요금 = " + this.intake);
    }
    // 속도 변경
    public void setSpeed(int speed){
        this.speed = speed;
    }
    // 속도 가속
    public void acclerate(int value){
        this.speed += value;
    }
    // 속도 감속
    public void slowdown(int value){
        this.speed -= value;
    }
    // 버스 현황
    public void showInfo(){
        if(this.mode == "일반" || this.mode=="운행 중") {
            System.out.println("\nTaxi"+ this.getTaxiNum() +"\n탑승 승객수 = "+ this.passenger + "\n잔여 승객 수 = " + this.possible_passenger
                    + "\n기본 요금 확인 = "+ this.elementPrice + "\n목적지 = " + this.object + "\n목적지까지 거리 = " + targetDistance + "km"+
                    "\n지불할 요금 = "+ this.price + "\n상태 = " + this.mode );
        }else{
            System.out.println("Taxi"+ this.getTaxiNum() + "\n주유량 = " + this.oil + "\n상태 = " + this.mode + "\n누적 요금 = " + this.intake) ;
        }
    }
}
