
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
			out.println("<html><head><title>Saída do formulário");
			out.println("</title></head>");
			out.println("<body>");
			out.println("<h1> Esta é a saída do formulário de dados</h1>");
			
			//extraimos  os dados do formulário
			String titulo = request.getParameter("title");
			String nome = request.getParameter("nome");
			String cidade = request.getParameter("cidade");
			String pais = request.getParameter("pais");
			String telefone = request.getParameter("telefone");
			String ano = request.getParameter("ano");
			
			//extraimos  os dados do campo de seleção
			String[] interesse = request.getParameterValues("interesse");

			//Saída de dados da página WEB
			
			
			out.println("<br /> Seu título é: " + titulo);
			out.println("<br /> Seu nome é: " + nome);
			out.println("<br /> Sua cidade é: " + cidade);
			out.println("<br /> Seu pais é: " + pais);
			out.println("<br /> Seu telefone é: " + telefone);
			out.println("<br /> Sua área de interece inclui:");
			out.println("<ul>");
			for (int i = 0; i < interesse.length; i++) {
				out.println("<li>" + interesse[i] + "</li>");
			}
			out.println("</ul>");
			out.println("<br /> Sua idade é: " + ano);
			
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
