package org.muzika.bandcampapi.searcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.nodes.Document;
import org.muzika.bandcampapi.lib.DiscoverResponse;
import org.muzika.bandcampapi.lib.WebSearcher;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;


@Service
public class BandcampSearcher extends WebSearcher {


    public BandcampSearcher() {
        super("https://bandcamp.com/");

        this.headers = new LinkedHashMap<>();
        headers.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:128.0) Gecko/20100101 Firefox/128.0");
        headers.put("Accept-Language","en-US,en;q=0.5");
        headers.put("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/png,image/svg+xml,*/*;q=0.8");
        headers.put("Alt-Used", "www.beatport.com" );
        headers.put( "Upgrade-Insecure-Requests","1");
        headers.put("Sec-Fetch-Dest","document");

        headers.put("Sec-Fetch-Mode","navigate");
        headers.put("Sec-Fetch-Site","none");
        headers.put("Sec-Fetch-User","?1");
        headers.put("Priority","u=0, i");


    }

    public static class DiscoverRequest {
        public int category_id = 1;
        public List<String> tag_norm_names = Arrays.asList("electronic", "house", "progressive-house", "melodic-techno");
        public int geoname_id = 0;
        public String slice = "rand";
        public Object time_facet_id = null;
        public String cursor = "*";
        public int size = 1;
        public List<String> include_result_types = Arrays.asList("a", "s");
    }

    public DiscoverResponse getRandomSong(String genre) throws IOException {

        DiscoverRequest request = new DiscoverRequest();

        String jsonBody = objectMapper.writeValueAsString(request);
        Document doc = this.postDocument("api/discover/1/discover_web",jsonBody);

        String jsonResponse = Objects.requireNonNull(doc.select("body").first()).html();


        return objectMapper.readValue(jsonResponse,DiscoverResponse.class);
    }


    public Document getSongImg(int id){
        return this.getDocument("https://f4.bcbits.com/img/a"+id+"_2.jpg");
    }



}
