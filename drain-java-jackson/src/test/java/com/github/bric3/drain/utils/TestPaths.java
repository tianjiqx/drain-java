/*
 * drain-java
 *
 * Copyright (c) 2021, Today - Brice Dutheil
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package com.github.bric3.drain.utils;

import java.nio.file.Files;
import java.nio.file.Path;

public class TestPaths {
    public static Path get(String first, String... more) {
        var subPath = Path.of(first, more);
        var resolved = Path.of("build/resources/test").resolve(subPath);
        if (Files.exists(resolved)) {
            return resolved;
        }
        resolved = Path.of("..").resolve(resolved);
        if (Files.exists(resolved)) {
            return resolved;
        }
        resolved = Path.of("build").resolve(subPath);
        if (Files.exists(resolved)) {
            return resolved;
        }
        resolved = Path.of("..").resolve(resolved);
        if (Files.exists(resolved)) {
            return resolved;
        }


        throw new IllegalStateException("Could not find " + subPath);
    }
}
