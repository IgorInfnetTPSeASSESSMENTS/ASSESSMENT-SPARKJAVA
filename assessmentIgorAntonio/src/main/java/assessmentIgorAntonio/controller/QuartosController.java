package assessmentIgorAntonio.controller;

import com.google.gson.Gson;
import assessmentIgorAntonio.model.domain.Quarto;
import assessmentIgorAntonio.model.service.AcomodacaoService;
import assessmentIgorAntonio.model.service.QuartosService;
import spark.Route;

public class QuartosController {
	
	private static Gson gsonDosQuartos = new Gson();
	
	public static Route obterQuartos = (req, res) -> {
		try {
			Integer index = Integer.valueOf(req.params("idDoHotel"));
			Integer index2 = Integer.valueOf(req.params("idDaAcomodacao"));
			return QuartosService.obterQuartos(index, index2);	
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return "Erro ao obter quartos. Verifique os parâmetros de entrada.";
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro interno ao obter quartos.";
		}
	};
	
	public static Route incluirQuartoPeloId = (req, res) -> {
		try {
			Integer index = Integer.valueOf(req.params("idDoHotel"));
			Integer index2 = Integer.valueOf(req.params("idDaAcomodacao"));
			Quarto quarto = gsonDosQuartos.fromJson(req.body(), Quarto.class);
			
			if(AcomodacaoService.obterAcomodacaoPeloId(index, index2) != null) {
				QuartosService.incluirQuartoPeloId(index, index2, quarto);
				return  "Quarto incluído com sucesso!";
			} else {
				return "Essa acomodação não existe!";
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return "Erro ao incluir quarto. Verifique os parâmetros de entrada.";
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro interno ao incluir quarto.";
		}
	};
	
	public static Route excluirQuartoPeloId = (req, res) -> {
		try {
			Integer index = Integer.valueOf(req.params("idDoHotel"));
			Integer index2 = Integer.valueOf(req.params("idDaAcomodacao"));
			Integer index3 = Integer.valueOf(req.params("idDoQuarto"));
			
			if(AcomodacaoService.obterAcomodacaoPeloId(index, index2) != null) {
				QuartosService.excluirQuartoPeloId(index, index2, index3);
				return "Quarto excluído com sucesso!";
			} else {
				return "Essa acomodação não existe!";
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return "Erro ao excluir quarto. Verifique os parâmetros de entrada.";
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro interno ao excluir quarto.";
		}
	};

	
	public static Route obterQuartoPeloId = (req, res) -> {
		try {
			Integer index = Integer.valueOf(req.params("idDoHotel"));
			Integer index2 = Integer.valueOf(req.params("idDaAcomodacao"));
			Integer index3 = Integer.valueOf(req.params("idDoQuarto"));
			
			if(AcomodacaoService.obterAcomodacaoPeloId(index, index2) != null) {
				return QuartosService.obterQuartoPeloId(index, index2, index3);
			} else {
				return "Essa acomodação não existe!";
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return "Erro ao obter quarto. Verifique os parâmetros de entrada.";
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro interno ao obter quarto.";
		}
	};
}
