/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objects.Record;

/**
 *
 * @author ׳’׳׳™׳×׳•׳ ׳•׳₪׳¨
 */
@WebServlet(name = "MyPrivateData", urlPatterns = {"/secured/MyPrivateData"})
public class MyPrivateData extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        List<Record> list = new ArrayList<Record>();
        list.add(new Record(100, "Lunch", false));
        list.add(new Record(5000, "Salary", true));
        list.add(new Record(300, "Gift", true));
        request.getSession().setAttribute("list", list);
        request.getRequestDispatcher("data.jsp").forward(request, response);

    }
}
