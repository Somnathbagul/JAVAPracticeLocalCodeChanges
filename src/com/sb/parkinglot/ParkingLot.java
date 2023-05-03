package com.sb.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    List<CompactSpot> compactSpotList = new ArrayList<>();
    List<LargeSpot> largeSpotList = new ArrayList<>();
    List<BikeSpot> bikeSpotList = new ArrayList<>();

    int freeCompactSpots;
    int freeLargeSpots;
    int freeBikeSpots;
    public ParkingLot(int freeCompactSpots, int freeLargeSpots, int freeBikeSpots) {
        this.freeCompactSpots = freeCompactSpots;
        this.freeLargeSpots = freeLargeSpots;
        this.freeBikeSpots = freeBikeSpots;
    }

   public void parkVehicle(Vehicle vehicle){
        System.out.println("We are about to park your vehicle of type "+vehicle.getVehicleType());
      if(vehicle.getVehicleType().equals(VehicleType.TRUCK)){
          if(freeLargeSpots>0){
              parkYourLargeVehicle(vehicle);
          }else{
              System.out.println("Sorry All Large Spots Are Full.");
          }
      }else if(vehicle.getVehicleType().equals(VehicleType.CAR)){
          if(freeLargeSpots>0) {
              parkYourLargeVehicle(vehicle);
          }else if(freeCompactSpots>0){
              parkYourCompactVehicle(vehicle);
          }else{
              System.out.println("Sorry All Large & Compact Spots Are Full.");
          }
      }else if(vehicle.getVehicleType().equals(VehicleType.BIKE)){
          if(freeBikeSpots>0){
              parkYourBikeVehicle(vehicle);
          }else if(freeCompactSpots>0) {
              parkYourCompactVehicle(vehicle);
          }else if(freeLargeSpots>0){
              parkYourLargeVehicle(vehicle);
          }else{
              System.out.println("Sorry Neither Bike,Compact or Large Spots Are Available for Bike.");
          }
      }

   }
    public void removeVehicle(Vehicle vehicle){

        ParkingSpot parkingSpot = vehicle.getParkingSpot();
        parkingSpot.setFree(true);
        if(vehicle.getVehicleType().equals(VehicleType.TRUCK)){
            if(largeSpotList.remove(parkingSpot)){
                freeLargeSpots++;
                System.out.println("We have successfully unpark/removed your "+vehicle.getVehicleType()+" vehicle.");
            }else{
                System.out.println("You don't have your vehicle parked at this parking lot.");
            }
        }else if(vehicle.getVehicleType().equals(VehicleType.CAR)){
            if(compactSpotList.remove(parkingSpot)){
                freeCompactSpots++;
                System.out.println("We have successfully unpark/removed your "+vehicle.getVehicleType()+" vehicle.");
            }else{
                System.out.println("You don't have your vehicle parked at this parking lot.");
            }

        }else if(vehicle.getVehicleType().equals(VehicleType.BIKE)){
            if(bikeSpotList.remove(parkingSpot)){
                freeBikeSpots++;
                System.out.println("We have successfully unpark/removed your "+vehicle.getVehicleType()+" vehicle.");
            }else{
                System.out.println("You don't have your vehicle parked at this parking lot.");
            }
        }

    }

    private void parkYourLargeVehicle(Vehicle vehicle) {
        LargeSpot largeSpot = new LargeSpot(ParkingSpotType.LARGE);
        largeSpot.setVehicle(vehicle);
        largeSpot.setFree(false);
        vehicle.setParkingSpot(largeSpot);
        largeSpotList.add(largeSpot);
        System.out.println("We have successfully parked your "+vehicle.getVehicleType()+" Vehicle.");
        freeLargeSpots--;
    }
    private void parkYourCompactVehicle(Vehicle vehicle) {
        CompactSpot compactSpot  = new CompactSpot(ParkingSpotType.COMPACT);
        compactSpot.setVehicle(vehicle);
        compactSpot.setFree(false);

        vehicle.setParkingSpot(compactSpot);
        compactSpotList.add(compactSpot);
        System.out.println("We have successfully parked your "+vehicle.getVehicleType()+" Vehicle.");
        freeCompactSpots--;
    }
    private void parkYourBikeVehicle(Vehicle vehicle) {
        BikeSpot bikeSpot = new BikeSpot(ParkingSpotType.BIKE);
        bikeSpot.setVehicle(vehicle);
        bikeSpot.setFree(false);

        vehicle.setParkingSpot(bikeSpot);
        bikeSpotList.add(bikeSpot);
        System.out.println("We have successfully parked your "+vehicle.getVehicleType()+" Vehicle.");
        freeBikeSpots--;
    }



}
