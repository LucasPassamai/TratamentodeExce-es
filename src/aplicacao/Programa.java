package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidades.Reserva;
import modelo.excecoes.ExcecaoDominio;

public class Programa {

	public static void main(String[] args) {
		
		
			Scanner sc = new Scanner(System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {	
			System.out.print("Número do quarto: ");
			int numero = sc.nextInt();
			System.out.print("Data do Check-in (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data do Check-out (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
				
			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println("Reserva: "+reserva);
			
			System.out.println();
			System.out.println("Insira os dados para atualizar a reserva: ");
			System.out.print("Data do Check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data do Check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
										
			reserva.atualizaDatas(checkIn, checkOut);
			System.out.println("Reserva: "+reserva);
		}
		catch(ParseException e) {
			System.out.println("Formato inválido de data: ");
		}
		catch(ExcecaoDominio e) {
			System.out.println("Erro na reserva: "+e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado!");
		}
				
		sc.close();
	}

}
