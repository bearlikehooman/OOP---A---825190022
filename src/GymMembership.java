//Novilia - 825190022

import java.util.Scanner;
public class GymMembership {
    String name;
    private int age;
    private int dataPilihan;
    private char dataMembership;
    private int sesiPT;

    public GymMembership(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void display(){
        System.out.println("Informasi General pada GYM ini:");
        System.out.println("Paket yang dapat anda pilih untuk mendapatkan membership di GYM ini:");
        System.out.println("A. $350 per 3 bulan membership;\nB. $600 per 6 bulan membership;\nC. $1000 per 1 tahun membership " +
                "\nD. Personal Training dengan personal trainer (privat) $80 per jam.");
        System.out.println("\nAnda dapat mendapatkan diskon apabila:");
        System.out.println("1. Jika anda berusia 55 tahun atau lebih anda akan mendapatkan diskon 30%;\n2. Bila anda membayar full" +
                " 1 tahun anda akan mendapatkan diskon 15%;\n3. Bila anda memilih lebih dari 5 kali sesi personal training anda mendapat 20% " +
                "diskon tiap sesinya nanti.");
    }

    public void question(){
        Scanner input = new Scanner(System.in);
        System.out.print("\nJika anda memilih paket per bulan maka ketik 1, jika anda memilih paket personal trainee maka ketik 2. \nPilihan anda: ");
        this.setData(input.nextInt());
    }
    public void setData(int pilihan){
         this.dataPilihan = pilihan;
    }

    public void choose(){
        if (this.dataPilihan == 1){
            Scanner inputPilihan = new Scanner(System.in);
            System.out.print("Anda pilih A. 3 bulan | B. 6 bulan | C. 1 tahun membership?\nPilihan anda: ");
            this.setMembershipCost(inputPilihan.next().charAt(0));
        }else{
            Scanner inputPilihan = new Scanner(System.in);
            System.out.print("Anda ingin berapa sesi? ");
            this.setTrainingSessionsCost(inputPilihan.nextInt());
        }
    }

    public void setMembershipCost(char dataMembership){
        this.dataMembership = dataMembership;
    }
    public void setTrainingSessionsCost(int sesiPT){
        this.sesiPT = sesiPT;
    }

    public void totalMembershipCost(){
        if (this.dataPilihan == 1 && this.dataMembership == 'A'){
            if (this.age >= 55){
                System.out.print("Total biaya yang harus anda bayar: $245 ");
            }else{
                System.out.print("Total biaya yang harus anda bayar: $350 ");
            }
        }
        else if (this.dataPilihan == 1 && this.dataMembership == 'B'){
            if(this.age >=55){
                System.out.print("Total biaya yang harus anda bayar: $420 ");
            }else{
                System.out.print("Total biaya yang harus anda bayar: $600 ");
            }
        }
        else if (this.dataPilihan == 1 && this.dataMembership == 'C'){
            if(this.age>=55){
                System.out.print("Total biaya yang harus anda bayar: $550");
            }else{
                System.out.print("Total biaya yang harus anda bayar: $850");
            }
        }else if (this.dataPilihan == 2 && this.sesiPT > 5){
            System.out.print("Anda akan mendapatkan diskon 20% per jam per sesi personal training anda nanti");
        }else if (this.dataPilihan == 2 && this.sesiPT <= 5){
            System.out.print("Anda harus membayar $80 per jam per sesi personal training anda nanti");
        }else{
            System.out.print("Anda salah input, tolong hanya menginput dengan huruf kapital dan angka saja.");
        }
    }
}
class Tracker extends GymMembership{
    private int days = 0;
    private int initialWeight, finalWeight;
    public Tracker(String name, int age) {
        super(name, age);
    }
    public void displayName(){
        System.out.println("\nNama: "+ super.name);
        this.days();
    }
    public int days(){
        return this.days++;
    }
    public void weight(){
        Scanner inputWeight = new Scanner(System.in);
        System.out.print("Masukkan persentasi body fat awal hari anda untuk di track progressnya: ");
        this.setWeight1(inputWeight.nextInt());

        System.out.print("Masukkan persentasi body fat akhir hari anda untuk di track progressnya: ");
        this.setWeight2(inputWeight.nextInt());
    }
    public void setWeight1(int initialWeight){
        this.initialWeight = initialWeight;
    }
    public void setWeight2(int finalWeight){
        this.finalWeight = finalWeight;
    }
    public int calculatedWeight() {
        return this.initialWeight - this.finalWeight;
    }
}

class Main{
    public static void main(String[] args){
        Scanner inputName = new Scanner(System.in);
        System.out.print("Masukkan nama anda: ");
        String name = inputName.nextLine();

        Scanner inputAge = new Scanner(System.in);
        System.out.print("Masukkan umur anda: ");
        int age = inputAge.nextInt();

        GymMembership person1 = new GymMembership(name, age);

        person1.display();
        person1.question();
        person1.choose();
        person1.totalMembershipCost();

        System.out.print("\nSetelah membuat membership di GYM anda juga dapat melakukan tracking progress anda per harinya.");
        Tracker person2 = new Tracker(name, age);
        person2.displayName();
        System.out.println("Pada hari ke-" + person2.days());
        person2.weight();
        System.out.println("Body fat anda telah berkurang "+person2.calculatedWeight() + "% hari ini");
    }
}
