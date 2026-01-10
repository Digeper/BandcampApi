package org.muzika.bandcampapi.services;


import lombok.extern.slf4j.Slf4j;
import org.muzika.bandcampapi.lib.DiscoverResponse;
import org.muzika.bandcampapi.kafkaMassages.RequestRandomSong;
import org.muzika.bandcampapi.kafkaMassages.RequestSlskdSong;
import org.muzika.bandcampapi.searcher.BandcampSearcher;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@Slf4j
public class KafkaConsumerService {

    private final BandcampSearcher searcher;
    private final KafkaProducerService kafka;

    public KafkaConsumerService(KafkaProducerService kafka, BandcampSearcher searcher) {
        this.kafka = kafka;
        this.searcher = searcher;

    }




    @KafkaListener(topics = {"request-random-song"}, containerFactory = "songConcurrentKafkaListenerContainerFactory")
    public void consumeRequestSong(RequestRandomSong loadedSong) {
        log.info("Received request song: {}", loadedSong);


        try {
            DiscoverResponse songs = searcher.getRandomSong(loadedSong.getGenre());
            kafka.send("request-slskd-song", UUID.randomUUID(), new RequestSlskdSong(songs,loadedSong.getSongId()));
            log.info("Sent request song");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

}
