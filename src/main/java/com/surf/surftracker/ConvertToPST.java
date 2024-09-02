package com.surf.surftracker;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

    public class ConvertToPST {
        public static void main(String[] args) {
            long[] epochSeconds = {
                    1724340896L,
                    1724338800L,
                    1724284800L,
                    1724295600L,
                    1724306400L,
                    1724317200L,
                    1724328000L,
                    1724338800L,
                    1724349600L,
                    1724360400L
            };

            ZoneId pacificZone = ZoneId.of("America/Los_Angeles");

            for (long epochSecond : epochSeconds) {
                ZonedDateTime pacificTime = Instant.ofEpochSecond(epochSecond).atZone(pacificZone);
                System.out.println("Epoch Second: " + epochSecond + " -> Pacific Time: " + pacificTime);
            }
        }
    }