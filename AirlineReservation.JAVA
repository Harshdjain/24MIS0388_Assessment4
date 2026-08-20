public class AirlineReservation {

    public static void main(String[] args) {

        String flightNumber = "AI101";
        String source = "Delhi";
        String destination = "Mumbai";

        int totalSeats = 100;
        int availableSeats = 20;

        String passengerName = "Rahul";
        int passengerAge = 25;
        String passengerType = "Adult";

        String flightClass = "Economy";

        String bookingDate = "20-08-2026";
        String travelDate = "25-08-2026";

        double baggageWeight = 25;
        double freeBaggage = 15;

        double economyFare = 5000;
        double businessFare = 9000;
        double firstClassFare = 15000;

        System.out.println("===== FLIGHT SEARCH =====");
        System.out.println("Flight: " + flightNumber);
        System.out.println("From: " + source);
        System.out.println("To: " + destination);
        System.out.println("Travel Date: " + travelDate);
        System.out.println("Available Seats: " + availableSeats);

        double fare;

        if (flightClass.equalsIgnoreCase("Economy")) {
            fare = economyFare;
        }
        else if (flightClass.equalsIgnoreCase("Business")) {
            fare = businessFare;
        }
        else if (flightClass.equalsIgnoreCase("First")) {
            fare = firstClassFare;
        }
        else {
            System.out.println("Invalid class.");
            return;
        }

        if (availableSeats <= 10) {
            fare = fare + fare * 20 / 100;
        }
        else if (availableSeats <= 30) {
            fare = fare + fare * 10 / 100;
        }

        if (passengerType.equalsIgnoreCase("Child")) {
            fare = fare * 50 / 100;
        }
        else if (passengerType.equalsIgnoreCase("Senior")) {
            fare = fare * 80 / 100;
        }

        if (passengerName == null || passengerName.isEmpty()) {
            System.out.println("Invalid passenger.");
            return;
        }

        if (passengerAge <= 0) {
            System.out.println("Invalid passenger age.");
            return;
        }

        if (availableSeats <= 0) {
            System.out.println("Flight is fully booked.");
            return;
        }

        double baggageCharge = 0;

        if (baggageWeight > freeBaggage) {
            double extraBaggage = baggageWeight - freeBaggage;
            baggageCharge = extraBaggage * 500;
        }

        boolean alreadyBooked = false;

        if (alreadyBooked) {
            System.out.println("Double booking not allowed.");
        }
        else {

            availableSeats--;

            double totalFare = fare + baggageCharge;

            System.out.println("\n===== BOOKING SUCCESSFUL =====");
            System.out.println("Passenger: " + passengerName);
            System.out.println("Flight: " + flightNumber);
            System.out.println("Class: " + flightClass);
            System.out.println("Base/Dynamic Fare: Rs." + fare);
            System.out.println("Baggage Charge: Rs." + baggageCharge);
            System.out.println("Total Fare: Rs." + totalFare);
            System.out.println("Remaining Seats: " + availableSeats);

            boolean cancelBooking = false;

            if (cancelBooking) {

                double refund;

                refund = totalFare - (totalFare * 20 / 100);

                availableSeats++;

                System.out.println("\n===== BOOKING CANCELLED =====");
                System.out.println("Cancellation Charge: Rs."
                        + (totalFare * 20 / 100));

                System.out.println("Refund Amount: Rs."
                        + refund);

                System.out.println("Seat Available Again: "
                        + availableSeats);
            }
        }

        System.out.println("\n===== FINAL DETAILS =====");
        System.out.println("Booking Date: " + bookingDate);
        System.out.println("Travel Date: " + travelDate);
        System.out.println("Passenger Type: " + passengerType);
        System.out.println("Available Seats: " + availableSeats);
    }
}