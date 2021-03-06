/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Piasy
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

package com.github.piasy.gh.model;

import com.github.piasy.base.model.jsr310.ThreeTenABPDelegate;
import com.github.piasy.base.model.provider.GsonConfig;
import com.ryanharter.auto.value.gson.AutoValueGsonTypeAdapterFactory;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by piasy on 15/8/10.
 *
 * DB Module class for dagger2.
 */
@Module
public class GsonProviderConfigModule {
    private static final String TIME_FORMAT_ISO_8601 = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    @Singleton
    @Provides
    GsonConfig provideGsonConfig(final ThreeTenABPDelegate delegate) {
        delegate.init();
        return GsonConfig.builder()
                .dateFormatString(TIME_FORMAT_ISO_8601)
                .dateTimeFormatter(DateTimeFormatterProvider.provideDateTimeFormatter())
                .autoGsonTypeAdapterFactory(new AutoValueGsonTypeAdapterFactory())
                .build();
    }
}
