import java.util.Scanner;

public class HospitalBillingProject {
   public static void main(String[] args) {
       Scanner console = new Scanner(System.in);
      
       String patientName;
       int patientAge, daysStayed, doctorChoice, medicineChoice, testChoice;
       double roomRate = 0, doctorFee = 0, medicineCost = 0, testCost = 0;
       String roomName = "", doctorName = "", medicineName = "", testName = "";
      
       System.out.println("================================");
       System.out.println("   MANILA TYTANA HOSPITAL");
       System.out.println("================================");
      
       System.out.print("Enter patient name: ");
       patientName = console.nextLine();
      
       System.out.print("Enter patient age: ");
       patientAge = console.nextInt();
      
       System.out.println("\n--- SELECT DOCTOR ---");
       System.out.println("1. Dr. Tugade (Cardio) - ₱1500");
       System.out.println("2. Dr. Te (Neuro) - ₱1800");
       System.out.println("3. Dr. Paolo (Ortho) - ₱1200");
       System.out.println("4. Dr. JL (General) - ₱800");
      
       doctorChoice = 0;
       while (doctorChoice < 1 || doctorChoice > 4) {
           System.out.print("Choice (1-4): ");
           doctorChoice = console.nextInt();
           if (doctorChoice < 1 || doctorChoice > 4) {
               System.out.println("WRONG INPUT! Please try again (1-4).");
           }
       }
      
       switch(doctorChoice) {
           case 1:
               doctorName = "Dr. Tugade (Cardio)";
               doctorFee = 1500;
               break;
           case 2:
               doctorName = "Dr. Te (Neuro)";
               doctorFee = 1800;
               break;
           case 3:
               doctorName = "Dr. Paolo (Ortho)";
               doctorFee = 1200;
               break;
           case 4:
               doctorName = "Dr. Valde (General)";
               doctorFee = 800;
               break;
           default:
               doctorName = "General Doctor";
               doctorFee = 500;
       }
      
       System.out.println("\n--- SELECT ROOM ---");
       System.out.println("1. General Ward - ₱1500/day");
       System.out.println("2. Semi-Private - ₱3000/day");
       System.out.println("3. Private Room - ₱6000/day");
      
       int roomChoice = 0;
       while (roomChoice < 1 || roomChoice > 3) {
           System.out.print("Choice (1-3): ");
           roomChoice = console.nextInt();
           if (roomChoice < 1 || roomChoice > 3) {
               System.out.println("WRONG INPUT! Please try again (1-3).");
           }
       }
      
       if(roomChoice == 1) {
           roomName = "General Ward";
           roomRate = 1500;
       } else if(roomChoice == 2) {
           roomName = "Semi-Private";
           roomRate = 3000;
       } else if(roomChoice == 3) {
           roomName = "Private Room";
           roomRate = 6000;
       } else {
           roomName = "General Ward";
           roomRate = 1500;
       }
      
       daysStayed = 0;
       while (daysStayed <= 0) {
           System.out.print("Enter days stayed: ");
           daysStayed = console.nextInt();
           if (daysStayed <= 0) {
               System.out.println("WRONG INPUT! Please enter positive number.");
           }
       }
      
       System.out.println("\n--- SELECT MEDICINE ---");
       System.out.println("1. Paracetamol - ₱50");
       System.out.println("2. Antibiotics - ₱300");
       System.out.println("3. Pain Reliever - ₱200");
       System.out.println("4. None - ₱0");
      
       medicineChoice = 0;
       while (medicineChoice < 1 || medicineChoice > 4) {
           System.out.print("Choice (1-4): ");
           medicineChoice = console.nextInt();
           if (medicineChoice < 1 || medicineChoice > 4) {
               System.out.println("WRONG INPUT! Please try again (1-4).");
           }
       }
      
       if(medicineChoice == 1) {
           medicineName = "Paracetamol";
           medicineCost = 50;
       } else if(medicineChoice == 2) {
           medicineName = "Antibiotics";
           medicineCost = 300;
       } else if(medicineChoice == 3) {
           medicineName = "Pain Reliever";
           medicineCost = 200;
       } else {
           medicineName = "None";
           medicineCost = 0;
       }
      
       System.out.println("\n--- SELECT TEST ---");
       System.out.println("1. Blood Test - ₱500");
       System.out.println("2. X-Ray - ₱800");
       System.out.println("3. None - ₱0");
      
       testChoice = 0;
       while (testChoice < 1 || testChoice > 3) {
           System.out.print("Choice (1-3): ");
           testChoice = console.nextInt();
           if (testChoice < 1 || testChoice > 3) {
               System.out.println("WRONG INPUT! Please try again (1-3).");
           }
       }
      
       if(testChoice == 1) {
           testName = "Blood Test";
           testCost = 500;
       } else if(testChoice == 2) {
           testName = "X-Ray";
           testCost = 800;
       } else {
           testName = "None";
           testCost = 0;
       }
      
       double roomTotal = daysStayed * roomRate;
       double subtotal = roomTotal + doctorFee + medicineCost + testCost;
       double tax = subtotal * 0.12;
       double total = subtotal + tax;
      
       System.out.println("\n\n********************************");
       System.out.println("       HOSPITAL RECEIPT         ");
       System.out.println("********************************");
       System.out.println("  PATIENT: " + patientName);
       System.out.println("  AGE: " + patientAge + " years old");
       System.out.println("  DOCTOR: " + doctorName);
       System.out.println("  ROOM: " + roomName + " (" + daysStayed + " days)");
       System.out.println("********************************");
       System.out.println("  BREAKDOWN:");
       System.out.printf("  Room: ₱%.0f x %d = ₱%.2f\n", roomRate, daysStayed, roomTotal);
       System.out.printf("  Doctor: %s = ₱%.2f\n", doctorName, doctorFee);
       System.out.printf("  Medicine: %s = ₱%.2f\n", medicineName, medicineCost);
       System.out.printf("  Test: %s = ₱%.2f\n", testName, testCost);
       System.out.println("  ------------------------------");
       System.out.printf("  Subtotal: ₱%.2f\n", subtotal);
       System.out.printf("  Tax (12%%): ₱%.2f\n", tax);
       System.out.printf("  TOTAL: ₱%.2f\n", total);
       System.out.println("********************************");
       System.out.println("    Thank you! Get well soon!   ");
       System.out.println("********************************");
      
       console.close();
   }
}



