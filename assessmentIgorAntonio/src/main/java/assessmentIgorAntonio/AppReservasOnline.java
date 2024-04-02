package assessmentIgorAntonio;

import assessmentIgorAntonio.controller.HotelController;
import spark.Spark;

public class AppReservasOnline {

    public static void main(String[] args) {
        try {
            Spark.port(8080);

            Spark.get("/", (req, res) -> {
                try {
                    return AppReservasOnline.class.getResourceAsStream("/index.html");
                } catch (Exception e) {
                    e.printStackTrace();
                    return "Erro ao carregar a página.";
                }
            });

            Spark.get("/hoteis", HotelController.getHoteis);
            Spark.post("/hoteis", HotelController.incluirHotel);
            Spark.delete("/hoteis/:id", HotelController.excluirHotelPeloId);
            Spark.get("/hoteis/:id", HotelController.getHotelPeloId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
