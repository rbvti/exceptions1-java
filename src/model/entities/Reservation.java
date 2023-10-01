package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	//Declarado como static para que haja apenas um SimpleDateFormat para toda instância de Reservation que a aplicação criar
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) { 
		//throws DomainException foi removida da assinatura porque DomainException passou a extender RuntimeException, e não mais Exception
		
		
		//Se o checkOut não for posterior ao checkIn
		if (!checkOut.after(checkIn)){
			throw new DomainException("Check-out date must be after check-in date! 2");
		}
				
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
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

	//public void setCheckIn(Date checkIn) {
	//	this.checkIn = checkIn;
	//}

	public Date getCheckOut() {
		return checkOut;
	}

	//public void setCheckOut(Date checkOut) {
	//	this.checkOut = checkOut;
	//}
	
	public long duration() {
		//Foi declarado um método com retorno do tipo long porque esta operação de diferença entre duas datas em milissegundos retorna um long
		long diff = checkOut.getTime() - checkIn.getTime();
		//Macete para transformar os milissegundos para dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		
	}
	
	public void updateDates(Date checkIn, Date checkOut) {
		//throws DomainException foi removida da assinatura porque DomainException passou a extender RuntimeException, e não mais Exception
		
		Date now = new Date(); //Pega a data de agora.
		
		//O checkIn ou checkOut não podem ser anteriores à data atual
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Reservation dates for update must be future dates! 1");
		}		
		//Se o checkOut não for posterior ao checkIn
		if (!checkOut.after(checkIn)){
			throw new DomainException("Check-out date must be after check-in date! 2");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
	}
	
	@Override
	public String toString() {
		return "room "
			+ roomNumber
			+ ", check-in: "
			+ sdf.format(checkIn)
			+ ", check-out: "
			+ sdf.format(checkOut)
			+ ", "
			+ duration()
			+ " nights";
	}
}
