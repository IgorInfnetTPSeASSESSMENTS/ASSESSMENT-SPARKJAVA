package assessmentIgorAntonio.model.service;

import assessmentIgorAntonio.model.domain.Acomodacao;
import assessmentIgorAntonio.model.domain.Hotel;

import java.util.Set;

public class AcomodacaoService {

    public static Set<Acomodacao> obterAcomodacoesDeUmHotel(int idDoHotel) {
        try {
            Hotel hotel = HotelService.obterHotelPeloId(idDoHotel);
            return hotel.getAcomodacoes();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void incluirAcomodacaoPeloId(int idDoHotel, int idDaAcomodacao, Acomodacao acomodacao) {
        try {
            Hotel hotel = HotelService.obterHotelPeloId(idDoHotel);
            acomodacao.setId(idDaAcomodacao);

            if (!hotel.getAcomodacoes().contains(acomodacao)) {
                hotel.adicionarAcomodacao(acomodacao);
            } else {
                System.out.println("Acomodação já existente no hotel.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void excluirAcomodacaoPeloId(int idDoHotel, int idDaAcomodacao) {
        try {
            Hotel hotel = HotelService.obterHotelPeloId(idDoHotel);
            hotel.excluirAcomodacaoPeloId(idDaAcomodacao);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    
    public static Acomodacao obterAcomodacaoPeloId(int idDoHotel, int idDaAcomodacao) {
        try {
            Hotel hotel = HotelService.obterHotelPeloId(idDoHotel);
            if (hotel != null) {
                return hotel.obterAcomodacaoPeloId(idDaAcomodacao);
            } else {
                return null; // Hotel não encontrado
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
