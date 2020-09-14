package com.acme.util;

public class Pair<F,S> {

    final F f;
    final S s;

    public Pair(final F f, final S s) {
    	// 2. Fixed the assignment issue.
        this.f = f;
        this.s = s;
    }

    public F first() { return f; }
    public S second() { return s; }
}
