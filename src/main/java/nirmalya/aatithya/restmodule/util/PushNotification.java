package nirmalya.aatithya.restmodule.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class PushNotification {
	
	@Autowired
	RestTemplate restTemplate;
	
	public final static String AUTH_KEY_FCM = "AAAAyZ1_amM:APA91bHN0BVGzNnHZoCX6hFN7pWXp3AQG468KyYr_hp09IV5cF98PIiR4mwNvHOqoEvcKB_LhwlSi6ynKmn8Doiz9nw3OSSsHAJrX3q9eS37eCKUjG6OIIVXuEOPLT-MvKJUbsziqiQg";
	public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";
	
	public String pushFCMNotification(String id,String msg) throws Exception {
		
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> notification = new HashMap<String,Object>();
 
		notification.put("body", msg);
		notification.put("title", "NERP");
		notification.put("sound", "default");
		
		String to = "/topics/" + id;
		
		map.put("to", to);
		map.put("notification", notification);
		
		JSONObject obj = new JSONObject(map); 

		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(API_URL_FCM);
		post.setHeader("Content-type", "application/json");
		post.setHeader("Authorization", "key=" + AUTH_KEY_FCM);

		post.setEntity(new StringEntity(obj.toString(), "UTF-8"));
		HttpResponse response = client.execute(post);

		Reader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
		StringBuilder builder = new StringBuilder();
		char[] buf = new char[1000];
		int l = 0;
		while (l >= 0) {
			builder.append(buf, 0, l);
			l = in.read(buf);
		}
		JSONObject arr = new JSONObject(builder.toString());
		
		String messageId = arr.get("message_id").toString();
		
		return messageId;
		
	}
	public String pushFCMNotificationForLate(String id,String msg) throws Exception {
		
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> notification = new HashMap<String,Object>();
 
		notification.put("body", msg);
		notification.put("title", "Late Alert:");
		notification.put("sound", "default");
		
		String to = "/topics/" + id;
		
		map.put("to", to);
		map.put("notification", notification);
		
		JSONObject obj = new JSONObject(map); 

		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(API_URL_FCM);
		post.setHeader("Content-type", "application/json");
		post.setHeader("Authorization", "key=" + AUTH_KEY_FCM);

		post.setEntity(new StringEntity(obj.toString(), "UTF-8"));
		HttpResponse response = client.execute(post);

		Reader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
		StringBuilder builder = new StringBuilder();
		char[] buf = new char[1000];
		int l = 0;
		while (l >= 0) {
			builder.append(buf, 0, l);
			l = in.read(buf);
		}
		JSONObject arr = new JSONObject(builder.toString());
		
		String messageId = arr.get("message_id").toString();
		
		return messageId;
		
	}
	public String pushFCMNotificationForOverTime(String id,String msg) throws Exception {
		
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> notification = new HashMap<String,Object>();
		
		notification.put("body", msg);
		notification.put("title", "Over Time Alert:");
		notification.put("sound", "default");
		
		String to = "/topics/" + id;
		
		map.put("to", to);
		map.put("notification", notification);
		
		JSONObject obj = new JSONObject(map); 
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(API_URL_FCM);
		post.setHeader("Content-type", "application/json");
		post.setHeader("Authorization", "key=" + AUTH_KEY_FCM);
		
		post.setEntity(new StringEntity(obj.toString(), "UTF-8"));
		HttpResponse response = client.execute(post);
		
		Reader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
		StringBuilder builder = new StringBuilder();
		char[] buf = new char[1000];
		int l = 0;
		while (l >= 0) {
			builder.append(buf, 0, l);
			l = in.read(buf);
		}
		JSONObject arr = new JSONObject(builder.toString());
		
		String messageId = arr.get("message_id").toString();
		
		return messageId;
		
	}
	public String pushFCMNotificationForChequeDate(String id,String msg) throws Exception {
		
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> notification = new HashMap<String,Object>();
		
		notification.put("body", msg);
		notification.put("title", "Cheque Date Reminder:");
		notification.put("sound", "default");
		
		String to = "/topics/" + id;
		
		map.put("to", to);
		map.put("notification", notification);
		
		JSONObject obj = new JSONObject(map); 
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(API_URL_FCM);
		post.setHeader("Content-type", "application/json");
		post.setHeader("Authorization", "key=" + AUTH_KEY_FCM);
		
		post.setEntity(new StringEntity(obj.toString(), "UTF-8"));
		HttpResponse response = client.execute(post);
		
		Reader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
		StringBuilder builder = new StringBuilder();
		char[] buf = new char[1000];
		int l = 0;
		while (l >= 0) {
			builder.append(buf, 0, l);
			l = in.read(buf);
		}
		JSONObject arr = new JSONObject(builder.toString());
		
		String messageId = arr.get("message_id").toString();
		
		return messageId;
		
	}

}
