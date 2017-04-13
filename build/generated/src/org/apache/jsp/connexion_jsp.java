package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class connexion_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/pied.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_otherwise;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_otherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_choose.release();
    _jspx_tagPool_c_otherwise.release();
    _jspx_tagPool_c_when_test.release();
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("    <html>\r\n");
      out.write("        <head>\r\n");
      out.write("            <title>Connexion</title>\r\n");
      out.write("            <!-- Materialize CSS -->\r\n");
      out.write("            <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css\">\r\n");
      out.write("            <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("            <!-- surcharge pour le thème material-->\r\n");
      out.write("            <link rel=\"stylesheet\" href=\"css/theme.css\">\r\n");
      out.write("            <link rel=\"stylesheet\" href=\"css/coeur.css\">\r\n");
      out.write("            <!-- material-icons -->\r\n");
      out.write("            <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\r\n");
      out.write("           \r\n");
      out.write("        </head>\r\n");
      out.write("        <body>\r\n");
      out.write("\r\n");
      out.write("            <!-- Entête du site -->\r\n");
      out.write("            <header>\r\n");
      out.write("                <nav class=\"blue\" role=\"navigation\">\r\n");
      out.write("                    <div class=\"nav-wrapper container\">\r\n");
      out.write("                        <a href=\"index.jsp\" class=\"brand-logo\" style=\"font-size: 30px;\"><i class=\"material-icons left deep-orange-text hide-on-med-and-down\">favorite</i>Fr&eacute;quence Cardiaque</a>\r\n");
      out.write("                        <ul id=\"\" class=\"right hide-on-med-and-down\">\r\n");
      out.write("                           \r\n");
      out.write("                            ");
      if (_jspx_meth_c_choose_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                            <!-- Dropdown Structure -->\r\n");
      out.write("                            <ul id=\"options\" class=\"dropdown-content\">\r\n");
      out.write("                              <li><a href=\"graphique.jsp\">Mon Activit&eacute;</a></li>\r\n");
      out.write("                              <li><a href=\"dossier.jsp\">Mon Dossier</a></li>\r\n");
      out.write("                              <li><a href=\"compte.jsp\">Mon Compte</a></li>\r\n");
      out.write("                              <li class=\"divider\"></li>\r\n");
      out.write("                              <li><a href=\"Deconnexion\">D&eacute;connexion</a></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                            \r\n");
      out.write("                        </ul>\r\n");
      out.write("                        <!-- Vue Mobile -->\r\n");
      out.write("                        <ul id=\"nav-mobile\" class=\"side-nav\">\r\n");
      out.write("                            <li><a>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.nom}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                        <a href=\"#\" data-activates=\"nav-mobile\" class=\"button-collapse\"><i class=\"material-icons\">menu</i></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </nav>\r\n");
      out.write("            </header>\r\n");
      out.write("            \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <!-- Contenu du site -->\r\n");
      out.write("            <main>\r\n");
      out.write("                <div class=\"section no-pad-bot\" id=\"index-banner\">\r\n");
      out.write("                    <div class=\"container\">\r\n");
      out.write("                        <h1 class=\"header center deep-orange-text\">Bienvenue sur la page de connexion </h1>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <br /><br /><h4>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.message}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h4><br /><br /><br /><br />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <form class=\"col s12\" action=\"Connexion\" method=\"POST\">\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("                                <div class=\"input-field col s12 m12 l6\">\r\n");
      out.write("                                    <i class=\"material-icons prefix\">perm_identity</i>\r\n");
      out.write("                                    <input id=\"identifiant\" type=\"text\" name=\"login\" class=\"validate\">\r\n");
      out.write("                                    <label for=\"identifiant\" class=\"active\">Identifiant</label>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"input-field col s12 m12 l6\">\r\n");
      out.write("                                    <i class=\"material-icons prefix\">vpn_key</i>\r\n");
      out.write("                                    <input id=\"mdp\" type=\"password\" name=\"mdp\" class=\"validate\">\r\n");
      out.write("                                    <label for=\"mdp\" class=\"active\">Mot de Passe</label>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("                                <div class=\"input-field col s12 m12 l12 center\">\r\n");
      out.write("                                    <input type=\"submit\" class=\"waves-effect waves-light btn blue\" value=\"Connexion\">\r\n");
      out.write("                                    <br />\r\n");
      out.write("                                    <p class=\"center petit\">Pas encore inscrit ? inscrivez-vous <a href=\"inscription.jsp\">ici</a>.</p>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </form>\r\n");
      out.write("                </div>\r\n");
      out.write("            </main>\r\n");
      out.write("\r\n");
      out.write("            <!-- Pied de page du site -->\r\n");
      out.write("            ");
      out.write("<footer class=\"page-footer blue\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col s12 m6\">\n");
      out.write("                <h5 class=\"white-text\">Ptut - V&ecirc;tement Intelligent - Fr&eacute;quence cardiaque</h5>\n");
      out.write("                <p class=\"grey-text text-lighten-4\">Projet du semestre 2 </p>\n");
      out.write("            </div>\n");
      out.write("        <div class=\"col l4 offset-l2 s12 m12\">\n");
      out.write("            <h5 class=\"white-text\">Liens</h5>\n");
      out.write("            <ul>\n");
      out.write("                <li><a class=\"grey-text text-lighten-3\" href=\"#!\">Cassajus Nicolas</a></li>\n");
      out.write("                <li><a class=\"grey-text text-lighten-3\" href=\"#!\">Farenc Margaux</a></li>\n");
      out.write("                <li><a class=\"grey-text text-lighten-3\" href=\"#!\">Le Guelvoui Alexandre</a></li>\n");
      out.write("                <li><a class=\"grey-text text-lighten-3\" href=\"#!\">Marco Corentin</a></li>\n");
      out.write("                <li><a class=\"grey-text text-lighten-3\" href=\"#!\">Robert Alexandre</a></li>\n");
      out.write("                <li><a class=\"grey-text text-lighten-3\" href=\"#!\">Ouled Moussa Hamza</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"footer-copyright\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("        © 2017 Copyright\n");
      out.write("        <a class=\"grey-text text-lighten-4 right\" href=\"#!\">Plus d'info</a>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("<!-- Materialize JavaScript -->\n");
      out.write("<script src=\"https://code.jquery.com/jquery-2.1.4.min.js\"></script>\n");
      out.write("<!--<script src=\"http://materializecss.com/bin/materialize.js\"></script> -->\n");
      out.write("<!--<script src=\"http://materializecss.com/bin/materialize.min.js\"></script> -->\n");
      out.write("<script src=\"materialize-v0.98.0/materialize/js/materialize.min.js\"></script>\n");
      out.write("<!-- Thème principal jQuery -->\n");
      out.write("<script src=\"js/main.js\"></script>");
      out.write("\r\n");
      out.write("            \r\n");
      out.write("    <script>\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("    \r\n");
      out.write("    // Permet d'animer les champs de formulaire\r\n");
      out.write("    Materialize.updateTextFields();\r\n");
      out.write("    \r\n");
      out.write("    // Permet de faire fonctionner le dropdown\r\n");
      out.write("    $(\".dropdown-button\").dropdown();\r\n");
      out.write("    \r\n");
      out.write("    // Vue Mobile\r\n");
      out.write("    $('.button-collapse').sideNav({\r\n");
      out.write("      menuWidth: 300, // Default is 300\r\n");
      out.write("      edge: 'left', // Choose the horizontal origin\r\n");
      out.write("      closeOnClick: true, // Closes side-nav on <a> clicks, useful for Angular/Meteor\r\n");
      out.write("      draggable: true // Choose whether you can drag to open on touch screens\r\n");
      out.write("    }\r\n");
      out.write("  );\r\n");
      out.write("});\r\n");
      out.write("  \r\n");
      out.write("        \r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("        </body>\r\n");
      out.write("    </html>");
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

  private boolean _jspx_meth_c_choose_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_0.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_0.setParent(null);
    int _jspx_eval_c_choose_0 = _jspx_th_c_choose_0.doStartTag();
    if (_jspx_eval_c_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                ");
        if (_jspx_meth_c_when_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                                ");
        if (_jspx_meth_c_otherwise_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                                \r\n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_c_choose_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
    return false;
  }

  private boolean _jspx_meth_c_when_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_0.setPageContext(_jspx_page_context);
    _jspx_th_c_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.nom != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_0 = _jspx_th_c_when_0.doStartTag();
    if (_jspx_eval_c_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                    <li>\r\n");
        out.write("                                        <a class=\"dropdown-button\" data-activates=\"options\" data-beloworigin=\"true\">\r\n");
        out.write("                                            <div class=\"chip\">\r\n");
        out.write("\r\n");
        out.write("                                                <img src=\"img/8biticon.jpg\" alt=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.nom}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\">\r\n");
        out.write("                                                    ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.nom}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write(" \r\n");
        out.write("                                            </div>\r\n");
        out.write("                                        </a>\r\n");
        out.write("                                    </li>\r\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_when_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
    return false;
  }

  private boolean _jspx_meth_c_otherwise_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_otherwise_0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_otherwise_0.setPageContext(_jspx_page_context);
    _jspx_th_c_otherwise_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    int _jspx_eval_c_otherwise_0 = _jspx_th_c_otherwise_0.doStartTag();
    if (_jspx_eval_c_otherwise_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                    <li><a href=\"connexion.jsp\"><i class=\"material-icons left\">perm_identity</i>Connexion</a></li>\r\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_otherwise_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_otherwise_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
      return true;
    }
    _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
    return false;
  }
}
