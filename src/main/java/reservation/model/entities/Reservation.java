package reservation.model.entities;

import reservation.model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Integer roomNumber;

    private Date checkIn;

    private Date checkOUt;

    public Reservation(Integer roomNumber, Date checkIn, Date checkOUt) throws DomainException {
        if(!checkOUt.after(checkIn)){
            throw new DomainException("Error in reservation: Check-out date must be after check-in date");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOUt = checkOUt;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOUt() {
        return checkOUt;
    }

    public long duration() {
        long diff = checkOUt.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkIn, Date checkOut) throws DomainException {
        Date now = new Date();
        if(checkIn.before(now) || checkOut.before(now)) {
            throw new DomainException("Error in reservation: Reservation dates for update must be future dates");
        }
        if(!checkOut.after(checkIn)){
           throw new DomainException("Error in reservation: Check-out date must be after check-in date");
        }
        this.checkIn = checkIn;
        this.checkOUt = checkOut;
    }

    @Override
    public String toString() {
        return "Room "
                + roomNumber
                + ", check-in: "
                + sdf.format(checkIn)
                + ", check-out: "
                + sdf.format(checkOUt)
                + ", "
                + duration()
                + " nights";
    }
}
