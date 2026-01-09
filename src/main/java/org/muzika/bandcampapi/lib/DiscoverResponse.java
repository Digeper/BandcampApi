package org.muzika.bandcampapi.lib;

import java.util.ArrayList;


class Price{
    public int amount;
    public String currency;
    public boolean is_money;
    public Price() {}
}

public class DiscoverResponse{
    public ArrayList<Result> results;
    public long result_count;
    public long batch_result_count;
    public String cursor;
    public long discover_spec_id;
    public Object is_following_discover_spec;
    public DiscoverResponse() {}
}

