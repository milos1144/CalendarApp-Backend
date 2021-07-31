package idms.barber.service;

import java.time.LocalDate;
import java.util.List;

import idms.barber.model.Reservation;

public interface ReservationService {

	
	List<Reservation> findAll();
	Reservation findOne(String barber, LocalDate reservationDate, int reservationTime);
	Reservation save(Reservation reservation);
	Reservation delete(String barber, LocalDate reservationDate, int reservationTime);
	List<Reservation> findByBarber(String barber);
	List<Reservation> findByBarberDate(String barber, LocalDate reservationDate);
}
