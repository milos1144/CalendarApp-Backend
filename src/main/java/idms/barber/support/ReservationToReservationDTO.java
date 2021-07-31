package idms.barber.support;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import idms.barber.model.Reservation;
import idms.barber.web.dto.ReservationDTO;

@Component
public class ReservationToReservationDTO implements Converter<Reservation, ReservationDTO> {

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	@Override
	public ReservationDTO convert(Reservation source) {
		
		if(source == null) {
			return null;
		}
		
		ReservationDTO dto = new ReservationDTO();
		
		dto.setId(source.getId());
		dto.setBarber(source.getBarber());
		dto.setCustomer(source.getCustomer());
		dto.setReservationDate(source.getReservationDate().format(dtf));
		dto.setReservationTime(source.getReservationTime());
		dto.setNote(source.getNote());
		
		return dto;
	}

	
	public List<ReservationDTO> convert(List<Reservation> reservations){
		List<ReservationDTO> retVal = new ArrayList<ReservationDTO>();
		
		for(Reservation reservation : reservations) {
			retVal.add(convert(reservation));
		}
		return retVal;
	}
}
