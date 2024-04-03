package assessmentIgorAntonio.controller;

import com.google.gson.Gson;

import assessmentIgorAntonio.model.domain.Quarto;
import assessmentIgorAntonio.model.domain.Reserva;
import assessmentIgorAntonio.model.service.HotelService;
import assessmentIgorAntonio.model.service.ClienteService;
import assessmentIgorAntonio.model.service.AcomodacaoService;
import assessmentIgorAntonio.model.service.QuartosService;
import assessmentIgorAntonio.model.service.ReservaService;
import spark.Route;

public class ReservaController {
	
	private static Gson gsonDaReserva = new Gson();
	
	public static Route realizarReserva = (req, res) -> {
		try {
			Integer idCliente = Integer.valueOf(req.params("id"));
            Reserva novaReserva = gsonDaReserva.fromJson(req.body(), Reserva.class);
            Quarto quartoEspecifico = QuartosService.obterQuartoPeloId(novaReserva.getHotelReservado(), novaReserva.getAcomodacao().getId(), novaReserva.getQuarto().getIdDoQuarto());
            
            String mensagemErro = validarReserva(novaReserva, idCliente);
            if (mensagemErro != null) {
                return mensagemErro;
            } else {
            quartoEspecifico.setDisponivel(false);
            ReservaService.realizarReserva(idCliente, novaReserva);
            }
           
            return "Reserva realizada com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    };
    
    private static String validarReserva(Reserva reserva, Integer idCliente) {
        Integer idHotel = reserva.getHotelReservado();
        Integer idAcomodacao = reserva.getAcomodacao().getId();
        Integer idQuarto = reserva.getQuarto().getIdDoQuarto();
        
        if (HotelService.obterHotelPeloId(idHotel) == null) {
            return "O hotel especificado não existe!";
        }
        
        if (ClienteService.obterClientePeloId(idCliente) == null) {
            return "O cliente especificado não existe!";
        }
        
        if (AcomodacaoService.obterAcomodacaoPeloId(idHotel, idAcomodacao) == null) {
            return "A acomodação especificada não existe!";
        }
        
        if (QuartosService.obterQuartoPeloId(idHotel, idAcomodacao, idQuarto) == null) {
            return "O quarto especificado não existe!";
        }
        
        if (!QuartosService.obterQuartoPeloId(idHotel, idAcomodacao, idQuarto).isDisponivel()) {
            return "O quarto especificado já está reservado!";
        }
        
        return null;
    }
}
