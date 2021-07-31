package idms.barber.web.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import idms.barber.model.Reservation;
import idms.barber.service.ReservationService;
import idms.barber.support.ReservationDTOToReservation;
import idms.barber.support.ReservationToReservationDTO;
import idms.barber.web.dto.ReservationDTO;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ApiReservationController {

	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private ReservationToReservationDTO toDto;
	
	@Autowired
	private ReservationDTOToReservation toReservation;
	
	@GetMapping("/reservations")
	private ResponseEntity<List<ReservationDTO>> findAll(){
	
		List<Reservation> retVal = reservationService.findAll();
		
		return new ResponseEntity<List<ReservationDTO>>(toDto.convert(retVal), HttpStatus.OK);
	}
	
	@GetMapping("/barbers")
	private ResponseEntity<List<ReservationDTO>> findByBarber(@RequestParam String barber){
		
		List<Reservation> retVal = reservationService.findByBarber(barber);
		
		return new ResponseEntity<List<ReservationDTO>>(toDto.convert(retVal), HttpStatus.OK);
	}
	
	
	@GetMapping("/barbersdate")
	private ResponseEntity<List<ReservationDTO>> findByBarberDate(@RequestParam String barber, @RequestParam String reservationDate){
		LocalDate parsed = LocalDate.parse(reservationDate, dtf);
		
		List<Reservation> retVal = reservationService.findByBarberDate(barber, parsed);
		
		return new ResponseEntity<List<ReservationDTO>>(toDto.convert(retVal), HttpStatus.OK);
	}
	
	@GetMapping("/appointment")
	private ResponseEntity<ReservationDTO> findOne(@RequestParam String barber, @RequestParam String reservationDate, 
			@RequestParam int reservationTime){
		
		LocalDate parsed = LocalDate.parse(reservationDate, dtf);
		
		Reservation reservation = reservationService.findOne(barber, parsed, reservationTime);
		
		return new ResponseEntity<ReservationDTO>(toDto.convert(reservation), HttpStatus.OK);
	}
	
	
	@PostMapping("/appointment")
	private ResponseEntity<ReservationDTO> addReservation(@RequestBody ReservationDTO newReservation){
		
		Reservation savedReservation = reservationService.save(toReservation.convert(newReservation));
		
		return new ResponseEntity<ReservationDTO>(toDto.convert(savedReservation), HttpStatus.CREATED);
	}
	
	@GetMapping("/dummy")
	private ResponseEntity<Boolean> dummy(){
		
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	@DeleteMapping("/appointment")
	private ResponseEntity<ReservationDTO> deleteReservation(@RequestParam String barber, @RequestParam String reservationDate, 
			@RequestParam int reservationTime){
		
		LocalDate parsed = LocalDate.parse(reservationDate, dtf);
		
		Reservation deleted = reservationService.delete(barber, parsed, reservationTime);
		
		if(deleted == null) {
			return new ResponseEntity<ReservationDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ReservationDTO>(toDto.convert(deleted), HttpStatus.OK);
	}
	
	
	@PutMapping("/appointment")
	private ResponseEntity<ReservationDTO> editReservation(@RequestBody ReservationDTO reservationDTO, @RequestParam String barber, @RequestParam String reservationDate, 
			@RequestParam int reservationTime){
		
		LocalDate parsedDate = LocalDate.parse(reservationDate, dtf);
		
		if(!barber.equals(reservationDTO.getBarber()) && !parsedDate.equals(LocalDate.parse(reservationDTO.getReservationDate(), dtf)) && reservationTime != reservationDTO.getReservationTime()) {
			return new ResponseEntity<ReservationDTO>(HttpStatus.BAD_REQUEST);
		}
		
		Reservation persisted = reservationService.save(toReservation.convert(reservationDTO));
		
		return new ResponseEntity<ReservationDTO>(toDto.convert(persisted), HttpStatus.OK);
	}
	
	
	@ExceptionHandler(value=DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	
	
}
