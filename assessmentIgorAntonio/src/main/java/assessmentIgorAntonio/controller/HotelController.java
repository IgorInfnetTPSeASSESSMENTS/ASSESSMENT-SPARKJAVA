package assessmentIgorAntonio.controller;

import java.util.Set;

import com.google.gson.Gson;

import assessmentIgorAntonio.model.domain.Hotel;
import assessmentIgorAntonio.model.service.HotelService;
import spark.Route;

public class HotelController {

    private static Gson gsonDoHotel = new Gson();

    public static Route getHoteis = (req, res) -> {
        try {
            Set<Hotel> hoteis = HotelService.listarHoteis();
            return hoteis;
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao listar hot�is.";
        }
    };

    public static Route incluirHotel = (req, res) -> {
        try {
            Hotel novoHotel = gsonDoHotel.fromJson(req.body(), Hotel.class);
            

            if (HotelService.existeHotelComId(novoHotel.getId())) {
                return "Erro ao incluir hotel. Já existe um hotel com o mesmo ID.";
            }
            
            HotelService.incluirHotel(novoHotel);
            
            return "Hotel incluído com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao incluir hotel.";
        }
    };

    public static Route excluirHotelPeloId = (req, res) -> {
        try {
            Integer index = Integer.valueOf(req.params("id"));
            Hotel hotelDeletado = HotelService.obterHotelPeloId(index);
            HotelService.excluirHotel(index);
            return "Hotel deletado: " + hotelDeletado;
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao excluir hotel.";
        }
    };

    public static Route getHotelPeloId = (req, res) -> {
        try {
            Integer index = Integer.valueOf(req.params("id"));
            Hotel hotelObtido = HotelService.obterHotelPeloId(index);
            return "Hotel recuperado com sucesso: " + hotelObtido;
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao recuperar hotel.";
        }
    };
}
