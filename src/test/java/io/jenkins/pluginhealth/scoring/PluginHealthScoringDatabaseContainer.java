/*
 * MIT License
 *
 * Copyright (c) 2023 Jenkins Infra
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.jenkins.pluginhealth.scoring;

import org.testcontainers.containers.PostgreSQLContainer;

public class PluginHealthScoringDatabaseContainer extends PostgreSQLContainer<PluginHealthScoringDatabaseContainer> {
    private static final String IMAGE_VERSION = "postgres:14.1-alpine";
    private static PluginHealthScoringDatabaseContainer container;

    private PluginHealthScoringDatabaseContainer() {
        super(IMAGE_VERSION);
    }

    public static PluginHealthScoringDatabaseContainer getInstance() {
        if (container == null) {
            container = new PluginHealthScoringDatabaseContainer();
        }
        return container;
    }

    @Override
    public void stop() {
        // nothing
    }
}
