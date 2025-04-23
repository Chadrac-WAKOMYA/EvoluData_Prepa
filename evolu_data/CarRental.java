package evolu_data;

import java.util.*;
import java.text.SimpleDateFormat;

public class CarRental {
    public static Boolean canScheduleAll(Collection<RentalTime> rentalTimes) {
        for (RentalTime rentalTimeInitial : rentalTimes ){
            for(RentalTime rentalTimeFinal : rentalTimes ){
                if(rentalTimeInitial.getStart().equals(rentalTimeFinal.getStart()) && rentalTimeInitial.getEnd().equals(rentalTimeFinal.getEnd())){
                    continue;
                }else{
                    if(isInIntervall(rentalTimeFinal, rentalTimeInitial.getStart(), rentalTimeInitial.getEnd())){
                        return false;
                    }
                        
                }
            }
        }

        return true;
    }

    public static boolean isInIntervall(RentalTime rentalTime, Date date1, Date date2){
        return (rentalTime.getStart().equals(date1) || rentalTime.getStart().after(date1)) && 
        (rentalTime.getEnd().equals(date2) || rentalTime.getEnd().before(date2));
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/y H:m");

        ArrayList<RentalTime> rentalTimes = new ArrayList<RentalTime>();
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 19:00"), sdf.parse("03/05/2020 20:30")));
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 22:10"), sdf.parse("03/05/2020 22:30")));
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 20:30"), sdf.parse("03/05/2020 22:00")));

        System.out.println(CarRental.canScheduleAll(rentalTimes));
    }
}

class RentalTime {
    private Date start, end;
    
    public RentalTime(Date start, Date end) {
        this.start = start;
        this.end = end;
    }
    
    public Date getStart() {
        return this.start;
    }
    
    public Date getEnd() {
        return this.end;
    } 
}
