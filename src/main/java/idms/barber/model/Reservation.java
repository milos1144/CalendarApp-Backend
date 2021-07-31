package idms.barber.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reservations")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "customer")
	private String customer;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "reservation_date")
	private LocalDate reservationDate;
	
	@Column(name = "reservation_time")
	private int reservationTime;

	@Column(name = "barber")
	private String barber;
	
	public Reservation() {
	}

	public Reservation(String customer, String note, LocalDate reservationDate, int reservationTime) {
		this.customer = customer;
		this.note = note;
		this.reservationDate = reservationDate;
		this.reservationTime = reservationTime;
	}

	public Reservation(int id, String customer, String note, LocalDate reservationDate, int reservationTime) {
		this.id = id;
		this.customer = customer;
		this.note = note;
		this.reservationDate = reservationDate;
		this.reservationTime = reservationTime;
	}
	
	

	public Reservation(int id, String customer, String note, LocalDate reservationDate, int reservationTime,
			String barber) {
		super();
		this.id = id;
		this.customer = customer;
		this.note = note;
		this.reservationDate = reservationDate;
		this.reservationTime = reservationTime;
		this.barber = barber;
	}

	public Reservation(String customer, String note, LocalDate reservationDate, int reservationTime, String barber) {
		super();
		this.customer = customer;
		this.note = note;
		this.reservationDate = reservationDate;
		this.reservationTime = reservationTime;
		this.barber = barber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public LocalDate getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(LocalDate reservationDate) {
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
		return "Reservation [id=" + id + ", customer=" + customer + ", note=" + note + ", reservationDate="
				+ reservationDate + ", reservationTime=" + reservationTime + ", barber=" + barber + "]";
	}

	
	
	
}
