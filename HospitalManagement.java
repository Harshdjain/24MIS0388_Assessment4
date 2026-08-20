public class HospitalManagement {

    public static void main(String[] args) {

        String patientName = "Rahul";
        int age = 65;
        String doctor = "Dr. Sharma";
        String department = "Cardiology";
        String appointmentType = "Regular";
        int consultationDuration = 30;

        int labTests = 2;
        double labChargePerTest = 500;

        int medicines = 3;
        double medicineChargePerMedicine = 200;

        boolean hasInsurance = true;
        double insurancePercentage = 80;

        boolean emergency = false;
        boolean followUp = false;


        double consultationFee;

        if (appointmentType.equalsIgnoreCase("Emergency")) {
            consultationFee = 1500;
        }
        else if (followUp) {
            consultationFee = 300;
        }
        else {
            consultationFee = 1000;
        }

        if (consultationDuration > 30) {
            consultationFee = consultationFee + 500;
        }

        double labCharges = labTests * labChargePerTest;

        double medicineCharges =
                medicines * medicineChargePerMedicine;

        double totalBill =
                consultationFee + labCharges + medicineCharges;

        if (emergency) {
            totalBill = totalBill + 1000;
        }

        double seniorDiscount = 0;

        if (age >= 60) {
            seniorDiscount = totalBill * 10 / 100;
        }

        double amountAfterSeniorDiscount =
                totalBill - seniorDiscount;

        double insuranceCoverage = 0;

        if (hasInsurance) {
            insuranceCoverage =
                    amountAfterSeniorDiscount *
                    insurancePercentage / 100;
        }

        double patientPayable =
                amountAfterSeniorDiscount - insuranceCoverage;


        System.out.println("===== HOSPITAL BILL =====");

        System.out.println("Patient Name: " + patientName);
        System.out.println("Age: " + age);
        System.out.println("Doctor: " + doctor);
        System.out.println("Department: " + department);
        System.out.println("Appointment Type: " + appointmentType);
        System.out.println("Consultation Duration: "
                + consultationDuration + " minutes");

        System.out.println("\nConsultation Fee: Rs."
                + consultationFee);

        System.out.println("Lab Charges: Rs."
                + labCharges);

        System.out.println("Medicine Charges: Rs."
                + medicineCharges);

        System.out.println("Total Bill: Rs."
                + totalBill);

        System.out.println("Senior Citizen Discount: Rs."
                + seniorDiscount);

        System.out.println("Insurance Coverage: Rs."
                + insuranceCoverage);

        System.out.println("Patient Payable Amount: Rs."
                + patientPayable);

        if (emergency) {
            System.out.println("Emergency Patient Rule Applied");
        }

        if (age >= 60) {
            System.out.println("Senior Citizen Rule Applied");
        }

        if (hasInsurance) {
            System.out.println("Insurance Rule Applied");
        }

        if (followUp) {
            System.out.println("Follow-up Consultation Rule Applied");
        }

        System.out.println("\nBilling Completed.");
    }
}