/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeServlet;

/**
 *
 * @author Administrator
 */
import java.util.*;
public class Calender
 { String  calendar=null;
   int year=-1,month=-1;
   public void setYear(int year)
   {  this.year=year;
   }
   public int getYear()
   {  return year;
   }
   public void setMonth(int month)
   { this.month=month;
   }
   public int getMonth()
   {  return month;
   }
   public String getCalendar()
   {  StringBuffer buffer=new StringBuffer();
      Calendar rili=Calendar.getInstance();
      rili.set(year,month-1,1);   //将日历翻到year年month月1日,注意0表示一月,
                                  //依次类推,11表示12月。
      //获取1日是星期几(get方法返回的值是1表示星期日,返回的值是7表示星期六):
      int 星期几=rili.get(Calendar.DAY_OF_WEEK)-1;
      int day=0;
      if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
      {  day=31;
      }
      if(month==4||month==6||month==9||month==11)
      {  day=30;
      }
     if(month==2)
      {  if(((year%4==0)&&(year%100!=0))||(year%400==0))
           {  day=29;
           }
         else
           {  day=28;
           }
      }
      String a[]=new String[42];
      for(int i=0;i<星期几;i++)
             { a[i]="**";
             }
      for(int i=星期几,n=1;i<星期几+day;i++)
             {  a[i]=String.valueOf(n) ;
                n++;
             }
      for(int i=星期几+day,n=1;i<42;i++)
             {  a[i]="**" ;
             }
     //用表格显示数组:
     buffer.append("<table border=1>");
     buffer.append("<tr>")  ;
     String weekday[]={"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
     for(int k=0;k<7;k++)
      {  buffer.append("<td>"+weekday[k]+"</td>");
      }
     buffer.append("</tr>") ;
     for(int k=0;k<42;k=k+7)
      {  buffer.append("<tr>")  ;
         for(int j=k;j<Math.min(7+k,42);j++)
          {  buffer.append("<td>"+a[j]+"</td>");
          }
        buffer.append("</tr>") ;
      }
     buffer.append("</table>");
     calendar=new String(buffer);
     return calendar;
   }
}
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.*;
//
//public class Calender extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		this.doPost(request, response);
//	}
//
//	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		response.setCharacterEncoding("GBK");
//		int current_year = request.getParameter("current_year") != null
//				? Integer.parseInt(request.getParameter("current_year"))
//				: 0;
//		int current_month = request.getParameter("current_month") != null
//				? Integer.parseInt(request.getParameter("current_month"))
//				: 0;
//		// 1代表下一个月，-1代表上一个月
//		int up_or_down = request.getParameter("up_or_down") != null
//				? Integer.parseInt(request.getParameter("up_or_down"))
//				: 0;
//
//		Date date = new Date();
//		SimpleDateFormat week_day_formate = new SimpleDateFormat("EEE");
//		String formated_week_day = week_day_formate.format(date.getTime());
//		SimpleDateFormat time_formate = new SimpleDateFormat("HH:mm:ss");
//		String formated_time = time_formate.format(date.getTime());
//		SimpleDateFormat date_formate = new SimpleDateFormat("yyyy/MM/dd");
//		/*
//		 * 这个是固定部分
//		 */
//		/* @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ */
//		String formated_date = date_formate.format(date.getTime());
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(date);
//
//		int today_year = calendar.get(Calendar.YEAR);
//		int today_month = calendar.get(Calendar.MONTH) + 1;
//		// 当前时间的日期
//		int today_day = calendar.get(Calendar.DAY_OF_MONTH);
//		// 直接访问index.do，没有附带任何参数
//		if (up_or_down == 0) {
//			current_year = today_year;
//			current_month = today_month;
//		}
//		// 获取当前的年月
//		else if (up_or_down == 1) {
//			if(current_month + 1 > 12) {
//				current_month = 1;
//				current_year += 1;
//			}
//			else 
//				current_month += 1;
//		} else if (up_or_down == -1) {
//			if((current_month - 1) == 0) {
//				current_month = 12;
//				current_year -= 1;
//			}
//			else 
//				current_month -= 1;
//		}
//		PrintWriter print_writer = response.getWriter();
//		print_writer.print("当前时间：");
//		print_writer.print("<br>");
//		print_writer.print("&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;");
//		print_writer.print("<br>");
//		print_writer.print(formated_date);
//		print_writer.print("<br>");
//		print_writer.print(formated_week_day);
//		print_writer.print("<br>");
//		print_writer.print(formated_time);
//		print_writer.print("<br>");
//		print_writer.print("&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;");
//		print_writer.print("<br>");
//		print_writer.print("<br>");
//		print_writer.print("<br>");
//		print_writer.print(current_year+"年"+current_month+"月");
//		print_writer.print("<br>");
//		print_writer.print("<hr>");
//		print_writer.print("<a href=index.do?current_year="+current_year+"&current_month="+current_month+"&up_or_down=-1>上个月</a>");
//		print_writer.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
//		print_writer.print("<a href=index.do?current_year="+current_year+"&current_month="+current_month+"&up_or_down=1>下个月</a>");
//		print_writer.print("<br>");
//		print_writer.print("<hr>");
//		/* @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ */
//		// 输出七行七列的表格
//		// 使用java bean的形式，由java类通知jsp应该从哪一格渲染到哪一格，
//		// java类只需要通知jsp当月1号在哪个位置和当月最后一天在哪个位置即可
//		// 需要弄出一个统一的规则，第一格是哪一个数字，
//
//
//		// 判断当前月份是否是当前时间的月份，是的话flag为true，检索当前天，并标红
//		boolean flag = false;
//		if (current_year==today_year && current_month == today_month)
//			flag = true;
//
//		String year_month = current_year + "-" + current_month;
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
//		try {
//			calendar.setTime(sdf.parse(year_month));
//		} catch (ParseException e1) {
//			e1.printStackTrace();
//		}
//		// 获取当前月份的天数
//		int number_of_current_month_days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
//
//		String year_month_day = current_year + "-" + current_month + "-1";
//		sdf = new SimpleDateFormat("yyyy-MM-dd");
//		try {
//			calendar.setTime(sdf.parse(year_month_day));
//		} catch (ParseException e1) {
//			e1.printStackTrace();
//		}
//		// 获取当前月份的第一天是星期几
//		int current_month_first_day_week = calendar.get(Calendar.DAY_OF_WEEK) - 1 == 0 ? 7 : calendar.get(Calendar.DAY_OF_WEEK) - 1;
//		// 获取上一个月份共有多少天
//		int last_month = current_month - 1 == 0 ? 12 : current_month - 1;
//		int year = current_month - 1 == 0 ? current_year - 1 : current_year;
//		String year_last_month = year + "-" + last_month;
//		sdf = new SimpleDateFormat("yyyy-MM");
//		try {
//			calendar.setTime(sdf.parse(year_last_month));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		int number_of_last_month_days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
//
//		print_writer.print("<table rules=all>");
//		print_writer.print("<tr>");
//		for (int i = 1; i < 8; i++) {
//			print_writer.print("<td>");
//			print_writer.print("<b>");
//			switch (i) {
//				case 1:
//					print_writer.print("一");
//					break;
//				case 2:
//					print_writer.print("二");
//					break;
//				case 3:
//					print_writer.print("三");
//					break;
//				case 4:
//					print_writer.print("四");
//					break;
//				case 5:
//					print_writer.print("五");
//					break;
//				case 6:
//					print_writer.print("六");
//					break;
//				case 7:
//					print_writer.print("日");
//					break;
//			}
//			print_writer.print("<b>");
//			print_writer.print("</td>");
//		}
//		print_writer.print("</tr>");
//		// 日历的第一行绘制完毕
//		print_writer.print("<tr>");
//		for (int i = current_month_first_day_week - 1, j = number_of_last_month_days - current_month_first_day_week
//				+ 2; i > 0; i--, j++) {
//			print_writer.print("<td>");
//			print_writer.print(j);
//			print_writer.print("</td>");
//		}
//		// 该变量用于记录第一行绘制完毕后，当前月份绘制到了第几天
//		int next_line_start = 0;
//		for (int i = current_month_first_day_week, j = 1; i < 8; i++) {
//			if (j == today_day) {
//
//				print_writer.print("<td>");
//				// 如果当前显示的是当前月份
//				if (flag) {
//					// 标红
//					print_writer.print("<font style=\"background:blue;\" color=\"red\">");
//					print_writer.print(j++);
//					print_writer.print("</font>");
//				} else {
//					print_writer.print("<font color=\"blue\">");
//					print_writer.print(j++);
//					print_writer.print("</font");
//				}
//				print_writer.print("</td>");
//			} else {
//				// 加高亮
//				print_writer.print("<td>");
//				print_writer.print("<font color=\"blue\">");
//				print_writer.print(j++);
//				print_writer.print("</font");
//				print_writer.print("</td>");
//			}
//			next_line_start = j;
//		}
//		print_writer.print("</tr>");
//
//		int day_in_current_month = next_line_start;
//		boolean curren_month_done = false;
//		int number_of_remained_blanks = 0;
//		int day_in_next_month = 1;
//		// 绘制当前月份剩下的日期
//		while (true) {
//			print_writer.print("<tr>");
//			for (int i = 1; i < 8; i++) {
//				if (day_in_current_month == today_day) {
//					print_writer.print("<td>");
//					if (flag) {
//						// 标红
//						print_writer.print("<font style=\"background:blue;\" color=\"red\">");
//						print_writer.print(day_in_current_month++);
//						print_writer.print("</font>");
//					} else {
//						print_writer.print("<font  color=\"blue\">");
//						print_writer.print(day_in_current_month++);
//						print_writer.print("</font");
//						number_of_remained_blanks = 7 - i;
//					}
//					print_writer.print("</td>");
//				} else {
//					print_writer.print("<td>");
//					print_writer.print("<font  color=\"blue\">");
//					print_writer.print(day_in_current_month++);
//					print_writer.print("</font");
//					print_writer.print("</td>");
//					number_of_remained_blanks = 7 - i;
//				}
//				if (day_in_current_month > number_of_current_month_days) {
//					curren_month_done = true;
//					break;
//				}
//			}
//			if (curren_month_done) {
//				for (int i = number_of_remained_blanks; i > 0; i--) {
//					print_writer.print("<td>");
//					print_writer.print(day_in_next_month++);
//					print_writer.print("</td>");
//				}
//				print_writer.print("</tr>");
//				break;
//			}
//			print_writer.print("</tr>");
//		}
//
//		// 一共是7行7列，看看还剩余多少行，使用下个月份的日期进行填充
//		// 计算之前占用了多少行，因为星期需（1-7）要占一行，所以是6行
//		int number_of_remained_rows = 6
//				- (current_month_first_day_week - 1 + number_of_current_month_days + number_of_remained_blanks) / 7;
//		for (int i = 0; i < number_of_remained_rows; i++) {
//			print_writer.print("<tr>");
//			for (i = 1; i < 8; i++) {
//				print_writer.print("<td>");
//				print_writer.print(day_in_next_month++);
//				print_writer.print("</td>");
//			}
//			print_writer.print("</tr>");
//		}
//		print_writer.print("</table>");
//	}
//}