package idms.barber.web.dto;



public class ReservationDTO {

	
	private Integer id;
	
	private String customer;
	
	private String note;
	
	private String reservationDate;
	
	private int reservationTime;

	private String barber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}


	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public int getReservationTime() {
		return reservationTime;
	}

	public void setReservationTime(int reservationTime) {
		this.reservationTime = reservationTime;
	}

	public String getBarber() {
		return barber;
	}

	public void setBarber(String barber) {
		this.barber = barber;
	}

	@Override
	public String toString() {
		return "ReservationDTO [id=" + id + ", customer=" + customer + ", note=" + note + ", reservationDate="
				+ reservationDate + ", reservationTime=" + reservationTime + ", barber=" + barber + "]";
	}

	
	
	

}
