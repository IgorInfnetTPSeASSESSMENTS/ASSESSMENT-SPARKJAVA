package assessmentIgorAntonio.model.service;

import java.util.Set;

import assessmentIgorAntonio.model.domain.Acomodacao;
import assessmentIgorAntonio.model.domain.Hotel;
import assessmentIgorAntonio.model.domain.Quarto;

public class QuartosService {

	public static Set<Quarto> obterQuartos(int idDoHotel, int idDaAcomodacao) {
		try {
			Hotel hotel = HotelService.obterHotelPeloId(idDoHotel);
			Acomodacao acomodacao = hotel.obterAcomodacaoPeloId(idDaAcomodacao);
			Set<Quarto> quartos = acomodacao.getQuartos();
			return quartos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void incluirQuartoPeloId(int idDoHotel, int idDaAcomodacao, Quarto quarto) {
		try {
			Hotel hotel = HotelService.obterHotelPeloId(idDoHotel);
			Acomodacao acomodacao = hotel.obterAcomodacaoPeloId(idDaAcomodacao);
			acomodacao.adicionarQuarto(quarto);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static void excluirQuartoPeloId(int idDoHotel, int idDaAcomodacao, int idDoQuarto) {
		try {
			Hotel hotel = HotelService.obterHotelPeloId(idDoHotel);
			Acomodacao acomodacao = hotel.obterAcomodacaoPeloId(idDaAcomodacao);
			acomodacao.removerQuartoPeloId(idDoQuarto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Quarto obterQuartoPeloId(int idDoHotel, int idDaAcomodacao, int idDoQuarto) {
		try {
			Hotel hotel = HotelService.obterHotelPeloId(idDoHotel);
			Acomodacao acomodacao = hotel.obterAcomodacaoPeloId(idDaAcomodacao);
			Quarto quarto = acomodacao.getQuartoPeloId(idDoQuarto);
			return quarto;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
