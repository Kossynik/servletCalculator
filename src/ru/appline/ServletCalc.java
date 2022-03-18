package ru.appline;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import ru.appline.logic.Operations;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/add")

public class ServletCalc extends HttpServlet {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {

        StringBuffer jb = new StringBuffer();
        String line;

        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {

                jb.append(line);
            }

        } catch (Exception e) {
            System.out.println("Error");
        }

        JsonObject jobj = gson.fromJson(String.valueOf(jb), JsonObject.class);

        int a = jobj.get("a").getAsInt();
        int b = jobj.get("b").getAsInt();
        String math = jobj.get("math").getAsString();

        double result;

        Operations operations = new Operations(a, b, math);

        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();

        response.getWriter().write("{" + "\"result\":");

        switch (math) {

            case "-": pw.print(gson.toJson(operations.mines(a, b, math)));
            case "+": pw.print(gson.toJson(operations.plus(a, b, math)));
            case "/": pw.print(gson.toJson(operations.division(a, b, math)));
            case "*": pw.print(gson.toJson(operations.multiplication(a, b, math)));

        }

        response.getWriter().write("" + "}");

    }

}