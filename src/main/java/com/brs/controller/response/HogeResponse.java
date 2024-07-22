package com.brs.controller.response;

public class HogeResponse {
    private int foo;
    private String bar;

    public HogeResponse(int foo, String bar) {
        this.foo = foo;
        this.bar = bar;
    }

    public int getFoo() {
        return foo;
    }

    public String getBar() {
        return bar;
    }
}
