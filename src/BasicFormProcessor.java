
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BasicFormProcessor
 */
public class BasicFormProcessor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ServletOutputStream out = response.getOutputStream();
			response.setContentType("text/html");
			out.println("<html><head><title>Sa�da do formul�rio");
			out.println("</title></head>");
			out.println("<body>");
			out.println("<h1> Esta � a sa�da do formul�rio de dados</h1>");
			
			//extraimos  os dados do formul�rio
			String titulo = request.getParameter("title");
			String nome = request.getParameter("nome");
			String cidade = request.getParameter("cidade");
			String pais = request.getParameter("pais");
			String telefone = request.getParameter("telefone");
			String ano = request.getParameter("ano");
			
			//extraimos  os dados do campo de sele��o
			String[] interesse = request.getParameterValues("interesse");

			//Sa�da de dados da p�gina WEB
			
			
			out.println("<br /> Seu t�tulo �: " + titulo);
			out.println("<br /> Seu nome �: " + nome);
			out.println("<br /> Sua cidade �: " + cidade);
			out.println("<br /> Seu pais �: " + pais);
			out.println("<br /> Seu telefone �: " + telefone);
			out.println("<br /> Sua �rea de interece inclui:");
			out.println("<ul>");
			for (int i = 0; i < interesse.length; i++) {
				out.println("<li>" + interesse[i] + "</li>");
			}
			out.println("</ul>");
			out.println("<br /> Sua idade �: " + ano);
			
			FileWriter x = new FileWriter("C:/Users/cursos senac ti/Desktop/arquivo.xls", true);
			String condeudo = nome + "|" + cidade + "|" + pais + "\n";
			x.write(condeudo);
			x.close();
			
			out.println("<a href='basicForm.html'>Voltar</a>");
			out.println("</body></html>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
