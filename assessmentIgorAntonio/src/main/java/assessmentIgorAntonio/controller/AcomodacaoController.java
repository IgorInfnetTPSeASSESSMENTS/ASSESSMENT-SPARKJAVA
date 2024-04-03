package assessmentIgorAntonio.controller;

import java.util.Set;

import com.google.gson.Gson;

import assessmentIgorAntonio.model.domain.Acomodacao;
import assessmentIgorAntonio.model.domain.Hotel;
import assessmentIgorAntonio.model.service.AcomodacaoService;
import assessmentIgorAntonio.model.service.HotelService;
import spark.Route;

public class AcomodacaoController {
	
	private static Gson gsonDaAcomodacao = new Gson();
	
	public static Route obterAcomodacoesDeUmHotel = (req,  res) -> {
		try {
			Integer index = Integer.valueOf(req.params("idDoHotel"));
			Set<Acomodacao> acomodacoes = AcomodacaoService.obterAcomodacoesDeUmHotel(index);
			return acomodacoes;
		} catch (Exception e) {
			e.printStackTrace();
			return null; 
		}
	};

	public static Route incluirAcomodacaoPeloId = (req, res) -> {
	    try {
	        Integer index = Integer.valueOf(req.params("idDoHotel"));
	        Integer index2 = Integer.valueOf(req.params("idDaAcomodacao"));
	        Acomodacao novaAcomodacao = gsonDaAcomodacao.fromJson(req.body(), Acomodacao.class);

	        if (HotelService.obterHotelPeloId(index) != null) {
	            Hotel hotel = HotelService.obterHotelPeloId(index);
	            Set<Acomodacao> acomodacoes = hotel.getAcomodacoes();
	            if (!acomodacoes.contains(novaAcomodacao)) {
	                AcomodacaoService.incluirAcomodacaoPeloId(index, index2, novaAcomodacao);
	                return "Acomodação incluída com sucesso!";
	            } else {
	                return "Acomodação já existente no hotel!";
	            }
	        } else {
	            return "Hotel especificado não existe!";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	};
	
	public static Route excluirAcomodacaoPeloId = (req,  res) -> {
		try {
			Integer index = Integer.valueOf(req.params("idDoHotel"));
			Integer index2 = Integer.valueOf(req.params("idDaAcomodacao"));
			
			if(HotelService.obterHotelPeloId(index) != null) {
				AcomodacaoService.excluirAcomodacaoPeloId(index, index2);
				return "Acomodação excluída com sucesso!";
			} else {
				return "Hotel especificado não existe!";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	};
	
	public static Route getAcomodacaoPeloId = (req, res) -> {
	    try {
	        Integer idDoHotel = Integer.valueOf(req.params("idDoHotel"));
	        Integer idDaAcomodacao = Integer.valueOf(req.params("idDaAcomodacao"));

	        Hotel hotel = HotelService.obterHotelPeloId(idDoHotel);
	        if (hotel != null) {
	            Acomodacao acomodacao = hotel.obterAcomodacaoPeloId(idDaAcomodacao);
	            if (acomodacao != null) {
	                return acomodacao;
	            } else {
	                return "Acomodação especificada não encontrada!";
	            }
	        } else {
	            return "Hotel especificado não encontrado!";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	};

}
