package modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import modelo.excecoes.ExcecaoDominio;

public class Reserva {
	
	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) throws ExcecaoDominio {
		if(!checkOut.after(checkIn)) {
			throw new ExcecaoDominio("A data de check-out dever ser posterior a data de check-in");
		}
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}
	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public Date getChackOut() {
		return checkOut;
	}
	
	public long duracao() {
		long diferenca = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	
	public void atualizaDatas(Date checkIn, Date checkOut) throws ExcecaoDominio {
		Date agora = new Date();
		if(checkIn.before(agora) || checkOut.before(agora)) {
			throw new ExcecaoDominio("As datas de reserva para atualiza��o devem ser datas futuras");
		}
		if(!checkOut.after(checkIn)) {
			throw new ExcecaoDominio("A data de check-out dever ser posterior a data de check-in");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;

	}
	
	@Override
	public String toString() {
		return "Quarto "
				+ numeroQuarto
				+", check-in: "
				+ sdf.format(checkIn)
				+", check-out: "
				+ sdf.format(checkOut)
				+", "
				+ duracao()
				+" noites";
	}
	
}
