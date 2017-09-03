package MyExercise;

import com.github.abola.crawler.CrawlerPack;

/**
 * 練習 高公局即時路況資料
 * 
 * @author Abola Lee
 *
 */
public class HighwayStaticInfo_Ex {

	public static void main(String[] args) {
		
		// 遠端資料路徑
		//String uri = "gz:http://tisvcloud.freeway.gov.tw/cms_value.xml.gz";
		String uri1 = "gz:http://tisvcloud.freeway.gov.tw/roadlevel_info.xml.gz";
		String uri2 = "gz:http://tisvcloud.freeway.gov.tw/avi_value.xml.gz";
		System.out.println(
				CrawlerPack.start()
			    	.getFromXml(uri1)
		);
		System.out.println(
				CrawlerPack.start()
						.getFromXml(uri2)
			    
		);
	}
}
