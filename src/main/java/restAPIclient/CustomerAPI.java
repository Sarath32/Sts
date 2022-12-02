package restAPIclient;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.api.crud.entity.Customers;

public class CustomerAPI {
	     
                                  //for all api this ?
	private static final String Get_Allcustomers_URL="http://localhost:8080/api/cus";
	
	private String url="jdbc:mysql://localhost:3306/restapiclient";
	private String username="root";
	private String password="";
	
	private RestTemplate rt=new RestTemplate();
	
	public void getallcustomer() {
		
		try {
			
			Connection con=DriverManager.getConnection(url, username, password);
			
			HttpHeaders headers=new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String>entity=new HttpEntity<String>("parameters",headers);
			
			                      //entity class name 
			ResponseEntity<List<Customers>>result=rt.exchange(Get_Allcustomers_URL, HttpMethod.GET, entity, 
					new ParameterizedTypeReference<List<Customers>>(){});
			List<Customers>cusdata=result.getBody();
			
			for (Customers cus : cusdata) {
				
				long id=cus.getId();
				String customername=cus.getCustomername();
				String customeraddress=cus.getCustomeraddress();
				long phnnumber=cus.getPhnnumber();
				
				System.out.println(id+" "+customername+" "+customeraddress+" "+phnnumber);
				
				Statement stmt=con.createStatement();
				String query="insert into customers value("+id+",'"+customername+"','"+customeraddress+"','"+phnnumber+"'"+")";
				stmt.executeUpdate(query);
				
				
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		} 
		
	}
	
	public static void main(String[] args) {
		
		CustomerAPI cusapi=new CustomerAPI();
		cusapi.getallcustomer();
		
	}
	
}
