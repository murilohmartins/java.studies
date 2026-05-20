package classes;

public class Register{
    String name;
    String number;

    public Register(String name, String number){
        this.name = name;
        this.number = number;
    }

    public void printInfos(){
        System.out.println(name+" - "+number);
    }

    public static void main(String[] args){
        Register[] registers = new Register[3];
        registers[0] = new Register("Murilo","123");
        registers[1] = new Register("Zeca","111");
        registers[2] = new Register("Miguel","112");
        registers[1].printInfos();
        registers[2].printInfos();
        registers[0].printInfos();
        for(int i= 0; i<=2; i++){
            registers[i].printInfos();
        }
    }
}
