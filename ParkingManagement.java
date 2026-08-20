public class ParkingManagement {

    public static void main(String[] args) {

        String vehicleNumber = "KA01AB1234";
        String vehicleType = "Car";

        boolean vip = false;

        int availableSlots = 10;
        int totalSlots = 10;

        int entryHour = 10;
        int exitHour = 14;

        boolean lostTicket = false;

        if (vehicleNumber == null || vehicleNumber.isEmpty()) {
            System.out.println("Invalid vehicle number.");
            return;
        }

        if (!vehicleType.equalsIgnoreCase("Bike")
                && !vehicleType.equalsIgnoreCase("Car")
                && !vehicleType.equalsIgnoreCase("SUV")
                && !vehicleType.equalsIgnoreCase("Truck")
                && !vehicleType.equalsIgnoreCase("Electric")) {

            System.out.println("Invalid vehicle type.");
            return;
        }

        boolean duplicateVehicle = false;

        if (duplicateVehicle) {
            System.out.println("Vehicle already parked.");
            return;
        }

        String slot;

        if (availableSlots <= 0) {
            System.out.println("Parking lot is full.");
            return;
        }

        if (vehicleType.equalsIgnoreCase("Bike")) {
            slot = "B-01";
        }
        else if (vehicleType.equalsIgnoreCase("Car")) {
            slot = "C-01";
        }
        else if (vehicleType.equalsIgnoreCase("SUV")) {
            slot = "S-01";
        }
        else if (vehicleType.equalsIgnoreCase("Truck")) {
            slot = "T-01";
        }
        else {
            slot = "E-01";
        }

        double hourlyRate;

        if (vehicleType.equalsIgnoreCase("Bike")) {
            hourlyRate = 20;
        }
        else if (vehicleType.equalsIgnoreCase("Car")) {
            hourlyRate = 50;
        }
        else if (vehicleType.equalsIgnoreCase("SUV")) {
            hourlyRate = 70;
        }
        else if (vehicleType.equalsIgnoreCase("Truck")) {
            hourlyRate = 100;
        }
        else {
            hourlyRate = 40;
        }

        int hours = exitHour - entryHour;

        // Early exit
        if (hours <= 0) {
            hours = 1;
        }

        boolean peakHour = false;

        if (entryHour >= 8 && entryHour <= 11) {
            peakHour = true;
        }

        if (entryHour >= 17 && entryHour <= 20) {
            peakHour = true;
        }

        double parkingFee = hourlyRate * hours;

        if (peakHour) {
            parkingFee = parkingFee + parkingFee * 25 / 100;
        }

        boolean overnight = false;

        if (exitHour < entryHour) {
            overnight = true;
            parkingFee = parkingFee + 200;
        }

        if (vip) {
            parkingFee = parkingFee * 50 / 100;
            slot = "VIP-01";
        }

        if (vehicleType.equalsIgnoreCase("Electric")) {
            System.out.println("EV charging available.");
            parkingFee = parkingFee + 100;
        }

        if (lostTicket) {
            parkingFee = 500;
            System.out.println("Lost ticket charge applied.");
        }

        availableSlots--;

        System.out.println("===== VEHICLE ENTRY =====");
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Allocated Slot: " + slot);
        System.out.println("Entry Time: " + entryHour + ":00");

        availableSlots++;

        System.out.println("\n===== VEHICLE EXIT =====");
        System.out.println("Exit Time: " + exitHour + ":00");
        System.out.println("Parking Duration: " + hours + " hours");
        System.out.println("Parking Fee: Rs." + parkingFee);

        if (peakHour) {
            System.out.println("Peak-hour pricing applied.");
        }

        if (overnight) {
            System.out.println("Overnight parking charge applied.");
        }

        if (vip) {
            System.out.println("VIP discount applied.");
        }

        System.out.println("Available Slots: "
                + availableSlots);

        System.out.println("\nParking Completed.");
    }
}