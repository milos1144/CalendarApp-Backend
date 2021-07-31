package idms.barber.support;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import idms.barber.model.Reservation;
import idms.barber.service.ReservationService;
import idms.barber.web.dto.ReservationDTO;

@Component
public class ReservationDTOToReservation implements Converter<ReservationDTO, Reservation>{

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	@Autowired
	private ReservationService reservationService;
	
	@Override
	public Reservation convert(ReservationDTO source) {

		System.out.println("***********");
		System.out.println(source);
		System.out.println("***********");
		
		Reservation reservation = null;
		
		if(source.getId() != null) {
			System.out.println("***********");
			System.out.println("Usao u if");
			System.out.println("***********");
			reservation = reservationService.findOne(source.getBarber(), LocalDate.parse(source.getReservationDate(), dtf), 
					source.getReservationTime());
			System.out.println("*********** u ifu");
			System.out.println(reservation);
			System.out.println("***********");
		}else {
			System.out.println("***********");
			System.out.println("Usao u else");
			System.out.println("***********");
			reservation = new Reservation();
		}
		
		System.out.println("***********");
		System.out.println(reservation);
		System.out.println("***********");
		
		reservation.setBarber(source.getBarber());
		reservation.setCustomer(source.getCustomer());
		reservation.setReservationDate(LocalDate.parse(source.getReservationDate(), dtf));
		reservation.setReservationTime(source.getReservationTime());
		reservation.setNote(source.getNote());
		
		
		return reservation;
	}

	
	public List<Reservation> convert(List<ReservationDTO> dtos){
		List<Reservation> retVal = new ArrayList<Reservation>();
		
		for(ReservationDTO dto : dtos) {
			retVal.add(convert(dto));
		}
		return retVal;
	}
	
}
