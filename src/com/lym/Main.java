package com.lym;


import jdk.nashorn.internal.ir.RuntimeNode;

import javax.xml.ws.Response;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


class Solution {
    public static void main(String[] args) {
        System.out.println(tableSizeFor(101));
    }

    static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n;
    }



}