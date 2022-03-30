package com.ukcloud.sources;

import com.ukcloud.storage.Time;

import java.util.List;

public class MockSource implements CloudSource {

    final List<CloudResource> resources;
    final long usage;

    public MockSource(List<CloudResource> resources, long usage) {
        this.resources = resources;
        this.usage = usage;
    }

    @Override
    public List<CloudResource> getResources() throws PlatformException {
        return resources;
    }

    @Override
    public long getUsage(CloudResource resource, Time periodStart, Time periodEnd) throws PlatformException {
        if (resources.contains(resource)) {
            return usage;
        }
        else {
            return 0;
        }
    }
}
