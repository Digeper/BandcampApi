package org.muzika.bandcampapi.kafkaMassages;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.muzika.DiscoverResponse;
import org.muzika.Result;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestSlskdSong {

    private UUID id;
    private String title;
    private String artist;


    public RequestSlskdSong(DiscoverResponse songs,UUID id) {
        this.id = id;
        Result song = songs.results.get(0);

        this.title = cleanString(song.title);
        this.artist = cleanString(song.album_artist);

    }

    private String cleanString(String in){
        if(in == null){
            return "";
        }
        String urlDecoded = URLDecoder.decode(in, StandardCharsets.UTF_8);

        return urlDecoded
                .replaceAll("\\[.*?]", "")
                .replaceAll("\\(.*?\\)}", "")
                .replaceAll(";", "")
                .replaceAll("EP", "")
                .replaceAll("null", "");
    }
}
