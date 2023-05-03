package com.sb.parkinglot;

public class MainClient {

    public static void main(String[] args) {

    ParkingLot parkingLot = new ParkingLot(2,2,2);
    Vehicle truck = new Vehicle(VehicleType.TRUCK);
    parkingLot.parkVehicle(truck);
    parkingLot.removeVehicle(truck);
    System.out.println("Available parking slots are: For Large "+parkingLot.freeLargeSpots+ " For Compact "+parkingLot.freeCompactSpots+" For Bikes "+ parkingLot.freeBikeSpots);
    }
}
