package com.ukcloud.sources;

import com.ukcloud.storage.Time;

import java.util.List;

public interface CloudSource {

    List<CloudResource> getResources() throws PlatformException;
    long getUsage(CloudResource resource, Time periodStart, Time periodEnd) throws PlatformException;
}
