package com.controller.struts;

import com.form.struts.Usuario;
import com.google.gson.Gson;
import com.model.strust.UsuarioQuery;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

/**
 *
 * @author Erick Pereda
 */
public class UsuarioAction extends MappingDispatchAction {
    private static String error = "ERROR";
    private static String success = "SUCCESS";
    private static String session = "SESSION";
    
    public ActionForward validarExisteSesion(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        String res=error;
        try {
            Usuario u = null;
            u = (Usuario) request.getSession().getAttribute("user");

            if (u == null) {
                System.out.println("VALIDACIÓN INICIAL \nNO SESSION ");
                res=session;
            }
            if (u != null) {
                System.out.println("VALIDACIÓN \nSESION INICIADA. ID: " + u.getId());
                request.setAttribute("user", u);
                res=success;
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
         //obtiene la informacion del header y footer para saber que sera mostrado
        

        return mapping.findForward(res);
    }
    
    public ActionForward loginUser(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/text; charset=utf-8");
        response.setHeader("Cache-Control", "no-cache");
         String res=error;
        try {
            UsuarioQuery uq = new UsuarioQuery();
            String email = request.getParameter("email");
            String contrasenia = request.getParameter("contrasenia");
            Gson gson = new Gson();
            if (email != null && contrasenia != null) {
                Usuario as = uq.existeUsuario(email, contrasenia); 
                PrintWriter writer = response.getWriter();
                writer.write(gson.toJson(as));
                writer.flush();
                request.getSession().setAttribute("user", as);
                response.getWriter().close();

                writer.close();
                System.out.println("LOGIN USER \nNombre: " + as.getNombre());
                System.out.println("ID : " + as.getId());
                res=success;
            }else{
                res=session;
            }

        } catch (IOException e) {
        }
        return mapping.findForward(res);
    }
    
    public ActionForward buscarEmail(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/text; charset=utf-8");
        response.setHeader("Cache-Control", "no-cache");
       
        try {
            UsuarioQuery uq = new UsuarioQuery();
            String email = request.getParameter("email");
            Gson gson = new Gson();
            boolean as =false;
            as=uq.existeEmail(email);
            System.out.println("as "+as);
            try (PrintWriter writer = response.getWriter()) {
                writer.write(gson.toJson(as));
                writer.flush();
            }
        } catch (IOException ex) {
        }
        return null;
    }
    
    public ActionForward logout(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        String res=error;
        try {
            request.getSession().setAttribute("user", null);
            res=success;
        } catch (Exception e) {
            res=error;
        }
        return mapping.findForward(res);
    }
    
}
