package fr.eni.tp.filmotheque.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@RequestMapping("/error")
@SessionAttributes({"s_membre"})
public class ExceptionController implements ErrorController
{
	@GetMapping
	public String erreur(HttpServletRequest request)
	{
		Object statut = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

		if (statut != null) {
			int code = Integer.parseInt(statut.toString());

			return switch (code)
			{
				case 400, 401, 403 -> "errors/400"; // Bad Request, Unauthorized, Forbidden
				case 404 -> "errors/404"; // Not Found
				case 405 -> "errors/405"; // Method Not Allowed
				case 409 -> "errors/409"; // Conflict
				default -> "errors/generic";
			};
		}

		return "errors/generic";
	}
}
