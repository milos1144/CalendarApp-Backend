package idms.barber.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import idms.barber.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

	@Query("SELECT r FROM Reservation r WHERE r.barber = :barber AND r.reservationDate = :reservationDate "
			+ "AND r.reservationTime = :reservationTime")
	Reservation findOne(@Param("barber") String barber, @Param("reservationDate") LocalDate reservationDate, @Param("reservationTime") int reservationTime);
	
	
	
	@Query("SELECT r FROM Reservation r WHERE r.barber = :barber")
	List<Reservation> findByBarber(@Param("barber") String barber);
	
	
	@Query("SELECT r FROM Reservation r WHERE r.barber = :barber AND r.reservationDate = :reservationDate")
	List<Reservation> findByBarberDate(@Param("barber") String barber, @Param("reservationDate") LocalDate reservationDate);
}
