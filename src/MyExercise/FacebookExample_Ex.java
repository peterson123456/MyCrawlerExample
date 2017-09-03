package MyExercise;

import com.github.abola.crawler.CrawlerPack;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * 資料探索練習 Facebook Graph Api Search 
 * 
 * 重點
 * 1. 利用Graph Api調整出需要的資料
 * 2. 取得一組Access Token (試著使用 long term token)
 * 3. 試著用『excel』或任何最簡易的方式，對資料進行探索
 * 
 * @author Abola Lee
 *
 */
public class FacebookExample_Ex {
	
	public static void main(String[] args) {
		
		// 遠端資料路徑
		// [query sample]
		//URL encode 中文
		// search?fields=name,id,likes,talking_about_count&limit=1000&q=靠北&type=page
		String uri = 
				"https://graph.facebook.com/v2.10"
				+ "/search?q=%E9%9D%A0%E5%8C%97&type=page&limit=1000&fields=name,id,likes,talking_about_count"
				+ "&access_token=EAACEdEose0cBAAeWNHeB0K6y9YMhNJw4ZC2et8PUu3YcZBaLYp37wZCdIefWM9woiXLUTqvoO9ZALrBqKfGdt7ihSA8nMLoCdZC4OiPZAxsQEba3Unz9I8I9mMbaZBKY7FXCjDXhADR17TklD60ZACnWSXmlZAxrJ9ZBiNAV7cjZAJWmnax8uGDf12ZCH87CdWXVp1UfVGOktuwibwZDZD";



		// Jsoup select 後回傳的是  Elements 物件
//		[data sample]
//		----
//		{
//			"data": [
//			{
//				"name": "靠北工程師",
//					"id": "1632027893700148",
//					"likes": 174587,
//					"talking_about_count": 188119
//			}
//		}
		Elements elems =
				CrawlerPack.start()
				.getFromJson(uri)
				.select("data");
		
		String output = "id,名稱,按讚數,討論人數\n";
		
		// 遂筆處理
		for( Element data: elems ){
			String id = data.select("id").text();
			String name = data.select("name").text();
			String likes = data.select("likes").text();
			String talking_about_count = data.select("talking_about_count").text();
			
			output += id+",\""+name+"\","+likes+","+talking_about_count+"\n";
		}
		
		System.out.println( output );
	} 
}
