package test.exchange.rate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@GetMapping("test.do")
	@ResponseBody
	public String test() {
		System.out.println("sibal");
		String jsonResponse = null;
		 try {
	            URL url = new URL("https://openapivts.koreainvestment.com:29443//uapi/domestic-stock/v1/quotations/inquire-price?fid_cond_mrkt_div_code=J&fid_input_iscd=005930");
	            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
	            
	            connection.setRequestMethod("GET");
	            connection.setRequestProperty("content-type", "application/json; charset=utf-8");
	            connection.setRequestProperty("authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0b2tlbiIsImF1ZCI6IjdhMWNkNDBhLWMwMDItNDYyNy05ZWVlLTY3ZjI5N2RiNzgxZiIsImlzcyI6InVub2d3IiwiZXhwIjoxNjg3OTMxOTM5LCJpYXQiOjE2ODc4NDU1MzksImp0aSI6IlBTc0VVN3BNbFA0bzBlTVJObVlVRzFBcTdDZmJDWjR1dVU4ZCJ9.3N0w-_qMl2qBSFPo984QsFtx_nCvxK_3n45VuFRwg6mhu6GIUuXlfBuBLHKeEEEHktvVEafdztSyFlv3QyLwwg");
	            connection.setRequestProperty("appkey", "PSsEU7pMlP4o0eMRNmYUG1Aq7CfbCZ4uuU8d");
	            connection.setRequestProperty("appsecret", "3leesykWctdjLwK7bc482HezywI8js9ZjKMWPT23+5WPvzqi1UuTkaNQ6eU+jtiMw89CWiXCLWfOCgUsJxkAdwfm2PhdQH5lfvkHNfbdkj0hspZFYWhBIHtUT3IvQtyV9AF2Xl0g6p9QxR2B9mCd0rNZDkoknjQsZxf42NkWbISyBeL1VFE=");
	            connection.setRequestProperty("tr_id", "FHKST01010100");

	            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	            String line;
	            StringBuilder response = new StringBuilder();
	            while ((line = reader.readLine()) != null) {
	                response.append(line);
	            }	
	            reader.close();

	            jsonResponse = response.toString();
	            System.out.println(jsonResponse);
	        } catch (Exception e) {
	        	System.out.println(e.getMessage());
	            e.printStackTrace();
	        }
		 System.out.println(jsonResponse);
		 return jsonResponse;
	}
}
