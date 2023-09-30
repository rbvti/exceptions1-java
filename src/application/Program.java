package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room numbe: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date!");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			//Informa as datas para atualização da reserva
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			
			// REGRA DE VALIDAÇÃO: Não poderá haver atualização para datas anteriores ao check-in inicial 
			
			// 2) Solução RUIM! Embora a implementação estaja na classe Reservation e não no programa principal.
			
			
			
				//Atualiza as datas
			String error =	reservation.updateDates(checkIn, checkOut);
			if (error != null) {
				
				//Imprime as datas atualizadas
				System.out.println("Error in reservation: " + error);
			}
			else {
				System.out.println("Resevation: " + reservation);
			}
			
			
		}

		
		sc.close();
	}

}
