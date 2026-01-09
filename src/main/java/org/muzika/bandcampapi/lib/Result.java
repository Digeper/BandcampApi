package org.muzika.bandcampapi.lib;

class BandImage{
    public long image_id;
    public boolean is_art;
}

class PrimaryImage{
    public long image_id;
    public boolean is_art;
}

public class Result{
    public long item_id;
    public String item_type;
    public String result_type;
    public String title;
    public String item_url;
    public PrimaryImage primary_image;
    public Object addl_images;
    public long band_id;
    public String album_artist;
    public String band_name;
    public String band_url;
    public boolean is_free_download;
    public boolean is_set_price;
    public Price price;
    public long band_genre_id;
    public String band_location;
    public FeaturedTrack featured_track;
    public boolean is_album_preorder;
    public String release_date;
    public long track_count;
    public long duration;
    public Object is_wishlisted;
    public Object is_owned;
    public Object package_info;
    public BandImage band_image;
    public Object is_following_band;

}

