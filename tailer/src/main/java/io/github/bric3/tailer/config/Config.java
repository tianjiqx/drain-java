/*
 * drain-java
 *
 * Copyright (c) 2021, Today - Brice Dutheil
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package io.github.bric3.tailer.config;

import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Config {
    public final boolean verbose;

    public final PrintStream out;
    public final PrintStream err;

    public final Charset charset;

    public final DrainConfig drain;

    public Config(boolean verbose) {
        this(verbose, "", 0, 4, 0.4);
    }

    public Config(boolean verbose, String parseAfterStr, int parseAfterCol, int depth, double similarityThreshold) {
        this.verbose = verbose;
        this.drain = new DrainConfig(parseAfterStr, parseAfterCol, depth, similarityThreshold);
        this.out = System.out;
        this.err = System.err;
        this.charset = StandardCharsets.UTF_8;
    }

    public static class DrainConfig {
        public final String parseAfterStr;
        public final int parseAfterCol;
        public final int depth;
        public final double similarityThreshold;


        DrainConfig(String parseAfterStr, int parseAfterCol, int depth, double similarityThreshold) {
            this.parseAfterStr = parseAfterStr;
            this.parseAfterCol = parseAfterCol;
            this.depth = depth;
            this.similarityThreshold = similarityThreshold;
        }

    }
}
