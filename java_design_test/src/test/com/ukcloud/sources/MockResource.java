package com.ukcloud.sources;

public class MockResource implements CloudResource {

    final String name;
    final String owner;
    final String type;

    public MockResource(String name, String owner, String type) {
        this.name = name;
        this.owner = owner;
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getOwner() {
        return owner;
    }

    @Override
    public String getType() {
        return type;
    }
}
