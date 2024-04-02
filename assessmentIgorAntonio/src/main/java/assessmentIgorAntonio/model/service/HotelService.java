package assessmentIgorAntonio.model.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import assessmentIgorAntonio.model.domain.Hotel;

public class HotelService {

    private static Set<Hotel> hoteis = new HashSet<>();
    private static int proximoId = 1;

    public static void incluirHotel(Hotel hotel) {
        try {
            hotel.setId(proximoId++);
            hoteis.add(hotel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Set<Hotel> listarHoteis() {
        try {
            return hoteis;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean excluirHotel(int id) {
        try {
            Iterator<Hotel> iterator = hoteis.iterator();
            while (iterator.hasNext()) {
                Hotel hotel = iterator.next();
                if (hotel.getId() == id) {
                    iterator.remove();
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Hotel obterHotelPeloId(int id) {
        try {
            for (Hotel hotel : hoteis) {
                if (hotel.getId() == id) {
                    return hotel;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getProximoId() {
        return proximoId;
    }

    public static void setProximoId(int proximoId) {
        HotelService.proximoId = proximoId;
    }
}
