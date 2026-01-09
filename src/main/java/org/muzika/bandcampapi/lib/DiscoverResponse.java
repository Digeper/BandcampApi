package org.muzika.bandcampapi.lib;

import java.util.ArrayList;

public class DiscoverResponse{
    public ArrayList<Result> results;
    public long result_count;
    public long batch_result_count;
    public String cursor;
    public long discover_spec_id;
    public Object is_following_discover_spec;
    public DiscoverResponse() {}
}
