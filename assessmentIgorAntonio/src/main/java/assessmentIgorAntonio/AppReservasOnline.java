package assessmentIgorAntonio;

import assessmentIgorAntonio.controller.AcomodacaoController;
import assessmentIgorAntonio.controller.ClienteController;
import assessmentIgorAntonio.controller.HotelController;
import assessmentIgorAntonio.controller.QuartosController;
import assessmentIgorAntonio.controller.ReservaController;
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
                    return "Erro ao carregar a p�gina.";
                }
            });
            
            //HOTEIS
            Spark.get("/hoteis", HotelController.getHoteis);
            Spark.post("/hoteis", HotelController.incluirHotel);
            Spark.delete("/hoteis/:id", HotelController.excluirHotelPeloId);
            Spark.get("/hoteis/:id", HotelController.getHotelPeloId);
            
            //CLIENTES
            Spark.get("/clientes", ClienteController.obterClientes);
            Spark.post("/clientes", ClienteController.criarCliente);
            Spark.delete("/clientes/:id", ClienteController.excluirClientePeloId);
            Spark.get("/clientes/:id", ClienteController.obterClientePeloId);
            
            //RESERVAS
            Spark.post("/:id/reservar", ReservaController.realizarReserva);
            
            //ACOMODACOES
            Spark.get("/acomodacoes/:idDoHotel", AcomodacaoController.obterAcomodacoesDeUmHotel);
            Spark.post("/acomodacoes/:idDoHotel/:idDaAcomodacao", AcomodacaoController.incluirAcomodacaoPeloId);
            Spark.delete("/acomodacoes/:idDoHotel/:idDaAcomodacao", AcomodacaoController.excluirAcomodacaoPeloId);
            Spark.get("/acomodacoes/:idDoHotel/:idDaAcomodacao", AcomodacaoController.getAcomodacaoPeloId);
            
            //QUARTOS
            Spark.get("/quartos/:idDoHotel/:idDaAcomodacao", QuartosController.obterQuartos);
            Spark.post("/quartos/:idDoHotel/:idDaAcomodacao", QuartosController.incluirQuartoPeloId);
            Spark.delete("/quartos/:idDoHotel/:idDaAcomodacao/:idDoQuarto", QuartosController.excluirQuartoPeloId);
            Spark.get("/quartos/:idDoHotel/:idDaAcomodacao/:idDoQuarto", QuartosController.obterQuartoPeloId);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
