package no.hvl.dat152.lab26.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.jsp.jstl.core.Config;

import java.io.IOException;

@WebServlet("/configlang")
public class ConfigLangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ConfigLangController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String locale = req.getParameter("locale");

		if (locale != null) {
			Config.set(req.getSession(), Config.FMT_LOCALE, locale);

			Cookie cookie = new Cookie("locale", locale);
			cookie.setMaxAge(365 * 24 * 60 * 60); // 1 year
			resp.addCookie(cookie);

			resp.sendRedirect(req.getHeader("referer"));
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
