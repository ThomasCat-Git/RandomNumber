package com.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

/**
 * Servlet implementation class RamdomSun
 */
@WebServlet("/generateRandomNumbers")
public class RamdomSun extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     
    public RamdomSun() {
        super();
        // TODO Auto-generated constructor stub
    }*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// 获取前端传递的参数
        int total = Integer.parseInt(request.getParameter("total"));
        
        // 生成三个随机数
        Random random = new Random();
        int num1 = random.nextInt(total - 2) + 1;
        int num2 = random.nextInt(total - num1 - 1) + 1;
        int num3 = total - num1 - num2;

        // 将结果放入一个Map中
        Result result = new Result(num1, num2, num3, num1 + num2 + num3);

        // 设置响应类型为JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        // 使用Gson将Map转换为JSON
        String jsonResponse = new Gson().toJson(result);

        // 将JSON响应发送给前端
        PrintWriter out = response.getWriter();
        out.print(jsonResponse);
        out.flush();
	}
	
	class Result {
        int num1;
        int num2;
        int num3;
        int sum;

        Result(int num1, int num2, int num3, int sum) {
            this.num1 = num1;
            this.num2 = num2;
            this.num3 = num3;
            this.sum = sum;
        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}*/

}
