package idms.barber.service.impl;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idms.barber.model.Reservation;
import idms.barber.repository.ReservationRepository;
import idms.barber.service.ReservationService;

@Service
@Transactional
public class JpaReservationService implements ReservationService{

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Override
	public List<Reservation> findAll() {
		
		return reservationRepository.findAll();
	}


	@Override
	public Reservation save(Reservation reservation) {

		return reservationRepository.save(reservation);
	}

	
	@Override
	public Reservation findOne(String barber, LocalDate reservationDate, int reservationTime) {
		
		return reservationRepository.findOne(barber, reservationDate, reservationTime);
	}


	@Override
	public List<Reservation> findByBarber(String barber) {

		return reservationRepository.findByBarber(barber);
	}


	@Override
	public List<Reservation> findByBarberDate(String barber, LocalDate reservationDate) {
		
		return reservationRepository.findByBarberDate(barber, reservationDate);
	}


	@Override
	public Reservation delete(String barber, LocalDate reservationDate, int reservationTime) {
		
		Reservation deleted = reservationRepository.findOne(barber, reservationDate, reservationTime);
		
		if(deleted != null) {
			reservationRepository.delete(deleted);
		}
		
		return deleted;
	}

}
