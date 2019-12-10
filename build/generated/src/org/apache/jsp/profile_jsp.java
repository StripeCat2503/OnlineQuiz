package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class profile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>My Profile</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "navbar.jsp", out, false);
      out.write("\n");
      out.write("        <div id=\"list-example\" class=\"list-group\">\n");
      out.write("            <a class=\"list-group-item list-group-item-action\" href=\"#list-item-1\">Item 1</a>\n");
      out.write("            <a class=\"list-group-item list-group-item-action\" href=\"#list-item-2\">Item 2</a>\n");
      out.write("            <a class=\"list-group-item list-group-item-action\" href=\"#list-item-3\">Item 3</a>\n");
      out.write("            <a class=\"list-group-item list-group-item-action\" href=\"#list-item-4\">Item 4</a>\n");
      out.write("        </div>\n");
      out.write("        <div data-spy=\"scroll\" data-target=\"#list-example\" data-offset=\"0\" class=\"scrollspy-example\">\n");
      out.write("            <h4 id=\"list-item-1\">Item 1</h4>\n");
      out.write("            <p>...</p>\n");
      out.write("            <h4 id=\"list-item-2\">Item 2</h4>\n");
      out.write("            <p>...</p>\n");
      out.write("            <h4 id=\"list-item-3\">Item 3</h4>\n");
      out.write("            <p>...</p>\n");
      out.write("            <h4 id=\"list-item-4\">Item 4</h4>\n");
      out.write("            <p>...</p>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
